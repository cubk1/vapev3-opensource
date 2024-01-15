package gg.vape.utils;

import gg.vape.Vape;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.blatant.HitBoxes;
import gg.vape.module.combat.Reach;
import gg.vape.module.none.ClientSettings;
import gg.vape.wrapper.impl.*;

import java.util.Iterator;
import java.util.List;

public class RotationUtil {
   public static final boolean c6332 = ForgeVersion.minorVersion() > 13;
   public static Reach c6404 = null;
   public static HitBoxes c7472 = null;

   public static int getAngleToEntity(Entity var0, Entity var1) {
      double var2 = 0.0;
      double var4 = var1.posX() - var0.posX();
      double var6 = var1.posZ() - var0.posZ();
      if (var6 > 0.0 && var4 > 0.0) {
         var2 = Math.toDegrees(-Math.atan(var4 / var6));
      } else if (var6 > 0.0 && var4 < 0.0) {
         var2 = Math.toDegrees(-Math.atan(var4 / var6));
      } else if (var6 < 0.0 && var4 > 0.0) {
         var2 = -90.0 + Math.toDegrees(Math.atan(var6 / var4));
      } else if (var6 < 0.0 && var4 < 0.0) {
         var2 = 90.0 + Math.toDegrees(Math.atan(var6 / var4));
      }

      int var8 = (int)(Math.abs(var2 - (double)var0.rotationYaw()) % 360.0);
      return var8 > 180 ? 360 - var8 : var8;
   }

   public static double c5542(Entity var0, double var1, double var3) {
      double var5 = 0.0;
      double var7 = var1 - var0.posX();
      double var9 = var3 - var0.posZ();
      if (var9 > 0.0 && var7 > 0.0) {
         var5 = Math.toDegrees(-Math.atan(var7 / var9));
      } else if (var9 > 0.0 && var7 < 0.0) {
         var5 = Math.toDegrees(-Math.atan(var7 / var9));
      } else if (var9 < 0.0 && var7 > 0.0) {
         var5 = -90.0 + Math.toDegrees(Math.atan(var9 / var7));
      } else if (var9 < 0.0 && var7 < 0.0) {
         var5 = 90.0 + Math.toDegrees(Math.atan(var9 / var7));
      }

      double var11 = Math.abs(var5 - (double)var0.rotationYaw()) % 360.0;
      double var13 = var11 > 180.0 ? 360.0 - var11 : var11;
      return var13;
   }

   public static int c7991(Entity var0, Entity var1) {
      double var2 = var1.posX() - var0.posX();
      double var4 = var1.posY() - var0.posY() + (double)(var1.c1998() / 2.0F) + 0.2;
      if (ForgeVersion.minorVersion() > 13) {
         var4 = var1.posY() - 0.3 - var0.posY();
      }

      double var6 = var1.posZ() - var0.posZ();
      double var8 = MathUtil.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)(-(Math.atan2(var4, var8) * 180.0 / Math.PI));
      float var11 = (float) MathUtil.c5162(var0.rotationPitch() - var10);
      return (int)var11;
   }

   public static boolean c5613(Entity var0) {
      if (!(var0 instanceof EntityLivingBase)) {
         return var0.isDead();
      } else {
         EntityLivingBase var1 = (EntityLivingBase)var0;
         return var0.isDead() || var1.getHealth() <= 0.0F;
      }
   }

   public static boolean c1548(Entity var0, double var1, double var3) {
      double var5 = 0.0;
      double var7 = var1 - var0.posX();
      double var9 = var3 - var0.posZ();
      if (var9 > 0.0 && var7 > 0.0) {
         var5 = Math.toDegrees(-Math.atan(var7 / var9));
      } else if (var9 > 0.0 && var7 < 0.0) {
         var5 = Math.toDegrees(-Math.atan(var7 / var9));
      } else if (var9 < 0.0 && var7 > 0.0) {
         var5 = -90.0 + Math.toDegrees(Math.atan(var9 / var7));
      } else if (var9 < 0.0 && var7 < 0.0) {
         var5 = 90.0 + Math.toDegrees(Math.atan(var9 / var7));
      }

      int var11 = (int) MathUtil.c5162((var5 - (double)var0.rotationYaw()) % 360.0);
      return var11 < 0;
   }

   public static boolean c2525(Entity var0, Entity var1) {
      double var2 = var1.posX() - var0.posX();
      double var4 = var1.posY() - var0.posY() + (double)(var1.c1998() / 2.0F) + 0.2;
      if (ForgeVersion.minorVersion() > 13) {
         var4 = var1.posY() - 0.3 - var0.posY();
      }

      double var6 = var1.posZ() - var0.posZ();
      double var8 = MathUtil.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)(-(Math.atan2(var4, var8) * 180.0 / Math.PI));
      float var11 = (float) MathUtil.c5162(var0.rotationPitch() - var10);
      return var11 < 0.0F;
   }

   public static EntityLivingBase c7709(double var0, float var2, float var3, float var4) {
      if (Minecraft.c2991().getObject() != null && Minecraft.theWorld().getObject() != null) {
         EntityLivingBase var5 = Minecraft.c2991();
         EntityOtherPlayerMP var6 = EntityOtherPlayerMP.c5474(var5.getWorld(), Minecraft.thePlayer().c5323());
         var6.c4743(var3);
         var6.c6100(var4);
         var6.c7293(var3);
         var6.c834(var4);
         return c7092(var0, var2, var5, var6);
      } else {
         return null;
      }
   }

   public static EntityLivingBase c7493(double var0, float var2) {
      return Minecraft.c2991().getObject() != null && Minecraft.theWorld().getObject() != null ? c7092(var0, var2, Minecraft.c2991(), Minecraft.c2991()) : null;
   }

   public static EntityLivingBase c7092(double var0, float var2, EntityLivingBase var3, EntityLivingBase var4) {
      Entity var5 = null;
      if (Minecraft.c2991().getObject() != null && Minecraft.theWorld().getObject() != null) {
         Vec3 var10 = var3.c181(0.0F);
         Vec3 var11 = var4.c3025(0.0F);
         Vec3 var12 = var10.c5090(var11.getX() * var0, var11.getY() * var0, var11.getZ() * var0);
         float var13 = 1.0F;
         List var14 = Minecraft.theWorld().c7700(var3, var3.boundingBox().c8708(var11.getX() * var0, var11.getY() * var0, var11.getZ() * var0).c6096(var13, var13, var13));
         double var15 = var0;

         for(int var17 = 0; var17 < var14.size(); ++var17) {
            Entity var18 = new Entity(var14.get(var17));
            if (var18.c1797()) {
               float var19 = var18.c3849() + var2;
               AxisAlignedBB var20 = var18.boundingBox().c6096(var19, var19, var19);
               RayTraceResult var21 = var20.c2786(var10, var12);
               if (var20.c6966(var10)) {
                  if (0.0 < var15 || var15 == 0.0) {
                     var5 = var18;
                     var15 = 0.0;
                  }
               } else if (var21.getObject() != null) {
                  double var22 = var10.c3571(var21.c1518());
                  if (var22 < var15 || var15 == 0.0) {
                     if (var18.getObject() == var3.c361().getObject() && !var18.c1199()) {
                        if (var15 == 0.0) {
                           var5 = var18;
                        }
                     } else {
                        var5 = var18;
                        var15 = var22;
                     }
                  }
               }
            }
         }

         if (var5 != null && (var15 < var0 || Minecraft.c1367().getObject() == null) && Minecraft.thePlayer().canEntityBeSeen(var5) && MappedClasses.EntityLivingBase.isInstance(var5.getObject())) {
            EntityLivingBase var24 = new EntityLivingBase(var5.getObject());
            if (!var24.isDead()) {
               return var24;
            }
         }
      }

      return null;
   }

   public static double c582(Entity var0, double var1, double var3, double var5) {
      double var7 = var0.posX() - var1;
      double var9 = var0.posY() - var3;
      double var11 = var0.posZ() - var5;
      return MathUtil.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public static double c6421(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var0 - var6;
      double var14 = var2 - var8;
      double var16 = var4 - var10;
      return MathUtil.sqrt(var12 * var12 + var14 * var14 + var16 * var16);
   }

   public static boolean c8871(EntityLivingBase var0) {
      if (var0 == null) {
         return false;
      } else if (MappedClasses.EntityPlayer.isInstance(var0)) {
         EntityPlayer var1 = (EntityPlayer)var0;
         boolean var2 = false;
         Object[] var3 = var1.c89().c2542();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Object var6 = var3[var5];
            ItemStack var7 = new ItemStack(var6);
            if (!var7.isNull()) {
               var2 = true;
            }
         }

         return var0.c320() && var0.c6156().isNull() && !var2;
      } else {
         return var0.c320() && var0.c6156().isNull();
      }
   }

   public static boolean c7454(EntityLivingBase var0) {
      if (var0.isNull()) {
         return false;
      } else if (!var0.isInstance(MappedClasses.EntityPlayer)) {
         return var0.c6156().isNull();
      } else {
         EntityPlayer var1 = new EntityPlayer(var0);
         boolean var2 = false;
         Object[] var3 = var1.c89().c2542();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Object var6 = var3[var5];
            if (var6 != null) {
               var2 = true;
               break;
            }
         }

         return var0.c6156().isNull() && !var2;
      }
   }

   public static void c1890() {
      if (c6404 == null) {
         c6404 = Vape.instance.getModManager().getMod(Reach.class);
         c7472 = Vape.instance.getModManager().getMod(HitBoxes.class);
      }

      if (!ClientSettings.c2707()) {
         if (c6404.getState() && !c6404.c6232().checkValue() || c7472.getState()) {
            double var0 = c6404.c3973();
            float var2 = c7472.c8217();
            float var3 = 1.0F;
            EntityLivingBase var4 = Minecraft.c2991();
            WorldClient var5 = Minecraft.theWorld();
            PlayerControllerMP var6 = Minecraft.playerController();
            if (!var4.isNull() && !var5.isNull()) {
               Minecraft.c7364(new Entity(null));
               double var7 = var6.c6299();
               Minecraft.c6810(var4.c7488(var7, var3));
               Vec3 var11 = var4.c181(var3);
               boolean var12 = false;
               double var9;
               if (var6.c6738()) {
                  var7 = 6.0;
                  var9 = 6.0;
               } else {
                  var9 = var0;
                  var7 = var0;
                  if (var0 > 3.0) {
                     var12 = true;
                  }
               }

               if (!Minecraft.c1367().isNull()) {
                  if (!var6.c6738()) {
                     var9 = var4.c7488(4.5 + (var7 - 3.0), var3).c1518().c3571(var11);
                  } else {
                     var9 = var4.c7488(var7, var3).c1518().c3571(var11);
                  }
               }

               if (var9 > 6.0) {
                  var9 = 6.0;
               }

               Vec3 var13 = var4.c3025(var3);
               Vec3 var14 = var11.c5090(var13.getX() * var7, var13.getY() * var7, var13.getZ() * var7);
               Minecraft.c2698().c7364(new Entity(null));
               Vec3 var15 = null;
               float var16 = 1.0F;
               List var17 = var5.c7700(var4, var4.boundingBox().c8708(var13.getX() * var7, var13.getY() * var7, var13.getZ() * var7).c6096(var16, var16, var16));
               double var18 = var9;

               for(int var20 = 0; var20 < var17.size(); ++var20) {
                  Entity var21 = new Entity(var17.get(var20));
                  if (var21.c1797()) {
                     float var22 = var21.c3849() + var2;
                     AxisAlignedBB var23 = var21.boundingBox().c6096(var22, var22, var22);
                     RayTraceResult var24 = var23.c2786(var11, var14);
                     if (var23.c6966(var11)) {
                        if (0.0 < var18 || var18 == 0.0) {
                           Minecraft.c2698().c7364(var21);
                           var15 = var24.isNull() ? var11 : var24.c1518();
                           var18 = 0.0;
                        }
                     } else if (!var24.isNull()) {
                        double var25 = var11.c3571(var24.c1518());
                        if (var25 < var18 || var18 == 0.0) {
                           if (var21 == var4.c361() && !var21.c1199()) {
                              if (var18 == 0.0 && c6404.c3177(var21)) {
                                 Minecraft.c2698().c7364(var21);
                                 var15 = var24.c1518();
                              }
                           } else if (!(var25 > 3.0) || c6404.c3177(var21)) {
                              Minecraft.c2698().c7364(var21);
                              var15 = var24.c1518();
                              var18 = var25;
                           }
                        }
                     }
                  }
               }

               Entity var27 = Minecraft.c2698().c4157();
               if (c6332) {
                  if (!var27.isNull() && var12 && var11.c3571(var15) > var0) {
                     Minecraft.c2698().c7364(new Entity(null));
                     Minecraft.c6810(RayTraceResult.c7207(RayTraceResult_type.c3161(), var15, new EnumFacing(null), BlockPos.c6918(var15)));
                  }

                  var27 = Minecraft.c2698().c4157();
               }

               if ((var18 < var9 || Minecraft.c1367().isNull()) && !var27.isNull()) {
                  Minecraft.c6810(RayTraceResult.c4244(var27, var15));
                  if (MappedClasses.EntityLivingBase.isInstance(var27.getObject()) || MappedClasses.EntityItemFrame.isInstance(var27.getObject())) {
                     Minecraft.c7364(var27);
                  }
               }
            }
         }

      }
   }

   public static boolean c7639(EntityLivingBase var0, EntityLivingBase var1, double var2) {
      return c2784(var0, var1, 6.0, var2, 360.0);
   }

   public static boolean c2784(EntityLivingBase var0, EntityLivingBase var1, double var2, double var4, double var6) {
      boolean var8 = var1.isDead() || var1.getName().equals("") || (double)var0.getDistanceToEntity(var1) > var2 || !var0.canEntityBeSeen(var1);
      if (var8) {
         return false;
      } else {
         int var9 = getAngleToEntity(var1, var0);
         int var10 = c7991(var1, var0);
         return (double)var9 < var4 && (double)var10 < var6;
      }
   }

   public static boolean c2980(Entity var0) {
      return var0.getObject().getClass().getName().contains("net.minecraft.entity.passive");
   }

   public static boolean c3232(Entity var0) {
      return var0.getObject().getClass().getName().contains("net.minecraft.entity.monster");
   }

   public static boolean c2881(Entity var0, double var1, double var3, boolean var5) {
      Iterator var6 = Minecraft.theWorld().c8905().iterator();

      EntityOtherPlayerMP var8;
      do {
         do {
            do {
               Object var7;
               do {
                  if (!var6.hasNext()) {
                     return false;
                  }

                  var7 = var6.next();
               } while(!MappedClasses.EntityOtherPlayerMP.isInstance(var7));

               var8 = new EntityOtherPlayerMP(var7);
            } while(var8.equals(var0));
         } while(var5 && Vape.instance.getFriendManager().isFriend(var8));
      } while((double)var8.getDistanceToEntity(var0) >= var1 || !((double) getAngleToEntity(var8, var0) < var3));

      return true;
   }

   public static boolean c1820(Entity var0) {
      return c2881(var0, 6.0, 60.0, true);
   }

   public static boolean c183(Entity var0, double var1, double var3, boolean var5) {
      Iterator var6 = Minecraft.theWorld().c8905().iterator();

      EntityOtherPlayerMP var8;
      do {
         do {
            do {
               Object var7;
               do {
                  if (!var6.hasNext()) {
                     return false;
                  }

                  var7 = var6.next();
               } while(!MappedClasses.EntityOtherPlayerMP.isInstance(var7));

               var8 = new EntityOtherPlayerMP(var7);
            } while(var8.equals(var0));
         } while(var5 && Vape.instance.getFriendManager().isFriend(var8));
      } while((double)var8.getDistanceToEntity(var0) >= var1 || !((double) getAngleToEntity(var0, var8) < var3));

      return true;
   }

   public static boolean c2049(Entity var0) {
      return c183(var0, 6.0, 60.0, true);
   }

   public static boolean c3881(Entity var0) {
      return var0.c6344() == 0.0 && var0.c612() == 0.0;
   }

   public static int c3360(Entity var0, int var1, boolean var2) {
      int var3 = 0;
      Iterator var4 = Minecraft.theWorld().c8905().iterator();

      while(true) {
         EntityOtherPlayerMP var6;
         do {
            Object var5;
            do {
               if (!var4.hasNext()) {
                  return var3;
               }

               var5 = var4.next();
            } while(!MappedClasses.EntityOtherPlayerMP.isInstance(var5));

            var6 = new EntityOtherPlayerMP(var5);
         } while(var2 && Vape.instance.getFriendManager().isFriend(var6));

         if (var6.getDistanceToEntity(var0) <= (float)var1) {
            ++var3;
         }
      }
   }

   public static int c5930(Entity var0, int var1) {
      return c3360(var0, var1, true);
   }

   public static double c4566(Entity var0, Entity var1) {
      double var2 = var0.getDistanceToEntity(var1);
      double var4 = Math.cos(Math.toRadians(var0.rotationYaw() + 90.0F)) * var2;
      double var6 = Math.sin(Math.toRadians(var0.rotationYaw() + 90.0F)) * var2;
      double var8 = var0.posX() + var4;
      double var10 = var0.posZ() + var6;
      return c6421(var8, 0.0, var10, var1.posX(), 0.0, var1.posZ());
   }
}
