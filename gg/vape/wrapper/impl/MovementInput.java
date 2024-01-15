package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MMovementInput;
import gg.vape.wrapper.Wrapper;

public class MovementInput extends Wrapper {
   public MovementInput(Object var1) {
      super(var1);
   }

   public boolean c2913() {
      return MMovementInput.c1266(vape.getMappings().movementInput, this.obj);
   }

   public void c175(boolean var1) {
      MMovementInput.c3724(vape.getMappings().movementInput, this.obj, var1);
   }

   public boolean c6738() {
      return MMovementInput.c2398(vape.getMappings().movementInput, this.obj);
   }

   public void c335(boolean var1) {
      MMovementInput.c1064(vape.getMappings().movementInput, this.obj, var1);
   }

   public boolean c5354() {
      return MMovementInput.c1265(vape.getMappings().movementInput, this.obj);
   }

   public void c2112(boolean var1) {
      MMovementInput.c1970(vape.getMappings().movementInput, this.obj, var1);
   }

   public boolean c3300() {
      return MMovementInput.c4906(vape.getMappings().movementInput, this.obj);
   }

   public void c479(boolean var1) {
      MMovementInput.c5536(vape.getMappings().movementInput, this.obj, var1);
   }

   public float moveStrafe() {
      return MMovementInput.c7265(vape.getMappings().movementInput, this.obj);
   }

   public float moveForward() {
      return MMovementInput.c7135(vape.getMappings().movementInput, this.obj);
   }

   public void moveStrafe(float var1) {
      MMovementInput.c6453(vape.getMappings().movementInput, this.obj, var1);
   }

   public void moveForward(float var1) {
      MMovementInput.moveForward(vape.getMappings().movementInput, this.obj, var1);
   }

   public boolean c3624() {
      return MMovementInput.c8303(vape.getMappings().movementInput, this.obj);
   }

   public boolean c5315() {
      return MMovementInput.c6710(vape.getMappings().movementInput, this.obj);
   }

   public void c2591(boolean var1) {
      MMovementInput.c7333(vape.getMappings().movementInput, this.obj, var1);
   }

   public void c7118(boolean var1) {
      MMovementInput.c7018(vape.getMappings().movementInput, this.obj, var1);
   }
}
