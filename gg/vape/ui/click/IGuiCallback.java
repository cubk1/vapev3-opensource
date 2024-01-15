package gg.vape.ui.click;

import gg.vape.ui.click.component.IGuiComponent;

public interface IGuiCallback<T extends IGuiComponent> {
   void call(T inst);
}
