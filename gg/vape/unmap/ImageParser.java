package gg.vape.unmap;

import func.skidline.c2813;
import lombok.SneakyThrows;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.zip.Inflater;

public class ImageParser {
   public final byte[] c8303 = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
   public final int c8543 = 1229472850;
   public final int c2395 = 1347179589;
   public final int c5930 = 1951551059;
   public final int c2372 = 1229209940;
   public final int c1753 = 1229278788;
   public final byte c7782 = 0;
   public final byte c2788 = 2;
   public final byte c893 = 3;
   public final byte c4150 = 4;
   public final byte c4692 = 6;
   public final InputStream c8544;
   public final byte[] c7991;
   public int c3898;
   public int c6071;
   public int c6288;
   public int c1453;
   public int c4882;
   public int c7953;
   public int c593;
   public int c4662;
   public byte[] c4611;
   public byte[] c8426;
   public byte[] c1542;

   public ImageParser(InputStream var1) throws IOException {
      this.c8544 = var1;
      this.c7991 = new byte[4096];
      this.c6255(this.c7991, 0, this.c8303.length);
      if (!this.c4677(this.c7991)) {
         throw new IOException("Not a valid PNG file");
      } else {
         this.c2156(1229472850);
         this.c669();
         this.c7679();

         while(true) {
            this.c1110();
            switch (this.c6071) {
               case 1229209940:
                  if (this.c593 == 3 && this.c4611 == null) {
                     throw new IOException("Missing PLTE chunk");
                  }

                  return;
               case 1347179589:
                  this.c8243();
                  break;
               case 1951551059:
                  this.c950();
            }

            this.c7679();
         }
      }
   }

   public int c2218() {
      return this.c4882;
   }

   public int c4110() {
      return this.c1453;
   }

   public boolean c5508() {
      return this.c593 == 6 || this.c593 == 4;
   }

   public boolean c5576() {
      return this.c5508() || this.c8426 != null || this.c1542 != null;
   }

   public boolean c1278() {
      return this.c593 == 6 || this.c593 == 2 || this.c593 == 3;
   }

   public void c8944(byte var1, byte var2, byte var3) {
      if (this.c5508()) {
         throw new UnsupportedOperationException("image has an alpha channel");
      } else {
         byte[] var4 = this.c4611;
         if (var4 == null) {
            this.c1542 = new byte[]{0, var1, 0, var2, 0, var3};
         } else {
            this.c8426 = new byte[var4.length / 3];
            int var5 = 0;

            for(int var6 = 0; var5 < var4.length; ++var6) {
               if (var4[var5] != var1 || var4[var5 + 1] != var2 || var4[var5 + 2] != var3) {
                  this.c8426[var6] = -1;
               }

               var5 += 3;
            }
         }

      }
   }

   public c2813 c8714(c2813 c28132) {
      switch (this.c593) {
         case 2: {
            switch (c28132) {
               case c3005:
               case c297:
               case c8800:
               case c7797: {
                  return c28132;
               }
            }
            return c2813.c7797;
         }
         case 6: {
            switch (c28132) {
               case c3005:
               case c297:
               case c8800:
               case c7797: {
                  return c28132;
               }
            }
            return c2813.c297;
         }
         case 0: {
            switch (c28132) {
               case c8083:
               case c2732: {
                  return c28132;
               }
            }
            return c2813.c8083;
         }
         case 4: {
            return c2813.c5987;
         }
         case 3: {
            switch (c28132) {
               case c3005:
               case c297:
               case c8800: {
                  return c28132;
               }
            }
            return c2813.c297;
         }
      }
      throw new UnsupportedOperationException("Not yet implemented");
   }

   /*
    * WARNING - Removed try catching itself - possible behaviour change.
    */
   public void c1511(ByteBuffer byteBuffer, int n, c2813 c28132)  throws IOException {
      int n2 = byteBuffer.position();
      int n3 = (this.c1453 * this.c7953 + 7) / 8 * this.c4662;
      byte[] byArray = new byte[n3 + 1];
      byte[] byArray2 = new byte[n3 + 1];
      byte[] byArray3 = this.c7953 < 8 ? new byte[this.c1453 + 1] : null;
      Inflater inflater = new Inflater();
      try {
         for (int i = 0; i < this.c4882; ++i) {
            this.c3378(inflater, byArray, 0, byArray.length);
            this.c4058(byArray, byArray2);
            byteBuffer.position(n2 + i * n);
            block1 : switch (this.c593) {
               case 2: {
                  switch (c28132) {
                     case c3005: {
                        this.c2496(byteBuffer, byArray);
                        break block1;
                     }
                     case c297: {
                        this.c2482(byteBuffer, byArray);
                        break block1;
                     }
                     case c8800: {
                        this.c5838(byteBuffer, byArray);
                        break block1;
                     }
                     case c7797: {
                        this.c3063(byteBuffer, byArray);
                        break block1;
                     }
                  }
                  throw new UnsupportedOperationException("Unsupported format for this image");
               }
               case 6: {
                  switch (c28132) {
                     case c3005: {
                        this.c5344(byteBuffer, byArray);
                        break block1;
                     }
                     case c297: {
                        this.c3063(byteBuffer, byArray);
                        break block1;
                     }
                     case c8800: {
                        this.c906(byteBuffer, byArray);
                        break block1;
                     }
                     case c7797: {
                        this.c6980(byteBuffer, byArray);
                        break block1;
                     }
                  }
                  throw new UnsupportedOperationException("Unsupported format for this image");
               }
               case 0: {
                  switch (c28132) {
                     case c8083:
                     case c2732: {
                        this.c3063(byteBuffer, byArray);
                        break block1;
                     }
                  }
                  throw new UnsupportedOperationException("Unsupported format for this image");
               }
               case 4: {
                  if (Objects.requireNonNull(c28132) == c2813.c5987) {
                     this.c3063(byteBuffer, byArray);
                     break block1;
                  }
                  throw new UnsupportedOperationException("Unsupported format for this image");
               }
               case 3: {
                  switch (this.c7953) {
                     case 8: {
                        byArray3 = byArray;
                        break;
                     }
                     case 4: {
                        this.c2439(byArray, byArray3);
                        break;
                     }
                     case 2: {
                        this.c8114(byArray, byArray3);
                        break;
                     }
                     case 1: {
                        this.c1322(byArray, byArray3);
                        break;
                     }
                     default: {
                        throw new UnsupportedOperationException("Unsupported bitdepth for this image");
                     }
                  }
                  switch (c28132) {
                     case c3005: {
                        this.c3713(byteBuffer, byArray3);
                        break block1;
                     }
                     case c297: {
                        this.c6267(byteBuffer, byArray3);
                        break block1;
                     }
                     case c8800: {
                        this.c8080(byteBuffer, byArray3);
                        break block1;
                     }
                  }
                  throw new UnsupportedOperationException("Unsupported format for this image");
               }
               default: {
                  throw new UnsupportedOperationException("Not yet implemented");
               }
            }
            byte[] byArray4 = byArray;
            byArray = byArray2;
            byArray2 = byArray4;
         }
      }
      finally {
         inflater.end();
      }
   }
@SneakyThrows
   public void c1547(ByteBuffer var1, int var2, c2813 var3) {
      if (var2 <= 0) {
         throw new IllegalArgumentException("stride");
      } else {
         int var4 = var1.position();
         int var5 = (this.c4882 - 1) * var2;
         var1.position(var4 + var5);
         this.c1511(var1, -var2, var3);
         var1.position(var1.position() + var5);
      }
   }

   public void c3063(ByteBuffer var1, byte[] var2) {
      var1.put(var2, 1, var2.length - 1);
   }

   public void c2496(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      if (this.c1542 != null) {
         var3 = this.c1542[1];
         var4 = this.c1542[3];
         byte var5 = this.c1542[5];
         int var6 = 1;

         for(int var7 = var2.length; var6 < var7; var6 += 3) {
            byte var8 = var2[var6];
            byte var9 = var2[var6 + 1];
            byte var10 = var2[var6 + 2];
            byte var11 = -1;
            if (var8 == var3 && var9 == var4 && var10 == var5) {
               var11 = 0;
            }

            var1.put(var11).put(var10).put(var9).put(var8);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; var3 += 3) {
            var1.put((byte)-1).put(var2[var3 + 2]).put(var2[var3 + 1]).put(var2[var3]);
         }
      }

   }

   public void c2482(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      if (this.c1542 != null) {
         var3 = this.c1542[1];
         var4 = this.c1542[3];
         byte var5 = this.c1542[5];
         int var6 = 1;

         for(int var7 = var2.length; var6 < var7; var6 += 3) {
            byte var8 = var2[var6];
            byte var9 = var2[var6 + 1];
            byte var10 = var2[var6 + 2];
            byte var11 = -1;
            if (var8 == var3 && var9 == var4 && var10 == var5) {
               var11 = 0;
            }

            var1.put(var8).put(var9).put(var10).put(var11);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; var3 += 3) {
            var1.put(var2[var3]).put(var2[var3 + 1]).put(var2[var3 + 2]).put((byte)-1);
         }
      }

   }

   public void c5838(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      if (this.c1542 != null) {
         var3 = this.c1542[1];
         var4 = this.c1542[3];
         byte var5 = this.c1542[5];
         int var6 = 1;

         for(int var7 = var2.length; var6 < var7; var6 += 3) {
            byte var8 = var2[var6];
            byte var9 = var2[var6 + 1];
            byte var10 = var2[var6 + 2];
            byte var11 = -1;
            if (var8 == var3 && var9 == var4 && var10 == var5) {
               var11 = 0;
            }

            var1.put(var10).put(var9).put(var8).put(var11);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; var3 += 3) {
            var1.put(var2[var3 + 2]).put(var2[var3 + 1]).put(var2[var3]).put((byte)-1);
         }
      }

   }

   public void c5344(ByteBuffer var1, byte[] var2) {
      int var3 = 1;

      for(int var4 = var2.length; var3 < var4; var3 += 4) {
         var1.put(var2[var3 + 3]).put(var2[var3 + 2]).put(var2[var3 + 1]).put(var2[var3]);
      }

   }

   public void c906(ByteBuffer var1, byte[] var2) {
      int var3 = 1;

      for(int var4 = var2.length; var3 < var4; var3 += 4) {
         var1.put(var2[var3 + 2]).put(var2[var3 + 1]).put(var2[var3]).put(var2[var3 + 3]);
      }

   }

   public void c6980(ByteBuffer var1, byte[] var2) {
      int var3 = 1;

      for(int var4 = var2.length; var3 < var4; var3 += 4) {
         var1.put(var2[var3]).put(var2[var3 + 1]).put(var2[var3 + 2]);
      }

   }

   public void c3713(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      int var5;
      byte var6;
      byte var7;
      byte var8;
      byte var9;
      if (this.c8426 != null) {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = this.c8426[var5];
            var1.put(var9).put(var8).put(var7).put(var6);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = -1;
            var1.put(var9).put(var8).put(var7).put(var6);
         }
      }

   }

   public void c6267(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      int var5;
      byte var6;
      byte var7;
      byte var8;
      byte var9;
      if (this.c8426 != null) {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = this.c8426[var5];
            var1.put(var6).put(var7).put(var8).put(var9);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = -1;
            var1.put(var6).put(var7).put(var8).put(var9);
         }
      }

   }

   public void c8080(ByteBuffer var1, byte[] var2) {
      int var3;
      int var4;
      int var5;
      byte var6;
      byte var7;
      byte var8;
      byte var9;
      if (this.c8426 != null) {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = this.c8426[var5];
            var1.put(var8).put(var7).put(var6).put(var9);
         }
      } else {
         var3 = 1;

         for(var4 = var2.length; var3 < var4; ++var3) {
            var5 = var2[var3] & 255;
            var6 = this.c4611[var5 * 3];
            var7 = this.c4611[var5 * 3 + 1];
            var8 = this.c4611[var5 * 3 + 2];
            var9 = -1;
            var1.put(var8).put(var7).put(var6).put(var9);
         }
      }

   }

   public void c2439(byte[] var1, byte[] var2) {
      int var3 = 1;
      int var4 = var2.length;

      while(var3 < var4) {
         int var5 = var1[1 + (var3 >> 1)] & 255;
         switch (var4 - var3) {
            default:
               var2[var3 + 1] = (byte)(var5 & 15);
            case 1:
               var2[var3] = (byte)(var5 >> 4);
               var3 += 2;
         }
      }

   }

   public void c8114(byte[] var1, byte[] var2) {
      int var3 = 1;
      int var4 = var2.length;

      while(var3 < var4) {
         int var5 = var1[1 + (var3 >> 2)] & 255;
         switch (var4 - var3) {
            default:
               var2[var3 + 3] = (byte)(var5 & 3);
            case 3:
               var2[var3 + 2] = (byte)(var5 >> 2 & 3);
            case 2:
               var2[var3 + 1] = (byte)(var5 >> 4 & 3);
            case 1:
               var2[var3] = (byte)(var5 >> 6);
               var3 += 4;
         }
      }

   }

   public void c1322(byte[] var1, byte[] var2) {
      int var3 = 1;
      int var4 = var2.length;

      while(var3 < var4) {
         int var5 = var1[1 + (var3 >> 3)] & 255;
         switch (var4 - var3) {
            default:
               var2[var3 + 7] = (byte)(var5 & 1);
            case 7:
               var2[var3 + 6] = (byte)(var5 >> 1 & 1);
            case 6:
               var2[var3 + 5] = (byte)(var5 >> 2 & 1);
            case 5:
               var2[var3 + 4] = (byte)(var5 >> 3 & 1);
            case 4:
               var2[var3 + 3] = (byte)(var5 >> 4 & 1);
            case 3:
               var2[var3 + 2] = (byte)(var5 >> 5 & 1);
            case 2:
               var2[var3 + 1] = (byte)(var5 >> 6 & 1);
            case 1:
               var2[var3] = (byte)(var5 >> 7);
               var3 += 8;
         }
      }

   }

   public void c4058(byte[] var1, byte[] var2) throws IOException{
      switch (var1[0]) {
         case 0:
            break;
         case 1:
            this.c50(var1);
            break;
         case 2:
            this.c5813(var1, var2);
            break;
         case 3:
            this.c6781(var1, var2);
            break;
         case 4:
            this.c126(var1, var2);
            break;
         default:
            throw new IOException("invalide filter type in scanline: " + var1[0]);
      }

   }

   public void c50(byte[] var1) {
      int var2 = this.c4662;
      int var3 = var2 + 1;

      for(int var4 = var1.length; var3 < var4; ++var3) {
         var1[var3] += var1[var3 - var2];
      }

   }

   public void c5813(byte[] var1, byte[] var2) {
      int var3 = this.c4662;
      int var4 = 1;

      for(int var5 = var1.length; var4 < var5; ++var4) {
         var1[var4] += var2[var4];
      }

   }

   public void c6781(byte[] var1, byte[] var2) {
      int var3 = this.c4662;

      int var4;
      for(var4 = 1; var4 <= var3; ++var4) {
         var1[var4] += (byte)((var2[var4] & 255) >>> 1);
      }

      for(int var5 = var1.length; var4 < var5; ++var4) {
         var1[var4] += (byte)((var2[var4] & 255) + (var1[var4 - var3] & 255) >>> 1);
      }

   }

   public void c126(byte[] var1, byte[] var2) {
      int var3 = this.c4662;

      int var4;
      for(var4 = 1; var4 <= var3; ++var4) {
         var1[var4] += var2[var4];
      }

      for(int var5 = var1.length; var4 < var5; ++var4) {
         int var6 = var1[var4 - var3] & 255;
         int var7 = var2[var4] & 255;
         int var8 = var2[var4 - var3] & 255;
         int var9 = var6 + var7 - var8;
         int var10 = var9 - var6;
         if (var10 < 0) {
            var10 = -var10;
         }

         int var11 = var9 - var7;
         if (var11 < 0) {
            var11 = -var11;
         }

         int var12 = var9 - var8;
         if (var12 < 0) {
            var12 = -var12;
         }

         if (var10 <= var11 && var10 <= var12) {
            var8 = var6;
         } else if (var11 <= var12) {
            var8 = var7;
         }

         var1[var4] += (byte)var8;
      }

   }

   @SneakyThrows
   public void c669() {
      this.c8021(13);
      this.c3467(this.c7991, 0, 13);
      this.c1453 = this.c4747(this.c7991, 0);
      this.c4882 = this.c4747(this.c7991, 4);
      this.c7953 = this.c7991[8] & 255;
      this.c593 = this.c7991[9] & 255;
      label43:
      switch (this.c593) {
         case 0:
            if (this.c7953 != 8) {
               throw new IOException("Unsupported bit depth: " + this.c7953);
            }

            this.c4662 = 1;
            break;
         case 1:
         case 5:
         default:
            throw new IOException("unsupported color format: " + this.c593);
         case 2:
            if (this.c7953 != 8) {
               throw new IOException("Unsupported bit depth: " + this.c7953);
            }

            this.c4662 = 3;
            break;
         case 3:
            switch (this.c7953) {
               case 1:
               case 2:
               case 4:
               case 8:
                  this.c4662 = 1;
                  break label43;
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  throw new IOException("Unsupported bit depth: " + this.c7953);
            }
         case 4:
            if (this.c7953 != 8) {
               throw new IOException("Unsupported bit depth: " + this.c7953);
            }

            this.c4662 = 2;
            break;
         case 6:
            if (this.c7953 != 8) {
               throw new IOException("Unsupported bit depth: " + this.c7953);
            }

            this.c4662 = 4;
      }

      if (this.c7991[10] != 0) {
         throw new IOException("unsupported compression method");
      } else if (this.c7991[11] != 0) {
         throw new IOException("unsupported filtering method");
      } else if (this.c7991[12] != 0) {
         throw new IOException("unsupported interlace method");
      }
   }

   public void c8243() throws IOException{
      int var1 = this.c3898 / 3;
      if (var1 >= 1 && var1 <= 256 && this.c3898 % 3 == 0) {
         this.c4611 = new byte[var1 * 3];
         this.c3467(this.c4611, 0, this.c4611.length);
      } else {
         throw new IOException("PLTE chunk has wrong length");
      }
   }

   public void c950() throws IOException{
      switch (this.c593) {
         case 0:
            this.c8021(2);
            this.c1542 = new byte[2];
            this.c3467(this.c1542, 0, 2);
         case 1:
         default:
            break;
         case 2:
            this.c8021(6);
            this.c1542 = new byte[6];
            this.c3467(this.c1542, 0, 6);
            break;
         case 3:
            if (this.c4611 == null) {
               throw new IOException("tRNS chunk without PLTE chunk");
            }

            this.c8426 = new byte[this.c4611.length / 3];
            Arrays.fill(this.c8426, (byte)-1);
            this.c3467(this.c8426, 0, this.c8426.length);
      }

   }

   public void c7679() throws IOException{
      if (this.c6288 > 0) {
         this.c8324(this.c6288 + 4);
      } else {
         this.c6255(this.c7991, 0, 4);
      }

      this.c6288 = 0;
      this.c3898 = 0;
      this.c6071 = 0;
   }
   @SneakyThrows
   public void c1110() {
      this.c6255(this.c7991, 0, 8);
      this.c3898 = this.c4747(this.c7991, 0);
      this.c6071 = this.c4747(this.c7991, 4);
      this.c6288 = this.c3898;
   }

   public void c2156(int var1) throws IOException{
      this.c1110();
      if (this.c6071 != var1) {
         throw new IOException("Expected chunk: " + Integer.toHexString(var1));
      }
   }

   public void c8021(int var1)throws IOException {
      if (this.c3898 != var1) {
         throw new IOException("Chunk has wrong size");
      }
   }

   public int c3467(byte[] var1, int var2, int var3) throws IOException{
      if (var3 > this.c6288) {
         var3 = this.c6288;
      }

      this.c6255(var1, var2, var3);
      this.c6288 -= var3;
      return var3;
   }

   public void c5571(Inflater var1) throws IOException{
      while(this.c6288 == 0) {
         this.c7679();
         this.c2156(1229209940);
      }

      int var2 = this.c3467(this.c7991, 0, this.c7991.length);
      var1.setInput(this.c7991, 0, var2);
   }

   public void c3378(Inflater var1, byte[] var2, int var3, int var4) throws IOException{
      try {
         do {
            int var5 = var1.inflate(var2, var3, var4);
            if (var5 <= 0) {
               if (var1.finished()) {
                  throw new EOFException();
               }

               if (!var1.needsInput()) {
                  throw new IOException("Can't inflate " + var4 + " bytes");
               }

               this.c5571(var1);
            } else {
               var3 += var5;
               var4 -= var5;
            }
         } while(var4 > 0);

      } catch (Exception var6) {
         throw (IOException) new IOException("inflate error", var6);
      }
   }

   public void c6255(byte[] var1, int var2, int var3) throws IOException{
      do {
         int var4 = this.c8544.read(var1, var2, var3);
         if (var4 < 0) {
            throw new EOFException();
         }

         var2 += var4;
         var3 -= var4;
      } while(var3 > 0);

   }

   public int c4747(byte[] var1, int var2) {
      return var1[var2] << 24 | (var1[var2 + 1] & 255) << 16 | (var1[var2 + 2] & 255) << 8 | var1[var2 + 3] & 255;
   }

   public void c8324(long var1) throws IOException{
      while(var1 > 0L) {
         long var3 = this.c8544.skip(var1);
         if (var3 < 0L) {
            throw new EOFException();
         }

         var1 -= var3;
      }

   }

   public boolean c4677(byte[] var1) {
      for(int var2 = 0; var2 < this.c8303.length; ++var2) {
         if (var1[var2] != this.c8303[var2]) {
            return false;
         }
      }

      return true;
   }
}
