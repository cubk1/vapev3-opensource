package gg.vape.ui.click.frame.impl.profile;

import func.skidline.c5711;
import gg.vape.config.Profile;
import gg.vape.config.PublicProfile;
import gg.vape.ui.click.actions.*;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class FramePublicProfile extends FrameComponent {
   public final Profile c6081;

   public FramePublicProfile(Profile var1, double var2) {
      super(true);
      this.c6081 = var1;
      this.setWidth(var2);
      this.onOffset(75.0);
      FrameComponent var4 = new FrameComponent(false);
      var4.onRendererHandling(new c5711(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 1)));
      var4.setColor(hoveringColor);
      var4.c7363(false);
      var4.setWidth(this.getWidth());
      var4.onOffset(20.0);
      IntractiveComponent var5 = new IntractiveComponent(var1.c1754(), RenderFlag.Centered, 1.0);
      var5.onOffset(10.0);
      var5.c7363(false);
      var4.addComponent(var5);
      this.addComponent(var4);
      FrameComponent var6;
      ExpandableButton var7;
      if (var1 instanceof PublicProfile) {
         var5.setWidth(var4.getWidth());
         this.onRendererHandling(new c5711(2.0, 2.0, 5000, 1, new PoseMatrix(2, 2, 2, 2)));
         var6 = new FrameComponent(false);
         var6.onRendererHandling(new c5711(2.0, 0.0, 5000, 3, new PoseMatrix(0, 0, 0, 0)));
         var6.setColor(hoveringColor);
         var6.setWidth(this.getWidth());
         var6.onOffset(20.0);
         var7 = new ExpandableButton("upload", 0.5F, 6.0F, -1.0F, true);
         var7.setText("Update your profile");
         var7.c4644(Color.BLACK);
         var7.setBackGroundColor(Color.WHITE);
         var7.setWidth(this.getWidth() * 0.33);
         var7.onOffset(15.0);
         var7.addAction(new ActionRetriePublicProfile(this, var1));
         var6.addComponent(var7);
         ExpandableButton var8 = new ExpandableButton("copy", 0.33F, 8.5F, 2.0F, true);
         var8.setText("Copy profile UUID");
         var8.c4644(Color.BLACK);
         var8.setBackGroundColor(Color.WHITE);
         var8.setWidth(this.getWidth() * 0.33);
         var8.onOffset(15.0);
         var8.addAction(new ActionCopyProfileString(this, var1));
         var6.addComponent(var8);
         ExpandableButton var9 = new ExpandableButton("delete", 0.5F, 6.0F, -1.0F, true);
         var9.setText("Make profile public");
         var9.c4644(Color.BLACK);
         var9.setBackGroundColor(Color.WHITE);
         var9.setWidth(this.getWidth() * 0.33);
         var9.onOffset(15.0);
         var9.addAction(new ActionDeleteProfile(this, var1));
         var6.addComponent(var9);
         this.addComponent(var6);
      } else {
         var5.setWidth(var4.getWidth() * 0.82);
         this.onRendererHandling(new c5711(2.0, 2.0, 1, 2, new PoseMatrix(2, 2, 2, 2)));
         var6 = new FrameComponent(false);
         var6.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(0, 0, 0, 0)));
         var6.setColor(hoveringColor);
         var6.setWidth(this.getWidth());
         var6.onOffset(20.0);
         var7 = new ExpandableButton("world", 0.28F, 1.6F, 3.5F, true);
         var7.setText("Make profile public");
         var7.c4644(Color.BLACK);
         var7.setBackGroundColor(Color.WHITE);
         var7.setWidth(13.0);
         var7.onOffset(17.0);
         var7.addAction(new ActionLoadPublicProfile(this, var1, var5));
         var7.addAction(new ActionSetProfile(this, var1, var5));
         var6.addComponent(var7);
         this.addComponent(var6);
      }

   }

   public Color getColor() {
      return hoveringColor;
   }

   public Profile c8574() {
      return this.c6081;
   }
}
