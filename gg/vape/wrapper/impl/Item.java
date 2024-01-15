package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MItem;
import gg.vape.wrapper.Wrapper;

public class Item extends Wrapper {
   public Item(Object var1) {
      super(var1);
   }

   public static Item c8459(String var0) {
      Object var1 = MItem.c6228(vape.getMappings().item, var0);
      return var1 == null ? null : new Item(var1);
   }

   public static int c1501(Item var0) {
      return MItem.c8085(vape.getMappings().item, var0.getObject());
   }

   public static Item c8896(int var0) {
      return new Item(MItem.c1412(vape.getMappings().item, var0));
   }

   public String c6376() {
      return MItem.c2191(vape.getMappings().item, this.getObject());
   }

   public String c2070(ItemStack var1) {
      return MItem.c1921(vape.getMappings().item, this.getObject(), var1.getObject());
   }

   public String c2090(ItemStack var1) {
      return MItem.c2215(vape.getMappings().item, this.getObject(), var1.getObject());
   }

   public int c3715() {
      return c1501(this);
   }

   public static RegistrySimple c7128() {
      return new RegistrySimple(MItem.c4215(vape.getMappings().item));
   }
}
