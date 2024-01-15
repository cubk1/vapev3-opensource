package gg.vape.wrapper.impl;

import gg.vape.mapping.MappedClasses;

public class MouseEvent extends ForgeEvent {
   public MouseEvent(Object var1) {
      super(var1);
   }

   public static MouseEvent c3437() {
      try {
         return new MouseEvent(MappedClasses.MouseEvent.newInstance());
      } catch (Exception var1) {
         return null;
      }
   }

   public int c3715() {
      return vape.getMappings().mouseEvent.c7740(this.obj);
   }

   public void c33(int var1) {
      vape.getMappings().mouseEvent.c7403(this.obj, var1);
   }

   public boolean c5354() {
      return vape.getMappings().mouseEvent.c5419(this.obj);
   }

   public void c175(boolean var1) {
      vape.getMappings().mouseEvent.c3896(this.obj, var1);
   }
}
