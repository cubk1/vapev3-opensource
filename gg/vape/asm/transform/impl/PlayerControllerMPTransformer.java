package gg.vape.asm.transform.impl;

import gg.vape.Vape;
import gg.vape.asm.helper.EventBuilder;
import gg.vape.asm.helper.Local;
import gg.vape.asm.helper.MethodInfo;
import gg.vape.asm.transform.ClassTransformer;
import gg.vape.event.impl.EventPostAttack;
import gg.vape.event.impl.EventPreAttack;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class PlayerControllerMPTransformer extends ClassTransformer {
   public final String c6174;

   public PlayerControllerMPTransformer() {
      super(MappedClasses.PlayerControllerMP);
      if (ForgeVersion.minorVersion() >= 15) {
         this.c6174 = "targetEntity";
      } else {
         this.c6174 = "p_78764_2_";
      }

   }

   public void c6999() {
      MappingMethod var1 = Vape.instance.getMappings().playerControllerMP.attackEntity;
      MethodInfo var2 = new MethodInfo(var1.getName(), var1.getDesc());
      Local var3 = (new Local("Ljava/lang/Object;",this.c6174,"param2","p_78764_2_","p_attackEntity_2_")).setTarget(Object.class);
      (new EventBuilder(0, EventPreAttack.class, this.classNode, var2, var3)).transform().inject();
      (new EventBuilder(-1, EventPostAttack.class, this.classNode, var2, var3)).transform().inject();
   }

   public void transform() {
      this.c6999();
   }
}
