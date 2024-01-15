package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

public class ClickType extends Wrapper {
   public static ClickType[] c6267 = new ClickType[]{c6725(), c6048(), c3012(), c1841(), c8000(), c1538(), c1023()};

   public ClickType(Object var1) {
      super(var1);
   }

   public static ClickType c6725() {
      return new ClickType(vape.getMappings().clickType.PICKUP);
   }

   public static ClickType c6048() {
      return new ClickType(vape.getMappings().clickType.QUICK_MOVE());
   }

   public static ClickType c3012() {
      return new ClickType(vape.getMappings().clickType.SWAP());
   }

   public static ClickType c1841() {
      return new ClickType(vape.getMappings().clickType.CLONE());
   }

   public static ClickType c8000() {
      return new ClickType(vape.getMappings().clickType.THROW());
   }

   public static ClickType c1538() {
      return new ClickType(vape.getMappings().clickType.QUICK_CRAFT());
   }

   public static ClickType c1023() {
      return new ClickType(vape.getMappings().clickType.PICKUP_ALL());
   }
}
