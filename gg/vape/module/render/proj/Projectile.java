package gg.vape.module.render.proj;

import gg.vape.wrapper.impl.EntityThrowable;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class Projectile implements IProjectile {
   public final Set c7320;
   public final Color c4874;

   public Projectile(Set var1, Color var2) {
      this.c7320 = var1;
      this.c4874 = var2;
   }

   public Projectile(Set var1) {
      this(var1, new Color(255, 255, 255));
   }

   public boolean c2764(EntityThrowable var1) {
      Iterator var2 = this.c7320.iterator();

      Class var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Class)var2.next();
      } while(!var1.isInstance(var3));

      return true;
   }

   public Color c5715(Object var1) {
      return this.c4874;
   }
}
