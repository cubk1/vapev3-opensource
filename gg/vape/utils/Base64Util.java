package gg.vape.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Base64Util {
   private static final char[] BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
   private static int[] DECODE_TABLE;
   private static boolean IS_DECODE_TABLE_INIT;

   public static String encodeBase64(byte[] data) {
      int len = data.length;
      byte[] result = new byte[len * 4];
      int pos = 0;
      int padding = 0;
      int bitPos = -6;

      for (byte datum : data) {
         int currentByte = datum & 0xFF;
         padding = (padding << 8) | currentByte;

         for (bitPos += 8; bitPos >= 0; bitPos -= 6) {
            result[pos++] = (byte) BASE64_ALPHABET[(padding >> bitPos) & 63];
         }
      }

      if (bitPos > -6) {
         result[pos++] = (byte) BASE64_ALPHABET[((padding << 8) >> (bitPos + 8)) & 63];
      }

      while (pos % 4 != 0) {
         result[pos++] = '=';
      }

      return new String(result, 0, pos, StandardCharsets.UTF_8);
   }

   public static byte[] decodeBase64(String encodedData) {
      byte[] data = encodedData.getBytes(StandardCharsets.UTF_8);
      int len = data.length;
      byte[] result = new byte[len + 1];
      int pos = 0;
      int bitPos = -8;

      if (!IS_DECODE_TABLE_INIT) {
         DECODE_TABLE = new int[256];

         for (int i = 0; i < 256; ++i) {
            DECODE_TABLE[i] = -1;
         }

         for (int i = 0; i < 64; ++i) {
            DECODE_TABLE[BASE64_ALPHABET[i]] = i;
         }

         IS_DECODE_TABLE_INIT = true;
      }

      int currentByte = 0;
      for (byte datum : data) {
         char currentChar = (char) datum;
         if (DECODE_TABLE[currentChar] == -1) {
            break;
         }

         currentByte = (currentByte << 6) | DECODE_TABLE[currentChar];
         bitPos += 6;

         if (bitPos >= 0) {
            result[pos++] = (byte) ((currentByte >> bitPos) & 0xFF);
            bitPos -= 8;
         }
      }

      result[pos] = 0;
      return Arrays.copyOf(result, pos);
   }
}