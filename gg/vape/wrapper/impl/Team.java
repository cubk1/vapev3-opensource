package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTeam;
import gg.vape.wrapper.Wrapper;

public class Team extends Wrapper {
   public Team(Object var1) {
      super(var1);
   }

   public boolean c1899(Team var1) {
      return MTeam.c5251(vape.getMappings().team, this.obj, var1.getObject());
   }
}
