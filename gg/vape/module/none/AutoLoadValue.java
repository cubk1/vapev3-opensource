package gg.vape.module.none;

import gg.vape.value.BooleanValue;

public class AutoLoadValue {
   public BooleanValue autoLoadState = BooleanValue.create(this, "Auto-load mod states", false, "Automatically enable saved module states upon loading profiles.\n(You can save module states by shift+right clicking a profile button)");
//public BooleanValue autoLoadState = BooleanValue.create(this, "Auto-load module states", false, "Automatically enable saved module states upon loading profiles.\n(You can save module states by shift+right clicking a profile button)");

}
