package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MNBTTagList;
import gg.vape.wrapper.Wrapper;

public class TagList extends Wrapper {
   public TagList(Object var1) {
      super(var1);
   }

   public int c1744() {
      return MNBTTagList.c891(vape.getMappings().tagList, this.obj);
   }

   public TagCompound c5365(int var1) {
      return new TagCompound(MNBTTagList.c7390(vape.getMappings().tagList, this.obj, var1));
   }
}
