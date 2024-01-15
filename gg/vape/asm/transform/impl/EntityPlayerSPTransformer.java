package gg.vape.asm.transform.impl;

import gg.vape.Vape;
import gg.vape.asm.helper.EventBuilder;
import gg.vape.asm.helper.Local;
import gg.vape.asm.helper.MethodInfo;
import gg.vape.asm.transform.ClassTransformer;
import gg.vape.event.impl.EventPostMotion;
import gg.vape.event.impl.EventPreMotion;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class EntityPlayerSPTransformer extends ClassTransformer {
   public String c8265;
   public String c737;
   public String c7139;
   public String c2256;
   public MethodInfo c5546;

   public EntityPlayerSPTransformer(Class<?> var1) {
      super(var1);
   }

   public void c6999() {
      new EventBuilder(0, EventPreMotion.class, this.classNode, this.c5546,
              new Local("this").setTarget(Object.class))

              .transform()
              .inject()
              .c2420(94, this.c737, "getYaw")
              .c2420(95, this.c7139, "getPitch")

              .c2420(101, this.c737, "getYaw")
              .c2420(101, this.c7139, "getPitch")

              .c2420(101, this.c2256, "isOnGround")
              .c2420(105, this.c737, "getYaw")
              .c2420(105, this.c7139, "getPitch")
              .c2420(105, this.c2256, "isOnGround")
              .c2420(109, this.c737, "getYaw")
              .c2420(109, this.c7139, "getPitch")
              .c2420(109, this.c2256, "isOnGround")
              .c2420(111, this.c2256, "isOnGround")
              .c2420(126, this.c737, "getYaw")
              .c2420(127, this.c7139, "getPitch");
   }

   public void c681() {
      (new EventBuilder(0, EventPreMotion.class, this.classNode, this.c5546, (new Local("this")).setTarget(Object.class))).transform().inject().c7643(177, "shouldAlwaysSend").c2420(168, this.c8265, "getY").c2420(170, this.c737, "getYaw").c2420(171, this.c7139, "getPitch").c2420(179, this.c8265, "getY").c2420(179, this.c737, "getYaw").c2420(179, this.c7139, "getPitch").c2420(179, this.c2256, "isOnGround").c2420(183, this.c8265, "getY").c2420(183, this.c2256, "isOnGround").c2420(187, this.c737, "getYaw").c2420(187, this.c7139, "getPitch").c2420(187, this.c2256, "isOnGround").c2420(191, this.c2256, "isOnGround").c2420(212, this.c737, "getYaw").c2420(213, this.c7139, "getPitch");
   }

   public void c4582() {
      (new EventBuilder(0, EventPreMotion.class, this.classNode, this.c5546, (new Local("this")).setTarget(Object.class))).transform().inject().c7643(252, "shouldAlwaysSend").c2420(239, this.c8265, "getY").c2420(241, this.c737, "getYaw").c2420(242, this.c7139, "getPitch").c2420(254, this.c8265, "getY").c2420(254, this.c737, "getYaw").c2420(254, this.c7139, "getPitch").c2420(254, this.c2256, "isOnGround").c2420(258, this.c8265, "getY").c2420(258, this.c2256, "isOnGround").c2420(262, this.c737, "getYaw").c2420(262, this.c7139, "getPitch").c2420(262, this.c2256, "isOnGround").c2420(266, this.c2256, "isOnGround").c2420(279, this.c737, "getYaw").c2420(280, this.c7139, "getPitch");
   }

   public void c2422() {
      MappingMethod var1 = null;
      if (ForgeVersion.minorVersion() >= 15) {
         var1 = Vape.instance.getMappings().entityPlayerSP.c5544;
      } else {
         var1 = Vape.instance.getMappings().entityClientPlayerMP.c5162;
      }

      this.c5546 = new MethodInfo(var1.getName(), var1.getDesc());
      this.c8265 = Vape.instance.getMappings().axisAlignedBB.minY.getFieldName();
      this.c737 = Vape.instance.getMappings().entity.yaw.getFieldName();
      this.c7139 = Vape.instance.getMappings().entity.pitch.getFieldName();
      this.c2256 = Vape.instance.getMappings().entity.onGround.getFieldName();
      int var2 = ForgeVersion.minorVersion();
      if (var2 == 13) {
         this.c6999();
      }

      if (var2 == 15) {
         this.c681();
      }

      if (var2 == 23) {
         this.c4582();
      }

      (new EventBuilder(-1, EventPostMotion.class, this.classNode, this.c5546, (new Local("this")).setTarget(Object.class))).transform().inject();
   }

   public void transform() {
      this.c2422();
   }
}
