package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;

public class MClickType extends Mapping {
   public final MappingField PICKUP;
   public final MappingField QUICK_MOVE;
   public final MappingField SWAP;
   public final MappingField CLONE;
   public final MappingField THROW;
   public final MappingField QUICK_CRAFT;
   public final MappingField PICKUP_ALL;

   public MClickType() {
      super(MappedClasses.ClickType);
      this.PICKUP = this.getMappingField("PICKUP", true, MappedClasses.ClickType);
      this.QUICK_MOVE = this.getMappingField("QUICK_MOVE", true, MappedClasses.ClickType);
      this.SWAP = this.getMappingField("SWAP", true, MappedClasses.ClickType);
      this.CLONE = this.getMappingField("CLONE", true, MappedClasses.ClickType);
      this.THROW = this.getMappingField("THROW", true, MappedClasses.ClickType);
      this.QUICK_CRAFT = this.getMappingField("QUICK_CRAFT", true, MappedClasses.ClickType);
      this.PICKUP_ALL = this.getMappingField("PICKUP_ALL", true, MappedClasses.ClickType);
   }

   public Object PICKUP() {
      return this.PICKUP.getObject(null);
   }

   public Object QUICK_MOVE() {
      return this.QUICK_MOVE.getObject(null);
   }

   public Object SWAP() {
      return this.SWAP.getObject(null);
   }

   public Object CLONE() {
      return this.CLONE.getObject(null);
   }

   public Object THROW() {
      return this.THROW.getObject(null);
   }

   public Object QUICK_CRAFT() {
      return this.QUICK_CRAFT.getObject(null);
   }

   public Object PICKUP_ALL() {
      return this.PICKUP_ALL.getObject(null);
   }

}
