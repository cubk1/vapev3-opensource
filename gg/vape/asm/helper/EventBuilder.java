package gg.vape.asm.helper;

import gg.vape.asm.ITramsformNode;
import gg.vape.wrapper.impl.LaunchClassLoader;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.*;
import pub.nextsense.Tweaker;
import pub.nextsense.util.DescUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.objectweb.asm.Opcodes.*;

public class EventBuilder {
   public final Class<?> eventClazz;
   public final ClassNode targetNode;
   public MethodNode processing;
   public final List<ITramsformNode> tramsformNodes = new ArrayList<>();
   public final LabelNode LabelStart = new LabelNode(new Label());
   public final LabelNode LabelEnd = new LabelNode(new Label());
   public boolean pre;
   public ITramsformNode preTransformer;
   public Class<?> target;
   public final int shift; //0 head //1 ret
   public InsnList building;
   public boolean usingOffsetCall;
   public String targetCallName;
   public int localIndex;
   public String owner;
   public static final String eventCallMethodName = "fire";
   public static int eventIndex = 1;

   public EventBuilder(int shift, Class<?> eventClass, ClassNode classNode, MethodInfo methodInfo, ITramsformNode... args) {

      for (MethodNode methodNode : classNode.methods) {
         if (methodInfo.is(methodNode.name, methodNode.desc)) {
            this.processing = methodNode;
            break;
         }
      }
      if(processing == null){
         System.out.println(methodInfo.toString());
      }
      this.shift = shift;
      this.eventClazz = eventClass;
      this.targetNode = classNode;

      for (ITramsformNode node : args) {
         node.onTransform(classNode, this.processing);
         this.tramsformNodes.add(node);
      }

      Tweaker.getClassBytes(eventClass);
      LaunchClassLoader.getLaunchClassLoader().cachedClasses().put(eventClass.getName(), eventClass);
   }

   public EventBuilder transform() {
      this.owner = this.eventClazz.getName().replace(".", "/");
      if (this.shift == 0) {

         for (ITramsformNode tramsformNode : this.tramsformNodes) {
            if (tramsformNode instanceof Local) {
               ((Local) tramsformNode).toStart(this.LabelStart);
            }
         }
      }

      InsnList insn = new InsnList();
      LabelNode outLabel = new LabelNode(new Label());
      this.localIndex = ++this.processing.maxLocals;
      LocalVariableNode eventLocalVar = new LocalVariableNode("event" + eventIndex++, DescUtils.getClassSignature(this.eventClazz), null, this.LabelStart, this.LabelEnd, this.localIndex);
      this.processing.localVariables.add(eventLocalVar);
      TypeInsnNode newOwner = new TypeInsnNode(NEW, this.owner);
      InsnNode dup = new InsnNode(DUP);
      StringBuilder initDesc = new StringBuilder();
      initDesc.append("(");

      for (ITramsformNode tramsformNode : this.tramsformNodes) {
         initDesc.append(tramsformNode.getDesc());
      }

      initDesc.append(")V");
      if(initDesc.toString().contains("null")){
         initDesc = new StringBuilder();
         initDesc.append(DescUtility.getConstructorDescriptor(eventClazz.getDeclaredConstructors()[0]));
         System.out.println("flaged! "+initDesc);
      }
      MethodInsnNode callInit = new MethodInsnNode(INVOKESPECIAL, this.owner, "<init>", initDesc.toString().equals("(java/lang/Object)V") ? "(Ljava/lang/Object;)V" : initDesc.toString(), false);
      VarInsnNode storeInit = new VarInsnNode(ASTORE, this.localIndex);
      VarInsnNode loadInit = new VarInsnNode(ALOAD, this.localIndex);
      MethodInsnNode callEvent = new MethodInsnNode(INVOKEVIRTUAL, this.owner, eventCallMethodName, "()Z", false);
      JumpInsnNode cmpJmp = new JumpInsnNode(IFEQ, outLabel);
      insn.add(this.LabelStart);
      System.out.println(pre);
      if (
              this.pre
      ) {
         insn.add(this.preTransformer.getPre());
         insn.add(new TypeInsnNode(INSTANCEOF, this.target.getName().replace(".", "/")));
         insn.add(new JumpInsnNode(IFEQ, this.LabelEnd));
      }


      if (this.shift == 0) {
         for (LocalVariableNode localVariableNode : this.processing.localVariables) {
            if (localVariableNode.index == 0) {
               localVariableNode.start = this.LabelStart;
            }
         }
      }

      insn.add(newOwner);
      insn.add(dup);

      for (ITramsformNode node : this.tramsformNodes) {
         System.out.println(node.getPre().size());

         insn.add(node.getPre());

      }

      insn.add(callInit);
      insn.add(storeInit);
      insn.add(new LabelNode(new Label()));
      insn.add(loadInit);
      insn.add(callEvent);
      insn.add(cmpJmp);
      insn.add(new LabelNode(new Label()));
      if (this.usingOffsetCall) {
         insn.add(new VarInsnNode(ALOAD, this.localIndex));
         insn.add(new MethodInsnNode(INVOKEVIRTUAL, this.owner, this.targetCallName, this.processing.desc, false));
      }

      insn.add(new InsnNode(getRetOpCode(this.processing.desc)));
      insn.add(outLabel);
      insn.add(this.LabelEnd);
      this.building = insn;
      return this;
   }

   public EventBuilder preTransform(ITramsformNode transformer, Class<?> target) {
      this.pre = true;
      transformer.onTransform(this.targetNode, this.processing);
      this.preTransformer = transformer;
      this.target = target;
      return this;
   }

   public EventBuilder relocal(ITramsformNode local, String name) {
      InsnList insn = new InsnList();
      insn.add(new VarInsnNode(ALOAD, this.localIndex));
      insn.add(new MethodInsnNode(INVOKEVIRTUAL, this.owner, name, "()" + local.getDesc(), false));
      if (local.hasOwner()) {
         insn.add(new TypeInsnNode(CHECKCAST, local.getOwner()));
      }

      insn.add(local.getPost());
      this.building.insertBefore(this.LabelEnd, insn);
      return this;
   }

   public EventBuilder inject() {
      if (this.shift == 0) {
         this.processing.instructions.insertBefore(this.processing.instructions.get(0), this.building);
      } else {

         if (this.shift == -1) {
            ListIterator<AbstractInsnNode> iterator = this.processing.instructions.iterator();

            while(true) {
               do {
                  if (!iterator.hasNext()) {
                     return this;
                  }

                  iterator.next();
               } while(iterator.hasNext());

               while(iterator.hasPrevious()) {
                  AbstractInsnNode var2 = iterator.previous();
                  if (var2 instanceof LineNumberNode) {
                     this.processing.instructions.insertBefore(var2, this.building);
                     return this;
                  }
               }
            }
         }

         ListIterator<AbstractInsnNode> iterator = this.processing.instructions.iterator();

         while(iterator.hasNext()) {
            AbstractInsnNode var2 = iterator.next();
            if (var2 instanceof LineNumberNode) {
               LineNumberNode var3 = (LineNumberNode)var2;
               if (var3.line == this.shift) {
                  this.processing.instructions.insertBefore(var3, this.building);
                  return this;
               }
            }
         }
      }

      return this;
   }

   public EventBuilder setOffset(int targetIndex) {
      this.usingOffsetCall = true;
      Tweaker.getClassBytes(this.eventClazz);
      String[] methodNames = Tweaker.getClassMethodNames(this.eventClazz);
      int count = 0;

      for (String str : methodNames) {
         if (count == targetIndex) {
            this.targetCallName = str;
            break;
         }

         ++count;
      }

      return this;
   }

   public EventBuilder c7643(int var1, String var2) {
      InsnList insn = new InsnList();
      LineNumberNode lineNumber = null;
      ListIterator<AbstractInsnNode> aiI = this.processing.instructions.iterator();

      while(aiI.hasNext()) {
         AbstractInsnNode ai = aiI.next();
         if (ai instanceof LineNumberNode) {
            LineNumberNode var7 = (LineNumberNode)ai;
            if (var7.line == var1) {
               lineNumber = var7;
            }
         }

         if (lineNumber != null && ai instanceof LabelNode) {
            insn.add(new VarInsnNode(ALOAD, this.localIndex));
            insn.add(new MethodInsnNode(INVOKEVIRTUAL, this.owner, var2, "()Z", false));
            insn.add(new JumpInsnNode(IFNE, (LabelNode)ai));
            break;
         }
      }

      this.processing.instructions.insert(lineNumber, insn);
      return this;
   }

   public EventBuilder c2420(int var1, String var2, String var3) {
      ListIterator var4 = this.processing.instructions.iterator();
      VarInsnNode var5 = null;
      InsnList var6 = new InsnList();
      boolean var7 = false;

      label41:
      while(true) {
         AbstractInsnNode var8;
         LineNumberNode var9;
         do {
            do {
               if (!var4.hasNext()) {
                  this.processing.instructions.clear();
                  this.processing.instructions = var6;
                  return this;
               }

               var8 = (AbstractInsnNode)var4.next();
               var6.add(var8);
            } while(!(var8 instanceof LineNumberNode));

            var9 = (LineNumberNode)var8;
         } while(var9.line != var1);

         while(true) {
            while(true) {
               if (!var4.hasNext()) {
                  continue label41;
               }

               var8 = (AbstractInsnNode)var4.next();
               if (var8 instanceof VarInsnNode) {
                  var5 = (VarInsnNode)var8;
               }

               if (var8 instanceof FieldInsnNode && !var7) {
                  FieldInsnNode var10 = (FieldInsnNode)var8;
                  if (var10.name.equals(var2)) {
                     var7 = true;
                     var5.var = this.localIndex;
                     MethodInsnNode var11 = new MethodInsnNode(INVOKEVIRTUAL, this.owner, var3, "()" + var10.desc, false);
                     var6.add(var11);
                     var6.insert(var5, var11);
                     var6.add(var10);
                     var6.remove(var10);
                     continue;
                  }
               }

               var6.add(var8);
            }
         }
      }
   }

   public static int loadVar(String desc) {
      switch (desc) {
         case "D":
            return DLOAD;
         case "F":
            return FLOAD;
         case "I":
         case "Z":
         case "C":
         case "B":
            return ILOAD;
         default:
            return ALOAD;
      }
   }

   public static int storeVar(String desc) {
      switch (desc) {
         case "D":
            return DSTORE;
         case "F":
            return FSTORE;
         case "I":
         case "Z":
         case "C":
         case "B":
            return ISTORE;
         default:
            return ASTORE;
      }
   }

   public static int getRetOpCode(String desc) {
      int paramTail = desc.indexOf(")") + 1;
      switch (desc.substring(paramTail, paramTail + 1)) {
         case "I":
         case "Z":
         case "C":
         case "B":
            return IRETURN;
         case "F":
            return FRETURN;
         case "D":
            return DRETURN;
         case "V":
            return RETURN;
         default:
            return ARETURN;
      }
   }
}
