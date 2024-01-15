package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MRenderItem;
import gg.vape.wrapper.Wrapper;

public class RenderItem extends Wrapper {
   public RenderItem(Object var1) {
      super(var1);
   }

   public static RenderItem c5211() {
      return new RenderItem(MRenderItem.c1015(vape.getMappings().renderItem));
   }

   public void c413(FontRenderer var1, TextureManager var2, ItemStack var3, int var4, int var5) {
      if (ForgeVersion.minorVersion() == 13) {
         MRenderItem.c7891(vape.getMappings().renderItem, this.obj, var1.getObject(), var2.getObject(), var3.getObject(), var4, var5);
      } else {
         MRenderItem.c426(vape.getMappings().renderItem, this.obj, var3.getObject(), var4, var5);
      }

   }

   public void c7826(FontRenderer var1, TextureManager var2, ItemStack var3, int var4, int var5) {
      if (ForgeVersion.minorVersion() == 13) {
         MRenderItem.c8758(vape.getMappings().renderItem, this.obj, var1.getObject(), var2.getObject(), var3.getObject(), var4, var5);
      } else {
         MRenderItem.c1727(vape.getMappings().renderItem, this.obj, var1.getObject(), var3.getObject(), var4, var5);
      }

   }

   public float c6767() {
      return MRenderItem.c3987(vape.getMappings().renderItem, this.obj);
   }
}
