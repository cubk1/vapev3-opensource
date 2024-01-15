package gg.vape.ui.click.frame.impl.profile;

import func.skidline.c5711;
import gg.vape.Vape;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.Frame;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.unmap.SliderInFrame;
import gg.vape.utils.render.PoseMatrix;

import java.util.Iterator;

public class FramePublicPublishProfiles extends Frame {
   public FrameComponent c8167;
   public FrameComponent c7760;
   public SliderInFrame c8692;
   public SliderInFrame c1761;

   public FramePublicPublishProfiles() {
      super("Public Publish Profiles", false);
      this.getFramePage().onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.c4452();
      this.c6239();
      this.setWidth(90.0);
      this.onOffset(20.0);
      this.addAction(a->{
         c7144( this.c8692);
         c7144( this.c1761);
      });
   }

   public void c7144(SliderInFrame var1) {
      Iterator<IGuiComponent> var2 = var1.c6047().getComponents().iterator();

      while(var2.hasNext()) {
         IGuiComponent var3 = var2.next();
         if (var3 instanceof FramePublicProfile) {
            FramePublicProfile var4 = (FramePublicProfile)var3;
            if (var4.c8574() instanceof PublicProfile) {
               PublicProfile var5 = (PublicProfile)var4.c8574();
               if (!var5.c2239()) {
                  var2.remove();
               }
            }
         }
      }

   }

   public void c4452() {
      this.c7760 = new FrameComponent(false);
      this.c7760.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 2, 0, 0)));
      this.addGuiComponent(this.c7760);
      IntractiveComponent var1 = new IntractiveComponent("Your public Profiles:", RenderFlag.Centered, 0.7);
      var1.setWidth(85.0);
      var1.onOffset(12.0);
      this.c7760.addComponent(var1);
      this.c1761 = new SliderInFrame(false);
      this.c1761.setWidth(100.0);
      this.c1761.onOffset(70.0);
      this.addGuiComponent(this.c1761);
   }

   public void c6239() {
      this.c8167 = new FrameComponent(false);
      this.c8167.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
      this.addGuiComponent(this.c8167);
      IntractiveComponent var1 = new IntractiveComponent("Your Public Profiles:", RenderFlag.Centered, 0.7);
      var1.setText("");
      var1.addAction(t->
              var1.setText("You have " + (10 - Vape.instance.getProfilesManager().c3809()) + " profiles remaining.")
      );
      var1.setWidth(85.0);
      var1.onOffset(12.0);
      this.c8167.addComponent(var1);
      this.c8692 = new SliderInFrame(false);
      this.c8692.setWidth(100.0);
      this.c8692.onOffset(70.0);
      this.addGuiComponent(this.c8692);

      for(int var2 = 0; var2 < 25; ++var2) {
         PublicProfile var3 = new PublicProfile("public  " + var2, "6.9");
         FramePublicProfile var4 = new FramePublicProfile(var3, 85.0);
         this.c8692.c8120(var4);
         this.c8692.draw();
      }

   }

   public void setWidth(double var1) {
      super.setWidth(var1);
      Iterator var3 = this.getFramePage().getComponents().iterator();

      while(true) {
         IGuiComponent var4;
         do {
            if (!var3.hasNext()) {
               return;
            }

            var4 = (IGuiComponent)var3.next();
            var4.setWidth(var1);
         } while(!(var4 instanceof SliderInFrame));

         SliderInFrame var5 = (SliderInFrame)var4;
         Iterator var6 = var5.c6047().getComponents().iterator();

         while(var6.hasNext()) {
            IGuiComponent var7 = (IGuiComponent)var6.next();
            var7.setWidth(var1 - 4.0);
         }
      }
   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      var1 -= 24.0;
      this.c8692.onOffset(var1 * 0.5);
      this.c1761.onOffset(var1 * 0.5);
      this.c8167.onOffset(12.0);
      this.c7760.onOffset(12.0);
   }

   public void draw() {
      this.setDragState(false);
      this.setCloseStatus(false);
      this.c3488().setDisplayable(false);
      this.c1042(FrameManager.c3462.getX() + FrameManager.c3462.getWidth() + 3.0);
      this.c467(FrameManager.c3462.getY());
      this.onOffset(FrameManager.c3462.getHeight());
      super.draw();
   }

   public void render(boolean flag) {
      super.render(false);
   }

   public void c7644(Profile var1) {
      if (!var1.c1754().equalsIgnoreCase("default")) {
         FrameComponent var2 = new FrameComponent(false);
         var2.onRendererHandling(new c5711(0.0, 0.0, 1, 1, new PoseMatrix(1, 2, 1, 2)));
         FramePublicProfile var3 = new FramePublicProfile(var1, 85.0);
         var2.addComponent(var3);
         if (var1 instanceof PublicProfile) {
            PublicProfile var4 = (PublicProfile)var1;
            if (var4.c2239()) {
               this.c8692.c8120(var2);
               this.c8692.draw();
            }
         } else {
            this.c1761.c8120(var2);
            this.c1761.draw();
         }

      }
   }

   public void c3891(Profile var1) {
      IGuiComponent var2 = null;
      Iterator var3 = this.c1761.c6047().getComponents().iterator();

      IGuiComponent var4;
      FrameComponent var5;
      FramePublicProfile var6;
      while(var3.hasNext()) {
         var4 = (IGuiComponent)var3.next();
         if (var4 instanceof FrameComponent) {
            var5 = (FrameComponent)var4;
            if (!var5.getComponents().isEmpty() && var5.getComponents().get(0) instanceof FramePublicProfile) {
               var6 = (FramePublicProfile)var5.getComponents().get(0);
               if (var6.c8574().c208().toString().equalsIgnoreCase(var1.c208().toString())) {
                  var2 = var4;
               }
            }
         }
      }

      if (var2 == null) {
         var3 = this.c8692.c6047().getComponents().iterator();

         while(var3.hasNext()) {
            var4 = (IGuiComponent)var3.next();
            if (var4 instanceof FrameComponent) {
               var5 = (FrameComponent)var4;
               if (!var5.getComponents().isEmpty() && var5.getComponents().get(0) instanceof FramePublicProfile) {
                  var6 = (FramePublicProfile)var5.getComponents().get(0);
                  if (var6.c8574().c208().toString().equalsIgnoreCase(var1.c208().toString())) {
                     var2 = var4;
                  }
               }
            }
         }
      }

      if (var2 != null) {
         this.c1761.c6047().c4043(var2);
         this.c1761.draw();
         this.c8692.c6047().c4043(var2);
         this.c8692.draw();
      }

   }

   public SliderInFrame c4033() {
      return this.c8692;
   }

   public SliderInFrame c1360() {
      return this.c1761;
   }


   // $FF: synthetic method
   static void c4249(FramePublicPublishProfiles var0, SliderInFrame var1) {
      var0.c7144(var1);
   }

}
