package gg.vape.ui.click.component;

import func.skidline.RectData;
import gg.vape.ui.click.IActionComponent;
import gg.vape.ui.click.IGuiCallback;
import gg.vape.ui.font.SmoothFontRenderer;
import gg.vape.unmap.ComponentCloseHandler;
import gg.vape.value.Value;

import java.awt.*;
import java.util.Set;

public interface IGuiComponent {
   Color accentColor = new Color(34, 231, 170, 255);
   Color backGroundColor = new Color(0, 7, 14, 120);
   Color hoveringColor = new Color(0, 0, 0, 120);
   Color l = new Color(0, 0, 0, 80);
   Color m = new Color(0, 0, 0, 30);
   Color n = new Color(0, 0, 0, 15);
   Color backGroundColorL = new Color(255, 255, 255, 30);
   /*
   Color accentColor = new Color(34, 231, 170, 255);
   Color backGroundColor = new Color(0, 7, 14, 150);
   Color hoveringColor = new Color(0, 0, 0, 150);
   Color l = new Color(0, 0, 0, 100);
   Color m = new Color(0, 0, 0, 50);
   Color n = new Color(0, 0, 0, 25);
   Color backGroundColorL = new Color(255, 255, 255, 50);
*/
   void render(boolean var1);

   void draw();

   double getX();

   void c1042(double var1);

   double getY();

   void c467(double var1);

   double getWidth();

   void setWidth(double var1);

   double getHeight();

   void onOffset(double var1);

   RectData c740();

   IGuiCompontHandler handler();

   void setParent(IGuiCompontHandler var1);

   boolean c4828(int var1, int var2, int var3);

   boolean c3210(char var1, int var2);

   boolean displayable();

   void setDisplayable(boolean var1);

   Set c5535();

   void c2888(RectData var1, IActionComponent var2);

   Set c6740();

   Set<ComponentCloseHandler> getCloseHandler();

   void addAction(IGuiCallback var1);

   SmoothFontRenderer getFont();

   boolean c905(int var1, int var2);

   Color getColor();

   void setColor(Color var1);

   Color getBackGroundColor();

   void setBackGroundColor(Color var1);

   boolean isHovering();

   Value<?,?> c5999();

   void c8376(Value<?,?> value);

   boolean c399();

   boolean c2877();

   void c4983(boolean var1);

   IGuiComponent c8735();
}
