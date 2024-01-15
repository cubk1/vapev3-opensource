package gg.vape.asm.transform;

import gg.vape.Vape;
import gg.vape.wrapper.impl.ForgeVersion;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import pub.nextsense.Tweaker;

import java.io.FileOutputStream;

public abstract class ClassTransformer {
   public final Class<?> target;
   public final byte[] origClassBytes;
   public byte[] transformedClassBytes;
   protected ClassNode classNode;

   protected static final int HEAD = 0, RETURN = 1;

   public ClassTransformer(Class<?> target) {
      this.target = target;
      this.origClassBytes = Tweaker.getClassBytes(target);//getClassBytes
      this.transformedClassBytes = new byte[this.origClassBytes.length];
      System.arraycopy(this.origClassBytes, 0, this.transformedClassBytes, 0, this.origClassBytes.length);
      ClassReader classReader = new ClassReader(this.origClassBytes);
      this.classNode = new ClassNode();
      classReader.accept(this.classNode, 0);
   }

   public abstract void transform();

   public void dump(String fileName) {
      try {
         FileOutputStream fos = new FileOutputStream(fileName);
         fos.write(this.transformedClassBytes);
         fos.close();
      } catch (Exception e) {
         Vape.throwEx(e);
      }
   }

   public void replaceClassBytes() {
      byte flag = 1;
      if (ForgeVersion.minorVersion() >= 23) {
         flag = 2;
      }

      ClassWriter classWriter = new ClassWriter(flag);
      this.classNode.accept(classWriter);
      this.transformedClassBytes = classWriter.toByteArray();
      int jvmtiError = Tweaker.setClassBytes(this.target, this.transformedClassBytes);//setClassBytes
      if(jvmtiError != 0){
         Vape.throwEx(new RuntimeException("TransformFailed!"));
      }
   }

   public void transformToOrig() {
      Tweaker.setClassBytes(this.target, this.origClassBytes);//setClassBytes
   }
}
