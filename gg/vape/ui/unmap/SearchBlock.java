package gg.vape.ui.unmap;

import com.google.gson.JsonObject;
import gg.vape.manager.FrameManager;
import gg.vape.ui.click.frame.impl.FrameClosable;
import gg.vape.wrapper.impl.Block;

import java.awt.*;

public class SearchBlock {
   public String c2190;
   public int c8648;
   public int c4504 = -1;
   public int c6615;
   public FrameClosable c3404;
   public final Color c2021;

   public SearchBlock(String name, int var2) {
      this.c2190 = name;
      this.c6615 = var2;
      this.c2021 = new Color(this.c6615);
      Block var3 = Block.c2509(this.c2190.replace(" ", "_"));
      if (var3 != null) {
         this.c8648 = Block.c3697(var3);
      }

      this.c535();
   }

   public void c535() {
      if (this.c2190.contains(":")) {
         String[] var1 = this.c2190.split(":");

         try {
            this.c4504 = Integer.parseInt(var1[1]);
            this.c8648 = Integer.parseInt(var1[0]);
         } catch (Exception var3) {
         }
      }

   }

   public int c2801() {
      return this.c8648;
   }

   public Color c6427() {
      return new Color(this.c6615);
   }

   public JsonObject c1007() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("blockname", this.c2190);
      var1.addProperty("blockid", this.c8648);
      var1.addProperty("color", this.c6615);
      return var1;
   }

   public SearchBlock c1966(JsonObject var1) {
      if (var1.get("blockname") != null && !var1.get("blockname").isJsonNull()) {
         this.c2190 = var1.get("blockname").getAsString();
         this.c535();
      }

      if (var1.get("blockid") != null && !var1.get("blockid").isJsonNull()) {
         this.c8648 = var1.get("blockid").getAsInt();
      }

      if (var1.get("color") != null && !var1.get("color").isJsonNull()) {
         this.c6615 = var1.get("color").getAsInt();
      }

      FrameManager.frameSearch.c6140(this);
      return this;
   }

   public String c6807() {
      return this.c2190;
   }

   public FrameClosable c8745() {
      return this.c3404;
   }

   public void c2950(FrameClosable var1) {
      this.c3404 = var1;
   }

   public int c2030() {
      return this.c4504;
   }

   public Color c5557() {
      return this.c2021;
   }

   public boolean c8575(int var1, int var2) {
      return this.c8648 == var1 && (this.c4504 == -1 || this.c4504 == var2);
   }
}
