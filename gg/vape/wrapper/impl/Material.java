package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class Material extends Wrapper {
   public Material(Object var1) {
      super(var1);
   }

   public static Material c8442() {
      return new Material(vape.getMappings().material.c6031());
   }

   public static Material c4045() {
      return new Material(vape.getMappings().material.c7468());
   }

   public boolean c5354() {
      return vape.getMappings().material.c4246(this.obj);
   }
}
