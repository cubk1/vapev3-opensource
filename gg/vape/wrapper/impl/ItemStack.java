package gg.vape.wrapper.impl;

import com.google.common.collect.Multimap;
import gg.vape.mapping.mappings.MItemStack;
import gg.vape.wrapper.Wrapper;

public class ItemStack extends Wrapper {
   public ItemStack(Object var1) {
      super(var1);
   }

   public static ItemStack c8898(Item var0) {
      return new ItemStack(vape.getMappings().itemStack.c5327(var0.getObject()));
   }

   public String c6376() {
      return vape.getMappings().itemStack.c4474(this.getObject());
   }

   public Item getItem() {
      return new Item(vape.getMappings().itemStack.getItem(this.obj));
   }

   public String c376() {
      return MItemStack.c6020(vape.getMappings().itemStack, this.obj);
   }

   public int c2021() {
      return MItemStack.c7893(vape.getMappings().itemStack, this.obj);
   }

   public TagList c7173() {
      return new TagList(MItemStack.c8454(vape.getMappings().itemStack, this.obj));
   }

   public Multimap c8230() {
      return ForgeVersion.minorVersion() >= 23 ? MItemStack.c7763(vape.getMappings().itemStack, this.obj, EntityEquipmentSlot.c2128().getObject()) : MItemStack.c6113(vape.getMappings().itemStack, this.obj);
   }

   public float c4126(int var1, int var2, int var3) {
      WorldClient var4 = Minecraft.theWorld();
      if (ForgeVersion.minorVersion() >= 23) {
         BlockState var5 = var4.getBlockState(BlockPos.create(var1, var2, var3));
         return MItemStack.c6753(vape.getMappings().itemStack, this.obj, var5.getObject());
      } else {
         return MItemStack.c6753(vape.getMappings().itemStack, this.obj, var4.getBlockByPos(var1, var2, var3).getObject());
      }
   }

   public int c5705() {
      return vape.getMappings().itemStack.c7740(this.obj);
   }
}
