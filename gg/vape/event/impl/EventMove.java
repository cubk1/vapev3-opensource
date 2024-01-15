package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;

public class EventMove extends Event {
   public double x;
   public double y;
   public double z;

   public EventMove(int type, double x, double y, double z) {
      this.eventType = type;
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public double getX() {
      return this.x;
   }

   public EventMove setX(double var1) {
      this.x = var1;
      return this;
   }

   public double getY() {
      return this.y;
   }

   public EventMove setY(double var1) {
      this.y = var1;
      return this;
   }

   public double getZ() {
      return this.z;
   }

   public EventMove setZ(double var1) {
      this.z = var1;
      return this;
   }

   public boolean fire() {

      for (Mod mod : Vape.instance.getModManager().collectMods()) {
         if (mod.getState()) {
            mod.onMove(this);
         }
      }

      return super.fire();
   }
}
