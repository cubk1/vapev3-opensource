package gg.vape.asm;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

public interface ITramsformNode {
   InsnList getPre();

   InsnList getPost();

   void onTransform(ClassNode var1, MethodNode var2);

   String getDesc();

   boolean hasOwner();

   ITramsformNode setOwner(Class<?> var1);

   String getOwner();
}
