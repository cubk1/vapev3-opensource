package gg.vape.module.blatant;

import gg.vape.Vape;
import gg.vape.event.impl.EventMotion;
import gg.vape.event.impl.EventMove;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.unmap.ModeSelection;
import gg.vape.utils.MathUtil;
import gg.vape.utils.TimerUtil;
import gg.vape.utils.datas.BlockData;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.value.NumberValue;
import gg.vape.value.Value;
import gg.vape.wrapper.impl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Scaffold extends Mod {
   public final ModeSelection legitMode = new ModeSelection("Legit");
   public final ModeSelection blatantMode = new ModeSelection("Blatant");
   public final BooleanValue tower = BooleanValue.create(this, "Tower", false, "Builds a tower upwards when you're standing still.");
   public final BooleanValue blockCount = BooleanValue.create(this, "Block Count", false, "Renders your block count on\nthe center of your screen.\n(Blatant Only)");
   public final BooleanValue stopMotion = BooleanValue.create(this, "Stop Motion", false, "Force stops your motion to tower.");
   public final BooleanValue stopSprinting = BooleanValue.create(this, "Stop Sprinting", false, "Stops you from sprinting when scaffolding\nThis is required to bypass AAC/GWEN");
   public final NumberValue delay = NumberValue.create(this, "Delay", "#", "ms", 0.0, 50.0, 500.0, 50.0, "Blatant scaffold place delay.");
   public final ModeValue c2733;
   public final TimerUtil c4937;
   public final TimerUtil c5183;
   public final List c7255;
   public boolean c3627;

   public Scaffold() {
      super("Scaffold", 49630, Category.Blatant, "Helps you make bridges/scaffold walk.");
      this.c2733 = ModeValue.create(this, "Mode", "Legit - Automatically shifts at edge of block when backwards (fastbridge)\nBlatant - Automatically place blocks under you (Designed for Hypixel)", this.legitMode, this.legitMode, this.blatantMode);
      this.c4937 = new TimerUtil();
      this.c5183 = new TimerUtil();
      this.c7255 = Arrays.asList(0, 6, 8, 9, 10, 11, 23, 25, 26, 27, 28, 30, 31, 32, 37, 38, 39, 40, 46, 51, 52, 65, 66, 116, 83, 85, 84, 92, 96, 103, 120, 131, 132, 137, 145, 171, 102, 160, 101, 78, 79, 174, 145, 146, 147, 148, 149, 150, 151, 152, 154, 54, 50, 14, 15, 16, 21, 73, 74, 163, 72, 70, 71, 64, 63, 69, 75, 76, 77, 143, 138);
      this.tower.setParent(this.stopMotion);
      this.addValue(new Value[]{this.c2733, this.tower, this.stopMotion, this.stopSprinting, this.delay, this.blockCount});
   }

   public boolean shouldStopSprinting() {
      return this.getState() && this.stopSprinting.getValue();
   }

   public boolean c399() {
      return this.c2733.getValue().equals(this.legitMode);
   }

   public boolean isBlatantMod() {
      return true;
   }

   public void onRender2D(RenderGameOverlayEvent event) {
      if (this.blockCount.getValue() && this.c2733.getValue().equals(this.blatantMode)) {
         ScaledResolution var2 = ScaledResolution.create(new Minecraft(), Minecraft.displayWidth(), Minecraft.displayHeight());
         float var3 = (float)var2.getScaledWidth();
         float var4 = (float)var2.getScaledHeight();
         FontRenderer var5 = Minecraft.getFontRenderer();
         String var6 = String.valueOf(this.c4332());
         int var7 = (new Color(255, 0, 0)).getRGB();
         if (this.c4332() >= 64 && 128 > this.c4332()) {
            var7 = (new Color(255, 255, 0)).getRGB();
         } else if (this.c4332() >= 128) {
            var7 = (new Color(0, 255, 0)).getRGB();
         }

         var5.drawStringWithShadow(var6, var3 / 2.0F - (float)(var5.getStringWidth(var6) / 2), var4 / 2.0F - 12.0F, var7);
      }

   }

   public void onEnable() {
      Vape.instance.getSettings().speedCheck(this);
      this.c4937.reset();
   }

   public void onDisable() {
      GameSettings var1 = Minecraft.gameSettings();
      if (this.c399() && var1.c4298().c5354()) {
         KeyBinding.setKeyBindState(var1.c4298().getKeyCode(), false);
         KeyBinding.onTick(var1.c4298().getKeyCode());
      }

   }

   public void onMove(EventMove event) {
      try {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         if (var2.onGround() && this.c2733.getValue().equals(this.legitMode)) {
            if (event.isPre()) {
               this.c3627 = var2.movementInput().c5315();
               boolean var3 = false;
               boolean var4 = !(var2.moveForward() > 0.0F) || var2.moveStrafe() != 0.0F;

               if (var4) {
                  var2.movementInput().c7118(true);
                  AxisAlignedBB var5;
                  if (ForgeVersion.minorVersion() >= 15) {
                     var5 = var2.boundingBox();
                  } else {
                     var5 = var2.boundingBox().copy();
                  }

                  if (var2.getWorld().getCollisionBoxes(var2, var5.c6096(-0.2, 0.0, -0.2).c1377(var2.c6344(), -1.0, var2.c612())).isEmpty()) {
                     var3 = true;
                  }
               }

               GameSettings var9 = Minecraft.gameSettings();
               int var6 = var9.c4298().getKeyCode();
               if (var3) {
                  KeyBinding.setKeyBindState(var6, true);
                  KeyBinding.onTick(var6);
               } else {
                  boolean var7 = var6 > 0 ? Keyboard.isKeyDown(var6) : Mouse.isButtonDown(100 + var6);
                  if (this.c3627 && !var7) {
                     KeyBinding.setKeyBindState(var6, false);
                     KeyBinding.onTick(var6);
                  }
               }
            } else {
               var2.movementInput().c7118(this.c3627);
            }
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   public void onMotionUpdate(EventMotion event) {
      try {
         EntityPlayerSP var2 = Minecraft.thePlayer();
         GameSettings var3 = Minecraft.gameSettings();
         this.setSuffix(this.c2733.getValue().getName());
         if (this.c2733.getValue().equals(this.blatantMode)) {
            BlockData var4 = new BlockData(var2.posX(), var2.posY() - 1.0, var2.posZ());
            int var5;
            if (event.isPre()) {
               if (this.shouldStopSprinting() && var2.isSprinting()) {
                  KeyBinding.setKeyBindState(Minecraft.gameSettings().keyBinding().getKeyCode(), false);
                  var2.setSprinting(false);
               }

               Vec3 var6 = this.c3463(var4);
               if (var6 != null) {
                  float[] var7 = this.c3266(var6);
                  event.setYaw(var7[0]);
                  event.setPitch(var7[1]);
               }

               if (this.c4951()) {
                  for(var5 = 9; var5 < 36; ++var5) {
                     if (var2.c7368().c8687(var5).c5354()) {
                        ItemStack var11 = var2.c7368().c8687(var5).c4981();
                        if (var11.getItem().isInstance(MappedClasses.ItemBlock) && !this.c7255.contains(var11.getItem().c3715()) && !c5993(var11)) {
                           this.c4447(var5, 7);
                           break;
                        }
                     }
                  }
               }
            } else {
               boolean var10 = var2.movementInput().moveForward() == 0.0F && var2.movementInput().moveStrafe() == 0.0F;
               if (var3.c6247().c5354() && this.c4332() > 0 && this.tower.getValue() && this.stopMotion.getValue()) {
                  var2.c7148(var2.posX());
                  var2.c8899(var2.posZ());
                  var2.c4745(var2.posX());
                  var2.c8766(var2.posZ());
                  var2.motionX(0.0);
                  var2.motionZ(0.0);
               }

               if (!var10) {
                  this.c4937.reset();
               }

               if (!this.c3386(var4).c5354()) {
                  return;
               }

               var5 = -1;

               int var12;
               for(var12 = 0; var12 < 9; ++var12) {
                  ItemStack var8 = var2.c89().c5272(var12);
                  if (c3858(var8) && !c5993(var8) && var8.getItem().isInstance(MappedClasses.ItemBlock) && !this.c7255.contains(var8.getItem().c3715())) {
                     var5 = var12;
                  }
               }

               if (var5 == -1) {
                  return;
               }

               var12 = var2.c89().c1744();
               var2.c89().c33(var5);
               if (var3.c6247().c5354() && this.tower.checkValue() && this.c4332() > 0) {
                  if (this.stopMotion.getValue()) {
                     var2.motionX(0.0);
                     var2.motionZ(0.0);
                  }

                  if (var2.posY() != (double)(var4.c1908() + 1) && this.c3386(new BlockData(var2.posX(), var2.posY() - 1.0, var2.posZ())) != Material.c8442() && var10) {
                     var2.motionY(0.41999998688697815);
                     var2.motionX(0.0);
                     var2.motionZ(0.0);
                     if (this.c4937.hasTimeElapsed(1000L)) {
                        var2.motionY(-0.28);
                        this.c4937.reset();
                     }
                  }
               }

               if (var2.c89().c5272(var5).getItem().isInstance(MappedClasses.ItemBlock) && !this.c7255.contains(var2.c89().c5272(var5).getItem().c3715()) && this.c5183.hasTimeElapsed(this.delay.getValue().longValue()) && !var2.getWorld().getBlockByPos(var4.c1368(), var4.c1908(), var4.c4775()).isInstance(MappedClasses.BlockChest)) {
                  if (!this.c4482(var4) && !this.c4482(var4.c4178(1, 0, 0)) && !this.c4482(var4.c4178(0, 0, 1)) && !this.c4482(var4.c4178(-1, 0, 0))) {
                     this.c4482(var4.c4178(0, 0, -1));
                  }

                  this.c5183.reset();
               }

               var2.c89().c33(var12);
            }
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }

   public void c4447(int var1, int var2) {
      EntityPlayerSP var3 = Minecraft.thePlayer();
      Minecraft.playerController().c7098(var3.c7368().c3715(), var1, var2, 2, var3);
   }

   public boolean c4951() {
      EntityPlayerSP var1 = Minecraft.thePlayer();

      for(int var2 = 36; var2 < 45; ++var2) {
         if (var1.c7368().c8687(var2).c5354()) {
            ItemStack var3 = var1.c7368().c8687(var2).c4981();
            Item var4 = var3.getItem();
            if (var4.isInstance(MappedClasses.ItemBlock) && !this.c7255.contains(var4.c3715()) && !c5993(var3)) {
               return false;
            }
         }
      }

      return true;
   }

   public boolean c4482(BlockData var1) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      WorldClient var3 = Minecraft.theWorld();
      Vec3 var4 = Vec3.create(var2.posX(), var2.posY() + (double)var2.getEyeHeight(), var2.posZ());
      EnumFacing[] enumFacings = EnumFacing.values();
      int efLen;
      if (ForgeVersion.minorVersion() > 13) {
         BlockPos var7 = BlockPos.create(var1.c1368(), var1.c1908(), var1.c4775());
         efLen = enumFacings.length;

         for(int i = 0; i < efLen; ++i) {
            EnumFacing ef = enumFacings[i];
            BlockPos blockPos = var7.offset(ef);
            EnumFacing efOpposite = ef.getOpposite();
            if (var4.squareDistanceTo(Vec3.create(var7.c3715(), var7.c7544(), var7.c2021()).c5090(0.5, 0.5, 0.5)) < var4.squareDistanceTo(Vec3.create(blockPos.c3715(), blockPos.c7544(), blockPos.c2021()).c5090(0.5, 0.5, 0.5)) && this.c8196(new BlockData(blockPos.c3715(), blockPos.c7544(), blockPos.c2021())).c987(this.c1497(blockPos), false)) {
               Vec3 var13 = Vec3.create(blockPos.c3715(), blockPos.c7544(), blockPos.c2021()).c5090(0.5, 0.5, 0.5).c8894(Vec3.create(efOpposite.c4271().c3715(), efOpposite.c4271().c7544(), efOpposite.c4271().c2021()).c6302(0.5));
               if (var4.squareDistanceTo(var13) <= 18.0) {
                  if (Minecraft.playerController().c1520(var2, var3, var2.getHeldItemHand(), BlockData.c5803(blockPos), efOpposite, var13)) {
                     var2.sendQueue().addToSendQueue(C0APacketAnimation.c8590());
                     this.c5183.reset();
                  }

                  return true;
               }
            }
         }
      } else {
         EnumFacing[] var17 = enumFacings;
         int var18 = enumFacings.length;

         for(efLen = 0; efLen < var18; ++efLen) {
            EnumFacing var19 = var17[efLen];
            BlockData var20 = var1.c430(var19);
            EnumFacing var21 = var19.getOpposite();
            double var22 = var4.squareDistanceTo(Vec3.create(var1.c1368(), var1.c1908(), var1.c4775()).c5090(0.5, 0.5, 0.5));
            double var14 = var4.squareDistanceTo(Vec3.create(var20.c1368(), var20.c1908(), var20.c4775()).c5090(0.5, 0.5, 0.5));
            if (var22 < var14) {
               Vec3 var16 = Vec3.create(var20.c1368(), var20.c1908(), var20.c4775()).c5090(0.5, 0.5, 0.5).c8894(Vec3.create(var21.c7219(), var21.c5705(), var21.c7217()).c6302(0.5));
               if (var4.squareDistanceTo(var16) <= 18.0) {
                  if (Minecraft.playerController().c1520(var2, var3, var2.getHeldItemHand(), var20, var21, var16)) {
                     var2.sendQueue().addToSendQueue(C0APacketAnimation.c8590());
                     this.c5183.reset();
                  }

                  return true;
               }
            }
         }
      }

      return false;
   }

   public Vec3 getBlockVec(BlockData var1) {
      try {
         EntityPlayerSP playerSP = Minecraft.thePlayer();
         Vec3 playerEyeVec = Vec3.create(playerSP.posX(), playerSP.posY() + (double)playerSP.getEyeHeight(), playerSP.posZ());
         EnumFacing[] enumFacings = EnumFacing.values();
         int var5;
         if (ForgeVersion.minorVersion() > 13) {
            BlockPos blockPos = BlockPos.create(var1.c1368(), var1.c1908(), var1.c4775());
            var5 = enumFacings.length;

            for(int i = 0; i < var5; ++i) {
               EnumFacing ef = enumFacings[i];
               if(blockPos.getObject() == null){
                  System.out.println("POSNULL");
               }
               System.out.println(Arrays.toString(enumFacings));
               BlockPos off = blockPos.offset(ef);
               try {
                  off = blockPos.offset(ef);
               }catch (Exception e){
                  e.printStackTrace();
               }
               EnumFacing efOpposite = ef.getOpposite();
               if (playerEyeVec.squareDistanceTo(Vec3.create(blockPos.c3715(), blockPos.c7544(), blockPos.c2021()).c5090(0.5, 0.5, 0.5)) < playerEyeVec.squareDistanceTo(Vec3.create(off.c3715(), off.c7544(), off.c2021()).c5090(0.5, 0.5, 0.5)) && this.c8196(new BlockData(off.c3715(), off.c7544(), off.c2021())).c987(this.c1497(off), false)) {
                  Vec3 var12 = Vec3.create(off.c3715(), off.c7544(), off.c2021()).c5090(0.5, 0.5, 0.5).c8894(Vec3.create(efOpposite.c4271().c3715(), efOpposite.c4271().c7544(), efOpposite.c4271().c2021()).c6302(0.5));
                  if (playerEyeVec.squareDistanceTo(var12) <= 18.0) {
                     return var12;
                  }
               }
            }
         } else {
            EnumFacing[] var17 = enumFacings;
            int var18 = enumFacings.length;

            for(var5 = 0; var5 < var18; ++var5) {
               EnumFacing var19 = var17[var5];
               BlockData var20 = var1.c430(var19);
               EnumFacing var21 = var19.getOpposite();
               double var22 = playerEyeVec.squareDistanceTo(Vec3.create(var1.c1368(), var1.c1908(), var1.c4775()).c5090(0.5, 0.5, 0.5));
               double var13 = playerEyeVec.squareDistanceTo(Vec3.create(var20.c1368(), var20.c1908(), var20.c4775()).c5090(0.5, 0.5, 0.5));
               if (var22 < var13) {
                  Vec3 var15 = Vec3.create(var20.c1368(), var20.c1908(), var20.c4775()).c5090(0.5, 0.5, 0.5).c8894(Vec3.create(var21.c7219(), var21.c5705(), var21.c7217()).c6302(0.5));
                  if (playerEyeVec.squareDistanceTo(var15) <= 18.0) {
                     return var15;
                  }
               }
            }
         }
      } catch (Exception var16) {
         var16.printStackTrace();
      }

      return null;
   }

   public Vec3 c3463(BlockData var1) {
      try {
         Vec3 var2;
         if ((var2 = this.getBlockVec(var1)) == null && (var2 = this.getBlockVec(var1.c4178(1, 0, 0))) == null && (var2 = this.getBlockVec(var1.c4178(0, 0, 1))) == null && (var2 = this.getBlockVec(var1.c4178(-1, 0, 0))) == null) {
            var2 = this.getBlockVec(var1.c4178(0, 0, -1));
         }

         return var2;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public float[] c3266(Vec3 var1) {
      EntityPlayerSP var2 = Minecraft.thePlayer();
      double var3 = var1.getX() - var2.posX();
      double var5 = var1.getY() - (var2.posY() + (double)var2.getEyeHeight());
      double var7 = var1.getZ() - var2.posZ();
      double var9 = MathUtil.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      float var13 = var2.rotationYaw() + MathUtil.wrapAngleTo180(var11 - var2.rotationYaw());
      float var14 = var2.rotationPitch() + MathUtil.wrapAngleTo180(var12 - var2.rotationPitch());
      return new float[]{var13, var14};
   }

   public static boolean c3858(ItemStack var0) {
      if (!var0.isNull() && !var0.getItem().isNull()) {
         return !var0.c6376().equalsIgnoreCase("tile.cactus") && var0.getItem().isInstance(MappedClasses.ItemBlock);
      } else {
         return false;
      }
   }

   public BlockState c1497(BlockPos var1) {
      return Minecraft.theWorld().getBlockState(var1);
   }

   public Block c8196(BlockData var1) {
      return Minecraft.theWorld().getBlockByPos(var1.c1368(), var1.c1908(), var1.c4775());
   }

   public Material c3386(BlockData var1) {
      return this.c8196(var1).c4045();
   }

   public static boolean c5993(ItemStack var0) {
      return var0.isNull();
   }

   public int c4332() {
      EntityPlayerSP var1 = Minecraft.thePlayer();
      int var2 = 0;

      for(int var3 = 0; var3 < 45; ++var3) {
         if (var1.c7368().c8687(var3).c5354()) {
            ItemStack var4 = var1.c7368().c8687(var3).c4981();
            Item var5 = var4.getItem();
            if (var4.getItem().isInstance(MappedClasses.ItemBlock) && !this.c7255.contains(var5.c3715())) {
               var2 += var4.c5705();
            }
         }
      }

      return var2;
   }
}
