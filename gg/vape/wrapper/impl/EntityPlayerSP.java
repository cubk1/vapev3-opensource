package gg.vape.wrapper.impl;

public class EntityPlayerSP extends EntityPlayer {
   public EntityPlayerSP(Object var1) {
      super(var1);
   }

   public MovementInput movementInput() {
      return new MovementInput(vape.getMappings().entityPlayerSP.c8903(this.obj));
   }

   public NetHandlerPlayClientImpl sendQueue() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.obj)).sendQueue() : new NetHandlerPlayClientImpl(vape.getMappings().entityPlayerSP.c5327(this.obj));
   }

   public float moveForward() {
      return ForgeVersion.minorVersion() >= 23 ? vape.getMappings().entityPlayerSP.c8820(this.obj) : super.moveForward();
   }

   public void c8393(float var1) {
      if (ForgeVersion.minorVersion() >= 23) {
         vape.getMappings().entityPlayerSP.c7180(this.obj, var1);
      } else {
         super.c8393(var1);
      }
   }

   public double c4759() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.getObject())).c63() : vape.getMappings().entityPlayerSP.c6749(this.obj);
   }

   public void c8340(double var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c6766(var1);
      } else {
         vape.getMappings().entityPlayerSP.c2636(this.obj, var1);
      }
   }

   public double c6488() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.getObject())).c1898() : vape.getMappings().entityPlayerSP.c5722(this.obj);
   }

   public void c8902(double var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c7992(var1);
      } else {
         vape.getMappings().entityPlayerSP.c1122(this.obj, var1);
      }
   }

   public double c4277() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.getObject())).c5286() : vape.getMappings().entityPlayerSP.c7233(this.obj);
   }

   public void c7516(double var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c4512(var1);
      } else {
         vape.getMappings().entityPlayerSP.c4458(this.obj, var1);
      }
   }

   public float c7809() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.getObject())).c4461() : vape.getMappings().entityPlayerSP.c443(this.obj);
   }

   public void c5528(float var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c6025(var1);
      } else {
         vape.getMappings().entityPlayerSP.c3962(this.obj, var1);
      }
   }

   public float c3132() {
      return ForgeVersion.minorVersion() <= 13 ? (new EntityClientPlayerMP(this.getObject())).c3155() : vape.getMappings().entityPlayerSP.c1721(this.obj);
   }

   public void c4006(float var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c8528(var1);
      } else {
         vape.getMappings().entityPlayerSP.c3021(this.obj, var1);
      }
   }

   public boolean c8347() {
      return vape.getMappings().entityPlayerSP.c2463(this.obj);
   }

   public void c479(boolean var1) {
      vape.getMappings().entityPlayerSP.c3896(this.obj, var1);
   }

   public boolean c1616() {
      return vape.getMappings().entityPlayerSP.c315(this.obj);
   }

   public void c2591(boolean var1) {
      vape.getMappings().entityPlayerSP.c2771(this.obj, var1);
   }

   public int c8495() {
      return vape.getMappings().entityPlayerSP.c6192(this.obj);
   }

   public void c2062(int var1) {
      vape.getMappings().entityPlayerSP.c7403(this.obj, var1);
   }

   public void setSprinting(boolean var1) {
      vape.getMappings().entityPlayerSP.c879(this.obj, var1);
   }

   public void c6694(String var1) {
      if (ForgeVersion.minorVersion() <= 13) {
         (new EntityClientPlayerMP(this.getObject())).c6694(var1);
      } else {
          vape.getMappings().entityPlayerSP.c2338(this.obj, var1);
      }
   }
}
