package gg.vape.wrapper.impl;

import gg.vape.wrapper.Wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container extends Wrapper {
   public Container(Object var1) {
      super(var1);
   }

   public List c7580() {
      List var1 = vape.getMappings().container.c7156(this.obj);
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.add(new Slot(var4));
      }

      return var2;
   }

   public int c3715() {
      return vape.getMappings().container.c4023(this.obj);
   }

   public Slot c8687(int var1) {
       return new Slot(vape.getMappings().container.c2260(this.obj, var1));
   }
}
