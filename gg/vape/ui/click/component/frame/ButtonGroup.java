package gg.vape.ui.click.component.frame;

import gg.vape.Vape;
import gg.vape.module.none.ClickGui;
import gg.vape.ui.click.ICloseable;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.click.component.GuiComponent;
import gg.vape.ui.click.component.IGuiComponent;
import gg.vape.ui.click.component.gui.CheckBox;
import gg.vape.ui.click.frame.FrameComponent;
import gg.vape.ui.click.frame.IFrameComponent;
import gg.vape.ui.unmap.SquareButton;
import gg.vape.unmap.ComponentCloseHandler;
import gg.vape.unmap.PoseRenderer;
import gg.vape.utils.render.PoseMatrix;
import gg.vape.utils.render.RenderUtils;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public abstract class ButtonGroup extends GuiComponent implements IFrameComponent, ICloseable {
   public static final double c500 = 12.0;
   public static final int c8446 = 5;
   public final FrameComponent list;
   public final FrameComponent subComponents = new FrameComponent(false);
   public final ButtonFrame mainButton;
   public final SquareButton expander;
   public final CheckBox c8561 = new CheckBox();
   public boolean c3852;
   public final ClickGui clickGui;
   public double width;
   public boolean c7356;
   public final FrameComponent component = new FrameComponent(false);
   public boolean flagTg = false;
   class c8377 implements IGuiCallback<ButtonGroup> {
      // $FF: synthetic field
      final ButtonGroup inst;

      c8377(ButtonGroup var1) {
         this.inst = var1;
      }
/*
*       this.addAction(b->{

            if (this.subComponents().getComponents().size() > 0) {
               this.expandBn().setDisplayable(true);
               this.Frame().handler().getParent().c8084();
               double offset = 0.0;

               for (IGuiComponent component : this.subComponents.getComponents()) {
                  if (component.displayable()) {
                     offset += component.getHeight() + 2.0;
                  }
               }

               this.subComponents.onOffset(offset + 2.0);
            } else {
               this.expandBn().setDisplayable(false);
            }

         //this.setAllHeight();
            this.setAllWidth();

      });
* */

      @Override
      public void call(ButtonGroup var1) {
         if (this.inst.subComponents().getComponents().size() > 0) {
            var1.expandBn().setDisplayable(true);
            var1.Frame().handler().getParent().c8084();
            double offset = 0.0;

            for (IGuiComponent component : this.inst.subComponents.getComponents()) {
               if (component.displayable()) {
                  offset += component.getHeight() + 2.0;
               }
            }

            this.inst.subComponents.onOffset(offset + 2.0);
         } else {
            var1.expandBn().setDisplayable(false);
         }

         this.inst.setAllWidth();
      }
   }

   public ButtonGroup(String Name, List<IGuiComponent> guiComponents) {
      this.setBackGroundColor(backGroundColorL);
      this.onRendererHandling(new PoseRenderer(0.0, 0.0, 2, 1, new PoseMatrix(0, 0, 0, 0)));
      this.clickGui = Vape.instance.getModManager().getMod(ClickGui.class);

      /*
      if(Name.equals("Blatant")){
         for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            System.out.println(ste);
         }
      }
      */

      flagTg = Name.equals("Text GUI");

      this.mainButton = new ButtonFrame(Name, false);

      this.expander = new SquareButton("+", false);
      this.expander.setDisplayable(true);

      this.mainButton.addAction(
              (mouseX, mouseY, mouseBn) -> {
                 if (mouseBn == 0) {
                    this.toggle();
                 } else if (mouseBn == 1 && expander.displayable()) {
                    expander.getClickEvent().onClick(mouseX, mouseY, 0);
                 }
              }
      );

      this.expander.addAction((mouseX, mouseY, mouseBn)->{
            if (mouseBn == 0) {
               if (this.isClosed()) {
                  expander.getGuiButton().setName("-");
                  this.setCloseStatus(false);
                  setExpanded(true);
               } else {
                  expander.getGuiButton().setName("+");
                  this.setCloseStatus(true);
                  setExpanded(false);
               }
            }
      });
      
      this.onClose(this::setExpanded);
      this.c8561.setDisplayable(true);
      this.c8561.c8121(true);
      this.c8561.setWidth(10.0);
      this.c8561.onOffset(10.0);
      this.list = new FrameComponent(false);

      this.list.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 3, new PoseMatrix(0, 0, 0, 0)));
      this.component.onRendererHandling(new PoseRenderer(0.0, 0.0, 1, 1, new PoseMatrix(3, 1, 0, 1)));
      this.component.addComponent(this.c8561);
      this.list.addComponent(this.component);

      this.list.addComponent(this.mainButton);
      this.list.addComponent(this.expander);
      this.subComponents.setDisplayable(false);
      this.subComponents.onRendererHandling(new PoseRenderer(0.0, 2.0, 5000, 1, new PoseMatrix(2, 5, 2, 5)));
      this.addComponent(this.list);
      this.addComponent(this.subComponents);
      this.addAction(new c8377(this));
      if (guiComponents != null) {
         for (IGuiComponent com : guiComponents) {
            this.addSubComponent(com);
         }
      }

      this.c7363(true);
      this.setWidth(this.mainButton.getGuiButton().getNameWidth() + 20.0);


   }

   public void setWidth(double var1) {
      super.setWidth(var1);
    //  System.out.println(var1);
    //  if(this.width>200){
     //    Thread.dumpStack();
    //  }

      this.width = var1;
      this.setAllWidth();

   }

   public void setWidthSilent(double var1) {
      super.setWidth(var1);
      this.width = var1;
   }

   @Override
   public double getWidth() {
      return width;
   }

   public void setAllWidth() {


      if(flagTg){
         this.expander.setWidth(this.getWidth() * 0.15);//this.expander.setX(getMX()+4);
      }else{
         this.expander.setWidth(this.width * 0.15);
      }
      this.subComponents.setWidth(this.getWidth() - 10.0);


     // System.out.println(this.getWidth());
      for (IGuiComponent component : this.subComponents.getComponents()) {
         component.setWidth(this.getWidth() - 10.0);
      }

      double off = this.width;
      //off -= this.expander.getWidth();
      if(!flagTg){
         off -= this.expander.getWidth();
      }
      if (!this.c7356 && this.subComponents().getComponents().size() > 0) {
         off -= this.expander.getWidth();
      }

      if (this.needDisplay()) {
         if (this.clickGui.getEditState()) {
            this.component.setDisplayable(true);
            this.mainButton.setWidth(off - this.c8561.getWidth());
            this.list.setDisplayable(true);
         } else {
            this.component.setDisplayable(false);
            this.mainButton.setWidth(off);
         }
      } else {
         this.mainButton.setWidth(off);
         this.component.setDisplayable(false);
      }

      try {
         this.c4647();
      } catch (Exception var4) {
      }

   }

   public void c4647() {
      if (!this.c2346()) {
         this.mainButton.getGuiButton().setColor(this.mainButton.getGuiButton().getColor());
      } else {
         this.mainButton.getGuiButton().setColor(Vape.instance.getSettings().guiColor.getAsColor());
      }

   }

   public void setExpanded(boolean flag) {
      for (IGuiComponent component : this.subComponents.getComponents()) {
         for (ComponentCloseHandler o : component.getCloseHandler()) {
            o.onClose(flag);
         }
      }

   }

   public void setColor(Color var1) {
      super.setColor(var1);
      this.Frame().setColor(var1);
   }

   public void render(boolean var1) {
      if (this.displayable()) {
         this.expander.setDisplayable(subComponents.components.size() > 0);
         this.mainButton.setWidth(this.subComponents.getWidth());
         GL11.glEnable(GL11.GL_BLEND);
         GL11.glDisable(GL11.GL_TEXTURE_2D);
         GL11.glBlendFunc(770, 771);
         if (this.subComponents.displayable()) {
            RenderUtils.drawRect(hoveringColor, this.subComponents.getX(), this.getY() + this.getHeight(), this.subComponents.getX() + this.subComponents.getWidth(), this.getY() + this.getHeight(), this.subComponents.getX() + this.subComponents.getWidth(), this.getY() + this.Frame().getHeight(), this.subComponents.getX(), this.getY() + this.Frame().getHeight());
         }

         GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glDisable(GL11.GL_BLEND);
      }

      super.render(var1);
   }

   public boolean isClosed() {
      return !this.subComponents.displayable();
   }

   public void setCloseStatus(boolean status) {
      this.subComponents.setDisplayable(!status);
   }

   public boolean isHovering() {
      Iterator var1 = this.subComponents.getComponents().iterator();

      IGuiComponent var2;
      do {
         if (!var1.hasNext()) {
            return super.isHovering();
         }

         var2 = (IGuiComponent)var1.next();
      } while(!var2.isHovering());

      return false;
   }

   public void onOffset(double var1) {
      super.onOffset(var1);
      this.mainButton.onOffset(var1);
      this.expander.onOffset(var1);
   }

   public void addSubComponent(IGuiComponent var1) {
      if (!this.subComponents.getComponents().contains(var1)) {
         this.subComponents.addComponent(var1);
      }
   }

   public FrameComponent subComponents() {
      return this.subComponents;
   }

   public ButtonFrame Frame() {
      return this.mainButton;
   }

   public SquareButton expandBn() {
      return this.expander;
   }

   public FrameComponent c8541() {
      return this.list;
   }

   public CheckBox c5615() {
      return this.c8561;
   }

   public void checkAva(boolean var1) {
      this.c8561.c8121(var1);
   }

   public void c7988(boolean var1) {
      this.c3852 = var1;
   }

   public boolean needDisplay() {
      return this.c3852;
   }

   public void c2367(boolean var1) {
      this.c7356 = var1;
   }


}
