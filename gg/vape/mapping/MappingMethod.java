package gg.vape.mapping;

import gg.vape.asm.helper.DescUtils;
import lombok.SneakyThrows;
import pub.nextsense.common.ReflectionHelper;


public class MappingMethod {
   public static int index = 0;
   public final int id;
   public final Class<?> owner;
   public String desc,descx;

   public MappingMethod(Class<?> var1, String var2, boolean var3, boolean var4, Class<?> var5, Class<?>... var6) {
      this.id = ++index;
      this.owner = var1;

      try {
         this.desc = DescUtils.genMethodDesc(var5, var6);
         this.descx = DescUtils.genMethodDescX(var5, var6);
         if (var3) {
            ReflectionHelper.a(this.id, var1, var2, this.desc, var4);
         } else {
            ReflectionHelper.b(this.id, var1, var2, this.desc, var4);
         }
      } catch (Exception var8) {
      }

   }

   public MappingMethod(Class<?> var1, String var2, boolean var3, boolean var4, String var5) {
      this.id = ++index;
      this.owner = var1;

      try {
         this.desc = "()" + var5;
         if (var3) {
            ReflectionHelper.a(this.id, var1, var2, var5, var4);
         } else {
            ReflectionHelper.b(this.id, var1, var2, var5, var4);
         }
      } catch (Exception var7) {
      }

   }
   @SneakyThrows
   public void c2642(Object var1, Object... var2) {
      ReflectionHelper.c(this.id, var1, var2);
   }
   @SneakyThrows
   public boolean c5509(Object var1, Object... var2) {
      return ReflectionHelper.d(this.id, var1, var2);
   }
   @SneakyThrows
   public char c1971(Object var1, Object... var2) {
      return ReflectionHelper.e(this.id, var1, var2);
   }
   @SneakyThrows
   public short c5409(Object var1, Object... var2) {
      return ReflectionHelper.f(this.id, var1, var2);
   }
   @SneakyThrows
   public int c2555(Object var1, Object... var2) {
      return ReflectionHelper.g(this.id, var1, var2);
   }
   @SneakyThrows
   public long c7032(Object var1, Object... var2) {
      return ReflectionHelper.h(this.id, var1, var2);
   }
   @SneakyThrows
   public float c3639(Object var1, Object... var2) {
      return ReflectionHelper.i(this.id, var1, var2);
   }
   @SneakyThrows
   public double c4409(Object var1, Object... var2) {
      return ReflectionHelper.j(this.id, var1, var2);
   }
   @SneakyThrows
   public byte c273(Object var1, Object... var2) {
      return ReflectionHelper.ddd(this.id, var1, var2);
   }
   @SneakyThrows
   public Object invoke(Object var1, Object... var2) {
      return ReflectionHelper.k(this.id, var1, var2);
   }
   @SneakyThrows
   public boolean[] c5243(Object var1, Object... var2) {
      return ReflectionHelper.l(this.id, var1, var2);
   }
   @SneakyThrows
   public char[] c8132(Object var1, Object... var2) {
      return ReflectionHelper.m(this.id, var1, var2);
   }
   @SneakyThrows
   public short[] c4565(Object var1, Object... var2) {
      return ReflectionHelper.n(this.id, var1, var2);
   }
   @SneakyThrows
   public int[] c3843(Object var1, Object... var2) {
      return ReflectionHelper.o(this.id, var1, var2);
   }
   @SneakyThrows
   public long[] c6844(Object var1, Object... var2) {
      return ReflectionHelper.p(this.id, var1, var2);
   }
   @SneakyThrows
   public float[] c6387(Object var1, Object... var2) {
      return ReflectionHelper.q(this.id, var1, var2);
   }
   @SneakyThrows
   public double[] c5670(Object var1, Object... var2) {
      return ReflectionHelper.r(this.id, var1, var2);
   }
   @SneakyThrows
   public Object[] invokeObjectArray(Object var1, Object... var2) {
      try {
         return ReflectionHelper.s(this.id, var1, var2);
      } catch (Exception var3) {
         return new Object[0];
      }
   }
   @SneakyThrows
   public void c3039(Object var1, Object... var2) {
      ReflectionHelper.bbb(this.id, var1, var2);
   }
   @SneakyThrows
   public Object c4955(Object... var1) {
      return ReflectionHelper.ccc(this.id, this.owner, var1);
   }

   public String getName() {
      return ReflectionHelper.gmn(this.id);
   }

   public String getDesc() {
      return this.descx;
   }
}
