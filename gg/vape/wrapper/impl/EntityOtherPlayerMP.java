package gg.vape.wrapper.impl;

public class EntityOtherPlayerMP extends EntityPlayer {
   public EntityOtherPlayerMP(Object var1) {
      super(var1);
   }

   public static EntityOtherPlayerMP c5474(World var0, GameProfile var1) {
      return new EntityOtherPlayerMP(vape.getMappings().entityOtherPlayerMP.c1352(var0.getObject(), var1.getObject()));
   }
}
