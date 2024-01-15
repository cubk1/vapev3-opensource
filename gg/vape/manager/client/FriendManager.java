package gg.vape.manager.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import gg.vape.friend.Friend;
import gg.vape.manager.FrameManager;
import gg.vape.mapping.MappedClasses;
import gg.vape.ui.click.IButtonOnClick;
import gg.vape.ui.click.actions.ActionAddFriend;
import gg.vape.ui.click.component.value.BooleanComponent;
import gg.vape.value.BooleanValue;
import gg.vape.value.ColorValue;
import gg.vape.wrapper.impl.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FriendManager {
   public BooleanValue useFriends = BooleanValue.create(this, "Use Friends", true);
   public BooleanValue useAlias = BooleanValue.create(this, "Use Alias", true);
   public BooleanValue forceAlias = BooleanValue.create(this, "Force Alias", false, "This will make the names appear in chat\nAnd on their regular Nametags as well\nThis will act similar to the NameSpoof mod");
   public BooleanValue useColor = BooleanValue.create(this, "Use color", true, "Re-colors certain render modules to use \"Friends Color\" on friends");
   public ColorValue friendsColor = ColorValue.create(this, "Friends Color", new Color(66, 244, 137));
   public final Set<Friend> c1445 = new HashSet();

   public FriendManager() {
      IButtonOnClick var1 = ((BooleanComponent)this.forceAlias.getComponent()).getCheckBox().getClickEvent();
      ((BooleanComponent)this.forceAlias.getComponent()).getCheckBox().addAction(new ActionAddFriend(this, var1));
   }

   public Set<Friend> getFriends() {
      return this.c1445;
   }

   public void c8533(Friend var1) {
      Friend var2 = this.c2989(var1.c3125());
      if (var2 != null) {
         this.c1445.remove(var2);
      }

      this.c1445.add(var1);
      FrameManager.frameFriends.c3423(var1);
      this.c2618();
   }

   public void c5011() {
      RayTraceResult var1 = Minecraft.c1367();
      if (!var1.isNull()) {
         Entity var2 = var1.c4157();
         if (!var2.isNull()) {
            if (var2.isInstance(MappedClasses.EntityOtherPlayerMP)) {
               EntityOtherPlayerMP var3 = new EntityOtherPlayerMP(var2);
               String var4 = var3.getName();
               Friend var5 = this.c2989(var4);
               if (var5 != null) {
                  this.c2616(var5);
               } else {
                  this.c8533(new Friend(var4, var4));
               }
            }

         }
      }
   }

   public void c2616(Friend var1) {
      this.c1445.remove(var1);
      FrameManager.frameFriends.c7057(var1.c3125());
      this.c2618();
   }

   public Friend c2989(String var1) {
      Iterator var2 = this.c1445.iterator();

      Friend var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Friend)var2.next();
      } while(!var3.c3125().equals(var1));

      return var3;
   }

   public boolean c4194(String var1) {
      Friend var2 = this.c2989(var1);
      return this.useFriends.getValue() && var2 != null && var2.inFriends();
   }

   public boolean isFriend(EntityLivingBase var1) {
      return this.c4194(var1.getName());
   }

   public Friend c6216(String var1, boolean var2) {
      if (!this.useFriends.getValue() && var2) {
         return null;
      } else {
         Friend var3 = this.c2989(var1);
         return var3 != null && !var3.inFriends() ? null : var3;
      }
   }

   public Friend getFriend(String var1) {
      return this.c6216(var1, true);
   }

   public void c2219() {
      this.getFriends().clear();
      FrameManager.frameFriends.c1814.c6047().getComponents().clear();
   }

   public void loadFriends(JsonArray var1) {
      if (var1.size() != 0) {
         var1 = var1.get(0).getAsJsonArray();
         this.c2219();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            try {
               JsonElement var3 = var1.get(var2);
               if (var3.isJsonObject() && !var3.isJsonNull()) {
                  Friend var4 = (new Friend("", "")).loadJson(var3.getAsJsonObject());
                  this.c8533(var4);
               }
            } catch (Exception var5) {
            }
         }

      }
   }

   public JsonArray toJson() {
      JsonArray array = new JsonArray();

      for (Friend f : this.getFriends()) {
         array.add(f.toJson());
      }

      return array;
   }

   public void c2618() {
      if (!Minecraft.theWorld().isNull()) {
         Iterator var1 = Minecraft.theWorld().c8905().iterator();

         while(var1.hasNext()) {
            Object var2 = var1.next();
            (new EntityPlayer(var2)).c3727();
         }

      }
   }
}
