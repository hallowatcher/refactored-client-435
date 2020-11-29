package com.jagex.runescape.cache.media.gameInterface;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.TextUtils;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

public class GameInterface extends SubNode {
    public static GameInterface[][] cachedInterfaces;
    public static int gameScreenInterfaceId = -1;
    public static int tabAreaInterfaceId = -1;
    public static int chatboxInterfaceId = -1;
    public static int fullscreenInterfaceId = -1;
    public static int fullscreenSiblingInterfaceId = -1;
    public static boolean[] loadedInterfaces;
    public static boolean drawTabIcons = false;
    public static boolean redrawTabArea = false;

    public boolean isIf3 = false;
    public int contentType;
    public String alternateText;
    public boolean aBoolean2641;
    public int fontId;
    public int originalHeight;
    public Object[] anObjectArray2644;
    public boolean filled;
    public int textColor;
    public int parentId;
    public int originalX;
    public Object[] anObjectArray2650;
    public InterfaceModelType alternateModelType = InterfaceModelType.MODEL;
    public int alternateAnimation;
    public int animationFrame;
    public boolean itemUsable;
    public int currentX;
    public int rotationZ;
    public Object[] anObjectArray2658;
    public int animation;
    public int remainingAnimationTime;
    public String[] aClass1Array2661;
    public int alternateHoveredTextColor;
    public String targetVerb;
    public boolean textShadowed;
    public int itemSpritePadsY;
    public String disabledText;
    public Object[] anObjectArray2669;
    public int alternateSpriteId;
    public Object[] anObjectArray2672;
    public int modelId;
    public String tooltip;
    public Object[] onLoadListeners;
    public int offsetY2d;
    public Object[] anObjectArray2680;
    public Object[] anObjectArray2681;
    public boolean aBoolean2682;
    public GameInterfaceType type;
    public int[] items;
    public InterfaceModelType modelType;
    public boolean hasListeners;
    public int id;
    public int rotationX;
    public int originalWidth;
    public int[] alternateRhs;
    public boolean aBoolean2694;
    public Object[] anObjectArray2695;
    public int currentY;
    public String[] configActions;
    public int[] images;
    public boolean orthogonal;
    public int clickMask;
    public boolean itemSwapable;
    public int[] imageY;
    public Object[] anObjectArray2707;
    public int[] imageX;
    public String spellName;
    public int[] itemAmounts;
    public int alternateModelId;
    public Object[] anObjectArray2712;
    public GameInterface[] aGameInterfaceArray2713;
    public int actionType;
    public int yTextAlignment;
    public int itemId;
    public int hoveredTextColor;
    public int scrollHeight;
    public int hoveredSiblingId;
    public int anInt2722;
    public boolean itemDeletesDraged;
    public int rotationY;
    public int alternateTextColor;
    public boolean isInventory;
    public int modelZoom;
    public boolean aBoolean2730;
    public int scrollPosition;
    public int lineHeight;
    public int xTextAlignment;
    public int itemAmount;
    public int anInt2736;
    public int offsetX2d;
    public int anInt2738;
    public int[] alternateOperators;
    public int originalY;
    public int spriteId;
    public int opacity;
    public int anInt2746;
    public Object[] anObjectArray2747;
    public int[][] clientScripts;
    public int itemSpritePadsX;
    public boolean isHidden;
    public int anInt2751;

    public GameInterface() {
        contentType = 0;
        rotationZ = 0;
        textShadowed = false;
        aBoolean2641 = false;
        targetVerb = "";
        animationFrame = 0;
        tooltip = English.ok;
        itemSpritePadsY = 0;
        remainingAnimationTime = 0;
        modelType = InterfaceModelType.MODEL;
        alternateAnimation = -1;
        textColor = 0;
        aBoolean2682 = false;
        modelId = -1;
        rotationX = 0;
        clickMask = 0;
        aBoolean2694 = false;
        parentId = -1;
        alternateHoveredTextColor = 0;
        hasListeners = false;
        alternateSpriteId = -1;
        currentY = 0;
        alternateModelId = -1;
        originalX = 0;
        isInventory = false;
        alternateText = "";
        itemSwapable = false;
        hoveredTextColor = 0;
        originalWidth = 0;
        animation = -1;
        xTextAlignment = 0;
        hoveredSiblingId = -1;
        spellName = "";
        offsetY2d = 0;
        itemAmount = 0;
        disabledText = "";
        id = -1;
        lineHeight = 0;
        itemUsable = false;
        filled = false;
        anInt2738 = -1;
        modelZoom = 100;
        itemDeletesDraged = false;
        anInt2722 = 0;
        yTextAlignment = 0;
        currentX = 0;
        orthogonal = false;
        spriteId = -1;
        aBoolean2730 = false;
        originalHeight = 0;
        opacity = 0;
        originalY = 0;
        rotationY = 0;
        anInt2746 = 0;
        offsetX2d = 0;
        isHidden = false;
        alternateTextColor = 0;
        scrollHeight = 0;
        scrollPosition = 0;
        anInt2736 = 0;
        itemId = -1;
        itemSpritePadsX = 0;
        actionType = 0;
        anInt2751 = 0;
    }

    public static void method639(int arg0) {
        synchronized(Class59.keyFocusListener) {
            Class59.anInt1389 = GenericTile.anInt1214;
            if(GameObjectDefinition.anInt2543 < 0) {
                for(int i = 0; i < 112; i++) {
                    Item.obfuscatedKeyStatus[i] = false;
                }
                GameObjectDefinition.anInt2543 = FramemapDefinition.anInt2183;
            } else {
                while(GameObjectDefinition.anInt2543 != FramemapDefinition.anInt2183) {
                    int i = RSString.keyCodes[FramemapDefinition.anInt2183];
                    FramemapDefinition.anInt2183 = 0x7f & FramemapDefinition.anInt2183 + 1;
                    if(i < 0) {
                        Item.obfuscatedKeyStatus[i ^ 0xffffffff] = false;
                    } else {
                        Item.obfuscatedKeyStatus[i] = true;
                    }
                }
            }
            GenericTile.anInt1214 = IdentityKit.anInt2598;
        }
        if(arg0 <= 121) {
            English.startingGameEngine = null;
        }
    }

    public static void method640() {
        ProducingGraphicsBuffer.aClass9_1615.method235();
    }


    public static void method642(Component arg0, int arg1) {
        if(arg1 != -10) {
            method639(-106);
        }
        Method method = Signlink.aMethod729;
        if(method != null) {
            try {
                method.invoke(arg0, Boolean.FALSE);
            } catch(Throwable throwable) {
                /* empty */
            }
        }
        arg0.addKeyListener(Class59.keyFocusListener);
        arg0.addFocusListener(Class59.keyFocusListener);
    }

    public static void method645() {
        GroundItemTile.aClass9_1364.method235();
        VertexNormal.aClass9_1102.method235();
        InteractiveObject.aClass9_470.method235();
        Class49.aClass9_1145.method235();
    }

    public static String getShortenedAmountText(int coins) {
        if(coins < 100000) {
            return String.valueOf(coins);
        }
        if(coins < 10000000) {
            return coins / 1000 + "K";
        }
        return coins / 0xf4240 + "M";
    }

    public static void runClientScripts(Object[] listeners, int arg1, int arg2, GameInterface gameInterface1, int arg4, boolean arg5) {
        int i = 0;
        ClientScript clientScript = ClientScript.decodeClientScript(((Integer) listeners[0]).intValue(), 76);
        int[] is = clientScript.intOperands;
        int[] is_0_ = clientScript.opcodes;
        int i_1_ = 0;
        int i_2_ = -1;
        int scriptOpcode = -1;

        try {
            anIntArray2086 = new int[clientScript.localIntCount];
            Class51.aClass1Array1204 = new String[clientScript.localStringCount];
            int i_4_ = 0;
            int i_5_ = 0;
            if(arg5) {
                Class43.cameraYawOffset = -119;
            }
            for(int i_6_ = 1; i_6_ < listeners.length; i_6_++) {
                if(listeners[i_6_] instanceof Integer) {
                    int i_7_ = ((Integer) listeners[i_6_]).intValue();
                    if(i_7_ == -2147483647) {
                        i_7_ = arg4;
                    }
                    if(i_7_ == -2147483646) {
                        i_7_ = arg2;
                    }
                    if(i_7_ == -2147483645) {
                        i_7_ = gameInterface1.id;
                    }
                    if(i_7_ == -2147483644) {
                        i_7_ = arg1;
                    }
                    anIntArray2086[i_4_++] = i_7_;
                } else if(listeners[i_6_] instanceof String) {
                    Class51.aClass1Array1204[i_5_++] = (String) listeners[i_6_];
                }
            }

            for(; ; ) {
                scriptOpcode = is_0_[++i_2_];
                if(scriptOpcode < 100) {
                    if(scriptOpcode == 0) {
                        Class67.anIntArray1588[i++] = is[i_2_];
                        continue;
                    }
                    if(scriptOpcode == 1) {
                        int i_8_ = is[i_2_];
                        Class67.anIntArray1588[i++] = GroundItemTile.varbitmasks[i_8_];
                        continue;
                    }
                    if(scriptOpcode == 2) {
                        int i_9_ = is[i_2_];
                        GroundItemTile.varbitmasks[i_9_] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if(scriptOpcode == 3) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = clientScript.stringOperands[i_2_];
                        continue;
                    }
                    if(scriptOpcode == 6) {
                        i_2_ += is[i_2_];
                        continue;
                    }
                    if(scriptOpcode == 7) {
                        i -= 2;
                        if(Class67.anIntArray1588[i] != Class67.anIntArray1588[1 + i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 8) {
                        i -= 2;
                        if(Class67.anIntArray1588[i] == Class67.anIntArray1588[1 + i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 9) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] > Class67.anIntArray1588[i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 10) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] < Class67.anIntArray1588[i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 21) {
                        if(Class29.anInt678 != 0) {
                            Class61 class61 = Class56.aClass61Array1320[--Class29.anInt678];
                            Class51.aClass1Array1204 = class61.aClass1Array1430;
                            anIntArray2086 = class61.anIntArray1420;
                            i_2_ = class61.anInt1433;
                            clientScript = class61.aClientScript_1419;
                            is = clientScript.intOperands;
                            is_0_ = clientScript.opcodes;
                            continue;
                        }
                        break;
                    }
                    if(scriptOpcode == 25) {
                        int i_10_ = is[i_2_];
                        Class67.anIntArray1588[i++] = Class40_Sub5_Sub6.method585(i_10_, 1369);
                        continue;
                    }
                    if(scriptOpcode == 27) {
                        int i_11_ = is[i_2_];
                        Class40_Sub2.method522(Class67.anIntArray1588[--i], i_11_);
                        continue;
                    }
                    if(scriptOpcode == 31) {
                        i -= 2;
                        if(Class67.anIntArray1588[i] <= Class67.anIntArray1588[i + 1]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 32) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] <= Class67.anIntArray1588[i]) {
                            i_2_ += is[i_2_];
                        }
                        continue;
                    }
                    if(scriptOpcode == 33) {
                        Class67.anIntArray1588[i++] = anIntArray2086[is[i_2_]];
                        continue;
                    }
                    if(scriptOpcode == 34) {
                        anIntArray2086[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if(scriptOpcode == 35) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = Class51.aClass1Array1204[is[i_2_]];
                        continue;
                    }
                    if(scriptOpcode == 36) {
                        Class51.aClass1Array1204[is[i_2_]] = Class40_Sub11.aClass1Array2153[--i_1_];
                        continue;
                    }
                    if(scriptOpcode == 37) {
                        int i_12_ = is[i_2_];
                        i_1_ -= i_12_;
                        System.out.println("THIS DOES SOMETHING, GO FIX!");
                        // TODO: Figure out what this actually does
//                        RSString class1 = (RSString.method627(i_12_, i_1_, Class40_Sub11.aClass1Array2153));
//                        Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                        continue;
                    }
                    if(scriptOpcode == 38) {
                        i--;
                        continue;
                    }
                    if(scriptOpcode == 39) {
                        i_1_--;
                        continue;
                    }
                    if(scriptOpcode == 40) {
                        int i_13_ = is[i_2_];
                        ClientScript clientScript_14_ = ClientScript.decodeClientScript(i_13_, 73);
                        int[] is_15_ = new int[clientScript_14_.localIntCount];
                        String[] class1s = new String[clientScript_14_.localStringCount];
                        for(int i_16_ = 0; clientScript_14_.intStackCount > i_16_; i_16_++) {
                            is_15_[i_16_] = Class67.anIntArray1588[i - (clientScript_14_.intStackCount + -i_16_)];
                        }
                        for(int i_17_ = 0; clientScript_14_.stringStackCount > i_17_; i_17_++) {
                            class1s[i_17_] = Class40_Sub11.aClass1Array2153[i_1_ - clientScript_14_.stringStackCount + i_17_];
                        }
                        i_1_ -= clientScript_14_.stringStackCount;
                        i -= clientScript_14_.intStackCount;
                        Class61 class61 = new Class61();
                        class61.aClass1Array1430 = Class51.aClass1Array1204;
                        class61.aClientScript_1419 = clientScript;
                        class61.anIntArray1420 = anIntArray2086;
                        clientScript = clientScript_14_;
                        class61.anInt1433 = i_2_;
                        Class56.aClass61Array1320[Class29.anInt678++] = class61;
                        is = clientScript.intOperands;
                        Class51.aClass1Array1204 = class1s;
                        i_2_ = -1;
                        anIntArray2086 = is_15_;
                        is_0_ = clientScript.opcodes;
                        continue;
                    }
                    if(scriptOpcode == 42) {
                        Class67.anIntArray1588[i++] = Class22_Sub1.anIntArray1847[is[i_2_]];
                        continue;
                    }
                    if(scriptOpcode == 43) {
                        Class22_Sub1.anIntArray1847[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                }
                boolean bool;
                bool = is[i_2_] == 1;
                if(scriptOpcode < 1000) {
                    if(scriptOpcode == 100) {
                        i -= 3;
                        int childInterfaceData = Class67.anIntArray1588[i];
                        int i_19_ = Class67.anIntArray1588[i + 1];
                        int i_20_ = Class67.anIntArray1588[i + 2];
                        GameInterface childInterface = getChildInterface(childInterfaceData);
                        if(childInterface.aGameInterfaceArray2713 == null) {
                            childInterface.aGameInterfaceArray2713 = new GameInterface[1 + i_20_];
                        }
                        if(childInterface.aGameInterfaceArray2713.length <= i_20_) {
                            GameInterface[] childInterfaces = new GameInterface[1 + i_20_];
                            for(int i_21_ = 0; childInterface.aGameInterfaceArray2713.length > i_21_; i_21_++) {
                                childInterfaces[i_21_] = childInterface.aGameInterfaceArray2713[i_21_];
                            }
                            childInterface.aGameInterfaceArray2713 = childInterfaces;
                        }
                        GameInterface gameInterface_22_ = new GameInterface();
                        gameInterface_22_.parentId = childInterface.id;
                        gameInterface_22_.type = GameInterfaceType.get(i_19_);
                        gameInterface_22_.id = ((0xffff & childInterface.id) << 15) + -2147483648 + i_20_;
                        childInterface.aGameInterfaceArray2713[i_20_] = gameInterface_22_;
                        if(bool) {
                            Class40_Sub6.aGameInterface_2116 = gameInterface_22_;
                        } else {
                            Class22_Sub2.aGameInterface_1887 = gameInterface_22_;
                        }
                    } else if(scriptOpcode == 101) {
                        GameInterface gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : Class40_Sub6.aGameInterface_2116;
                        GameInterface gameInterface_23_ = getChildInterface(gameInterface.parentId);
                        gameInterface_23_.aGameInterfaceArray2713[HuffmanEncoding.method1021(gameInterface.id, 32767)] = null;
                    } else {
                        if(scriptOpcode != 102) {
                            break;
                        }
                        GameInterface gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                        gameInterface.aGameInterfaceArray2713 = null;
                    }
                } else if(scriptOpcode >= 1000 && scriptOpcode < 1100 || scriptOpcode >= 2000 && scriptOpcode < 2100) {
                    GameInterface gameInterface;
                    if(scriptOpcode >= 2000) {
                        gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                        scriptOpcode -= 1000;
                    } else {
                        gameInterface = bool ? Class40_Sub6.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                    }
                    if(scriptOpcode == 1000) {
                        i -= 2;
                        gameInterface.currentX = Class67.anIntArray1588[i];
                        gameInterface.currentY = Class67.anIntArray1588[i + 1];
                    } else if(scriptOpcode == 1001) {
                        i -= 2;
                        gameInterface.originalWidth = Class67.anIntArray1588[i];
                        gameInterface.originalHeight = Class67.anIntArray1588[1 + i];
                    } else if(scriptOpcode == 1003) {
                        gameInterface.isHidden = Class67.anIntArray1588[--i] == 1;
                    } else {
                        if(scriptOpcode != 1004) {
                            break;
                        }
                        gameInterface.hasListeners = Class67.anIntArray1588[--i] == 1;
                    }
                } else if(scriptOpcode >= 1100 && scriptOpcode < 1200 || scriptOpcode >= 2100 && scriptOpcode < 2200) {
                    GameInterface gameInterface;
                    if(scriptOpcode < 2000) {
                        gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : Class40_Sub6.aGameInterface_2116;
                    } else {
                        gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                        scriptOpcode -= 1000;
                    }
                    if(scriptOpcode == 1100) {
                        i -= 2;
                        gameInterface.anInt2746 = Class67.anIntArray1588[i];
                        gameInterface.scrollPosition = Class67.anIntArray1588[1 + i];
                    } else if(scriptOpcode == 1101) {
                        int i_24_ = Class67.anIntArray1588[--i];
                        int i_25_ = (0x7e0b & i_24_) >> 10;
                        int i_26_ = i_24_ & 0x1f;
                        int i_27_ = i_24_ >> 5 & 0x1f;
                        gameInterface.textColor = (i_27_ << 11) + (i_25_ << 19) + (i_26_ << 3);
                    } else if(scriptOpcode == 1102) {
                        gameInterface.filled = Class67.anIntArray1588[--i] == 1;
                    } else if(scriptOpcode == 1103) {
                        gameInterface.opacity = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1104) {
                        i--;
                    } else if(scriptOpcode == 1105) {
                        gameInterface.spriteId = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1106) {
                        gameInterface.anInt2751 = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1107) {
                        gameInterface.aBoolean2641 = Class67.anIntArray1588[--i] == 1;
                    } else if(scriptOpcode == 1108) {
                        gameInterface.modelType = InterfaceModelType.MODEL;
                        gameInterface.modelId = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1109) {
                        i -= 6;
                        gameInterface.offsetX2d = Class67.anIntArray1588[i];
                        gameInterface.offsetY2d = Class67.anIntArray1588[1 + i];
                        gameInterface.rotationX = Class67.anIntArray1588[i + 2];
                        gameInterface.rotationZ = Class67.anIntArray1588[3 + i];
                        gameInterface.rotationY = Class67.anIntArray1588[4 + i];
                        gameInterface.modelZoom = Class67.anIntArray1588[5 + i];
                    } else if(scriptOpcode == 1110) {
                        gameInterface.animation = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1111) {
                        gameInterface.orthogonal = Class67.anIntArray1588[--i] == 1;
                    } else if(scriptOpcode == 1112) {
                        gameInterface.disabledText = Class40_Sub11.aClass1Array2153[--i_1_];
                    } else if(scriptOpcode == 1113) {
                        gameInterface.fontId = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1114) {
                        i -= 3;
                        gameInterface.xTextAlignment = Class67.anIntArray1588[i];
                        gameInterface.yTextAlignment = Class67.anIntArray1588[i + 1];
                        gameInterface.lineHeight = Class67.anIntArray1588[i + 2];
                    } else {
                        if(scriptOpcode != 1115) {
                            break;
                        }
                        gameInterface.textShadowed = Class67.anIntArray1588[--i] == 1;
                    }
                } else if((scriptOpcode < 1200 || scriptOpcode >= 1300) && (scriptOpcode < 2200 || scriptOpcode >= 2300)) {
                    if((scriptOpcode < 1300 || scriptOpcode >= 1400) && (scriptOpcode < 2300 || scriptOpcode >= 2400)) {
                        if(scriptOpcode < 1500) {
                            if(scriptOpcode == 1400) {
                                i -= 2;
                                int i_28_ = Class67.anIntArray1588[i + 1];
                                int i_29_ = Class67.anIntArray1588[i];
                                GameInterface gameInterface = getChildInterface(i_29_);
                                if(gameInterface.aGameInterfaceArray2713 == null || gameInterface.aGameInterfaceArray2713.length <= i_28_ || gameInterface.aGameInterfaceArray2713[i_28_] == null) {
                                    Class67.anIntArray1588[i++] = 0;
                                } else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(bool) {
                                        Class40_Sub6.aGameInterface_2116 = gameInterface.aGameInterfaceArray2713[i_28_];
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface.aGameInterfaceArray2713[i_28_];
                                    }
                                }
                            } else if(scriptOpcode == 1401) {
                                i -= 3;
                                int i_30_ = Class67.anIntArray1588[i];
                                int i_31_ = Class67.anIntArray1588[2 + i];
                                int i_32_ = Class67.anIntArray1588[i + 1];
                                GameInterface gameInterface = Class27.method361(cachedInterfaces[i_30_], i_31_, true, 0, -1, 0, i_32_, 398);
                                if(gameInterface == null) {
                                    Class67.anIntArray1588[i++] = 0;
                                } else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(bool) {
                                        Class40_Sub6.aGameInterface_2116 = gameInterface;
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface;
                                    }
                                }
                            } else {
                                if(scriptOpcode != 1402) {
                                    break;
                                }
                                i -= 3;
                                GameInterface gameInterface = getChildInterface(Class67.anIntArray1588[i]);
                                int i_33_ = Class67.anIntArray1588[2 + i];
                                int i_34_ = Class67.anIntArray1588[i + 1];
                                GameInterface gameInterface_35_ = Class27.method361(gameInterface.aGameInterfaceArray2713, i_33_, true, gameInterface.scrollPosition, gameInterface.id, gameInterface.anInt2746, i_34_, 398);
                                if(gameInterface_35_ == null) {
                                    Class67.anIntArray1588[i++] = 0;
                                } else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(bool) {
                                        Class40_Sub6.aGameInterface_2116 = gameInterface_35_;
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface_35_;
                                    }
                                }
                            }
                        } else if(scriptOpcode < 1600) {
                            GameInterface gameInterface = bool ? Class40_Sub6.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                            if(scriptOpcode == 1500) {
                                Class67.anIntArray1588[i++] = gameInterface.currentX;
                            } else if(scriptOpcode == 1501) {
                                Class67.anIntArray1588[i++] = gameInterface.currentY;
                            } else if(scriptOpcode == 1502) {
                                Class67.anIntArray1588[i++] = gameInterface.originalWidth;
                            } else if(scriptOpcode == 1503) {
                                Class67.anIntArray1588[i++] = gameInterface.originalHeight;
                            } else if(scriptOpcode == 1504) {
                                Class67.anIntArray1588[i++] = !gameInterface.isHidden ? 0 : 1;
                            } else {
                                if(scriptOpcode != 1505) {
                                    break;
                                }
                                Class67.anIntArray1588[i++] = gameInterface.parentId;
                            }
                        } else if(scriptOpcode >= 1700) {
                            if(scriptOpcode < 2500) {
                                if(scriptOpcode == 2401) {
                                    i -= 3;
                                    int i_36_ = Class67.anIntArray1588[1 + i];
                                    int i_37_ = Class67.anIntArray1588[i];
                                    int i_38_ = Class67.anIntArray1588[i + 2];
                                    GameInterface gameInterface = Class27.method361(cachedInterfaces[i_37_], i_38_, false, 0, -1, 0, i_36_, 398);
                                    if(gameInterface == null) {
                                        Class67.anIntArray1588[i++] = -1;
                                    } else {
                                        Class67.anIntArray1588[i++] = gameInterface.id;
                                    }
                                } else {
                                    if(scriptOpcode != 2402) {
                                        break;
                                    }
                                    i -= 3;
                                    GameInterface gameInterface = getChildInterface(Class67.anIntArray1588[i]);
                                    int i_39_ = Class67.anIntArray1588[1 + i];
                                    int i_40_ = Class67.anIntArray1588[i + 2];
                                    GameInterface gameInterface_41_ = Class27.method361(cachedInterfaces[gameInterface.id >> 16], i_40_, false, gameInterface.scrollPosition, 0xffff & gameInterface.id, gameInterface.anInt2746, i_39_, 398);
                                    if(gameInterface_41_ == null) {
                                        Class67.anIntArray1588[i++] = -1;
                                    } else {
                                        Class67.anIntArray1588[i++] = gameInterface_41_.id;
                                    }
                                }
                            } else if(scriptOpcode >= 2600) {
                                if(scriptOpcode < 2700) {
                                    GameInterface gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                                    if(scriptOpcode == 2600) {
                                        Class67.anIntArray1588[i++] = gameInterface.anInt2746;
                                    } else {
                                        if(scriptOpcode != 2601) {
                                            break;
                                        }
                                        Class67.anIntArray1588[i++] = gameInterface.scrollPosition;
                                    }
                                } else {
                                    if(scriptOpcode < 2800) {
                                        break;
                                    }
                                    if(scriptOpcode < 3100) {
                                        if(scriptOpcode == 3000) {
                                            int i_42_ = Class67.anIntArray1588[--i];
                                            if(CacheIndex.anInt1819 == -1) {
                                                PacketBuffer.method517(0, i_42_);
                                                CacheIndex.anInt1819 = i_42_;
                                            }
                                        } else if(scriptOpcode == 3001 || scriptOpcode == 3003) {
                                            i -= 2;
                                            int i_43_ = Class67.anIntArray1588[i];
                                            int i_44_ = Class67.anIntArray1588[i + 1];
                                            Class33.method406(0, i_44_, i_43_, -128);
                                        } else if(scriptOpcode == 3002) {
                                            GameInterface gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : Class40_Sub6.aGameInterface_2116;
                                            if(CacheIndex.anInt1819 == -1) {
                                                PacketBuffer.method517(gameInterface.id & 0x7fff, gameInterface.parentId);
                                                CacheIndex.anInt1819 = gameInterface.id;
                                            }
                                        } else {
                                            if(scriptOpcode != 3003) {
                                                break;
                                            }
                                            GameInterface gameInterface = bool ? Class40_Sub6.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                                            int i_45_ = Class67.anIntArray1588[--i];
                                            Class33.method406(0x7fff & gameInterface.id, i_45_, gameInterface.parentId, -121);
                                        }
                                    } else if(scriptOpcode >= 3200) {
                                        if(scriptOpcode < 3300) {
                                            if(scriptOpcode == 3200) {
                                                i -= 3;
                                                WallDecoration.method950(Class67.anIntArray1588[i], Class67.anIntArray1588[i + 1], Class67.anIntArray1588[2 + i]);
                                            } else if(scriptOpcode == 3201) {
                                                Class51.method942(Class67.anIntArray1588[--i]);
                                            } else {
                                                if(scriptOpcode != 3202) {
                                                    break;
                                                }
                                                i -= 2;
                                                Class57.method975(Class67.anIntArray1588[i + 1], Class67.anIntArray1588[i]);
                                            }
                                        } else if(scriptOpcode < 3400) {
                                            if(scriptOpcode != 3300) {
                                                break;
                                            }
                                            Class67.anIntArray1588[i++] = pulseCycle;
                                        } else if(scriptOpcode < 4100) {
                                            if(scriptOpcode == 4000) {
                                                i -= 2;
                                                int i_46_ = Class67.anIntArray1588[i];
                                                int i_47_ = Class67.anIntArray1588[i + 1];
                                                Class67.anIntArray1588[i++] = i_46_ + i_47_;
                                            } else if(scriptOpcode == 4001) {
                                                i -= 2;
                                                int i_48_ = Class67.anIntArray1588[1 + i];
                                                int i_49_ = Class67.anIntArray1588[i];
                                                Class67.anIntArray1588[i++] = i_49_ + -i_48_;
                                            } else if(scriptOpcode == 4002) {
                                                i -= 2;
                                                int i_50_ = Class67.anIntArray1588[i + 1];
                                                int i_51_ = Class67.anIntArray1588[i];
                                                Class67.anIntArray1588[i++] = i_51_ * i_50_;
                                            } else if(scriptOpcode == 4003) {
                                                i -= 2;
                                                int i_52_ = Class67.anIntArray1588[i];
                                                int i_53_ = Class67.anIntArray1588[i + 1];
                                                Class67.anIntArray1588[i++] = i_52_ / i_53_;
                                            } else if(scriptOpcode == 4004) {
                                                int i_54_ = Class67.anIntArray1588[--i];
                                                Class67.anIntArray1588[i++] = (int) (Math.random() * (double) i_54_);
                                            } else if(scriptOpcode == 4005) {
                                                int i_55_ = Class67.anIntArray1588[--i];
                                                Class67.anIntArray1588[i++] = (int) ((double) (1 + i_55_) * Math.random());
                                            } else if(scriptOpcode == 4006) {
                                                i -= 5;
                                                int i_56_ = Class67.anIntArray1588[1 + i];
                                                int i_57_ = Class67.anIntArray1588[i];
                                                int i_58_ = Class67.anIntArray1588[i + 3];
                                                int i_59_ = Class67.anIntArray1588[i + 4];
                                                int i_60_ = Class67.anIntArray1588[2 + i];
                                                Class67.anIntArray1588[i++] = i_57_ + (i_59_ + -i_60_) * (-i_57_ + i_56_) / (i_58_ - i_60_);
                                            } else if(scriptOpcode == 4007) {
                                                i -= 2;
                                                int i_61_ = Class67.anIntArray1588[i];
                                                int i_62_ = Class67.anIntArray1588[i + 1];
                                                Class67.anIntArray1588[i++] = i_61_ + i_62_ * i_61_ / 100;
                                            } else if(scriptOpcode == 4008) {
                                                i -= 2;
                                                int i_63_ = Class67.anIntArray1588[i];
                                                int i_64_ = Class67.anIntArray1588[i + 1];
                                                Class67.anIntArray1588[i++] = UnderlayDefinition.bitWiseOR(1 << i_64_, i_63_);
                                            } else if(scriptOpcode == 4009) {
                                                i -= 2;
                                                int i_65_ = Class67.anIntArray1588[i];
                                                int i_66_ = Class67.anIntArray1588[1 + i];
                                                Class67.anIntArray1588[i++] = HuffmanEncoding.method1021(i_65_, -1 + -(1 << i_66_));
                                            } else if(scriptOpcode == 4010) {
                                                i -= 2;
                                                int i_67_ = Class67.anIntArray1588[i];
                                                int i_68_ = Class67.anIntArray1588[1 + i];
                                                Class67.anIntArray1588[i++] = HuffmanEncoding.method1021(1 << i_68_, i_67_) != 0 ? 1 : 0;
                                            } else if(scriptOpcode == 4011) {
                                                i -= 2;
                                                int i_69_ = Class67.anIntArray1588[i + 1];
                                                int i_70_ = Class67.anIntArray1588[i];
                                                Class67.anIntArray1588[i++] = i_70_ % i_69_;
                                            } else if(scriptOpcode == 4012) {
                                                i -= 2;
                                                int i_71_ = Class67.anIntArray1588[i];
                                                int i_72_ = Class67.anIntArray1588[i + 1];
                                                if(i_71_ == 0) {
                                                    Class67.anIntArray1588[i++] = 0;
                                                } else {
                                                    Class67.anIntArray1588[i++] = (int) Math.pow((double) i_71_, (double) i_72_);
                                                }
                                            } else {
                                                if(scriptOpcode != 4013) {
                                                    break;
                                                }
                                                i -= 2;
                                                int i_73_ = Class67.anIntArray1588[i];
                                                int i_74_ = Class67.anIntArray1588[1 + i];
                                                if(i_73_ == 0) {
                                                    Class67.anIntArray1588[i++] = 0;
                                                } else if(i_74_ == 0) {
                                                    Class67.anIntArray1588[i++] = Integer.MAX_VALUE;
                                                } else {
                                                    Class67.anIntArray1588[i++] = (int) Math.pow((double) i_73_, 1.0 / (double) i_74_);
                                                }
                                            }
                                        } else {
                                            if(scriptOpcode >= 4200) {
                                                break;
                                            }
                                            if(scriptOpcode == 4100) {
                                                String class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                                                int i_75_ = Class67.anIntArray1588[--i];
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1 + i_75_;
                                            } else if(scriptOpcode == 4101) {
                                                i_1_ -= 2;
                                                String class1 = Class40_Sub11.aClass1Array2153[i_1_ + 1];
                                                String class1_76_ = Class40_Sub11.aClass1Array2153[i_1_];
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1_76_ + class1;
                                            } else if(scriptOpcode == 4102) {
                                                String class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                                                int i_77_ = Class67.anIntArray1588[--i];
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1 + HuffmanEncoding.method1024(true, (byte) -85, i_77_);
                                            } else if(scriptOpcode == 4103) {
                                                String class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1.toLowerCase();
                                            } else if(scriptOpcode == 4104) {
                                                int i_78_ = Class67.anIntArray1588[--i];
                                                long l = 86400000L * ((long) i_78_ + 11745L);
                                                Class8.aCalendar279.setTime(new Date(l));
                                                int i_79_ = Class8.aCalendar279.get(Calendar.DATE);
                                                int i_80_ = Class8.aCalendar279.get(Calendar.MONTH);
                                                int i_81_ = Class8.aCalendar279.get(Calendar.YEAR);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = i_79_ + "-" + Class40_Sub5_Sub17_Sub1.aClass1Array2964[i_80_] + "-" + i_81_;
                                            } else if(scriptOpcode == 4105) {
                                                i_1_ -= 2;
                                                String class1 = Class40_Sub11.aClass1Array2153[i_1_];
                                                String class1_82_ = Class40_Sub11.aClass1Array2153[i_1_ + 1];
                                                if(Player.localPlayer.playerAppearance == null || !Player.localPlayer.playerAppearance.gender) {
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                                                } else {
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1_82_;
                                                }
                                            } else if(scriptOpcode == 4106) {
                                                int i_83_ = Class67.anIntArray1588[--i];
                                                Class40_Sub11.aClass1Array2153[i_1_++] = Integer.toString(i_83_).toString();
                                            } else {
                                                if(scriptOpcode != 4107) {
                                                    break;
                                                }
                                                i_1_ -= 2;
                                                Class67.anIntArray1588[i++] = Class40_Sub11.aClass1Array2153[i_1_].compareTo(Class40_Sub11.aClass1Array2153[i_1_ + 1]);
                                            }
                                        }
                                    } else if(scriptOpcode == 3100) {
                                        String str = Class40_Sub11.aClass1Array2153[--i_1_];
                                        Class44.addChatMessage("", str, 0);
                                    } else {
                                        if(scriptOpcode != 3101) {
                                            break;
                                        }
                                        i -= 2;
                                        ActorDefinition.playAnimation(Class67.anIntArray1588[i], Class67.anIntArray1588[i + 1], Player.localPlayer);
                                    }
                                }
                            } else {
                                GameInterface gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                                if(scriptOpcode == 2500) {
                                    Class67.anIntArray1588[i++] = gameInterface.currentX;
                                } else if(scriptOpcode == 2501) {
                                    Class67.anIntArray1588[i++] = gameInterface.currentY;
                                } else if(scriptOpcode == 2502) {
                                    Class67.anIntArray1588[i++] = gameInterface.originalWidth;
                                } else if(scriptOpcode == 2503) {
                                    Class67.anIntArray1588[i++] = gameInterface.originalHeight;
                                } else if(scriptOpcode == 2504) {
                                    Class67.anIntArray1588[i++] = gameInterface.isHidden ? 1 : 0;
                                } else {
                                    if(scriptOpcode != 2505) {
                                        break;
                                    }
                                    Class67.anIntArray1588[i++] = gameInterface.parentId;
                                }
                            }
                        } else {
                            GameInterface gameInterface = bool ? Class40_Sub6.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                            if(scriptOpcode == 1600) {
                                Class67.anIntArray1588[i++] = gameInterface.anInt2746;
                            } else {
                                if(scriptOpcode != 1601) {
                                    break;
                                }
                                Class67.anIntArray1588[i++] = gameInterface.scrollPosition;
                            }
                        }
                    } else {
                        GameInterface gameInterface;
                        if(scriptOpcode >= 2000) {
                            gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                            scriptOpcode -= 1000;
                        } else {
                            gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : Class40_Sub6.aGameInterface_2116;
                        }
                        if(scriptOpcode >= 1300 && scriptOpcode <= 1309 || scriptOpcode >= 1314 && scriptOpcode <= 1317) {
                            String class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                            Object[] objects = new Object[class1.length() + 1];
                            for(int i_84_ = objects.length - 1; i_84_ >= 1; i_84_--) {
                                if(class1.charAt(-1 + i_84_) == 115) {
                                    objects[i_84_] = Class40_Sub11.aClass1Array2153[--i_1_];
                                } else {
                                    objects[i_84_] = new Integer(Class67.anIntArray1588[--i]);
                                }
                            }
                            objects[0] = new Integer(Class67.anIntArray1588[--i]);
                            if(scriptOpcode == 1303) {
                                gameInterface.anObjectArray2707 = objects;
                            }
                            if(scriptOpcode == 1317) {
                                gameInterface.anObjectArray2680 = objects;
                            }
                            if(scriptOpcode == 1304) {
                                gameInterface.anObjectArray2658 = objects;
                            }
                            if(scriptOpcode == 1302) {
                                gameInterface.anObjectArray2644 = objects;
                            }
                            if(scriptOpcode == 1316) {
                                gameInterface.anObjectArray2747 = objects;
                            }
                            if(scriptOpcode == 1301) {
                                gameInterface.anObjectArray2681 = objects;
                            }
                            if(scriptOpcode == 1300) {
                                gameInterface.onLoadListeners = objects;
                            }
                            if(scriptOpcode == 1315) {
                                gameInterface.anObjectArray2695 = objects;
                            }
                            if(scriptOpcode == 1306) {
                                gameInterface.anObjectArray2669 = objects;
                            }
                            if(scriptOpcode == 1305) {
                                gameInterface.anObjectArray2672 = objects;
                            }
                            if(scriptOpcode == 1309) {
                                gameInterface.anObjectArray2712 = objects;
                            }
                            if(scriptOpcode == 1308) {
                                gameInterface.anObjectArray2650 = objects;
                            }
                        } else if(scriptOpcode == 1310) {
                            int i_85_ = -1 + Class67.anIntArray1588[--i];
                            if(i_85_ >= 0 && i_85_ <= 9) {
                                if(gameInterface.aClass1Array2661 == null || gameInterface.aClass1Array2661.length <= i_85_) {
                                    String[] class1s = new String[1 + i_85_];
                                    if(gameInterface.aClass1Array2661 != null) {
                                        for(int i_86_ = 0; gameInterface.aClass1Array2661.length > i_86_; i_86_++) {
                                            class1s[i_86_] = gameInterface.aClass1Array2661[i_86_];
                                        }
                                    }
                                    gameInterface.aClass1Array2661 = class1s;
                                }
                                gameInterface.aClass1Array2661[i_85_] = Class40_Sub11.aClass1Array2153[--i_1_];
                            } else {
                                i_1_--;
                            }
                        } else if(scriptOpcode == 1311) {
                            gameInterface.anInt2738 = Class67.anIntArray1588[--i];
                        } else if(scriptOpcode == 1312) {
                            gameInterface.aBoolean2694 = Class67.anIntArray1588[--i] == 1;
                        } else {
                            if(scriptOpcode != 1313) {
                                break;
                            }
                            i--;
                        }
                    }
                } else {
                    GameInterface gameInterface;
                    if(scriptOpcode < 2000) {
                        gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : Class40_Sub6.aGameInterface_2116;
                    } else {
                        gameInterface = getChildInterface(Class67.anIntArray1588[--i]);
                        scriptOpcode -= 1000;
                    }
                    if(scriptOpcode == 1200) {
                        i -= 3;
                        int i_87_ = Class67.anIntArray1588[i];
                        int i_88_ = Class67.anIntArray1588[i + 2];
                        if(i_87_ == -1) {
                            gameInterface.modelType = InterfaceModelType.NULL;
                        } else {
                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_87_, 10);
                            gameInterface.modelType = InterfaceModelType.ITEM;
                            gameInterface.rotationX = class40_sub5_sub16.xan2d;
                            gameInterface.rotationY = class40_sub5_sub16.zan2d;
                            gameInterface.modelZoom = 100 * class40_sub5_sub16.zoom2d / i_88_;
                            gameInterface.rotationZ = class40_sub5_sub16.yan2d;
                            gameInterface.offsetY2d = class40_sub5_sub16.yOffset2d;
                            gameInterface.offsetX2d = class40_sub5_sub16.xOffset2d;
                            gameInterface.modelId = i_87_;
                        }
                    } else if(scriptOpcode == 1201) {
                        gameInterface.modelType = InterfaceModelType.NPC_CHATHEAD;
                        gameInterface.modelId = Class67.anIntArray1588[--i];
                    } else if(scriptOpcode == 1202) {
                        gameInterface.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
                        gameInterface.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
                    } else {
                        if(scriptOpcode != 1203) {
                            break;
                        }
                        GameInterface desiredInterface = !bool ? Class40_Sub6.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                        gameInterface.anInt2738 = desiredInterface.id;
                    }
                }
            }
        } catch(Exception exception) {
            /* empty */
        }

    }

    public static GameInterface getChildInterface(int childInterfaceData) {
        int parentInterfaceId = childInterfaceData >> 16;
        int childInterfaceId = 0xffff & childInterfaceData;
        if(cachedInterfaces[parentInterfaceId] == null || cachedInterfaces[parentInterfaceId][childInterfaceId] == null) {
            if(!decodeGameInterface(parentInterfaceId)) {
                return null;
            }
        }

        return cachedInterfaces[parentInterfaceId][childInterfaceId];
    }

    public static void updateGameInterface(GameInterface gameInterface) {
        int type = gameInterface.contentType;
        if(type >= 1 && type <= 100 || type >= 701 && type <= 800) {
            if(type == 1 && Class12.friendListStatus == 0) {
                gameInterface.disabledText = English.loadingFriendList;
                gameInterface.actionType = 0;
            } else if(type == 1 && Class12.friendListStatus == 1) {
                gameInterface.disabledText = English.connectingToFriendserver;
                gameInterface.actionType = 0;
            } else if(type == 2 && Class12.friendListStatus != 2) {
                gameInterface.actionType = 0;
                gameInterface.disabledText = PacketBuffer.str_Please_Wait;
            } else {
                int fCount = Item.friendsCount;
                if(type > 700)
                    type -= 601;
                else
                    type--;
                if(Class12.friendListStatus != 2)
                    fCount = 0;
                if(fCount <= type) {
                    gameInterface.disabledText = "";
                    gameInterface.actionType = 0;
                } else {
                    gameInterface.disabledText = Class40_Sub11.friendUsernames[type];
                    gameInterface.actionType = 1;
                }
            }
        } else if(type >= 101 && type <= 200 || type >= 801 && type <= 900) {
            if(type <= 800)
                type -= 101;
            else
                type -= 701;
            int count = Item.friendsCount;
            if(Class12.friendListStatus != 2)
                count = 0;
            if(type >= count) {
                gameInterface.disabledText = "";
                gameInterface.actionType = 0;
            } else {
                if(Class40_Sub7.friendWorlds[type] == 0) {
                    gameInterface.disabledText = Native.aClass1_610 + English.offline;
                } else if(Class40_Sub7.friendWorlds[type] < 5000) {
                    if(Class40_Sub7.friendWorlds[type] == Class13.worldid) {
                        gameInterface.disabledText = Native.aClass1_1162 + English.world + Class40_Sub7.friendWorlds[type];
                    } else {
                        gameInterface.disabledText = Native.aClass1_1283 + English.world + Class40_Sub7.friendWorlds[type];
                    }
                } else if(Class13.worldid == Class40_Sub7.friendWorlds[type]) {
                    gameInterface.disabledText = Native.aClass1_1162 + English.classic + (-5000 + Class40_Sub7.friendWorlds[type]);
                } else {
                    gameInterface.disabledText = Native.aClass1_1283 + English.classic + (Class40_Sub7.friendWorlds[type] + -5000);
                }
                gameInterface.actionType = 1;
            }
        } else if(type == 203) {
            int count = Item.friendsCount;
            if(Class12.friendListStatus != 2)
                count = 0;
            gameInterface.scrollHeight = 20 + 15 * count;
            if(gameInterface.originalHeight >= gameInterface.scrollHeight)
                gameInterface.scrollHeight = 1 + gameInterface.originalHeight;
        } else if(type >= 401 && type <= 500) {
            type -= 401;
            if(type == 0 && Class12.friendListStatus == 0) {
                gameInterface.disabledText = English.loadingIgnoreList;
                gameInterface.actionType = 0;
            } else if(type == 1 && Class12.friendListStatus == 0) {
                gameInterface.disabledText = PacketBuffer.str_Please_Wait;
                gameInterface.actionType = 0;
            } else {
                int i_4_ = Class42.anInt1008;
                if(Class12.friendListStatus == 0)
                    i_4_ = 0;
                if(i_4_ <= type) {
                    gameInterface.actionType = 0;
                    gameInterface.disabledText = "";
                } else {
                    gameInterface.disabledText = TextUtils.formatName(TextUtils.longToName(WallDecoration.ignores[type]));
                    gameInterface.actionType = 1;
                }
            }
        } else if(type == 503) {
            gameInterface.scrollHeight = 15 * Class42.anInt1008 + 20;
            if(gameInterface.scrollHeight <= gameInterface.originalHeight)
                gameInterface.scrollHeight = gameInterface.originalHeight + 1;
        } else if(type == 324) {
            if(Class64.anInt1511 == -1) {
                Class64.anInt1511 = gameInterface.spriteId;
                Main.anInt1769 = gameInterface.alternateSpriteId;
            }
            if(!LinkedList.aClass30_1082.gender)
                gameInterface.spriteId = Main.anInt1769;
            else
                gameInterface.spriteId = Class64.anInt1511;
        } else if(type == 325) {
            if(Class64.anInt1511 == -1) {
                Main.anInt1769 = gameInterface.alternateSpriteId;
                Class64.anInt1511 = gameInterface.spriteId;
            }
            if(LinkedList.aClass30_1082.gender)
                gameInterface.spriteId = Main.anInt1769;
            else
                gameInterface.spriteId = Class64.anInt1511;
        } else if(type == 327) {
            gameInterface.rotationX = 150;
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) pulseCycle / 40.0));
            gameInterface.modelId = 0;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 328) {
            gameInterface.rotationX = 150;
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) pulseCycle / 40.0));
            gameInterface.modelId = 1;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 600)
            gameInterface.disabledText = Native.reportedName + Native.prefixYellowBar;
        else if(type == 620) {
            if(InteractiveObject.playerRights >= 1) {
                if(Class67.reportMutePlayer) {
                    gameInterface.textColor = 0xff0000;
                    gameInterface.disabledText = English.moderatorOptionMutePlayerFor48HoursON;
                } else {
                    gameInterface.textColor = 0xffffff;
                    gameInterface.disabledText = English.moderatorOptionMutePlayerFor48HoursOFF;
                }
            } else
                gameInterface.disabledText = "";
        }
    }

    public static void drawScrollBar(int x, int y, int height, int scrollPosition, int scrollMaximum, int unknownArrayIndex) {
        int length = (-32 + height) * height / scrollMaximum;
        CacheIndex.aClass40_Sub5_Sub14_Sub2Array215[unknownArrayIndex].drawImage(x, y);
        CacheIndex.aClass40_Sub5_Sub14_Sub2Array215[1].drawImage(x, y - (-height + 16));
        Rasterizer.drawFilledRectangle(x, y + 16, 16, height + -32, Class55.anInt1299);
        if(length < 8)
            length = 8;
        int scrollCurrent = (-32 + height - length) * scrollPosition / (-height + scrollMaximum);
        Rasterizer.drawFilledRectangle(x, 16 + y + scrollCurrent, 16, length, MemoryCache.anInt321);
        Rasterizer.drawVerticalLine(x, 16 + y + scrollCurrent, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(1 + x, scrollCurrent + y + 16, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, scrollCurrent + y + 16, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, 17 + y + scrollCurrent, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(x + 15, y + 16 + scrollCurrent, length, Class56.anInt1318);
        Rasterizer.drawVerticalLine(x + 14, scrollCurrent + 17 + y, length - 1, Class56.anInt1318);
        Rasterizer.drawHorizontalLine(x, length + scrollCurrent + 15 + y, 16, Class56.anInt1318);
        Rasterizer.drawHorizontalLine(x + 1, 14 + y + scrollCurrent + length, 15, Class56.anInt1318);
    }

    public static boolean decodeGameInterface(int interfaceId) {
        if(loadedInterfaces[interfaceId]) {
            return true;
        }

        if(!MemoryCache.gameInterfaceCacheIndex.fileExists(interfaceId)) {
            return false;
        }

        int gameInterfaceCount = MemoryCache.gameInterfaceCacheIndex.fileLength(interfaceId);
        if(gameInterfaceCount == 0) {
            loadedInterfaces[interfaceId] = true;
            return true;
        }

        if(cachedInterfaces[interfaceId] == null) {
            cachedInterfaces[interfaceId] = new GameInterface[gameInterfaceCount];
        }

        for(int i = 0; i < gameInterfaceCount; i++) {
            if(cachedInterfaces[interfaceId][i] == null) {
                byte[] interfaceFileData = MemoryCache.gameInterfaceCacheIndex.getFile(i, interfaceId);

                if(interfaceFileData != null) {
                    cachedInterfaces[interfaceId][i] = new GameInterface();
                    cachedInterfaces[interfaceId][i].id = (interfaceId << 16) + i;
                    if(interfaceFileData[0] == -1) {
                        cachedInterfaces[interfaceId][i].decodeIf3(new Buffer(interfaceFileData));
                    } else {
                        cachedInterfaces[interfaceId][i].decodeIf1(new Buffer(interfaceFileData));
                    }
                }
            }
        }

        loadedInterfaces[interfaceId] = true;
        return true;
    }

    public static void resetInterfaceAnimations(int interfaceId) {
        if(decodeGameInterface(interfaceId)) {
            GameInterface[] interfaceChildren = cachedInterfaces[interfaceId];
            for(GameInterface interfaceChild : interfaceChildren) {
                if(interfaceChild != null) {
                    interfaceChild.remainingAnimationTime = 0;
                    interfaceChild.animationFrame = 0;
                }
            }
        }
    }

    public static void resetInterface(int interfaceId) {
        if(interfaceId == -1 || !loadedInterfaces[interfaceId]) {
            return;
        }

        MemoryCache.gameInterfaceCacheIndex.unloadFile(1, interfaceId);

        if(cachedInterfaces[interfaceId] != null) {
            boolean deleteFromCache = true;

            for(int i = 0; cachedInterfaces[interfaceId].length > i; i++) {
                if(cachedInterfaces[interfaceId][i] != null) {
                    if(cachedInterfaces[interfaceId][i].type != GameInterfaceType.INVENTORY)
                        cachedInterfaces[interfaceId][i] = null;
                    else
                        deleteFromCache = false;
                }
            }

            if(deleteFromCache) {
                cachedInterfaces[interfaceId] = null;
            }

            loadedInterfaces[interfaceId] = false;
        }
    }

    public static void createInterfaceMemoryBuffers() {
        cachedInterfaces = new GameInterface
                [MemoryCache.gameInterfaceCacheIndex.getLength()][];
        loadedInterfaces = new boolean
                [MemoryCache.gameInterfaceCacheIndex.getLength()];
    }

    public static void callOnLoadListeners(int interfaceId) {
        if(decodeGameInterface(interfaceId)) {
            GameInterface[] gameInterfaces = cachedInterfaces[interfaceId];
            for(GameInterface gameInterface : gameInterfaces) {
                if(gameInterface.onLoadListeners != null) {
                    runClientScripts(gameInterface.onLoadListeners, 0, 0, gameInterface, 0, false);
                }
            }
        }
    }

    public static Object[] decodeListener(Buffer buffer) {
        int length = buffer.getUnsignedByte();
        if(length == 0) {
            return null;
        }
        Object[] objects = new Object[length];
        for(int i = 0; i < length; i++) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0)
                objects[i] = new Integer(buffer.getIntBE());
            else if(opcode == 1)
                objects[i] = buffer.getRSString();
        }
        return objects;
    }

    public void swapItems(int arg0, boolean arg1, int arg2) {
        int i = items[arg2];
        items[arg2] = items[arg0];
        items[arg0] = i;
        i = itemAmounts[arg2];
        itemAmounts[arg2] = itemAmounts[arg0];
        if(arg1) {
            clientScripts = null;
        }
        itemAmounts[arg0] = i;
    }

    public void decodeIf1(Buffer buffer) {
        isIf3 = false;
        type = GameInterfaceType.get(buffer.getUnsignedByte());
        actionType = buffer.getUnsignedByte();
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE(); // originalX
        originalY = currentY = buffer.getShortBE(); // originalY
        originalWidth = buffer.getUnsignedShortBE();
        originalHeight = buffer.getUnsignedShortBE();
        opacity = buffer.getUnsignedByte();
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        hoveredSiblingId = buffer.getUnsignedShortBE();
        if(hoveredSiblingId == 0xFFFF) {
            hoveredSiblingId = -1;
        }
        int var2 = buffer.getUnsignedByte();
        int var3;
        if(var2 > 0) {
            alternateOperators = new int[var2];
            alternateRhs = new int[var2];
            for(var3 = 0; var2 > var3; var3++) {
                alternateOperators[var3] = buffer.getUnsignedByte();
                alternateRhs[var3] = buffer.getUnsignedShortBE();
            }
        }
        var3 = buffer.getUnsignedByte();
        if(var3 > 0) {
            clientScripts = new int[var3][];
            for(int i_2_ = 0; i_2_ < var3; i_2_++) {
                int i_3_ = buffer.getUnsignedShortBE();
                clientScripts[i_2_] = new int[i_3_];
                for(int i_4_ = 0; i_3_ > i_4_; i_4_++) {
                    clientScripts[i_2_][i_4_] = buffer.getUnsignedShortBE();
                    if(clientScripts[i_2_][i_4_] == 65535) {
                        clientScripts[i_2_][i_4_] = -1;
                    }
                }
            }
        }
        if(type == GameInterfaceType.LAYER) {
            scrollHeight = buffer.getUnsignedShortBE();
            isHidden = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.UNKNOWN) {
            buffer.getUnsignedShortBE();
            buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.INVENTORY) {
            items = new int[originalHeight * originalWidth];
            itemAmounts = new int[originalHeight * originalWidth];
            itemSwapable = buffer.getUnsignedByte() == 1;
            isInventory = buffer.getUnsignedByte() == 1;
            itemUsable = buffer.getUnsignedByte() == 1;
            itemDeletesDraged = buffer.getUnsignedByte() == 1;
            itemSpritePadsX = buffer.getUnsignedByte();
            itemSpritePadsY = buffer.getUnsignedByte();
            imageX = new int[20];
            imageY = new int[20];
            images = new int[20];
            for(int sprite = 0; sprite < 20; sprite++) {
                int hasSprite = buffer.getUnsignedByte();
                if(hasSprite == 1) {
                    images[sprite] = buffer.getShortBE();
                    imageX[sprite] = buffer.getShortBE();
                    imageY[sprite] = buffer.getIntBE();
                } else {
                    imageY[sprite] = -1;
                }
            }
            configActions = new String[5];
            for(int i_7_ = 0; i_7_ < 5; i_7_++) {
                configActions[i_7_] = buffer.getString();
                if(configActions[i_7_].length() == 0) {
                    configActions[i_7_] = null;
                }
            }
        }
        if(type == GameInterfaceType.RECTANGLE) {
            filled = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT || type == GameInterfaceType.UNKNOWN) {
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            lineHeight = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT) {
            disabledText = buffer.getString();
            alternateText = buffer.getString();
        }
        if(type == GameInterfaceType.UNKNOWN || type == GameInterfaceType.RECTANGLE || type == GameInterfaceType.TEXT) {
            textColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.RECTANGLE || type == GameInterfaceType.TEXT) {
            alternateTextColor = buffer.getIntBE();
            hoveredTextColor = buffer.getIntBE();
            alternateHoveredTextColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.GRAPHIC) {
            spriteId = buffer.getIntBE();
            alternateSpriteId = buffer.getIntBE();
        }
        if(type == GameInterfaceType.MODEL) {
            modelType = InterfaceModelType.MODEL;
            modelId = buffer.getUnsignedShortBE();
            if(modelId == 0xFFFF) {
                modelId = -1;
            }
            alternateModelType = InterfaceModelType.MODEL;
            alternateModelId = buffer.getUnsignedShortBE();
            if(alternateModelId == 0xFFFF) {
                alternateModelId = -1;
            }
            animation = buffer.getUnsignedShortBE();
            if(animation == 0xFFFF) {
                animation = -1;
            }
            alternateAnimation = buffer.getUnsignedShortBE();
            if(alternateAnimation == 0xFFFF) {
                alternateAnimation = -1;
            }
            modelZoom = buffer.getUnsignedShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
        }
        if(type == GameInterfaceType.TEXT_INVENTORY) {
            items = new int[originalWidth * originalHeight];
            itemAmounts = new int[originalWidth * originalHeight];
            xTextAlignment = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
            itemSpritePadsX = buffer.getShortBE();
            itemSpritePadsY = buffer.getShortBE();
            isInventory = buffer.getUnsignedByte() == 1;
            configActions = new String[5];
            for(int i_8_ = 0; i_8_ < 5; i_8_++) {
                configActions[i_8_] = buffer.getString();
                if(configActions[i_8_].length() == 0) {
                    configActions[i_8_] = null;
                }
            }
        }
        if(type == GameInterfaceType.IF1_TOOLTIP) {
            disabledText = buffer.getString();
        }
        if(actionType == 2 || type == GameInterfaceType.INVENTORY) {
            targetVerb = buffer.getString();
            spellName = buffer.getString();
            clickMask = buffer.getUnsignedShortBE();
        }
        if(actionType == 1 || actionType == 4 || actionType == 5 || actionType == 6) {
            tooltip = buffer.getString();
            if(tooltip.length() == 0) {
                if(actionType == 1) {
                    tooltip = English.ok;
                }
                if(actionType == 4) {
                    tooltip = English.select;
                }
                if(actionType == 5) {
                    tooltip = English.select;
                }
                if(actionType == 6) {
                    tooltip = English.sContinue;
                }
            }
        }
    }

    public ImageRGB method638(byte arg0, int arg1) {
        FramemapDefinition.aBoolean2177 = false;
        if(arg1 < 0 || imageY.length <= arg1) {
            return null;
        }
        int i = imageY[arg1];
        if(i == -1) {
            return null;
        }
        int i_9_ = 124 % ((-15 - arg0) / 34);
        ImageRGB class40_sub5_sub14_sub4 = (ImageRGB) ImageRGB.imageRgbCache.get((long) i);
        if(class40_sub5_sub14_sub4 != null) {
            return class40_sub5_sub14_sub4;
        }
        class40_sub5_sub14_sub4 = Class48.method927(0, MemoryCache.gameImageCacheIndex, true, i);
        if(class40_sub5_sub14_sub4 == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            ImageRGB.imageRgbCache.put((long) i, class40_sub5_sub14_sub4);
        }
        return class40_sub5_sub14_sub4;
    }

    public ImageRGB getImageRgb(boolean useAlternateImage) {
        FramemapDefinition.aBoolean2177 = false;

        int i;
        if(useAlternateImage) {
            i = alternateSpriteId;
        } else {
            i = spriteId;
        }
        if(Configuration.FREE_TELEPORTS) {
            switch(id) {
                case 12582924:
                case 12582927:
                case 12582930:
                case 12583493:
                case 12582934:
                case 12583300:
                case 12583301:
                case 12583404:
                case 12583481:
                    i = alternateSpriteId;
                    break;
                default:
                    break;
            }
        }
        if(i == -1) {
            return null;
        }
        ImageRGB imageRGB = (ImageRGB) ImageRGB.imageRgbCache.get((long) i);

        if(imageRGB != null) {
            return imageRGB;
        }
        imageRGB = Class48.method927(0, MemoryCache.gameImageCacheIndex, true, i);
        if(imageRGB == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            ImageRGB.imageRgbCache.put((long) i, imageRGB);
        }
        return imageRGB;
    }

    public void decodeIf3(Buffer buffer) {
        buffer.getUnsignedByte();
        isIf3 = true;
        type = GameInterfaceType.get(buffer.getUnsignedByte());
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE();
        originalY = currentY = buffer.getShortBE();
        originalWidth = buffer.getUnsignedShortBE();
        if(type == GameInterfaceType.LINE) {
            originalHeight = buffer.getShortBE();
        } else {
            originalHeight = buffer.getUnsignedShortBE();
        }
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        isHidden = buffer.getUnsignedByte() == 1;
        hasListeners = buffer.getUnsignedByte() == 1;
        if(type == GameInterfaceType.LAYER) {
            anInt2746 = buffer.getUnsignedShortBE();
            scrollPosition = buffer.getUnsignedShortBE();
        }
        if(type == GameInterfaceType.GRAPHIC) {
            spriteId = buffer.getIntBE();
            anInt2751 = buffer.getUnsignedShortBE();
            aBoolean2641 = buffer.getUnsignedByte() == 1;
            opacity = buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.MODEL) {
            modelType = InterfaceModelType.MODEL;
            modelId = buffer.getUnsignedShortBE();
            if(modelId == 65535) {
                modelId = -1;
            }
            offsetX2d = buffer.getShortBE();
            offsetY2d = buffer.getShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
            rotationY = buffer.getUnsignedShortBE();
            modelZoom = buffer.getUnsignedShortBE();
            animation = buffer.getUnsignedShortBE();
            if(animation == 65535) {
                animation = -1;
            }
            orthogonal = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT) {
            fontId = buffer.getUnsignedShortBE();
            disabledText = buffer.getString();
            lineHeight = buffer.getUnsignedByte();
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.RECTANGLE) {
            textColor = buffer.getIntBE();
            filled = buffer.getUnsignedByte() == 1;
            opacity = buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.LINE) {
            buffer.getUnsignedByte();
            textColor = buffer.getIntBE();
        }
        if(hasListeners) {
            // various interface action listeners (click, mouse move, onload, etc)
            onLoadListeners = decodeListener(buffer);
            anObjectArray2681 = decodeListener(buffer);
            anObjectArray2644 = decodeListener(buffer);
            anObjectArray2707 = decodeListener(buffer);
            anObjectArray2658 = decodeListener(buffer);
            anObjectArray2672 = decodeListener(buffer);
            anObjectArray2669 = decodeListener(buffer);
            decodeListener(buffer);
            anObjectArray2650 = decodeListener(buffer);
            anObjectArray2712 = decodeListener(buffer);
            decodeListener(buffer);
            anObjectArray2695 = decodeListener(buffer);
            anObjectArray2747 = decodeListener(buffer);
            anObjectArray2680 = decodeListener(buffer);
            isInventory = buffer.getUnsignedByte() == 1;
            anInt2736 = buffer.getUnsignedShortBE();
            aBoolean2694 = buffer.getUnsignedByte() == 1;
            buffer.getUnsignedByte();
            int i = buffer.getUnsignedByte();
            if(i > 0) {
                aClass1Array2661 = new String[i];
                for(int i_10_ = 0; i_10_ < i; i_10_++) {
                    aClass1Array2661[i_10_] = buffer.getString();
                }
            }
            anInt2738 = buffer.getUnsignedShortBE();
            if(anInt2738 == 65535) {
                anInt2738 = -1;
            }
        }
    }

    public Model method646(byte arg0, AnimationSequence arg1, int arg2, boolean arg3, PlayerAppearance arg4) {
        FramemapDefinition.aBoolean2177 = false;
        InterfaceModelType modelType;
        int i_11_;
        if(arg3) {
            i_11_ = alternateModelId;
            modelType = alternateModelType;
        } else {
            modelType = this.modelType;
            i_11_ = modelId;
        }
        if(modelType == InterfaceModelType.NULL) {
            return null;
        }
        if(modelType == InterfaceModelType.MODEL && i_11_ == -1) {
            return null;
        }
        if(arg0 <= 25) {
            hasListeners = true;
        }
        Model model = (Model) WallDecoration.aClass9_1264.get((long) ((modelType.ordinal() << 16) + i_11_));
        if(model == null) {
            if(modelType == InterfaceModelType.MODEL) {
                model = Model.getModel(MemoryCache.modelCacheIndex, i_11_, 0);
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.NPC_CHATHEAD) {
                model = ActorDefinition.getDefinition(i_11_).getHeadModel();
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.LOCAL_PLAYER_CHATHEAD) {
                if(arg4 == null) {
                    return null;
                }
                model = arg4.getStaticModel();
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.ITEM) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_11_, 10);
                model = class40_sub5_sub16.asGroundStack(false, 10);
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                // TODO: Theres a bug with smelting bars and stacked items in inventory, please figure this out
                try {
                    model.applyLighting(64 + class40_sub5_sub16.ambient, 768 + class40_sub5_sub16.contrast, -50, -10, -50, true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            WallDecoration.aClass9_1264.put((long) ((modelType.ordinal() << 16) + i_11_), model);
        }
        if(arg1 != null) {
            model = arg1.method598(arg2, model, true);
        }
        return model;
    }

    public TypeFace getTypeFace() {
        FramemapDefinition.aBoolean2177 = false;
        if(fontId == 65535) {
            return null;
        }
        TypeFace typeFace = (TypeFace) TypeFace.typeFaceCache.get(fontId);

        if(typeFace != null) {
            return typeFace;
        }

        typeFace = TypeFace.getFont(MemoryCache.gameImageCacheIndex, 0, fontId);

        if(typeFace == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            TypeFace.typeFaceCache.put(fontId, typeFace);
        }

        return typeFace;
    }
}