package gg.vape.asm.helper;

import gg.vape.Vape;
import org.objectweb.asm.Type;
import pub.nextsense.Tweaker;

import java.util.HashMap;
import java.util.Map;

public class DescUtils {
   public static final Map<Class<?>, String> descMap = new HashMap<>();

   public static String genMethodDesc(Class<?> retType, Class<?>... args) {
      StringBuilder result = new StringBuilder();
      result.append("(");

      for (Class<?> clz : args) {
         result.append(getClassSignature(clz));
      }

      result.append(")");
      result.append(getClassSignature(retType));
      return result.toString();
   }
   public static String genMethodDescX(Class<?> retType, Class<?>... args) {
      StringBuilder result = new StringBuilder();
      result.append("(");

      for (Class<?> clz : args) {
         result.append(getClassSignatureX(clz));
      }

      result.append(")");
      result.append(getClassSignatureX(retType));
      return result.toString();
   }
   static String getClassSignatureX(Class<?> clz) {
      return Type.getDescriptor(clz);
   }

   public static void traceStack() {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      for (StackTraceElement traceElement : stackTrace) {
         Vape.lout(traceElement.toString());
      }

   }

   public static String getClassSignature(Class<?> target) {
      return descMap.containsKey(target) ? descMap.get(target) : Tweaker.getClassSignature(target);
   }

   public static Class<?> getArrayType(Class<?> target) {
      String desc = "[" + Tweaker.getClassSignature(target);
      return Tweaker.getClassInJava(desc);
   }

   static {
      descMap.put(Boolean.TYPE, "Z");
      descMap.put(Byte.TYPE, "B");
      descMap.put(Character.TYPE, "C");
      descMap.put(Short.TYPE, "S");
      descMap.put(Integer.TYPE, "I");
      descMap.put(Long.TYPE, "J");
      descMap.put(Float.TYPE, "F");
      descMap.put(Double.TYPE, "D");
      descMap.put(Void.TYPE, "V");
      descMap.put(boolean[].class, "[Z");
      descMap.put(byte[].class, "[B");
      descMap.put(char[].class, "[C");
      descMap.put(short[].class, "[S");
      descMap.put(int[].class, "[I");
      descMap.put(long[].class, "[J");
      descMap.put(float[].class, "[F");
      descMap.put(double[].class, "[D");
   }
}
