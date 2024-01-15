package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.Random;
import java.util.UUID;

public class MEntity extends Mapping {
   public final MappingField entityId;
   public final MappingField posX;
   public final MappingField posY;
   public final MappingField posZ;
   public final MappingField motionX;
   public final MappingField motionY;
   public final MappingField motionZ;
   public final MappingField yaw;
   public final MappingField pitch;
   public final MappingField onGround;
   public final MappingField isDead;
   public final MappingField ticksExisted;
   public final MappingField c4065;
   public final MappingField c685;
   public final MappingField c489;
   public final MappingField c5737;
   public final MappingField c4226;
   public final MappingField c3923;
   public final MappingField c6379;
   public final MappingField c1040;
   public final MappingField boundingBox;
   public final MappingField c2355;
   public final MappingField c5372;
   public final MappingField hurtResistantTime;
   public final MappingField c8551;
   public final MappingField isInWeb;
   public final MappingField world;
   public final MappingField c3242;
   public final MappingField isCollidedHorizontally;
   public final MappingField isCollidedVertically;
   public final MappingField c3098;
   public final MappingField c162;
   public final MappingField c8876;
   public final MappingField c2725;
   public MappingField c2710;
   public MappingField c4789;
   public final MappingField prevPosX;
   public final MappingField prevPosY;
   public final MappingField prevPosZ;
   public final MappingField c8686;
   public final MappingField c563;
   public final MappingMethod getName;
   public final MappingMethod getDistanceToEntity;
   public final MappingMethod isSprinting;
   public final MappingMethod c907;
   public final MappingMethod c4812;
   public final MappingMethod c8615;
   public final MappingMethod c7583;
   public final MappingMethod c5019;
   public final MappingMethod getEyeHeight;
   public MappingMethod c8823;
   public final MappingMethod c354;
   public final MappingMethod isInWater;
   public MappingMethod c6355;
   public MappingMethod c5472;
   public final MappingMethod c4517;
   public final MappingMethod c8819;
   public final MappingMethod c4527;
   public final MappingMethod c8595;
   public final MappingMethod c2;
   public final MappingMethod c5782;
   public final MappingMethod c1152;
   public final MappingMethod c703;
   public final MappingMethod c4014;
   public final MappingMethod c6502;
   public final MappingMethod c6334;
   public final MappingMethod c2734;
   public final MappingMethod c1061;
   public MappingMethod c8151;
   public MappingMethod c3909;
   public MappingMethod c5695;
   public MappingMethod c6672;
   public MappingField c5918;
   public MappingField c8182;
   public MappingField c5731;
   public MappingMethod c8075;
   public MappingMethod c4508;
   public MappingMethod isSneaking;

   public MEntity() {
      super(MappedClasses.Entity);
      this.entityId = this.getMappingFieldNoRemap("entityId", true, Integer.TYPE);
      this.posX = this.getMappingFieldNoRemap("posX", true, Double.TYPE);
      this.posY = this.getMappingFieldNoRemap("posY", true, Double.TYPE);
      this.posZ = this.getMappingFieldNoRemap("posZ", true, Double.TYPE);
      this.motionX = this.getMappingFieldNoRemap("motionX", true, Double.TYPE);
      this.motionY = this.getMappingFieldNoRemap("motionY", true, Double.TYPE);
      this.motionZ = this.getMappingFieldNoRemap("motionZ", true, Double.TYPE);
      this.yaw = this.getMappingFieldNoRemap("rotationYaw", true, Float.TYPE);
      this.pitch = this.getMappingFieldNoRemap("rotationPitch", true, Float.TYPE);
      this.onGround = this.getMappingFieldNoRemap("onGround", true, Boolean.TYPE);
      this.isDead = this.getMappingFieldNoRemap("isDead", true, Boolean.TYPE);
      this.ticksExisted = this.getMappingFieldNoRemap("ticksExisted", true, Integer.TYPE);
      this.c685 = this.getMappingFieldNoRemap("lastTickPosX", true, Double.TYPE);
      this.c489 = this.getMappingFieldNoRemap("lastTickPosY", true, Double.TYPE);
      this.c5737 = this.getMappingFieldNoRemap("lastTickPosZ", true, Double.TYPE);
      this.c3923 = this.getMappingFieldNoRemap("height", true, Float.TYPE);
      this.c4226 = this.getMappingFieldNoRemap("width", true, Float.TYPE);
      this.c6379 = this.getMappingFieldNoRemap("prevRotationYaw", true, Float.TYPE);
      this.c1040 = this.getMappingFieldNoRemap("prevRotationPitch", true, Float.TYPE);
      this.prevPosX = this.getMappingFieldNoRemap("prevPosX", true, Double.TYPE);
      this.prevPosY = this.getMappingFieldNoRemap("prevPosY", true, Double.TYPE);
      this.prevPosZ = this.getMappingFieldNoRemap("prevPosZ", true, Double.TYPE);
      this.boundingBox = this.getMappingFieldNoRemap("boundingBox", true, MappedClasses.AxisAlignedBB);
      this.c2355 = this.getMappingFieldNoRemap("ridingEntity", true, MappedClasses.Entity);
      this.c5372 = this.getMappingFieldNoRemap("rand", true, Random.class);
      this.c8551 = this.getMappingFieldNoRemap("noClip", true, Boolean.TYPE);
      this.isInWeb = this.getMappingFieldNoRemap("isInWeb", true, Boolean.TYPE);
      this.c4065 = this.getMappingFieldNoRemap("fallDistance", true, Float.TYPE);
      this.hurtResistantTime = this.getMappingFieldNoRemap("hurtResistantTime", true, Integer.TYPE);
      this.c563 = this.getMappingFieldNoRemap("entityUniqueID", true, UUID.class);
      if (ForgeVersion.minorVersion() == 13) {
         this.c5918 = this.getMappingFieldNoRemap("field_70135_K", false, Boolean.TYPE);
         this.c8182 = this.getMappingFieldNoRemap("yOffset", true, Float.TYPE);
         this.c5731 = this.getMappingFieldNoRemap("ySize", true, Float.TYPE);
         this.c8823 = this.getMappingMethodNoRemap("updateFallState", true, Void.TYPE, Double.TYPE, Boolean.TYPE);
         this.c6672 = this.getMappingMethodNoRemap("func_145780_a", false, Void.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, MappedClasses.Block);
         this.c5782 = this.getMappingMethodNoRemap("func_145748_c_", false, MappedClasses.ITextComponent);
         this.c703 = this.getMappingMethodNoRemap("copyDataFrom", true, Void.TYPE, MappedClasses.Entity, Boolean.TYPE);
      } else {
         if (ForgeVersion.minorVersion() < 23) {
            this.c8823 = this.getMappingMethodNoRemap("updateFallState", true, Void.TYPE, Double.TYPE, Boolean.TYPE, MappedClasses.Block, MappedClasses.BlockPos);
         }

         this.c5695 = this.getMappingMethodNoRemap("playStepSound", true, Void.TYPE, MappedClasses.BlockPos, MappedClasses.Block);
         this.c5782 = this.getMappingMethodNoRemap("getDisplayName", true, MappedClasses.ITextComponent);
         this.c703 = this.getMappingMethodNoRemap("copyDataFromOld", true, Void.TYPE, MappedClasses.Entity);
         this.c8151 = this.getMappingMethodNoRemap("getEntityBoundingBox", true, MappedClasses.AxisAlignedBB);
      }

      if (ForgeVersion.minorVersion() >= 23) {
         this.world = this.getMappingFieldNoRemap("world", true, MappedClasses.World);
         this.c8075 = this.getMappingMethodNoRemap("func_70091_d", false, Void.TYPE, MappedClasses.MoverType, Double.TYPE, Double.TYPE, Double.TYPE);
      } else {
         this.world = this.getMappingFieldNoRemap("worldObj", true, MappedClasses.World);
         this.c2710 = this.getMappingFieldNoRemap("fire", true, Integer.TYPE);
         this.c4789 = this.getMappingFieldNoRemap("fireResistance", true, Integer.TYPE);
         this.c6355 = this.getMappingMethodNoRemap("playSound", true, Void.TYPE, String.class, Float.TYPE, Float.TYPE);
         this.c5472 = this.getMappingMethodNoRemap("getSwimSound", true, String.class);
         this.c8075 = this.getMappingMethodNoRemap("moveEntity", true, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
      }

      this.c3242 = this.getMappingFieldNoRemap("stepHeight", true, Float.TYPE);
      this.isCollidedHorizontally = this.getMappingFieldNoRemap("isCollidedHorizontally", true, Boolean.TYPE);
      this.isCollidedVertically = this.getMappingFieldNoRemap("isCollidedVertically", true, Boolean.TYPE);
      this.c3098 = this.getMappingFieldNoRemap("isCollided", true, Boolean.TYPE);
      this.c8686 = this.getMappingFieldNoRemap("prevDistanceWalkedModified", true, Float.TYPE);
      this.c162 = this.getMappingFieldNoRemap("distanceWalkedModified", true, Float.TYPE);
      this.c8876 = this.getMappingFieldNoRemap("distanceWalkedOnStepModified", true, Float.TYPE);
      this.c2725 = this.getMappingFieldNoRemap("nextStepDistance", true, Integer.TYPE);
      this.getDistanceToEntity = this.getMappingMethodNoRemap("getDistanceToEntity", true, Float.TYPE, MappedClasses.Entity);
      this.isSprinting = this.getMappingMethodNoRemap("isSprinting", true, Boolean.TYPE);
      this.isSneaking = this.getMappingMethodNoRemap("isSneaking", true, Boolean.TYPE);
      this.c907 = this.getMappingMethodNoRemap("isInvisible", true, Boolean.TYPE);
      this.c4812 = this.getMappingMethodNoRemap("isRiding", true, Boolean.TYPE);
      this.getName = this.getMappingMethodNoRemap(ForgeVersion.minorVersion() == 13 ? "getCommandSenderName" : "getName", true, String.class);
      this.c8615 = this.getMappingMethodNoRemap("canBeCollidedWith", true, Boolean.TYPE);
      this.c7583 = this.getMappingMethodNoRemap("getCollisionBorderSize", true, Float.TYPE);
      this.c5019 = this.getMappingMethodNoRemap("canRiderInteract", false, Boolean.TYPE);
      this.getEyeHeight = this.getMappingMethodNoRemap("getEyeHeight", true, Float.TYPE);
      this.c354 = this.getMappingMethodNoRemap("canTriggerWalking", true, Boolean.TYPE);
      this.isInWater = this.getMappingMethodNoRemap("isInWater", true, Boolean.TYPE);
      this.c4517 = this.getMappingMethodNoRemap("func_145775_I", false, Void.TYPE);
      this.c8819 = this.getMappingMethodNoRemap("isWet", true, Boolean.TYPE);
      this.c4527 = this.getMappingMethodNoRemap("dealFireDamage", true, Void.TYPE, Integer.TYPE);
      this.c8595 = this.getMappingMethodNoRemap("setFire", true, Void.TYPE, Integer.TYPE);
      this.c2 = this.getMappingMethodNoRemap("setFlag", true, Void.TYPE, Integer.TYPE, Boolean.TYPE);
      this.c1152 = this.getMappingMethodNoRemap("getUniqueID", true, UUID.class);
      this.c4014 = this.getMappingMethodNoRemap("setPositionAndRotation", true, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
      this.c6502 = this.getMappingMethodNoRemap("setAngles", true, Void.TYPE, Float.TYPE, Float.TYPE);
      this.c6334 = this.getMappingMethodNoRemap("<init>", false, Void.TYPE, MappedClasses.World);
      this.c2734 = this.getMappingMethodNoRemap("setInvisible", true, Void.TYPE, Boolean.TYPE);
      this.c1061 = this.getMappingMethodNoRemap("setPosition", true, Void.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
      this.c3909 = this.getMappingMethodNoRemap("setSprinting", true, Void.TYPE, Boolean.TYPE);
      this.c4508 = this.getMappingMethodNoRemap("setSneaking", true, Void.TYPE, Boolean.TYPE);
   }

   public int entityId(Object var1) {
      return this.entityId.getInt(var1);
   }

   public double posX(Object var1) {
      return this.posX.getDouble(var1);
   }

   public double posY(Object var1) {
      return this.posY.getDouble(var1);
   }

   public double posZ(Object var1) {
      return this.posZ.getDouble(var1);
   }

   public double c5722(Object var1) {
      return this.motionX.getDouble(var1);
   }

   public double c7233(Object var1) {
      return this.motionY.getDouble(var1);
   }

   public double c8153(Object var1) {
      return this.motionZ.getDouble(var1);
   }

   public void motionX(Object var1, double var2) {
      this.motionX.setDouble(var1, var2);
   }

   public void c1122(Object var1, double var2) {
      this.motionY.setDouble(var1, var2);
   }

   public void motionZ(Object var1, double var2) {
      this.motionZ.setDouble(var1, var2);
   }

   public void c7180(Object var1, float var2) {
      this.yaw.setFloat(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.pitch.setFloat(var1, var2);
   }

   public void c3021(Object var1, float var2) {
      this.c6379.setFloat(var1, var2);
   }

   public void c8649(Object var1, float var2) {
      this.c1040.setFloat(var1, var2);
   }

   public float c1721(Object var1) {
      return this.yaw.getFloat(var1);
   }

   public float c4020(Object var1) {
      return this.pitch.getFloat(var1);
   }

   public float c5303(Object var1) {
      return this.c6379.getFloat(var1);
   }

   public float c677(Object var1) {
      return this.c1040.getFloat(var1);
   }

   public String c3795(Object var1) {
      return (String)this.getName.invoke(var1);
   }

   public float getDistanceToEntity(Object var1, Object var2) {
      return this.getDistanceToEntity.c3639(var1, var2);
   }

   public boolean onGround(Object var1) {
      return this.onGround.getBoolean(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.onGround.setBoolean(var1, var2);
   }

   public float c3241(Object var1) {
      return this.c4065.getFloat(var1);
   }

   public void c5412(Object var1, float var2) {
      this.c4065.setFloat(var1, var2);
   }

   public int hurtResistantTime(Object var1) {
      return this.hurtResistantTime.getInt(var1);
   }

   public boolean isDead(Object var1) {
      return this.isDead.getBoolean(var1);
   }

   public int ticksExisted(Object var1) {
      return this.ticksExisted.getInt(var1);
   }

   public boolean c5943(Object var1) {
      return this.isSprinting.c5509(var1);
   }

   public boolean isSneaking(Object var1) {
      return this.isSneaking.c5509(var1);
   }

   public boolean c2438(Object var1) {
      return this.c907.c5509(var1);
   }

   public boolean c5877(Object var1) {
      return this.c4812.c5509(var1);
   }

   public double c973(Object var1) {
      return this.c685.getDouble(var1);
   }

   public void c7773(Object var1, double var2) {
      this.c685.setDouble(var1, var2);
   }

   public double c8365(Object var1) {
      return this.c489.getDouble(var1);
   }

   public void c765(Object var1, double var2) {
      this.c489.setDouble(var1, var2);
   }

   public double c2024(Object var1) {
      return this.c5737.getDouble(var1);
   }

   public void c5802(Object var1, double var2) {
      this.c5737.setDouble(var1, var2);
   }

   public float c4053(Object var1) {
      return this.c3923.getFloat(var1);
   }

   public float c5025(Object var1) {
      return this.c4226.getFloat(var1);
   }

   public Object c6468(Object var1) {
      return this.boundingBox.getObject(var1);
   }

   public boolean c4600(Object var1) {
      return this.c8615.c5509(var1);
   }

   public float c889(Object var1) {
      return this.c7583.c3639(var1);
   }

   public Object c7340(Object var1) {
      return this.c2355.getObject(var1);
   }

   public boolean c4947(Object var1) {
      return this.c5019.c5509(var1);
   }

   public float c4287(Object var1) {
      return this.getEyeHeight.c3639(var1);
   }

   public Random c6312(Object var1) {
      return (Random)this.c5372.getObject(var1);
   }

   public boolean c550(Object var1) {
      return this.c8551.getBoolean(var1);
   }

   public void c2134(Object var1, double var2) {
      this.posX.setDouble(var1, var2);
   }

   public void c4324(Object var1, double var2) {
      this.posY.setDouble(var1, var2);
   }

   public void c5706(Object var1, double var2) {
      this.posZ.setDouble(var1, var2);
   }

   public float c8545(Object var1) {
      return this.c8182.getFloat(var1);
   }

   public float c1700(Object var1) {
      return this.c5731.getFloat(var1);
   }

   public void c1776(Object var1, float var2) {
      this.c5731.setFloat(var1, var2);
   }

   public boolean isInWeb(Object var1) {
      return this.isInWeb.getBoolean(var1);
   }

   public void c2771(Object var1, boolean var2) {
      this.isInWeb.setBoolean(var1, var2);
   }

   public Object c5641(Object var1) {
      return this.world.getObject(var1);
   }

   public boolean c1730(Object var1) {
      return this.c5918.getBoolean(var1);
   }

   public float c114(Object var1) {
      return this.c3242.getFloat(var1);
   }

   public void c6658(Object var1, float var2) {
      this.c3242.setFloat(var1, var2);
   }

   public boolean c5714(Object var1) {
      return this.isCollidedHorizontally.getBoolean(var1);
   }

   public boolean isCollidedVertically(Object var1) {
      return this.isCollidedVertically.getBoolean(var1);
   }

   public void c879(Object var1, boolean var2) {
      this.isCollidedHorizontally.setBoolean(var1, var2);
   }

   public void c473(Object var1, boolean var2) {
      this.isCollidedVertically.setBoolean(var1, var2);
   }

   public void c8178(Object var1, boolean var2) {
      this.c3098.setBoolean(var1, var2);
   }

   public void c78(Object var1, double var2, boolean var4) {
      this.c8823.c2642(var1, var2, var4);
   }

   public void c1931(Object var1, double var2, boolean var4, Object var5, Object var6) {
      this.c8823.c2642(var1, var2, var4, var5, var6);
   }

   public boolean c1942(Object var1) {
      return this.c354.c5509(var1);
   }

   public float c3176(Object var1) {
      return this.c162.getFloat(var1);
   }

   public float c1068(Object var1) {
      return this.c8876.getFloat(var1);
   }

   public void c766(Object var1, float var2) {
      this.c162.setFloat(var1, var2);
   }

   public float c1785(Object var1) {
      return this.c8686.getFloat(var1);
   }

   public void c2732(Object var1, float var2) {
      this.c8686.setFloat(var1, var2);
   }

   public void c2290(Object var1, float var2) {
      this.c8876.setFloat(var1, var2);
   }

   public int c2515(Object var1) {
      return this.c2725.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c2725.setInt(var1, var2);
   }

   public boolean c6907(Object var1) {
      return this.isInWater.c5509(var1);
   }

   public void c358(Object var1, String var2, float var3, float var4) {
      this.c6355.c2642(var1, var2, var3, var4);
   }

   public String c7402(Object var1) {
      return (String)this.c5472.invoke(var1);
   }

   public void c1584(Object var1, int var2, int var3, int var4, Object var5) {
      this.c6672.c2642(var1, var2, var3, var4, var5);
   }

   public void c7061(Object var1) {
      this.c4517.c2642(var1);
   }

   public boolean c3723(Object var1) {
      return this.c8819.c5509(var1);
   }

   public void c2803(Object var1, int var2) {
      this.c4527.c2642(var1, var2);
   }

   public int c1348(Object var1) {
      return this.c2710.getInt(var1);
   }

   public void c2185(Object var1, int var2) {
      this.c2710.setInt(var1, var2);
   }

   public void c4778(Object var1, int var2) {
      this.c8595.c2642(var1, var2);
   }

   public int c6114(Object var1) {
      return this.c4789.getInt(var1);
   }

   public void c5700(Object var1, Object var2) {
      this.boundingBox.setObject(var1, var2);
   }

   public void c4839(Object var1, Object var2, Object var3) {
      this.c5695.c2642(var1, var2, var3);
   }

   public double c747(Object var1) {
      return this.prevPosX.getDouble(var1);
   }

   public double c2916(Object var1) {
      return this.prevPosY.getDouble(var1);
   }

   public double prevPosZ(Object var1) {
      return this.prevPosZ.getDouble(var1);
   }

   public void c4980(Object var1, double var2) {
      this.prevPosX.setDouble(var1, var2);
   }

   public void c446(Object var1, double var2) {
      this.prevPosY.setDouble(var1, var2);
   }

   public void c3717(Object var1, double var2) {
      this.prevPosZ.setDouble(var1, var2);
   }

   public void c6094(Object var1, int var2, boolean var3) {
      this.c2.c2642(var1, var2, var3);
   }

   public Object c3388(Object var1) {
      return this.c5782.invoke(var1);
   }

   public UUID c2924(Object var1) {
      return (UUID)this.c1152.invoke(var1);
   }

   public void c3061(Object var1, UUID var2) {
      this.c563.setObject(var1, var2);
   }

   public void c8366(Object var1, Object var2, boolean var3) {
      this.c703.c2642(var1, var2, var3);
   }

   public void c6635(Object var1, double var2, double var4, double var6, float var8, float var9) {
      this.c4014.c2642(var1, var2, var4, var6, var8, var9);
   }

   public void c2190(Object var1, float var2, float var3) {
      this.c6502.c2642(var1, var2, var3);
   }

   public Object c7800(Object var1) {
      return this.c6334.c4955(var1);
   }

   public Object c5464(Object var1) {
      return this.c8151.invoke(var1);
   }

   public void c3677(Object var1, boolean var2) {
      this.c2734.c2642(var1, var2);
   }

   public void c737(Object var1, double var2, double var4, double var6) {
      this.c1061.c2642(var1, var2, var4, var6);
   }

   public void c3933(Object var1, boolean var2) {
      this.c4508.c2642(var1, var2);
   }
}
