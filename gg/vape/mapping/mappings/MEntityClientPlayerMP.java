package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;

public class MEntityClientPlayerMP extends Mapping {
   public final MappingMethod c237;
   public final MappingField c5312;
   public final MappingField c1536;
   public final MappingField c7422;
   public final MappingField c4187;
   public final MappingField c6451;
   public final MappingField c5647;
   public final MappingField c5650;
   public final MappingField c6643;
   public final MappingField c3877;
   public final MappingField c7940;
   public final MappingField c6212;
   public MappingMethod c5162;

   public MEntityClientPlayerMP() {
      super(MappedClasses.EntityClientPlayerMP);
      this.c5312 = this.getMappingFieldNoRemap("sendQueue", true, MappedClasses.NetHandlerPlayClient);
      this.c1536 = this.getMappingFieldNoRemap("wasSprinting", true, Boolean.TYPE);
      this.c7422 = this.getMappingFieldNoRemap("wasSneaking", true, Boolean.TYPE);
      this.c4187 = this.getMappingFieldNoRemap("oldPosX", true, Double.TYPE);
      this.c6451 = this.getMappingFieldNoRemap("oldMinY", true, Double.TYPE);
      this.c5647 = this.getMappingFieldNoRemap("oldPosY", true, Double.TYPE);
      this.c5650 = this.getMappingFieldNoRemap("oldPosZ", true, Double.TYPE);
      this.c6643 = this.getMappingFieldNoRemap("oldRotationYaw", true, Float.TYPE);
      this.c3877 = this.getMappingFieldNoRemap("oldRotationPitch", true, Float.TYPE);
      this.c7940 = this.getMappingFieldNoRemap("ticksSinceMovePacket", true, Integer.TYPE);
      this.c6212 = this.getMappingFieldNoRemap("wasOnGround", true, Boolean.TYPE);
      this.c237 = this.getMappingMethodNoRemap("sendChatMessage", true, Void.TYPE, String.class);
      this.c5162 = this.getMappingMethodNoRemap("sendMotionUpdates", true, Void.TYPE);
   }

   public Object c6780(Object var1) {
      return this.c5312.getObject(var1);
   }

   public boolean c5419(Object var1) {
      return this.c1536.getBoolean(var1);
   }

   public void c3896(Object var1, boolean var2) {
      this.c1536.setBoolean(var1, var2);
   }

   public boolean c2418(Object var1) {
      return this.c7422.getBoolean(var1);
   }

   public void c2771(Object var1, boolean var2) {
      this.c7422.setBoolean(var1, var2);
   }

   public double c6749(Object var1) {
      return this.c4187.getDouble(var1);
   }

   public void c2636(Object var1, double var2) {
      this.c4187.setDouble(var1, var2);
   }

   public double c5722(Object var1) {
      return this.c6451.getDouble(var1);
   }

   public void c1122(Object var1, double var2) {
      this.c6451.setDouble(var1, var2);
   }

   public double c7233(Object var1) {
      return this.c5647.getDouble(var1);
   }

   public void c4458(Object var1, double var2) {
      this.c5647.setDouble(var1, var2);
   }

   public double c8153(Object var1) {
      return this.c5650.getDouble(var1);
   }

   public void c7773(Object var1, double var2) {
      this.c5650.setDouble(var1, var2);
   }

   public float c1721(Object var1) {
      return this.c6643.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c6643.setFloat(var1, var2);
   }

   public float c4020(Object var1) {
      return this.c3877.getFloat(var1);
   }

   public void c3962(Object var1, float var2) {
      this.c3877.setFloat(var1, var2);
   }

   public int c2985(Object var1) {
      return this.c7940.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c7940.setInt(var1, var2);
   }

   public void c879(Object var1, boolean var2) {
      this.c6212.setBoolean(var1, var2);
   }

   public void c2338(Object var1, String var2) {
      this.c237.c2642(var1, var2);
   }

}
