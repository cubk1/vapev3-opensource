package gg.vape.asm.transform.impl;

import gg.vape.Vape;
import gg.vape.asm.helper.EventBuilder;
import gg.vape.asm.helper.Local;
import gg.vape.asm.helper.MethodInfo;
import gg.vape.asm.transform.ClassTransformer;
import gg.vape.event.impl.EventPostMove;
import gg.vape.event.impl.EventPreMove;
import gg.vape.event.impl.EventSetSprinting;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class EntityTransformer extends ClassTransformer {
   public final String local_x;
   public final String local_y;
   public final String local_z;
   public final String local_sprinting;

   public EntityTransformer() {
      super(MappedClasses.Entity);
      if (ForgeVersion.minorVersion() >= 15) {
         this.local_x = "x";
         this.local_y = "y";
         this.local_z = "z";
         this.local_sprinting = "sprinting";
      } else {
         this.local_x = "p_70091_1_";
         this.local_y = "p_70091_3_";
         this.local_z = "p_70091_5_";
         this.local_sprinting = "p_70031_1_";
      }

   }

   public void moveTransform() {
      //moveEntity
      MappingMethod target = Vape.instance.getMappings().entity.c8075;
      MethodInfo info = new MethodInfo(target.getName(), target.getDesc());
      Local lx = new Local("D", this.local_x,"param1","p_moveEntity_1_","p_70091_1_");
      Local ly = new Local("D", this.local_y,"param3","p_moveEntity_3_","p_70091_3_");
      Local lz = new Local("D", this.local_z,"param5","p_moveEntity_5_","p_70091_5_");
      new EventBuilder(HEAD, EventPreMove.class, this.classNode, info, lx, ly, lz)
              .preTransform(new Local("this"), MappedClasses.EntityPlayerSP)
              .transform()
              .relocal(lx, "getX")
              .relocal(ly, "getY")
              .relocal(lz, "getZ")
              .inject();
      new EventBuilder(-1, EventPostMove.class, this.classNode, info, lx, ly, lz)
              .preTransform(new Local("this"), MappedClasses.EntityPlayerSP)
              .transform()
              .inject();
   }

   public void c681() {
   }

   public void setSprintingTransform() {
      MappingMethod target = Vape.instance.getMappings().entity.c3909;
      MethodInfo var2 = new MethodInfo(target.getName(), target.getDesc());
      (new EventBuilder(0, EventSetSprinting.class, this.classNode, var2, (new Local("this")).setTarget(Object.class), new Local("Z",this.local_sprinting,"param1","p_setSprinting_1_","p_70031_1"))).transform().inject();
   }

   public void transform() {
      this.moveTransform();
      this.setSprintingTransform();
   }
}
