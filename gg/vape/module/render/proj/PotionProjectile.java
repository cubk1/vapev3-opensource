package gg.vape.module.render.proj;

import gg.vape.mapping.MappedClasses;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;

public class PotionProjectile extends Projectile {
   public PotionProjectile() {
      super(new HashSet(Collections.singleton(MappedClasses.EntityPotion)), new Color(255, 66, 249));
   }
}
