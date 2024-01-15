package gg.vape.ui.click;

import gg.vape.ui.click.component.IGuiComponent;

public interface IClickable extends IGuiComponent {
   void addAction(IButtonOnClick var1);

   IButtonOnClick getClickEvent();
}
