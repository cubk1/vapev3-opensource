package gg.vape.asm.transform.impl;

import gg.vape.Vape;
import gg.vape.asm.helper.EventBuilder;
import gg.vape.asm.helper.Local;
import gg.vape.asm.helper.MethodInfo;
import gg.vape.asm.transform.ClassTransformer;
import gg.vape.event.impl.EventPacketReceive;
import gg.vape.event.impl.EventPacketSend;
import gg.vape.mapping.MappedClasses;
import gg.vape.mapping.MappingMethod;
import gg.vape.wrapper.impl.ForgeVersion;

public class NetworkManagerTransformer extends ClassTransformer {
   public final String local_read;
   public final String local_packetIn;

   public NetworkManagerTransformer() {
      super(MappedClasses.NetworkManager);
      if (ForgeVersion.minorVersion() >= 15) {
         this.local_packetIn = "packetIn";
      } else {
         this.local_packetIn = "p_150725_1_";
      }

      this.local_read = "p_channelRead0_2_";
   }

   public void c6999() {
      MappingMethod var1 = Vape.instance.getMappings().networkManager.c8599;
      MappingMethod var2 = Vape.instance.getMappings().networkManager.c4095;
      MethodInfo var3 = new MethodInfo(var1.getName(), var1.getDesc());
      MethodInfo var4 = new MethodInfo(var2.getName(), var2.getDesc());
      Local pou = (new Local("Ljava/lang/Object;",this.local_packetIn,"param1","p_sendPacket_1_","packetIn","p_150725_1_")).setTarget(Object.class);
      Local pin = (new Local("Ljava/lang/Object;",this.local_read,"param2","p_channelRead0_2_")).setTarget(Object.class);
      new EventBuilder(0, EventPacketReceive.class, this.classNode, var3, pin)
              .transform()
              .relocal(pin.setOwner(MappedClasses.Packet), "getPacketInstance")
              .inject();
      new EventBuilder(0, EventPacketSend.class, this.classNode, var4, pou)
              .transform()
              .relocal(pou.setOwner(MappedClasses.Packet), "getPacketInstance")
              .inject();
   }

   public void transform() {
      this.c6999();
   }
}
