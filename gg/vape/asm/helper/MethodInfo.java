package gg.vape.asm.helper;

public class MethodInfo {
   public String name = null;
   public String desc = null;

   public MethodInfo(String var1, String var2) {
      this.name = var1;
      this.desc = var2;
   }

   public MethodInfo(String var1) {
      this.name = var1;
   }

   public boolean is(String name, String desc) {
      //System.out.println(this.name+ this.desc + " - "+name+ desc);
      return this.name.equals(name) && (this.desc == null || this.desc.equals(desc));
   }

   @Override
   public String toString() {
      return "MethodInfo{" +
              "name='" + name + '\'' +
              ", desc='" + desc + '\'' +
              '}';
   }
}
