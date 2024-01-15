package gg.vape.module;

public class SubModule extends Mod {
   public final Mod parent;

   public SubModule(Mod parent, String name) {
      super(name);
      this.parent = parent;
   }

   public Mod getParent() {
      return this.parent;
   }
}
