package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MGuiChest;

public class GuiChest extends GuiContainer {
   public GuiChest(Object var1) {
      super(var1);
   }

   public Inventory c7049() {
      return new Inventory(MGuiChest.c5978(vape.getMappings().guiChest, this.obj));
   }
}
