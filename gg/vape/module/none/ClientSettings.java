package gg.vape.module.none;

import com.google.common.collect.Multimap;
import gg.vape.Vape;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Mod;
import gg.vape.module.blatant.*;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.utils.KeyBoardUtil;
import gg.vape.utils.RotationUtil;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.value.Value;
import gg.vape.wrapper.impl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import pub.nextsense.Tweaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ClientSettings {
   public static boolean not1710 = ForgeVersion.minorVersion() > 13;
   public static String colorPrefix = String.valueOf('§');
   public final SquareButton syncSettingsButton = new SquareButton("Sync Settings", false);
   public ColorValue guiColor;
   public BooleanValue showTooltips;
   public BooleanValue ignoreNaked;
   public BooleanValue players;
   public BooleanValue mobs;
   public BooleanValue mcf;
   public BooleanValue blatantMode;
   public AntiBot theAntiBot;
   public final BooleanValue teamServer;
   public final BooleanValue teamColor;
   public BooleanValue enableOnLoad;
   public BooleanValue speedCheck;
   public final List<Value<?,? extends IGuiComponent>> csValues;

   public ClientSettings() {
      this.guiColor = ColorValue.create(this, "Gui Color", GuiComponent.accentColor);
      this.showTooltips = BooleanValue.create(this, "Show Tooltips", true, "Toggles visibility of these");
      this.ignoreNaked = BooleanValue.create(this, "Ignore naked", false, "Ignore entities without armor or a held item");
      this.players = BooleanValue.create(this, "Players", true, "Attack players");
      this.mobs = BooleanValue.create(this, "Mobs", false, "Attack mobs");
      this.mcf = BooleanValue.create(this, "MiddleClick friends", true, "Click middle mouse button to add the player you are hovering over as a friend");
      this.blatantMode = BooleanValue.create(this, "Blatant mode", false, "Required for certain features.\nThis may make your client detectable(via screenshare) until you restart Minecraft.\nThis cannot be disabled once enabled.");
      this.teamServer = BooleanValue.create(this, "Teams by server", false, "Ignore players on your team designated by the server");
      this.teamColor = BooleanValue.create(this, "Teams by color", false, "Ignore players with the same name color as you");
      this.enableOnLoad = BooleanValue.create(this, "Enable on load", false, "Enable blatant mode upon injecting vape");
      this.speedCheck = BooleanValue.create(this, "Speed Check", false, "Disables any active movement modules\nwhen enabling another.");
      this.csValues = new ArrayList<>(Arrays.asList(this.guiColor, this.players, this.mobs, this.ignoreNaked, this.teamServer, this.teamColor, this.mcf, this.showTooltips, this.blatantMode, this.enableOnLoad, this.speedCheck));
      if (Vape.isSupportedVersion()) {
         ((BooleanComponent)this.blatantMode.getComponent()).getCheckBox().addAction(new ActionEnableBlatantMode(this));
         ((BooleanComponent)this.blatantMode.getComponent()).getCheckBox().addAction(new c3256(this));
      } else {
         ((BooleanComponent)this.blatantMode.getComponent()).getCheckBox().c4983(true);
         this.blatantMode.getComponent().c4983(true);
         ((BooleanComponent)this.blatantMode.getComponent()).setText("Blatant mode not yet available for this Minecraft version");
      }

      ((BooleanComponent)this.enableOnLoad.getComponent()).getCheckBox().addAction(new c3240(this));
      ((BooleanComponent)this.speedCheck.getComponent()).getCheckBox().addAction(new c5838(this));
      this.blatantMode.setToggleable(false);
      this.blatantMode.limitValues(this.enableOnLoad);
      this.blatantMode.limitValues(this.speedCheck);
   }
   class c5838 implements IButtonOnClick {
      // $FF: synthetic field
      final ClientSettings c8030;

      c5838(ClientSettings var1) {
         this.c8030 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            ((BooleanComponent)this.c8030.speedCheck.getComponent()).c8121(!this.c8030.speedCheck.getValue());
            this.c8030.blatantMode.setToggleable(this.c8030.speedCheck.getValue());
         }
      }
   }

   class c3240 implements IButtonOnClick {
      // $FF: synthetic field
      final ClientSettings c7817;

      c3240(ClientSettings var1) {
         this.c7817 = var1;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            ((BooleanComponent)this.c7817.enableOnLoad.getComponent()).c8121(!this.c7817.enableOnLoad.getValue());
            this.c7817.blatantMode.setToggleable(this.c7817.enableOnLoad.getValue());
         }
      }
   }

   class c3256 implements IGuiCallback {
      // $FF: synthetic field
      final ClientSettings c6773;

      c3256(ClientSettings var1) {
         this.c6773 = var1;
      }

      public void call(IGuiComponent inst) {
         if (Tweaker.isBlatantMode()) {
            ((BooleanComponent)this.c6773.blatantMode.getComponent()).c8121(true);
         }

      }
   }

   static class ActionEnableBlatantMode implements IButtonOnClick {
      // $FF: synthetic field
      final ClientSettings clientSettings;

      ActionEnableBlatantMode(ClientSettings clientSettings) {
         this.clientSettings = clientSettings;
      }

      public void onClick(int mouseX, int mouseY, int mouseBn) {
         if (mouseBn == 0) {
            if (!Tweaker.isBlatantMode()) {
               Tweaker.loadBlatantMode();
            }
         }
      }
   }
   public static boolean isMouseDown() {
      int var0 = Minecraft.gameSettings().c210().getKeyCode();
      int var1 = 100 + var0;
      return var1 == 0 ? KeyBoardUtil.c6509() : Mouse.isButtonDown(var1);
   }

   public static boolean c2707() {
      int var0 = Minecraft.gameSettings().c3763().getKeyCode();
      int var1 = 100 + var0;
      return var1 == 1 ? KeyBoardUtil.c2203() : Mouse.isButtonDown(var1);
   }

   public static boolean c7649(KeyBinding var0) {
      int var1 = var0.getKeyCode();
      return var1 > 0 ? Keyboard.isKeyDown(var1) : Mouse.isButtonDown(100 + var1);
   }

   public static double c7384(ItemStack var0) {
      double var1 = 0.0;
      Multimap var3 = var0.c8230();
      if (var3.size() > 0) {
         AttributeModifier var4 = new AttributeModifier(var3.values().toArray()[0]);
         var1 = var4.c1779();
      }

      var1 += EnchantmentHelper.c2619(var0, EnumCreatureAttribute.c3198());
      return var1;
   }

   public static double c913(ItemStack var0) {
      double var1 = 0.0;
      Multimap var3 = var0.c8230();
      if (var3.size() > 0) {
         AttributeModifier var4 = new AttributeModifier(var3.values().toArray()[0]);
         var1 = var4.c1779();
      }

      var1 += EnchantmentHelper.c2619(var0, EnumCreatureAttribute.c3198());
      return var1;
   }

   public static double c6304(ItemStack var0) {
      double var1 = 0.0;
      Multimap var3 = var0.c8230();
      if (var3.size() > 0) {
         AttributeModifier var4 = new AttributeModifier(var3.values().toArray()[0]);
         var1 = var4.c1779();
      }

      var1 += EnchantmentHelper.c2619(var0, EnumCreatureAttribute.c3198());
      return var1;
   }

   public IGuiComponent[] c3408() {
      IGuiComponent[] var1 = new IGuiComponent[this.csValues.size()];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = ((Value)this.csValues.get(var2)).getComponent();
      }

      return var1;
   }

   public boolean c5510(Entity var1) {
      if (var1.isInstance(MappedClasses.EntityOtherPlayerMP)) {
         EntityOtherPlayerMP var2 = new EntityOtherPlayerMP(var1);
         if (this.teamColor.getValue()) {
            String var3 = Minecraft.thePlayer().c7053().c693();
            String var4 = var2.c7053().c693();
            if (var3.startsWith(colorPrefix) && var4.startsWith(colorPrefix) && var3.length() > 1 && var4.length() > 1) {
               int var5 = var3.charAt(1) == 'r' ? 3 : 1;
               if (var3.charAt(var5) == var4.charAt(var5)) {
                  return true;
               }
            }
         }

         if (this.teamServer.getValue()) {
            return !var2.c3258().isNull() && !Minecraft.thePlayer().c3258().isNull() && Minecraft.thePlayer().c3258().c1899(var2.c3258());
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean c2159(Entity var1) {
      return this.theAntiBot.getState() && this.theAntiBot.c3177(var1);
   }

   //todo
   public boolean isTarget(Entity var1, boolean var2) {
      EntityPlayerSP var3 = Minecraft.thePlayer();
      if (var1.isNull()) {
         return false;
      } else if (var1.isInstance(MappedClasses.EntityAmbientCreature)) {
         return false;
      } else if (var1.equals(var3)) {
         return false;
      } else if (!var1.isInstance(MappedClasses.EntityLivingBase)) {
         return false;
      } else if (ForgeVersion.minorVersion() > 13 && var1.isInstance(MappedClasses.MouseEvent)) {
         return false;
      } else {
         EntityLivingBase entityPlayer = new EntityLivingBase(var1.getObject());
         if (entityPlayer.getHealth() <= 0.0F) {
            return false;
         } else if (var2 && RotationUtil.c8871(entityPlayer)) {
            return false;
         } else if (Vape.instance.getFriendManager().isFriend(entityPlayer)) {
            return false;
         } else if (!this.players.getValue() && var1.isInstance(MappedClasses.EntityOtherPlayerMP)) {
            return false;
         } else if (this.mobs.getValue() || !var1.isInstance(MappedClasses.EntityCreature) && !var1.isInstance(MappedClasses.EntitySlime)) {
            if (Vape.instance.getSettings().ignoreNaked.getValue() && RotationUtil.c7454(entityPlayer)) {
               return false;
            } else if (this.c5510(entityPlayer)) {
               return false;
            } else {
               return !this.c2159(entityPlayer);
            }
         } else {
            return false;
         }
      }
   }

   public void speedCheck(Mod var1) {
      if (this.speedCheck.getValue()) {
         Mod var2 = Vape.instance.getModManager().getMod(Scaffold.class);
         Mod var3 = Vape.instance.getModManager().getMod(Fly.class);
         Mod var4 = Vape.instance.getModManager().getMod(Speed.class);
         Mod var5 = Vape.instance.getModManager().getMod(LongJump.class);
         List var6 = Arrays.asList(var2, var3, var4, var5);
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            Mod var8 = (Mod)var7.next();
            if (var8 != null && !var8.equals(var1) && var8.getState()) {
               var8.c141();
            }
         }
      }

   }
}
