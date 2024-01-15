package gg.vape.asm.helper;

import gg.vape.asm.ITramsformNode;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Local implements ITramsformNode {
   public final String varName;
   public final List<String> varList;
   public final InsnList preBuilding = new InsnList();
   public final InsnList postBuilding = new InsnList();
   public LocalVariableNode localVar;
   public VarInsnNode load;
   public VarInsnNode store;
   public String localVarDesc;
   public String targetDesc = null;
   public boolean hasOwner;
   public String owner;

   public Local(String string) {
      this.varName = string;
      varList = null;
   }

   public Local(String string, String tdesc) {
      this.varName = string;
      targetDesc = tdesc;
      varList = null;
   }
   public Local(String tdesc, String... string) {
      varList = Arrays.asList(string);
      this.varName = null;
      targetDesc = tdesc;
   }

   public void toStart(LabelNode labelNode) {
      if (this.localVar != null) {
         this.localVar.start = labelNode;
      }
   }

   @Override
   public InsnList getPre() {
      return this.preBuilding;
   }

   @Override
   public InsnList getPost() {
      return this.postBuilding;
   }

   @Override
   public void onTransform(ClassNode classNode, MethodNode methodNode) {
      //System.out.println(this.varName + " " + (methodNode.localVariables.size() == 0));
      if(methodNode.localVariables == null){
         System.out.println("NULL@ "+varName);
      }
      if (
              (varName != null && this.varName.equals("this")) && methodNode.localVariables.size() == 0) {
         Object object;
         String string = "L" + classNode.name + ";";
         LabelNode labelNode = null;
         LabelNode labelNode2 = null;
         Iterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
         block0: while (iterator.hasNext()) {
            object = iterator.next();
            if (!(object instanceof LabelNode)) continue;
            labelNode = (LabelNode)object;
            while (iterator.hasNext()) {
               iterator.next();
               if (iterator.hasNext()) continue;
               while (((ListIterator<?>) iterator).hasPrevious()) {
                  object = ((ListIterator<?>) iterator).previous();
                  if (!(object instanceof LabelNode)) continue;
                  labelNode2 = (LabelNode)object;
                  break block0;
               }
            }
         }

         object = new LocalVariableNode("this", string, null, labelNode, labelNode2, 0);
         methodNode.localVariables.add((LocalVariableNode)object);
         this.localVar = (LocalVariableNode) object;

         this.load = new VarInsnNode(Opcodes.ALOAD, 0);
         this.preBuilding.add(this.load);
         this.store = new VarInsnNode(Opcodes.ASTORE, 0);
         this.postBuilding.add(this.store);
         this.localVarDesc = string;
      } else {

        // methodNode.localVariables.forEach(l->{
        //    System.out.println(l.name);
        // });

         for (LocalVariableNode localVariableNode : methodNode.localVariables) {
           // System.out.println(localVariableNode.name + " - " + varName);

            boolean flag;
            if(varList != null){
               flag = varList.contains(localVariableNode.name);
            }else{
               flag = localVariableNode.name.equals(this.varName);
            }
            if(!flag && varList != null){
              // System.out.println(varList);
               //System.out.println(localVariableNode.name);
            }
            if (!flag) continue;
            this.localVar = localVariableNode;
            this.load = new VarInsnNode(EventBuilder.loadVar(localVariableNode.desc), localVariableNode.index + ((localVariableNode.desc.equals("D") || localVariableNode.desc.equals("J"))&&localVariableNode.index!= 1?1:0) );
            this.preBuilding.add(this.load);
            this.store = new VarInsnNode(EventBuilder.storeVar(localVariableNode.desc), localVariableNode.index + ((localVariableNode.desc.equals("D") || localVariableNode.desc.equals("J"))&&localVariableNode.index!= 1?1:0));
            this.postBuilding.add(this.store);
            this.localVarDesc = this.localVar.desc;
            System.out.println(localVariableNode.name);
            break;
         }
      }
   }

   @Override
   public String getDesc() {
      return this.targetDesc != null ? this.targetDesc : this.localVarDesc;
   }

   @Override
   public boolean hasOwner() {
      return this.hasOwner;
   }

   @Override
   public ITramsformNode setOwner(Class<?> clazz) {
      this.hasOwner = true;
      this.owner = clazz.getName().replace(".", "/");
      return this;
   }

   @Override
   public String getOwner() {
      return this.owner;
   }

   public Local setTarget(Class<?> clazz) {
      this.targetDesc = DescUtils.getClassSignatureX(clazz);
      return this;
   }
}


          /*Iterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
         LabelNode labelNode = null;
         LabelNode labelNode2 = null;

         while (iterator.hasNext()) {
             object = iterator.next();
            if (object instanceof LabelNode) {
               labelNode = (LabelNode)object;
               while (iterator.hasNext()) {
                  iterator.next();
                  if (!iterator.hasNext()) {
                     ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator(methodNode.instructions.indexOf((AbstractInsnNode) object));
                     while (listIterator.hasPrevious()) {
                        object = listIterator.previous();
                        if (object instanceof LabelNode) {
                           labelNode2 = (LabelNode)object;
                           break;
                        }
                     }
                     break;
                  }
               }
            }
         }*/