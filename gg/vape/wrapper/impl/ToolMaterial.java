package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MItem_ToolMaterial;
import gg.vape.wrapper.Wrapper;

public class ToolMaterial extends Wrapper {
   public ToolMaterial(Object var1) {
      super(var1);
   }

   public static ToolMaterial c8473() {
      return new ToolMaterial(MItem_ToolMaterial.c7280(vape.getMappings().item_toolMaterial));
   }
}
