package gg.vape.event.hook;

public interface IHook {
   Class<?> getTarget();

   void call(Object var1);
}
