package com.w0lfb0mb.notenoughfoxes.init;

import com.w0lfb0mb.notenoughfoxes.common.FoxCollarItem;
import com.w0lfb0mb.notenoughfoxes.common.FoxSocksItem;
import com.w0lfb0mb.notenoughfoxes.common.FoxSpawnEggItem;
import com.w0lfb0mb.notenoughfoxes.common.ModCreativeModeTab;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    private ItemInit() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, notenoughfoxes.MODID);

    public static final RegistryObject<Item> RED_FOX_EGG = ITEMS.register("red_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.RED,
            14842913,
            14005919,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> SNOW_FOX_EGG = ITEMS.register("snow_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.SNOW,
            16316651,
            12045757,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> BLACK_FOX_EGG = ITEMS.register("black_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.BLACK,
            921104,
            16381172,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> SILVER_FOX_EGG = ITEMS.register("silver_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.SILVER,
            2302759,
            723725,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> PLUM_FOX_EGG = ITEMS.register("plum_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.PLUM,
            6112875,
            14668774,
            new Item.Properties()
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> TREED0M_FOX_EGG = ITEMS.register("treed0m_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.TREED0M,
            349455,
            6898708,
            new Item.Properties()
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> JUICE_FOX_EGG = ITEMS.register("juice_fox_spawn_egg", () -> new FoxSpawnEggItem(
            Fox.Type.JUICE,
            16748069,
            27551,
            new Item.Properties()
                    .stacksTo(64)
    ));

    public static final RegistryObject<Item> COLLAR_REMOVER = ITEMS.register("collar_remover", () -> new Item(
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));
    public static final RegistryObject<Item> COLLAR_PURPLE = ITEMS.register("purple_collar", () -> new FoxCollarItem(
            Fox.CC.PURPLE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_WHITE = ITEMS.register("white_collar", () -> new FoxCollarItem(
            Fox.CC.WHITE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_ORANGE = ITEMS.register("orange_collar", () -> new FoxCollarItem(
            Fox.CC.ORANGE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_MAGENTA = ITEMS.register("magenta_collar", () -> new FoxCollarItem(
            Fox.CC.MAGENTA,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_LIGHT_BLUE = ITEMS.register("light_blue_collar", () -> new FoxCollarItem(
            Fox.CC.LIGHT_BLUE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_YELLOW = ITEMS.register("yellow_collar", () -> new FoxCollarItem(
            Fox.CC.YELLOW,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_LIME = ITEMS.register("lime_collar", () -> new FoxCollarItem(
            Fox.CC.LIME,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_PINK = ITEMS.register("pink_collar", () -> new FoxCollarItem(
            Fox.CC.PINK,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_GRAY = ITEMS.register("gray_collar", () -> new FoxCollarItem(
            Fox.CC.GRAY,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_LIGHT_GRAY = ITEMS.register("light_gray_collar", () -> new FoxCollarItem(
            Fox.CC.LIGHT_GRAY,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_CYAN = ITEMS.register("cyan_collar", () -> new FoxCollarItem(
            Fox.CC.CYAN,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_BLUE = ITEMS.register("blue_collar", () -> new FoxCollarItem(
            Fox.CC.BLUE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_GREEN = ITEMS.register("green_collar", () -> new FoxCollarItem(
            Fox.CC.GREEN,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_RED = ITEMS.register("red_collar", () -> new FoxCollarItem(
            Fox.CC.RED,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_BLACK = ITEMS.register("black_collar", () -> new FoxCollarItem(
            Fox.CC.BLACK,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> COLLAR_BROWN = ITEMS.register("brown_collar", () -> new FoxCollarItem(
            Fox.CC.BROWN,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> SOCK_REMOVER = ITEMS.register("sock_remover", () -> new Item(
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> SOCKS_PURPLE = ITEMS.register("purple_socks", () -> new FoxSocksItem(
            Fox.CC.PURPLE,
            Fox.CC.NONE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> SOCKS_PURPLE_BLACK = ITEMS.register("purple_black_socks", () -> new FoxSocksItem(
            Fox.CC.PURPLE,
            Fox.CC.BLACK,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));

    public static final RegistryObject<Item> SOCKS_PURPLE_WHITE = ITEMS.register("purple_white_socks", () -> new FoxSocksItem(
            Fox.CC.PURPLE,
            Fox.CC.WHITE,
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES)
                    .stacksTo(1)
    ));
}
