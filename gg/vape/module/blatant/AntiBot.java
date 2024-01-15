package gg.vape.module.blatant;

import gg.vape.event.impl.EventPlayerTick;
import gg.vape.mapping.MappedClasses;
import gg.vape.module.Category;
import gg.vape.module.Mod;
import gg.vape.module.none.ClientSettings;
import gg.vape.unmap.ModeSelection;
import gg.vape.value.BooleanValue;
import gg.vape.value.ModeValue;
import gg.vape.wrapper.impl.*;

import java.util.*;

public class AntiBot extends Mod {
   public final ModeSelection hypixel = new ModeSelection("Hypixel");
   public final ModeSelection mineplex = new ModeSelection("Mineplex");
   public final ModeValue c7722;
   public final BooleanValue c2619;
   public final Map c2043;
   public Object c8227;

   public AntiBot() {
      super("AntiBot", -16711707, Category.Blatant, "Removes anti-cheat bots");
      this.c7722 = ModeValue.create(this, "Mode", this.hypixel, this.hypixel, this.mineplex);
      this.c2619 = BooleanValue.create(this, "Remove Bots", true, "Removes guaranteed bots.");
      this.c2043 = new HashMap();
      this.addValue(this.c7722, this.c2619);
   }

   public boolean c3177(Entity var1) {
      EntityPlayer var2;
      if (this.c7722.getValue() == this.hypixel) {
         if (!ClientSettings.not1710) {
            return false;
         }

         if (var1.isInstance(MappedClasses.EntityPlayer)) {
            var2 = new EntityPlayer(var1);
            EntityPlayerSP var3 = Minecraft.thePlayer();
            if (!var2.equals(var3) && var3.getDistanceToEntity(var2) < 10.0F) {
               String var4 = var2.c7053().c693();
               return (Integer) this.c2043.getOrDefault(var2.getEntityID(), -1) < 20 || var4.equalsIgnoreCase(ClientSettings.colorPrefix + "r" + var2.getName() + ClientSettings.colorPrefix + "r") || var4.contains("NPC") || (Integer) this.c2043.getOrDefault(var2.getEntityID(), -1) < 20 && !this.c8801().contains(var2.c7543());
            }
         }
      } else if (this.c7722.getValue() == this.mineplex && var1.isInstance(MappedClasses.EntityPlayer)) {
         var2 = new EntityPlayer(var1);
         return var2.getHealth() >= 0.0F;
      }

      return false;
   }

   public void onTick(EventPlayerTick event) {
      this.setSuffix(this.c7722.getValue().getName());
      WorldClient var2;
      if (this.c7722.getValue() == this.mineplex) {
         if (!this.c2619.getValue()) {
            return;
         }

         if (this.c8227 == null || Minecraft.theWorld().getObject() != this.c8227) {
            this.c2043.clear();
            this.c8227 = Minecraft.theWorld().getObject();
         }

         var2 = Minecraft.theWorld();
         EntityPlayerSP var3 = Minecraft.thePlayer();
         Iterator var4 = var2.c8905().iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            EntityPlayer var6 = new EntityPlayer(var5);
            if (!var6.isInstance(MappedClasses.EntityPlayerSP) && !Float.isNaN(var6.getHealth()) && var6.posY() > var3.posY() && var3.getDistanceToEntity(var6) < 10.0F) {
               var2.c7364(var6);
               break;
            }
         }
      }

      if (this.c7722.getValue() == this.hypixel) {
         if (this.c8227 == null || Minecraft.theWorld().getObject() != this.c8227) {
            this.c2043.clear();
            this.c8227 = Minecraft.theWorld().getObject();
         }

         var2 = Minecraft.theWorld();
         Iterator var9 = var2.c8905().iterator();

         while(true) {
            Object var10;
            do {
               if (!var9.hasNext()) {
                  return;
               }

               var10 = var9.next();
            } while(MappedClasses.EntityPlayerSP.isAssignableFrom(var10.getClass()));

            EntityPlayer var11 = new EntityPlayer(var10);
            boolean var12 = var11.onGround();
            if ((!var12 || !var11.isCollidedVertically()) && var11.posY() - Minecraft.thePlayer().posY() > 7.0) {
               this.c2043.put(var11.getEntityID(), 0);
            } else if (Minecraft.theWorld().getBlockByPos((int)var11.posX(), (int)var11.posY(), (int)var11.posZ()).c4045() != Material.c8442()) {
               this.c2043.put(var11.getEntityID(), (Integer)this.c2043.getOrDefault(var11.getEntityID(), -1) + 1);
            }

            String var7 = var11.c7053().c693();
            boolean var8 = var7.equalsIgnoreCase(var11.getName() + ClientSettings.colorPrefix + "r") || var7.equalsIgnoreCase(ClientSettings.colorPrefix + "r" + var11.getName() + ClientSettings.colorPrefix + "r");
            if (this.c2619.getValue() && var11.c320() && (Integer)this.c2043.get(var11.getEntityID()) < 5 && var8) {
               Minecraft.theWorld().c7364(var11);
               break;
            }
         }
      }

   }

   public void onDisable() {
      this.c2043.clear();
   }

   public List c8801() {
      ArrayList var1 = new ArrayList();
      NetHandlerPlayClientImpl var2 = Minecraft.thePlayer().sendQueue();
      Collection var3 = var2.c8291();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         NetworkPlayerInfo var6 = new NetworkPlayerInfo(var5);
         var1.add(var6.c304().getUUID());
      }

      return var1;
   }
}
