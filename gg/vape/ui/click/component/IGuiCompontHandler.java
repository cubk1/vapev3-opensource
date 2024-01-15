package gg.vape.ui.click.component;

import gg.vape.ui.click.IGuiRenderer;

import java.util.List;

public interface IGuiCompontHandler extends IGuiComponent {
   List<IGuiComponent> getComponents();

   List<IGuiComponent> getDisplayableComponents();

   IGuiComponent addComponent(IGuiComponent var1);

   IGuiComponent c1202(int var1, IGuiComponent var2);

   void c4043(IGuiComponent var1);

   IGuiRenderer getParent();

   void onRendererHandling(IGuiRenderer var1);
}
