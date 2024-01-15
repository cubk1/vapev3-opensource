package gg.vape.wrapper;

import gg.vape.Vape;

public class Wrapper {
   public static Vape vape = Vape.instance;
   protected final Object obj;

   public Wrapper(Object object) {
      if (object instanceof Wrapper) {
         Wrapper wrapper = (Wrapper)object;
         this.obj = wrapper.getObject();
      } else {
         this.obj = object;
      }
   }

   public Object getObject() {
      return this.obj;
   }

   public boolean equals(Object object) {
      if (object != null && this.obj != null) {
         if (object instanceof Wrapper) {
            Wrapper wrapper = (Wrapper)object;
            return this.obj.equals(wrapper.obj);
         } else {
            return super.equals(object);
         }
      } else {
         return false;
      }
   }

   public boolean isNull() {
      return this.obj == null;
   }

   public boolean isNotNull() {
      return this.obj != null;
   }

   public boolean isInstance(Class<?> clazz) {
      return clazz != null && clazz.isInstance(this.obj);
   }

   public String toString() {
      return this.obj.toString();
   }
}
