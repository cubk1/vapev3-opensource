package gg.vape.module.render.proj;

import gg.vape.wrapper.impl.EntityThrowable;

import java.awt.*;

public interface IProjectile {
   boolean c2764(EntityThrowable var1);

   default float c3964() {
      return 0.125F;
   }

   default float c1226() {
      return 0.25F;
   }

   Color c5715(Object var1);
}
