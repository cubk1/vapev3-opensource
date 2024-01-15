package gg.vape.module.render.proj;

import gg.vape.mapping.MappedClasses;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;

public class ArrowProjectile extends Projectile {
   public ArrowProjectile() {
      super(new HashSet(Collections.singletonList(MappedClasses.EntityArrow)), new Color(255, 0, 0));
   }

   public float c3964() {
      return 0.25F;
   }

   public float c1226() {
      return 0.5F;
   }
}
