package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class WorldNameable extends Wrapper {
   public WorldNameable(Object var1) {
      super(var1);
   }

   public String c6376() {
      return vape.getMappings().worldNameable.c68(this.obj);
   }

   public boolean c6738() {
      return vape.getMappings().worldNameable.c5419(this.obj);
   }

   public ITextComponent c7508() {
      return new ITextComponent(vape.getMappings().worldNameable.c5327(this.obj));
   }
}
