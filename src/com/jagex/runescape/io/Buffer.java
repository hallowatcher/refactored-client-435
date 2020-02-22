package com.jagex.runescape.io;

import com.jagex.runescape.*;

import java.math.BigInteger;

public class Buffer extends Node {
    public static Cache aClass9_1933 = new Cache(100);
    public static IndexedColorSprite aClass40_Sub5_Sub14_Sub2_1959;
    public static int[] anIntArray1972;
    public static int anInt1976 = 0;
    public static int anInt1978 = 0;

    public static int anInt1982 = 0;
    public static RSString aClass1_1983 = (Class58.method978("Too many incorrect logins from your address)3"));
    public static int[] anIntArray1984 = new int[2000];
    public static int anInt1985 = -1;
    public static int anInt1987 = 0;
    public static RSString aClass1_1990 = Class58.method978("Ausw-=hlen");

    public int currentPosition;
    public byte[] buffer;

    public Buffer(int arg0) {
        buffer = Class13.method246(-21955, arg0);
        currentPosition = 0;
    }

    public Buffer(byte[] buffer) {
        currentPosition = 0;
        this.buffer = buffer;

    }

    public static boolean method472(int arg0, Class6 arg1, int arg2) {
        byte[] is = arg1.method187(arg2, (byte) -96);
        if(arg0 >= -84) {
            method499(true);
        }
        if(is == null) {
            return false;
        }
        Class6.method184(is, 0);
        return true;

    }

    public static void method499(boolean arg0) {
        aClass1_1990 = null;
        anIntArray1984 = null;
        aClass40_Sub5_Sub14_Sub2_1959 = null;
        aClass1_1983 = null;
        aClass9_1933 = null;
        anIntArray1972 = null;
    }

    public static Class40_Sub5_Sub10 method501(byte arg0, int arg1) {
        if(arg0 != -94) {
            aClass9_1933 = null;
        }
        Class40_Sub5_Sub10 class40_sub5_sub10 = ((Class40_Sub5_Sub10) Class68.aClass9_1615.method231((long) arg1, (byte) 107));
        if(class40_sub5_sub10 != null) {
            return class40_sub5_sub10;
        }
        byte[] is = Class49.aClass6_1150.method172(arg1, 114, 3);
        class40_sub5_sub10 = new Class40_Sub5_Sub10();
        if(is != null) {
            class40_sub5_sub10.method622((byte) 58, new Buffer(is));
        }
        Class68.aClass9_1615.method230(-7208, (long) arg1, class40_sub5_sub10);
        return class40_sub5_sub10;

    }

    public int method460(int arg0) {
        currentPosition += 2;
        int i = ((buffer[-1 + currentPosition] + -128 & 0xff) + (0xff00 & buffer[-2 + currentPosition] << 8));
        if(i > 32767) {
            i -= 65536;
        }
        if(arg0 != -23843) {
            anInt1978 = -67;
        }
        return i;

    }

    public int method461(byte arg0) {
        if(arg0 < 56) {
            getSignedSmart();
        }
        currentPosition += 2;
        return ((buffer[-2 + currentPosition] << 8 & 0xff00) + (0xff & buffer[currentPosition + -1] - 128));

    }

    public void putBytes128(int arg1, byte[] arg2, int arg3) {
        for(int i = arg1; i < arg3 + arg1; i++) {
            arg2[i] = (byte) (buffer[currentPosition++] - 128);
        }

    }

    public int getShortUNKNOWN() {
        currentPosition += 2;
        int i = ((0xff00 & buffer[currentPosition - 2] << 8) + (buffer[currentPosition - 1] & 0xff));
        if(i > 0x7fff) {
            i -= 0x10000;
        }
        return i;

    }

    public RSString getRSString(int arg0) {
        int i = currentPosition;
        if(arg0 != -10721) {
            method483(null, true, -57, 63);
        }
        while(buffer[currentPosition++] != 0) {
            /* empty */
        }
        return Class19.method279(buffer, true, i, -1 + currentPosition + -i);
    }

    public void put(int arg0, byte arg1) {
        if(arg1 == -128) {
            buffer[currentPosition++] = (byte) arg0;
        }
    }

    public void applyRSA(BigInteger modulus, BigInteger key, int arg2) {
        int i = currentPosition;
        currentPosition = 0;
        byte[] is = new byte[i];
        method497(is, 0, i, (byte) 45);
        BigInteger biginteger = new BigInteger(is);
        BigInteger biginteger_0_ = biginteger.modPow(key, modulus);
        System.out.println("RSA");
        byte[] is_1_ = biginteger_0_.toByteArray();
        currentPosition = 0;
        if(arg2 == 19280) {
            put(is_1_.length, (byte) -128);
            method475(is_1_.length, is_1_, 0, 8636);
        }
    }

    public byte method467(byte arg0) {
        if(arg0 < 9) {
            getRSString(-30);
        }
        return (byte) -buffer[currentPosition++];
    }

    public int getUnsignedByte() {
        return 0xff & buffer[currentPosition++];
    }

    public int getUnsignedShortBE() {
        currentPosition += 2;
        return (((0xff & buffer[currentPosition + -2]) << 8) + (buffer[currentPosition + -1] & 0xff));
    }

    public int method470(int arg0) {
        if(arg0 >= -114) {
            buffer = null;
        }
        currentPosition += 4;
        return ((0xff00 & buffer[currentPosition + -1] << 8) + ((buffer[-4 + currentPosition] << 16 & 0xff0000) + ((buffer[-3 + currentPosition] & 0xff) << 24)) + (buffer[currentPosition + -2] & 0xff));
    }

    public int method471(byte arg0) {
        int i = 41 / ((78 - arg0) / 36);
        return 0xff & -buffer[currentPosition++];
    }

    public int method473(int arg0, int arg1) {
        int i = Class67.method1034(true, arg1, currentPosition, buffer);
        putInt(127, i);
        if(arg0 <= 14) {
            anIntArray1972 = null;
        }
        return i;
    }

    public void method474(int arg0, int arg1) {
        int i = -63 / ((-60 - arg1) / 61);
        buffer[currentPosition++] = (byte) (arg0 >> 8);
        buffer[currentPosition++] = (byte) arg0;
    }

    public void method475(int arg0, byte[] arg1, int arg2, int arg3) {
        if(arg3 == 8636) {
            for(int i = arg2; arg2 + arg0 > i; i++) {
                buffer[currentPosition++] = arg1[i];
            }
        }
    }

    public int method476(int arg0) {
        if(arg0 != 255) {
            putTri(-16, 96);
        }
        return 0xff & buffer[currentPosition++] - 128;
    }

    public void putTri(int arg0, int arg1) {
        if(arg1 != 13723) {
            currentPosition = -49;
        }
        buffer[currentPosition++] = (byte) (arg0 >> 16);
        buffer[currentPosition++] = (byte) (arg0 >> 8);
        buffer[currentPosition++] = (byte) arg0;
    }

    public void method478(int arg0, int arg1) {
        if(arg1 > -17) {
            anInt1985 = -53;
        }
        buffer[currentPosition++] = (byte) (128 + arg0);
        buffer[currentPosition++] = (byte) (arg0 >> 8);
    }

    public void finishVarByte(int arg0, byte arg1) {
        if(arg1 != 16) {
            anIntArray1984 = null;
        }
        buffer[-1 + (currentPosition + -arg0)] = (byte) arg0;
    }

    public int method480(byte arg0) {
        if(arg0 != -70) {
            return -26;
        }
        return 0xff & 128 - buffer[currentPosition++];
    }

    public void putLong(long arg0, boolean arg1) {
        buffer[currentPosition++] = (byte) (int) (arg0 >> 56);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 48);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 40);
        if(arg1 != false) {
            method500(79);
        }
        buffer[currentPosition++] = (byte) (int) (arg0 >> 32);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 24);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 16);
        buffer[currentPosition++] = (byte) (int) (arg0 >> 8);
        buffer[currentPosition++] = (byte) (int) arg0;
    }

    public int getSignedSmart() {
        int peek = buffer[currentPosition] & 0xff;
        if(peek >= 128) {
            return -49152 + getUnsignedShortBE();
        }
        return getUnsignedByte() + -64;
    }

    public void method483(int[] arg0, boolean arg1, int arg2, int arg3) {
        int i = (-arg3 + arg2) / 8;
        int i_3_ = currentPosition;
        currentPosition = arg3;
        int i_4_ = 0;
        if(arg1 != false) {
            method509(87, 12);
        }
        for(/**/; i > i_4_; i_4_++) {
            int i_5_ = readInt();
            int i_6_ = readInt();
            int i_7_ = 32;
            int i_8_ = -957401312;
            int i_9_ = -1640531527;
            while((i_7_-- ^ 0xffffffff) < -1) {
                i_6_ -= ((i_5_ >>> 5 ^ i_5_ << 4) + i_5_ ^ i_8_ + arg0[~0x71dffffc & i_8_ >>> 11]);
                i_8_ -= i_9_;
                i_5_ -= ((i_6_ >>> 5 ^ i_6_ << 4) + i_6_ ^ arg0[0x3 & i_8_] + i_8_);
            }
            currentPosition -= 8;
            putInt(64, i_5_);
            putInt(57, i_6_);
        }
        currentPosition = i_3_;
    }

    public int method484(byte arg0) {
        currentPosition += 2;
        if(arg0 < 82) {
            return -115;
        }
        int i = ((0xff & -128 + buffer[currentPosition + -2]) + (0xff00 & buffer[-1 + currentPosition] << 8));
        if(i > 32767) {
            i -= 65536;
        }
        return i;
    }

    public int method485(byte arg0) {
        currentPosition += 4;
        if(arg0 != -48) {
            method502((byte) 24);
        }
        return ((buffer[currentPosition - 3] << 8 & 0xff00) + (((0xff & buffer[-1 + currentPosition]) << 24) + (0xff0000 & buffer[-2 + currentPosition] << 16)) + (buffer[currentPosition - 4] & 0xff));
    }

    public void method486(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) arg1;
        if(arg0 != 14912) {
            method496(73, 82);
        }
        buffer[currentPosition++] = (byte) (arg1 >> 8);
    }

    public void method487(int arg0, byte arg1) {
        buffer[currentPosition++] = (byte) (arg0 >> 16);
        buffer[currentPosition++] = (byte) (arg0 >> 24);
        buffer[currentPosition++] = (byte) arg0;
        if(arg1 <= 84) {
            method470(44);
        }
        buffer[currentPosition++] = (byte) (arg0 >> 8);
    }

    public int getTri(boolean arg0) {
        if(arg0 != true) {
            anInt1976 = -89;
        }
        currentPosition += 3;
        return (((buffer[-3 + currentPosition] & 0xff) << 16) + ((buffer[-2 + currentPosition] & 0xff) << 8) + (0xff & buffer[currentPosition + -1]));
    }

    public void method489(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) (arg1 + arg0);
    }

    public int method490(byte arg0) {
        if(arg0 != -70) {
            anInt1976 = 28;
        }
        currentPosition += 2;
        return ((0xff00 & buffer[currentPosition - 1] << 8) + (0xff & buffer[-2 + currentPosition]));
    }

    public int readInt() {
        currentPosition += 4;
        return ((0xff & buffer[-1 + currentPosition]) + (buffer[-2 + currentPosition] << 8 & 0xff00) + (buffer[-3 + currentPosition] << 16 & 0xff0000) + (~0xffffff & buffer[-4 + currentPosition] << 24));
    }

    public byte method492(int arg0) {
        if(arg0 != 128) {
            method492(-79);
        }
        return (byte) (-buffer[currentPosition++] + 128);
    }

    public void method493(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) (arg0 >> 8);
        buffer[currentPosition++] = (byte) (arg0 + -arg1);
    }

    public void method494(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) arg0;
        buffer[currentPosition++] = (byte) (arg0 >> 8);
        buffer[currentPosition++] = (byte) (arg0 >> 16);
        buffer[currentPosition++] = (byte) (arg0 >> 24);
        if(arg1 < 69) {
            put(34, (byte) -50);
        }
    }

    public byte method495(int arg0) {
        if(arg0 >= -39) {
            anIntArray1984 = null;
        }
        return (byte) (buffer[currentPosition++] - 128);
    }

    public void method496(int arg0, int arg1) {
        if(arg0 != 255) {
            anInt1976 = 21;
        }
        buffer[currentPosition++] = (byte) -arg1;
    }

    public void method497(byte[] arg0, int arg1, int arg2, byte arg3) {
        for(int i = arg1; arg2 + arg1 > i; i++) {
            arg0[i] = buffer[currentPosition++];
        }
        if(arg3 != 45) {
            method485((byte) -119);
        }
    }

    public long method498(int arg0) {
        long l = 0xffffffffL & (long) readInt();
        long l_10_ = (long) readInt() & 0xffffffffL;
        if(arg0 != 1362367312) {
            method499(false);
        }
        return l_10_ + (l << 32);
    }

    public int method500(int arg0) {
        if(arg0 < 28) {
            anInt1982 = -107;
        }
        int i = buffer[currentPosition++];
        int i_11_ = 0;
        for(/**/; i < 0; i = buffer[currentPosition++]) {
            i_11_ = (0x7f & i | i_11_) << 7;
        }
        return i | i_11_;
    }

    public int method502(byte arg0) {
        int i = buffer[currentPosition] & 0xff;
        int i_12_ = 100 / ((arg0 + 39) / 32);
        if((i ^ 0xffffffff) <= -129) {
            return getUnsignedShortBE() + -32768;
        }
        return getUnsignedByte();
    }

    public void method503(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) (arg1 >> 8);
        buffer[currentPosition++] = (byte) arg1;
        if(arg0 != -2030879560) {
            method486(1, -84);
        }
        buffer[currentPosition++] = (byte) (arg1 >> 24);
        buffer[currentPosition++] = (byte) (arg1 >> 16);
    }

    public int method504(boolean arg0) {
        currentPosition += 2;
        if(arg0 != false) {
            method474(40, 44);
        }
        return ((0xff & buffer[currentPosition + -2] - 128) + (0xff00 & buffer[currentPosition + -1] << 8));
    }

    public void method505(RSString arg0, byte arg1) {
        int i = -97 / ((38 - arg1) / 37);
        currentPosition += arg0.method51(0, arg0.method59(-3136), buffer, currentPosition, -40);
        buffer[currentPosition++] = (byte) 0;
    }

    public void putInt(int arg0, int arg1) {
        buffer[currentPosition++] = (byte) (arg1 >> 24);
        buffer[currentPosition++] = (byte) (arg1 >> 16);
        buffer[currentPosition++] = (byte) (arg1 >> 8);
        buffer[currentPosition++] = (byte) arg1;
    }

    public int method507(int arg0) {
        if(arg0 != -64) {
            return -71;
        }
        currentPosition += 4;
        return ((buffer[-4 + currentPosition] << 8 & 0xff00) + ((~0xffffff & buffer[currentPosition + -2] << 24) + (buffer[currentPosition + -1] << 16 & 0xff0000) + (buffer[-3 + currentPosition] & 0xff)));
    }

    public byte get() {
        return buffer[currentPosition++];
    }

    public void method509(int arg0, int arg1) {
        if(arg1 != 32768) {
            aClass40_Sub5_Sub14_Sub2_1959 = null;
        }
        if((arg0 ^ 0xffffffff) <= -1 && arg0 < 128) {
            put(arg0, (byte) -128);
        } else if(arg0 >= 0 && arg0 < 32768) {
            method474(32768 + arg0, arg1 ^ 0x807d);
        } else {
            throw new IllegalArgumentException();
        }
    }
}