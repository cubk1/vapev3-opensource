package gg.vape.wrapper.impl;

import gg.vape.mapping.mappings.MTickEvent_Phase;
import gg.vape.wrapper.Wrapper;

public class TickEventPhase extends Wrapper {
   public TickEventPhase(Object var1) {
      super(var1);
   }

   public static TickEventPhase c5866() {
      return new TickEventPhase(MTickEvent_Phase.c2308(vape.getMappings().mTickEventPhase));
   }

   public static TickEventPhase c3827() {
      return new TickEventPhase(MTickEvent_Phase.c8424(vape.getMappings().mTickEventPhase));
   }
}
