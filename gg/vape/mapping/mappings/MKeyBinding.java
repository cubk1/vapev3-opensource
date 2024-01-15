package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingMethod;

public class MKeyBinding extends Mapping {
   public final MappingMethod getKeyCode;
   public final MappingMethod isPressed;
   public final MappingMethod setKeyBindState;
   public final MappingMethod c7683;
   public final MappingMethod c345;

   public MKeyBinding() {
      super(MappedClasses.KeyBinding);
      this.getKeyCode = this.getMappingMethodNoRemap("getKeyCode", true, Integer.TYPE);
      this.isPressed = this.getMappingMethodNoRemap("isPressed", true, Boolean.TYPE);
      this.setKeyBindState = this.getMappingMethod("setKeyBindState", true, Void.TYPE, Integer.TYPE, Boolean.TYPE);
      this.c7683 = this.getMappingMethod("onTick", true, Void.TYPE, Integer.TYPE);
      this.c345 = this.getMappingMethodNoRemap("func_151470_d", false, Boolean.TYPE);
   }

   public boolean c4246(Object var1) {
      return this.c345.c5509(var1);
   }

   public int c4023(Object var1) {
      return this.getKeyCode.c2555(var1);
   }

   public boolean c2418(Object var1) {
      return this.isPressed.c5509(var1);
   }

   public void c6094(Object var1, int var2, boolean var3) {
      this.setKeyBindState.c2642(var1, var2, var3);
   }

   public void c2327(int var1) {
      this.c7683.c2642(null, var1);
   }
}
