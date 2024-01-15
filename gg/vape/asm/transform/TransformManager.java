package gg.vape.asm.transform;

import gg.vape.asm.transform.impl.EntityPlayerSPTransformer;
import gg.vape.asm.transform.impl.EntityTransformer;
import gg.vape.asm.transform.impl.NetworkManagerTransformer;
import gg.vape.asm.transform.impl.PlayerControllerMPTransformer;
import gg.vape.mapping.MappedClasses;
import gg.vape.wrapper.impl.ForgeVersion;

import java.util.ArrayList;
import java.util.List;

public class TransformManager {
   public final List<ClassTransformer> transformers = new ArrayList<>();

   public TransformManager() {
      try {
         this.transformers.add(new EntityPlayerSPTransformer(MappedClasses.EntityPlayerSP));
         this.transformers.add(new EntityTransformer());
         this.transformers.add(new NetworkManagerTransformer());
         this.transformers.add(new PlayerControllerMPTransformer());
         if (ForgeVersion.minorVersion() == 13) {
            this.transformers.add(new EntityPlayerSPTransformer(MappedClasses.EntityClientPlayerMP));
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void doTransform() {
      for (ClassTransformer transformer : this.transformers) {
         transformer.transform();
         transformer.replaceClassBytes();
      }

   }

   public void transformToOrig() {
      for (ClassTransformer transformer : this.transformers) {
         transformer.transformToOrig();
      }
   }
}
