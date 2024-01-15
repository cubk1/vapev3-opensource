package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MGuiContainer;

import java.util.Set;

public class GuiContainer extends GuiScreen {
   public GuiContainer(Object var1) {
      super(var1);
   }

   public Container c7455() {
      return new Container(vape.getMappings().guiContainer.c6780(this.obj));
   }

   public Slot c1577(int var1, int var2) {
      return new Slot(MGuiContainer.c1605(vape.getMappings().guiContainer, this.obj, var1, var2));
   }

   public void c175(boolean var1) {
      MGuiContainer.c3065(vape.getMappings().guiContainer, this.obj, var1);
   }

   public void c335(boolean var1) {
      MGuiContainer.c3798(vape.getMappings().guiContainer, this.obj, var1);
   }

   public int c341() {
      return MGuiContainer.c7250(vape.getMappings().guiContainer, this.obj);
   }

   public int c7219() {
      return MGuiContainer.c218(vape.getMappings().guiContainer, this.obj);
   }

   public int c5705() {
      return MGuiContainer.c3419(vape.getMappings().guiContainer, this.obj);
   }

   public int c7217() {
      return MGuiContainer.c6714(vape.getMappings().guiContainer, this.obj);
   }

   public ItemStack c719() {
      return new ItemStack(MGuiContainer.c5364(vape.getMappings().guiContainer, this.obj));
   }

   public void c7525(ItemStack var1) {
      MGuiContainer.c4663(vape.getMappings().guiContainer, this.obj, var1.getObject());
   }

   public void c4051(Slot var1, int var2, int var3, int var4) {
      MGuiContainer.c2403(vape.getMappings().guiContainer, this.obj, var1.getObject(), var2, var3, var4);
   }

   public void c1619(Slot var1, int var2, int var3, ClickType var4) {
      MGuiContainer.c4423(vape.getMappings().guiContainer, this.obj, var1.getObject(), var2, var3, var4.getObject());
   }

   public void c8768(Slot var1) {
      MGuiContainer.c6768(vape.getMappings().guiContainer, this.obj, var1.getObject());
   }

   public void c5892(long var1) {
      MGuiContainer.c8059(vape.getMappings().guiContainer, this.obj, var1);
   }

   public void c33(int var1) {
      MGuiContainer.c4453(vape.getMappings().guiContainer, this.obj, var1);
   }

   public void c2112(boolean var1) {
      MGuiContainer.c2349(vape.getMappings().guiContainer, this.obj, var1);
   }

   public void c2062(int var1) {
      MGuiContainer.c5611(vape.getMappings().guiContainer, this.obj, var1);
   }

   public Set c2886() {
      return MGuiContainer.c8060(vape.getMappings().guiContainer, this.obj);
   }

   public void c5732(int var1) {
      MGuiContainer.c1080(vape.getMappings().guiContainer, this.obj, var1);
   }
}
