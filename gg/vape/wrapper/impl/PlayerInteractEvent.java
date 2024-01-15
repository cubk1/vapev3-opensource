package gg.vape.wrapper.impl;

import gg.vape.Vape;
import gg.vape.mapping.mappings.MPlayerInteractEvent;

public class PlayerInteractEvent extends PlayerEvent {
   public PlayerInteractEvent(Object var1) {
      super(var1);
   }

   public int c1744() {
      if (ForgeVersion.minorVersion() == 13) {
         return MPlayerInteractEvent.c7739(Vape.instance.getMappings().playerInteractEvent, this.getObject());
      } else {
         return this.c8566().isNull() ? 0 : this.c8566().c3715();
      }
   }

   public int c3715() {
      if (ForgeVersion.minorVersion() == 13) {
         return MPlayerInteractEvent.c2934(Vape.instance.getMappings().playerInteractEvent, this.getObject());
      } else {
         return this.c8566().isNull() ? 0 : this.c8566().c7544();
      }
   }

   public int c7544() {
      if (ForgeVersion.minorVersion() == 13) {
         return MPlayerInteractEvent.c8904(Vape.instance.getMappings().playerInteractEvent, this.getObject());
      } else {
         return this.c8566().isNull() ? 0 : this.c8566().c2021();
      }
   }

   public int c7219() {
      if (ForgeVersion.minorVersion() == 13) {
         return MPlayerInteractEvent.c295(Vape.instance.getMappings().playerInteractEvent, this.getObject());
      } else {
         return this.c5399().isNull() ? -1 : this.c5399().c1744();
      }
   }

   public BlockPos c8566() {
      return new BlockPos(MPlayerInteractEvent.c39(Vape.instance.getMappings().playerInteractEvent, this.getObject()));
   }

   public EnumFacing c5399() {
      return new EnumFacing(MPlayerInteractEvent.c1681(Vape.instance.getMappings().playerInteractEvent, this.getObject()));
   }

   public String c2485() {
      return ForgeVersion.minorVersion() >= 23 ? "" : MPlayerInteractEvent.c2221(Vape.instance.getMappings().playerInteractEvent, this.getObject());
   }
}
