package gg.vape.event.impl;

import gg.vape.Vape;
import gg.vape.event.Event;
import gg.vape.module.Mod;
import gg.vape.wrapper.impl.Entity;

import java.util.Iterator;

public class EventMotion extends Event {
   public Entity entity;
   public float yaw;
   public float pitch;
   public boolean onGround;
   protected boolean shouldAlwaysSend;
   double posY;

   public EventMotion(Entity entity, int type) {
      this.entity = entity;
      this.yaw = this.entity.rotationYaw();
      this.pitch = this.entity.rotationPitch();
      this.onGround = this.entity.onGround();
      this.eventType = type;
   }

   public boolean fire() {
      try {
         Iterator var1 = Vape.instance.getModManager().collectMods().iterator();

         while(var1.hasNext()) {
            Mod var2 = (Mod)var1.next();
            if (var2.getState()) {
               var2.onMotionUpdate(this);
            }
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      return this.c5586();
   }

   public void setYaw(float var1) {
      this.yaw = var1;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public void setPitch(float var1) {
      this.pitch = var1;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public void setOnGround(boolean var1) {
      this.onGround = var1;
   }

   public void setY(double var1) {
      this.posY = var1;
   }

   public double getY() {
      return this.posY;
   }

   public boolean shouldAlwaysSend(){
      return shouldAlwaysSend;
   }
}
