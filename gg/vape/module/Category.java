package gg.vape.module;

import gg.vape.unmap.INamed;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Category implements INamed {
   public static Category Other = new Category("Other", new Color(36,128,145).getRGB());
   public static Category None = new Category("None", new Color(211,136,31).getRGB());
   public static Category Combat = new Category("Combat", new Color(214,27,6).getRGB());
   public static Category Utility = new Category("Utility", new Color(27,145,68).getRGB());
   public static Category Render = new Category("Render", "All kinds of visual goodies", new Color(135,14,165).getRGB());
   public static Category Blatant = new Category("Blatant", "Modules which are typically used for blatant cheaters", new Color(219,21,133).getRGB());
   public static Category World = new Category("World", new Color(70,73,16).getRGB());
   public static List<Category> categories = new ArrayList<>();
   public final String name;
   public final String desc;
   public final int color;

   public Category(String name, String desc, int color) {
      this.name = name;
      this.desc = desc;
      this.color = color;
   }

   public Category(String name, int color) {
      this(name, "", color);
   }

   public static List<Category> values() {
      return categories;
   }

   public static void destruct() {
      categories.clear();
      categories = null;
      Other = null;
      None = null;
      Combat = null;
      Utility = null;
      Render = null;
      Blatant = null;
      World = null;
   }

   public String getName() {
      return this.name;
   }

   public String toString() {
      return this.name;
   }

   public int getColor() {
      return this.color;
   }

   public String getDesc() {
      return this.desc;
   }

   static {
      categories.add(Blatant);
      categories.add(Combat);
      categories.add(None);
      categories.add(Other);
      categories.add(Render);
      categories.add(Utility);
      categories.add(World);
   }
}
