package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MGuiScreen;
import gg.vape.wrapper.Wrapper;

public class GuiScreen extends Wrapper {
   public GuiScreen(Object var1) {
      super(var1);
   }

   public int c1744() {
      return MGuiScreen.c6747(vape.getMappings().guiScreen, this.obj);
   }

   public int c3715() {
      return MGuiScreen.c3642(vape.getMappings().guiScreen, this.obj);
   }
}
