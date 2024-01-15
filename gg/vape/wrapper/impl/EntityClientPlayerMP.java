package gg.vape.wrapper.impl;

public class EntityClientPlayerMP extends EntityPlayerSP {
   public EntityClientPlayerMP(Object var1) {
      super(var1);
   }

   public NetHandlerPlayClientImpl sendQueue() {
      return new NetHandlerPlayClientImpl(vape.getMappings().entityClientPlayerMP.c6780(this.obj));
   }

   public boolean c6738() {
      return vape.getMappings().entityClientPlayerMP.c5419(this.obj);
   }

   public void c175(boolean var1) {
      vape.getMappings().entityClientPlayerMP.c3896(this.obj, var1);
   }

   public boolean c5354() {
      return vape.getMappings().entityClientPlayerMP.c2418(this.obj);
   }

   public void c335(boolean var1) {
      vape.getMappings().entityClientPlayerMP.c2771(this.obj, var1);
   }

   public double c63() {
      return vape.getMappings().entityClientPlayerMP.c6749(this.obj);
   }

   public void c6766(double var1) {
      vape.getMappings().entityClientPlayerMP.c2636(this.obj, var1);
   }

   public double c8246() {
      return vape.getMappings().entityClientPlayerMP.c5722(this.obj);
   }

   public void c4997(double var1) {
      vape.getMappings().entityClientPlayerMP.c1122(this.obj, var1);
   }

   public double c1898() {
      return vape.getMappings().entityClientPlayerMP.c7233(this.obj);
   }

   public void c7992(double var1) {
      vape.getMappings().entityClientPlayerMP.c4458(this.obj, var1);
   }

   public double c5286() {
      return vape.getMappings().entityClientPlayerMP.c8153(this.obj);
   }

   public void c4512(double var1) {
      vape.getMappings().entityClientPlayerMP.c7773(this.obj, var1);
   }

   public float c4461() {
      return vape.getMappings().entityClientPlayerMP.c1721(this.obj);
   }

   public void c6025(float var1) {
      vape.getMappings().entityClientPlayerMP.c7180(this.obj, var1);
   }

   public float c3155() {
      return vape.getMappings().entityClientPlayerMP.c4020(this.obj);
   }

   public void c8528(float var1) {
      vape.getMappings().entityClientPlayerMP.c3962(this.obj, var1);
   }

   public int c5203() {
      return vape.getMappings().entityClientPlayerMP.c2985(this.obj);
   }

   public void c33(int var1) {
      vape.getMappings().entityClientPlayerMP.c7403(this.obj, var1);
   }

   public void c2112(boolean var1) {
      vape.getMappings().entityClientPlayerMP.c879(this.obj, var1);
   }

   public void c6694(String var1) {
       vape.getMappings().entityClientPlayerMP.c2338(this.obj, var1);
   }
}
