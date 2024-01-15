package gg.vape.ui.click.frame.impl.profile;

import func.skidline.c5711;
import gg.vape.Vape;
import gg.vape.config.PublicProfile;
import gg.vape.manager.FrameManager;
import gg.vape.ui.click.actions.ActionCopyProfileUUID;
import gg.vape.ui.click.actions.ActionGetIndividualProfile;
import gg.vape.ui.click.actions.ActionLikePublicProfile;
import gg.vape.ui.click.actions.ActionSyncProfile;
import gg.vape.ui.click.component.RenderFlag;
import gg.vape.ui.click.component.gui.ExpandableButton;
import gg.vape.ui.click.component.gui.IntractiveComponent;
import gg.vape.ui.click.component.value.NumberComponent;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.utils.render.PoseMatrix;

import java.awt.*;

public class FrameProfilesExplorer extends FrameComponent {
   public final PublicProfile c2166;

   public FrameProfilesExplorer(PublicProfile var1, double var2) {
      super(true);
      this.c2166 = var1;
      this.c8030(0.5);
      this.setBackGroundColor(new Color(40, 40, 40, 100));
      this.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(2, 2, 2, 2)));
      this.setWidth(var2);
      this.onOffset(75.0);
      FrameComponent var4 = new FrameComponent(false);
      var4.onRendererHandling(new c5711(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 1)));
      var4.setColor(hoveringColor);
      var4.c7363(false);
      var4.setWidth(this.getWidth());
      var4.onOffset(20.0);
      IntractiveComponent var5 = new IntractiveComponent(var1.c1754(), RenderFlag.Regular, 1.0);
      var5.setWidth(var4.getWidth() * 0.75);
      var5.onOffset(10.0);
      var5.c7363(false);
      var4.addComponent(var5);
      IntractiveComponent var6 = new IntractiveComponent(var1.c8382() + "", RenderFlag.NoString, 1.0);
      var6.setText("Total profile usages");
      var6.setWidth(var4.getWidth() * 0.25);
      var6.onOffset(10.0);
      var6.c7363(false);
      var4.addComponent(var6);
      this.addComponent(var4);
      FrameComponent var7 = new FrameComponent(false);
      var7.onRendererHandling(new c5711(0.0, 0.0, 5000, 3, new PoseMatrix(0, 0, 0, 0)));
      var7.setColor(hoveringColor);
      var7.c7363(false);
      var7.setWidth(this.getWidth());
      var7.onOffset(20.0);
      FrameComponent var8 = new FrameComponent(false);
      var8.onRendererHandling(new c5711(0.0, 0.0, 5000, 1, new PoseMatrix(2, 0, 0, 0)));
      var8.setColor(hoveringColor);
      var8.c7363(false);
      var8.setWidth(this.getWidth());
      var8.onOffset(20.0);
      var7.addComponent(var8);
      ExpandableButton var9 = new ExpandableButton("copy", 0.2F, 0.1F, 0.1F, true);
      var9.setText("Copy profile UUID");
      var9.setBackGroundColor(hoveringColor);
      var9.setWidth(7.0);
      var9.onOffset(7.0);
      var9.c7363(false);
      var9.addAction(new ActionCopyProfileUUID(this, var1, var9));
      var8.addComponent(var9);
      IntractiveComponent var10 = new IntractiveComponent(var1.c208().toString(), RenderFlag.Regular, 0.5);
      var10.setWidth(var7.getWidth() * 0.8);
      var10.onOffset(10.0);
      var10.c7363(false);
      var7.addComponent(var10);
      IntractiveComponent var11 = new IntractiveComponent("", RenderFlag.Regular, 0.5);
      var11.setWidth(var7.getWidth() * 0.1);
      var11.onOffset(10.0);
      var11.c7363(false);
      var7.addComponent(var11);
      this.addComponent(var7);
      FrameComponent var12 = new FrameComponent(false);
      var12.onRendererHandling(new c5711(0.0, 0.0, 5000, 2, new PoseMatrix(0, 0, 0, 0)));
      var12.setColor(hoveringColor);
      var12.c7363(false);
      var12.setWidth(this.getWidth());
      var12.onOffset(20.0);
      IntractiveComponent var13 = new IntractiveComponent("Updated:", RenderFlag.Regular, 0.7);
      var13.setText("Made with Vape v" + var1.c2580());
      var13.setWidth(var12.getWidth() * 0.25);
      var13.onOffset(10.0);
      var13.c7363(false);
      var12.addComponent(var13);
      IntractiveComponent var14 = new IntractiveComponent(var1.c4968().length() > 10 ? var1.c4968().substring(0, 10) : var1.c4968(), RenderFlag.Regular, 0.7);
      var14.setText("Made with Vape v" + var1.c2580());
      var14.setWidth(var12.getWidth() * 0.75);
      var14.onOffset(10.0);
      var14.c7363(false);
      var12.addComponent(var14);
      this.addComponent(var12);
      this.c3813();
   }

   public void c3813() {
      FrameComponent var1 = new FrameComponent(false);
      var1.onRendererHandling(new c5711(2.0, 0.0, 1, 3, new PoseMatrix(0, 0, 0, 0)));
      var1.setColor(hoveringColor);
      var1.setWidth(this.getWidth());
      var1.onOffset(20.0);
      FrameComponent var2 = new FrameComponent(true);
      var2.onRendererHandling(new c5711(0.0, 0.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      var2.setColor(hoveringColor);
      var2.setWidth(this.getWidth() / 2.0 - 30.0);
      var2.onOffset(17.0);
      var1.addComponent(var2);
      ExpandableButton var3 = new ExpandableButton("gui", 0.35F, 10.0F, 3.0F);
      var3.c707(0.5);
      var3.setBackGroundColor(new Color(40, 40, 40, 100));
      var3.setText("Preview settings");
      var3.setWidth(var2.getWidth());
      var3.onOffset(17.0);
      FrameViewer var4 = FrameManager.c6371;
      var2.addComponent(var3);
      FrameComponent var5 = new FrameComponent(true);
      var5.onRendererHandling(new c5711(0.0, 0.0, 1, 1, new PoseMatrix(0, 0, 0, 0)));
      var5.setColor(hoveringColor);
      var5.setWidth(this.getWidth() / 2.0 - 4.0);
      var5.onOffset(17.0);
      ExpandableButton var6 = new ExpandableButton("download", 0.5F, 20.0F, 0.0F);
      var6.setWidth(var5.getWidth());
      var6.onOffset(17.0);
      var6.c707(0.5);
      var6.setBackGroundColor(new Color(40, 40, 40, 100));
      var6.addAction(new ActionSyncProfile(this, var6));
      var6.addAction(new ActionGetIndividualProfile(this));
      var5.addComponent(var6);
      var1.addComponent(var5);
      FrameComponent var7 = new FrameComponent(false);
      var7.onRendererHandling(new c5711(1.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));
      var7.setColor(hoveringColor);
      var7.setWidth(1.0);
      var7.onOffset(15.0);
      FrameComponent var8 = new FrameComponent(false);
      var8.onRendererHandling(new c5711(1.0, 0.0, 2, 2, new PoseMatrix(0, 0, 0, 0)));
      var8.setColor(hoveringColor);
      var8.setWidth(1.0);
      var8.onOffset(15.0);
      IntractiveComponent var9 = new IntractiveComponent(String.valueOf(this.c2166.c581()), RenderFlag.Centered, 0.5);
      var9.setWidth(15.0);
      var9.onOffset(5.0);
      var8.addComponent(var9);
      IntractiveComponent var10 = new IntractiveComponent(String.valueOf(this.c2166.c3883()), RenderFlag.Centered, 0.5);
      var10.setWidth(15.0);
      var10.onOffset(5.0);
      var8.addComponent(var10);
      ExpandableButton var11 = new ExpandableButton("like", 0.25F, 3.5F, 1.0F);
      var11.setWidth(15.0);
      var11.onOffset(10.0);
      var8.addComponent(var11);
      ExpandableButton var12 = new ExpandableButton("dislike", 0.25F, 3.5F, 1.5F);
      var12.setWidth(15.0);
      var12.onOffset(10.0);
      var8.addComponent(var12);
      NumberComponent var13 = new NumberComponent(100.0, 0.0, null, null, null);
      var13.c8030(50.0);
      var13.c4983(true);
      var13.setWidth(32.0);
      var13.onOffset(2.0);
      var7.addComponent(var8);
      var7.addComponent(var13);
      var13.setColor(Vape.instance.getSettings().guiColor.getAsColor());
      var12.addAction(new ActionLikePublicProfile(this, var9, var10));
      var1.addComponent(var7);
      this.addComponent(var1);
   }

   public Color getColor() {
      return hoveringColor;
   }

   // $FF: synthetic method
   public static PublicProfile c7230(FrameProfilesExplorer var0) {
      return var0.c2166;
   }
}
