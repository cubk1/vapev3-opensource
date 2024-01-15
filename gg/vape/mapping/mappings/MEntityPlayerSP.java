package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class MEntityPlayerSP extends Mapping {
   public final MappingMethod setSprinting;
   public MappingMethod c3298;
   public MappingMethod c5544;
   public final MappingField movementInput;
   public MappingField c5374;
   public MappingField sendQueue;
   public MappingField c1691;
   public MappingField c1539;
   public MappingField c5101;
   public MappingField c5168;
   public MappingField c622;
   public MappingField c4646;
   public MappingField c8847;
   public MappingField c2918;

   public MEntityPlayerSP() {
      super(MappedClasses.EntityPlayerSP);
      this.movementInput = this.getMappingFieldNoRemap("movementInput", true, MappedClasses.MovementInput);
      if (ForgeVersion.minorVersion() > 13) {
         if (ForgeVersion.minorVersion() >= 23) {
            this.c5374 = this.getMappingFieldNoRemap("field_191988_bg", false, Float.TYPE);
            this.sendQueue = this.getMappingFieldNoRemap("connection", true, MappedClasses.NetHandlerPlayClient);
         } else {
            this.sendQueue = this.getMappingFieldNoRemap("sendQueue", true, MappedClasses.NetHandlerPlayClient);
         }

         this.c1691 = this.getMappingFieldNoRemap("lastReportedPosX", true, Double.TYPE);
         this.c1539 = this.getMappingFieldNoRemap("lastReportedPosY", true, Double.TYPE);
         this.c5101 = this.getMappingFieldNoRemap("lastReportedPosZ", true, Double.TYPE);
         this.c5168 = this.getMappingFieldNoRemap("lastReportedYaw", true, Float.TYPE);
         this.c622 = this.getMappingFieldNoRemap("lastReportedPitch", true, Float.TYPE);
         this.c4646 = this.getMappingFieldNoRemap("serverSneakState", true, Boolean.TYPE);
         this.c8847 = this.getMappingFieldNoRemap("serverSprintState", true, Boolean.TYPE);
         this.c2918 = this.getMappingFieldNoRemap("positionUpdateTicks", true, Integer.TYPE);
         this.c3298 = this.getMappingMethodNoRemap("sendChatMessage", true, Void.TYPE, String.class);
         this.c5544 = this.getMappingMethodNoRemap("onUpdateWalkingPlayer", true, Void.TYPE);
      }

      this.setSprinting = this.getMappingMethodNoRemap("setSprinting", true, Void.TYPE, Boolean.TYPE);
   }

   public float c8820(Object var1) {
      return this.c5374.getFloat(var1);
   }

   public void c7180(Object var1, float var2) {
      this.c5374.setFloat(var1, var2);
   }

   public Object c8903(Object var1) {
      return this.movementInput.getObject(var1);
   }

   public Object c5327(Object var1) {
      return this.sendQueue.getObject(var1);
   }

   public double c6749(Object var1) {
      return this.c1691.getDouble(var1);
   }

   public double c5722(Object var1) {
      return this.c1539.getDouble(var1);
   }

   public double c7233(Object var1) {
      return this.c5101.getDouble(var1);
   }

   public float c443(Object var1) {
      return this.c5168.getFloat(var1);
   }

   public float c1721(Object var1) {
      return this.c622.getFloat(var1);
   }

   public boolean c2463(Object var1) {
      return this.c4646.getBoolean(var1);
   }

   public boolean c315(Object var1) {
      return this.c8847.getBoolean(var1);
   }

   public void c2636(Object var1, double var2) {
      this.c1691.setDouble(var1, var2);
   }

   public void c1122(Object var1, double var2) {
      this.c1539.setDouble(var1, var2);
   }

   public void c4458(Object var1, double var2) {
      this.c5101.setDouble(var1, var2);
   }

   public void c3962(Object var1, float var2) {
      this.c5168.setFloat(var1, var2);
   }

   public void c3021(Object var1, float var2) {
      this.c622.setFloat(var1, var2);
   }

   public void c3896(Object var1, boolean var2) {
      this.c4646.setBoolean(var1, var2);
   }

   public void c2771(Object var1, boolean var2) {
      this.c8847.setBoolean(var1, var2);
   }

   public int c6192(Object var1) {
      return this.c2918.getInt(var1);
   }

   public void c7403(Object var1, int var2) {
      this.c2918.setInt(var1, var2);
   }

   public void c879(Object var1, boolean var2) {
      this.setSprinting.c2642(var1, var2);
   }

   public void c2338(Object var1, String var2) {
      this.c3298.c2642(var1, var2);
   }
}
