package gg.vape.ui.click.frame;

import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.actions.ActionCloseFrame;
import gg.vape.ui.click.actions.ActionToggleDisplay;
import gg.vape.ui.click.component.frame.ButtonFrame;
import gg.vape.ui.click.component.frame.ButtonGroup;
import gg.vape.ui.click.frame.impl.FrameSettings;

import java.awt.*;
//todo
public class FrameButtonGroup extends ButtonGroup {
   public final Frame frame;

   public FrameButtonGroup(Frame frame) {
      super(frame.c7694().getName(), frame.getComponentList());
      this.frame = frame;
      this.onOffset(20.0);
      ClickGui clickGui = Vape.instance.getModManager().getMod(ClickGui.class);
      ButtonFrame buttonFrame = this.Frame();
      buttonFrame.addAction(new ActionCloseFrame(this, frame, clickGui));
      this.addAction(new ActionToggleDisplay(this, clickGui, frame));
      this.setWidth(97.0);
      if (!(frame instanceof FrameSettings)) {
         this.c7988(true);
      }

      this.c8121(true);
      this.c2367(false);
   }

   public boolean c399() {
      return this.frame.displayable();
   }

   public void toggle() {
      if (this.frame.displayable()) {
         this.frame.setDisplayable(false);
         this.Frame().getGuiButton().setColor(Color.WHITE);
      } else {
         this.frame.setDisplayable(true);
         this.Frame().getGuiButton().setColor(this.getColor());
      }

   }

   public void c4647() {
      if (!this.c2346()) {
         this.Frame().getGuiButton().setColor(Color.WHITE);
      } else {
         this.Frame().getGuiButton().setColor(Vape.instance.getSettings().guiColor.getAsColor());
      }

   }

   public boolean c2346() {
      return this.frame.displayable();
   }

   public void c8121(boolean var1) {
      if (this.c2346() != var1) {
         this.toggle();
      }

   }
}
