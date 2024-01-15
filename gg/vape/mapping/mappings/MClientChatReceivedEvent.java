package gg.vape.mapping.mappings;

import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.Mapping;
import gg.vape.mapping.MappingField;
import gg.vape.wrapper.impl.ITextComponent;

public class MClientChatReceivedEvent extends Mapping {
   public final MappingField c3616;

   public MClientChatReceivedEvent() {
      super("net/minecraftforge/client/event/ClientChatReceivedEvent");
      this.c3616 = this.getMappingFieldNoRemap("message", true, MappedClasses.ITextComponent);
   }

   public ITextComponent c5451(Object var1) {
      return new ITextComponent(this.c3616.getObject(var1));
   }

   public void c6771(Object var1, Object var2) {
      this.c3616.setObject(var1, var2);
   }
}
