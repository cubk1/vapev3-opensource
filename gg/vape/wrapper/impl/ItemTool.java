package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MItemTool;
import gg.vape.wrapper.Wrapper;

public class ItemTool extends Wrapper {
   public ItemTool(Object var1) {
      super(var1);
   }

   public ToolMaterial c8473() {
      return new ToolMaterial(MItemTool.c4940(vape.getMappings().itemTool, this.obj));
   }
}
