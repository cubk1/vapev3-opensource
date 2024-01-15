package gg.vape.wrapper.impl;

import gg.vape.Vape;
import gg.vape.mapping.mappings.MGameSettings;
import gg.vape.module.none.ClientSettings;
import gg.vape.wrapper.Wrapper;

public class GameSettings extends Wrapper {
   public GameSettings(Object var1) {
      super(var1);
   }

   public KeyBinding c210() {
      return new KeyBinding(MGameSettings.c8188(Vape.instance.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c3763() {
      return new KeyBinding(MGameSettings.c8804(Vape.instance.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c6987() {
      return new KeyBinding(MGameSettings.c937(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c4590() {
      return new KeyBinding(MGameSettings.c7753(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c1091() {
      return new KeyBinding(MGameSettings.c6366(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c2387() {
      return new KeyBinding(MGameSettings.c748(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c4599() {
      return new KeyBinding(MGameSettings.c933(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c6247() {
      return new KeyBinding(MGameSettings.c3570(vape.getMappings().gameSettings, this.getObject()));
   }

   public KeyBinding c4298() {
      return new KeyBinding(MGameSettings.c2379(vape.getMappings().gameSettings, this.getObject()));
   }

   public int c5203() {
      return MGameSettings.c5431(vape.getMappings().gameSettings, this.getObject());
   }

   public boolean c100() {
      return MGameSettings.c4477(vape.getMappings().gameSettings, this.obj);
   }

   public void c175(boolean var1) {
      MGameSettings.c2246(vape.getMappings().gameSettings, this.obj, var1);
   }

   public boolean c1173() {
      return MGameSettings.c2701(vape.getMappings().gameSettings, this.obj);
   }

   public void c335(boolean var1) {
      MGameSettings.c7958(vape.getMappings().gameSettings, this.obj, var1);
   }

   public int c8694() {
      if (ClientSettings.not1710) {
         return MGameSettings.c4982(vape.getMappings().gameSettings, this.obj);
      } else {
         return MGameSettings.c4558(vape.getMappings().gameSettings, this.obj) ? 2 : 0;
      }
   }

   public void c33(int var1) {
      if (ClientSettings.not1710) {
         MGameSettings.c4262(vape.getMappings().gameSettings, this.obj, var1);
      } else {
         MGameSettings.c1946(vape.getMappings().gameSettings, this.obj, var1 > 0);
      }

   }

   public float c5716() {
      return MGameSettings.c1924(vape.getMappings().gameSettings, this.obj);
   }

   public void c6025(float var1) {
      MGameSettings.c5181(vape.getMappings().gameSettings, this.obj, var1);
   }

   public KeyBinding keyBinding() {
      return new KeyBinding(MGameSettings.c7759(vape.getMappings().gameSettings, this.obj));
   }

   public KeyBinding c3503() {
      return new KeyBinding(MGameSettings.c6160(vape.getMappings().gameSettings, this.obj));
   }

   public void c2062(int var1) {
      MGameSettings.c7657(vape.getMappings().gameSettings, this.obj, var1);
   }

   public boolean c8729() {
      return MGameSettings.c2174(vape.getMappings().gameSettings, this.obj);
   }

   public void c2112(boolean var1) {
      MGameSettings.c254(vape.getMappings().gameSettings, this.obj, var1);
   }

   public int c8517() {
      return MGameSettings.c6188(vape.getMappings().gameSettings, this.obj);
   }

   public void c5732(int var1) {
      MGameSettings.c3364(vape.getMappings().gameSettings, this.obj, var1);
   }

   public float c6231() {
      return MGameSettings.c6317(vape.getMappings().gameSettings, this.obj);
   }

   public int c8495() {
      return MGameSettings.c2686(vape.getMappings().gameSettings, this.obj);
   }

   public boolean c521() {
      return MGameSettings.c1498(vape.getMappings().gameSettings, this.obj);
   }
}
