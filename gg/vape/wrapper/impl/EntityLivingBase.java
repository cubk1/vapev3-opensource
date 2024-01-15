package gg.vape.wrapper.impl;

import java.util.Collection;

public class EntityLivingBase extends Entity {
   public EntityLivingBase(Object var1) {
      super(var1);
   }

   public static AttributeModifier c8952() {
      return new AttributeModifier(vape.getMappings().entityLivingBase.c6031());
   }

   public float getHealth() {
      return vape.getMappings().entityLivingBase.c6244(this.obj);
   }

   public int c5603() {
      return vape.getMappings().entityLivingBase.c2099(this.obj);
   }

   public void setJumpTicks(int var1) {
      vape.getMappings().entityLivingBase.jumpTicks(this.obj, var1);
   }

   public Vec3 c181(float var1) {
      return new Vec3(vape.getMappings().entityLivingBase.c5140(this.obj, var1));
   }

   public Vec3 c3025(float var1) {
      return new Vec3(vape.getMappings().entityLivingBase.c7269(this.obj, var1));
   }

   public boolean canEntityBeSeen(Entity var1) {
      return vape.getMappings().entityLivingBase.c948(this.obj, var1.getObject());
   }

   public RayTraceResult c7488(double var1, float var3) {
      return new RayTraceResult(vape.getMappings().entityLivingBase.c1014(this.obj, var1, var3));
   }

   public boolean isPotionActive(Potion var1) {
      return vape.getMappings().entityLivingBase.c7780(this.obj, var1.getObject());
   }

   public PotionEffect getActivePotionEffect(Potion var1) {
      return new PotionEffect(vape.getMappings().entityLivingBase.c1690(this.obj, var1.getObject()));
   }

   public void c8385() {
   }

   public float moveStrafe() {
      return vape.getMappings().entityLivingBase.c437(this.obj);
   }

   public void c2947(float var1) {
      vape.getMappings().entityLivingBase.c3021(this.obj, var1);
   }

   public float moveForward() {
      return vape.getMappings().entityLivingBase.c443(this.obj);
   }

   public void c8393(float var1) {
      vape.getMappings().entityLivingBase.c8649(this.obj, var1);
   }

   public ItemStack c6156() {
      return new ItemStack(vape.getMappings().entityLivingBase.c3024(this.obj));
   }

   public void swingItem() {
      if (ForgeVersion.minorVersion() >= 23) {
         vape.getMappings().entityLivingBase.c4067(this.obj, EnumHead.c1307().getObject());
      } else {
         vape.getMappings().entityLivingBase.c5770(this.obj);
      }
   }

   public AttributeInstance c3853(IAttributeModifier var1) {
      return new AttributeInstance(vape.getMappings().entityLivingBase.c2332(this.obj, var1.getObject()));
   }

   public Object c8108() {
      return vape.getMappings().entityLivingBase.c2141(this.obj);
   }

   public void c3662(float var1) {
      vape.getMappings().entityLivingBase.c5412(this.obj, var1);
   }

   public float c2958() {
      return vape.getMappings().entityLivingBase.c677(this.obj);
   }

   public float c8895() {
      return vape.getMappings().entityLivingBase.c8820(this.obj);
   }

   public float c394() {
      return vape.getMappings().entityLivingBase.c7751(this.obj);
   }

   public void c2324(PotionEffect var1) {
      vape.getMappings().entityLivingBase.c1450(this.obj, var1.getObject());
   }

   public void c4326(int var1) {
      if (ForgeVersion.minorVersion() >= 23) {
         vape.getMappings().entityLivingBase.c7916(this.obj, Potion.c6875(var1).getObject());
      } else {
         vape.getMappings().entityLivingBase.c2803(this.obj, var1);
      }
   }

   public boolean c5048() {
      return vape.getMappings().entityLivingBase.c4402(this.obj);
   }

   public boolean isOnLadder() {
      return vape.getMappings().entityLivingBase.c7358(this.obj);
   }

   public float c6680() {
      return vape.getMappings().entityLivingBase.c5834(this.obj);
   }

   public float c5053() {
      return vape.getMappings().entityLivingBase.c2859(this.obj);
   }

   public void c8484(float var1) {
      vape.getMappings().entityLivingBase.c1776(this.obj, var1);
   }

   public float c5320() {
      return vape.getMappings().entityLivingBase.c6893(this.obj);
   }

   public void c2968(float var1) {
      vape.getMappings().entityLivingBase.c6658(this.obj, var1);
   }

   public float c8386() {
      return vape.getMappings().entityLivingBase.c2612(this.obj);
   }

   public void c3064(float var1) {
      vape.getMappings().entityLivingBase.c766(this.obj, var1);
   }

   public float c3796() {
      return vape.getMappings().entityLivingBase.c2405(this.obj);
   }

   public static EntityLivingBase c1801(World var0) {
      return new EntityLivingBase(vape.getMappings().entityLivingBase.c6519(var0.getObject()));
   }

   public Collection c808() {
       return (Collection) vape.getMappings().entityLivingBase.c5156(this.obj);
   }
}
