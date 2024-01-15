package gg.vape.wrapper.impl;

import gg.vape.utils.MathUtil;
import gg.vape.wrapper.Wrapper;

import java.util.Random;
import java.util.UUID;

public class Entity extends Wrapper {
   public Entity(Object var1) {
      super(var1);
   }

   public String getName() {
      return vape.getMappings().entity.c3795(this.obj);
   }

   public int getEntityID() {
      return vape.getMappings().entity.entityId(this.obj);
   }

   public double posX() {
      return vape.getMappings().entity.posX(this.obj);
   }

   public double posY() {
      return vape.getMappings().entity.posY(this.obj);
   }

   public double posZ() {
      return vape.getMappings().entity.posZ(this.obj);
   }

   public double c6344() {
      return vape.getMappings().entity.c5722(this.obj);
   }

   public void motionX(double var1) {
      vape.getMappings().entity.motionX(this.obj, var1);
   }

   public double motionY() {
      return vape.getMappings().entity.c7233(this.obj);
   }

   public void motionY(double var1) {
      vape.getMappings().entity.c1122(this.obj, var1);
   }

   public double c612() {
      return vape.getMappings().entity.c8153(this.obj);
   }

   public void motionZ(double var1) {
      vape.getMappings().entity.motionZ(this.obj, var1);
   }

   public float rotationYaw() {
      return vape.getMappings().entity.c1721(this.obj);
   }

   public void c7293(float var1) {
      vape.getMappings().entity.c7180(this.obj, var1);
   }

   public float rotationPitch() {
      return vape.getMappings().entity.c4020(this.obj);
   }

   public void c834(float var1) {
      vape.getMappings().entity.c3962(this.obj, var1);
   }

   public float c3825() {
      return vape.getMappings().entity.c5303(this.obj);
   }

   public void c4743(float var1) {
      vape.getMappings().entity.c3021(this.obj, var1);
   }

   public float c301() {
      return vape.getMappings().entity.c677(this.obj);
   }

   public void c6100(float var1) {
      vape.getMappings().entity.c8649(this.obj, var1);
   }

   public float getDistanceToEntity(Entity var1) {
      return vape.getMappings().entity.getDistanceToEntity(this.obj, var1.obj);
   }

   public boolean onGround() {
      return vape.getMappings().entity.onGround(this.obj);
   }

   public void c3224(boolean var1) {
      vape.getMappings().entity.c3896(this.obj, var1);
   }

   public boolean isDead() {
      return vape.getMappings().entity.isDead(this.obj);
   }

   public int ticksExisted() {
      return vape.getMappings().entity.ticksExisted(this.obj);
   }

   public boolean isSneaking() {
      return vape.getMappings().entity.isSneaking(this.obj);
   }

   public boolean isSprinting() {
      return vape.getMappings().entity.c5943(this.obj);
   }

   public boolean c320() {
      return vape.getMappings().entity.c2438(this.obj);
   }

   public boolean c3947() {
      return vape.getMappings().entity.c5877(this.obj);
   }

   public double c5823() {
      return vape.getMappings().entity.c973(this.obj);
   }

   public void c4745(double var1) {
      vape.getMappings().entity.c7773(this.obj, var1);
   }

   public double c8561() {
      return vape.getMappings().entity.c8365(this.obj);
   }

   public void c2563(double var1) {
      vape.getMappings().entity.c765(this.obj, var1);
   }

   public double c7002() {
      return vape.getMappings().entity.c2024(this.obj);
   }

   public void c8766(double var1) {
      vape.getMappings().entity.c5802(this.obj, var1);
   }

   public float c1998() {
      return vape.getMappings().entity.c4053(this.obj);
   }

   public float c8958() {
      return vape.getMappings().entity.c5025(this.obj);
   }

   public AxisAlignedBB boundingBox() {
      return new AxisAlignedBB(vape.getMappings().entity.c6468(this.obj));
   }

   public void c1130(AxisAlignedBB var1) {
      vape.getMappings().entity.c5700(this.obj, var1.getObject());
   }

   public boolean c1797() {
      return vape.getMappings().entity.c4600(this.obj);
   }

   public float c3849() {
      return vape.getMappings().entity.c889(this.obj);
   }

   public Entity c361() {
      return new Entity(vape.getMappings().entity.c7340(this.obj));
   }

   public boolean c1199() {
      return vape.getMappings().entity.c4947(this.obj);
   }

   public float getEyeHeight() {
      return vape.getMappings().entity.c4287(this.obj);
   }

   public Random c1913() {
      return vape.getMappings().entity.c6312(this.obj);
   }

   public boolean c3492() {
      return vape.getMappings().entity.c550(this.obj);
   }

   public void c7148(double var1) {
      vape.getMappings().entity.c2134(this.obj, var1);
   }

   public void c4805(double var1) {
      vape.getMappings().entity.c4324(this.obj, var1);
   }

   public void c8899(double var1) {
      vape.getMappings().entity.c5706(this.obj, var1);
   }

   public float c6316() {
      return vape.getMappings().entity.c8545(this.obj);
   }

   public float c5962() {
      return vape.getMappings().entity.c1700(this.obj);
   }

   public void c8868(float var1) {
      vape.getMappings().entity.c1776(this.obj, var1);
   }

   public boolean isInWeb() {
      return vape.getMappings().entity.isInWeb(this.obj);
   }

   public void c1648(boolean var1) {
      vape.getMappings().entity.c2771(this.obj, var1);
   }

   public World getWorld() {
      return new World(vape.getMappings().entity.c5641(this.obj));
   }

   public float c7206() {
      return vape.getMappings().entity.c3241(this.obj);
   }

   public void c1995(float var1) {
      vape.getMappings().entity.c5412(this.obj, var1);
   }

   public int hurtResistantTime() {
      return vape.getMappings().entity.hurtResistantTime(this.obj);
   }

   public boolean c5356() {
      return vape.getMappings().entity.c1730(this.obj);
   }

   public float c3619() {
      return vape.getMappings().entity.c114(this.obj);
   }

   public void c7106(float var1) {
      vape.getMappings().entity.c6658(this.obj, var1);
   }

   public void c2434(boolean var1) {
      vape.getMappings().entity.c879(this.obj, var1);
   }

   public void c8782(boolean var1) {
      vape.getMappings().entity.c473(this.obj, var1);
   }

   public void c6201(boolean var1) {
      vape.getMappings().entity.c8178(this.obj, var1);
   }

   public boolean isCollidedHorizontally() {
      return vape.getMappings().entity.c5714(this.obj);
   }

   public boolean isCollidedVertically() {
      return vape.getMappings().entity.isCollidedVertically(this.obj);
   }

   public void c1272(double var1, boolean var3) {
      vape.getMappings().entity.c78(this.obj, var1, var3);
   }

   public void c3868(double var1, boolean var3, Block var4, BlockPos var5) {
      vape.getMappings().entity.c1931(this.obj, var1, var3, var4.getObject(), var5.getObject());
   }

   public boolean c6282() {
      return vape.getMappings().entity.c1942(this.obj);
   }

   public float c4365() {
      return vape.getMappings().entity.c3176(this.obj);
   }

   public void c1133(float var1) {
      vape.getMappings().entity.c766(this.obj, var1);
   }

   public float c7432() {
      return vape.getMappings().entity.c1785(this.obj);
   }

   public void c7970(float var1) {
      vape.getMappings().entity.c2732(this.obj, var1);
   }

   public float c6070() {
      return vape.getMappings().entity.c1068(this.obj);
   }

   public void c592(float var1) {
      vape.getMappings().entity.c2290(this.obj, var1);
   }

   public int c1029() {
      return vape.getMappings().entity.c2515(this.obj);
   }

   public void c5732(int var1) {
      vape.getMappings().entity.c7403(this.obj, var1);
   }

   public boolean isInWater() {
      return vape.getMappings().entity.c6907(this.obj);
   }

   public void c4652(String var1, float var2, float var3) {
      vape.getMappings().entity.c358(this.obj, var1, var2, var3);
   }

   public String c6060() {
      return vape.getMappings().entity.c7402(this.obj);
   }

   public void c2883(int var1, int var2, int var3, Block var4) {
      vape.getMappings().entity.c1584(this.obj, var1, var2, var3, var4.getObject());
   }

   public void c6707() {
      vape.getMappings().entity.c7061(this.obj);
   }

   public boolean c1285() {
      return vape.getMappings().entity.c3723(this.obj);
   }

   public void c8274(int var1) {
      vape.getMappings().entity.c2803(this.obj, var1);
   }

   public int c710() {
      return vape.getMappings().entity.c1348(this.obj);
   }

   public void c8796(int var1) {
      vape.getMappings().entity.c4778(this.obj, var1);
   }

   public void c445(int var1) {
      vape.getMappings().entity.c2185(this.obj, var1);
   }

   public int c3676() {
      return vape.getMappings().entity.c6114(this.obj);
   }

   public void c8670(BlockPos var1, Block var2) {
      vape.getMappings().entity.c4839(this.obj, var1.getObject(), var2.getObject());
   }

   public double prevPosX() {
      return vape.getMappings().entity.c747(this.obj);
   }

   public double c8732() {
      return vape.getMappings().entity.c2916(this.obj);
   }

   public double prevPosZ() {
      return vape.getMappings().entity.prevPosZ(this.obj);
   }

   public void c2863(double var1) {
      vape.getMappings().entity.c4980(this.obj, var1);
   }

   public void c6518(double var1) {
      vape.getMappings().entity.c446(this.obj, var1);
   }

   public void c7911(double var1) {
      vape.getMappings().entity.c3717(this.obj, var1);
   }

   public void c6537(int var1, boolean var2) {
      vape.getMappings().entity.c6094(this.obj, var1, var2);
   }

   public ITextComponent c7053() {
      return new ITextComponent(vape.getMappings().entity.c3388(this.obj));
   }

   public UUID c7543() {
      return vape.getMappings().entity.c2924(this.obj);
   }

   public void c5418(UUID var1) {
      vape.getMappings().entity.c3061(this.obj, var1);
   }

   public void c7981(Entity var1, boolean var2) {
      vape.getMappings().entity.c8366(this.obj, var1.getObject(), var2);
   }

   public void c7698(double var1, double var3, double var5, float var7, float var8) {
      vape.getMappings().entity.c6635(this.obj, var1, var3, var5, var7, var8);
   }

   public void c7551(float var1, float var2) {
      vape.getMappings().entity.c2190(this.obj, var1, var2);
   }

   public static Entity c5934(World var0) {
      return new Entity(vape.getMappings().entity.c7800(var0.getObject()));
   }

   public double c7689(double var1, double var3, double var5) {
      double var7 = this.posX() - var1;
      double var9 = this.posY() - var3;
      double var11 = this.posZ() - var5;
      return MathUtil.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public AxisAlignedBB c69() {
      return new AxisAlignedBB(vape.getMappings().entity.c5464(this.obj));
   }

   public void c4992(boolean var1) {
      vape.getMappings().entity.c3677(this.obj, var1);
   }

   public void c8308(double var1, double var3, double var5) {
      vape.getMappings().entity.c737(this.obj, var1, var3, var5);
   }

   public void c1563(boolean var1) {
       vape.getMappings().entity.c3933(this.obj, var1);
   }
}
