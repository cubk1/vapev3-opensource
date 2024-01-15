package gg.vape.mapping;

import gg.vape.asm.helper.DescUtils;
import lombok.SneakyThrows;
import pub.nextsense.common.ReflectionHelper;

public class MappingField {
   public static int id = 0;
   public final int index;
   public boolean fieldNotFound;

   public MappingField(Class<?> owner, String name, boolean isStatic, boolean remap, Class<?> desc) {
      this(owner, name, isStatic, remap, DescUtils.getClassSignature(desc));
   }

   public MappingField(Class<?> owner, String name, boolean isStatic, boolean remap, String desc) {
      this(owner, name, isStatic, remap, desc, false);
   }

   public MappingField(Class<?> owner, String name, boolean isStatic, boolean remap, String desc, boolean isArray) {
      this.index = ++id;
      if (isArray) {
         desc = "[" + desc;
      }
      try {
         if (isStatic) {
            ReflectionHelper.tryGetField(this.index, owner, name, desc, remap);
         } else {
            ReflectionHelper.tryGetStatic(this.index, owner, name, desc, remap);
         }
      } catch (Exception e) {
         this.fieldNotFound = true;
      }

   }

   @SneakyThrows
   public boolean getBoolean(Object instance) {
      return ReflectionHelper.getBoolean(this.index, instance);
   }
   @SneakyThrows
   public char getChar(Object instance) {
      return ReflectionHelper.getChar(this.index, instance);
   }
   @SneakyThrows
   public short getShort(Object instance) {
      return ReflectionHelper.getShort(this.index, instance);
   }
   @SneakyThrows
   public int getInt(Object instance) {
      return ReflectionHelper.getInt(this.index, instance);
   }
   @SneakyThrows
   public long getLong(Object instance) {
      return ReflectionHelper.getLong(this.index, instance);
   }
   @SneakyThrows
   public float getFloat(Object instance) {
      return ReflectionHelper.getFloat(this.index, instance);
   }
   @SneakyThrows
   public double getDouble(Object instance) {
      return ReflectionHelper.getDouble(this.index, instance);
   }
   @SneakyThrows
   public Object getObject(Object instance) {
      return ReflectionHelper.getObject(this.index, instance);
   }
   @SneakyThrows
   public boolean[] getBooleanArray(Object instance) {
      return ReflectionHelper.getBooleanArray(this.index, instance);
   }
   @SneakyThrows
   public char[] getCharArray(Object instance) {
      return ReflectionHelper.getCharArray(this.index, instance);
   }
   @SneakyThrows
   public short[] getShortArray(Object instance) {
      return ReflectionHelper.getShortArray(this.index, instance);
   }
   @SneakyThrows
   public int[] getIntArray(Object instance) {
      return ReflectionHelper.getIntArray(this.index, instance);
   }
   @SneakyThrows
   public long[] getLongArray(Object instance) {
      return ReflectionHelper.getLongArray(this.index, instance);
   }
   @SneakyThrows
   public float[] getFloatArray(Object instance) {
      return ReflectionHelper.getFloatArray(this.index, instance);
   }
   @SneakyThrows
   public double[] getDoubleArray(Object instance) {
      return ReflectionHelper.getDoubleArray(this.index, instance);
   }
   @SneakyThrows
   public Object[] getObjectArray(Object instance) {
      return ReflectionHelper.getObjectArray(this.index, instance);
   }
   @SneakyThrows
   public void setBoolean(Object instance, boolean value) {
      ReflectionHelper.setBoolean(this.index, instance, value);
   }
   @SneakyThrows
   public void setChar(Object instance, char value) {
      ReflectionHelper.setChar(this.index, instance, value);
   }
   @SneakyThrows
   public void setShort(Object instance, short value) {
      ReflectionHelper.setShort(this.index, instance, value);
   }
   @SneakyThrows
   public void setInt(Object instance, int value) {
      ReflectionHelper.setInt(this.index, instance, value);
   }
   @SneakyThrows
   public void setLong(Object instance, long value) {
      ReflectionHelper.setLong(this.index, instance, value);
   }
   @SneakyThrows
   public void setFloat(Object instance, float value) {
      ReflectionHelper.setFloat(this.index, instance, value);
   }
   @SneakyThrows
   public void setDouble(Object instance, double value) {
      ReflectionHelper.setDouble(this.index, instance, value);
   }
   @SneakyThrows
   public void setObject(Object instance, Object value) {
      ReflectionHelper.setObject(this.index, instance, value);
   }
   @SneakyThrows
   public void setBooleanArray(Object instance, boolean[] value) {
      ReflectionHelper.setBooleanArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setCharArray(Object instance, char[] value) {
      ReflectionHelper.setCharArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setShortArray(Object instance, short[] value) {
      ReflectionHelper.setShortArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setIntArray(Object instance, int[] value) {
      ReflectionHelper.setIntArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setLongArray(Object instance, long[] value) {
      ReflectionHelper.setLongArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setFloatArray(Object instance, float[] value) {
      ReflectionHelper.setFloatArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setDoubleArray(Object instance, double[] value) {
      ReflectionHelper.setDoubleArray(this.index, instance, value);
   }
   @SneakyThrows
   public void setObjectArray(Object instance, Object[] value) {
      ReflectionHelper.setObjectArray(this.index, instance, value);
   }

   public boolean hasField() {
      return this.fieldNotFound;
   }

   public String getFieldName() {
      return ReflectionHelper.gfn(this.index);
   }
}
