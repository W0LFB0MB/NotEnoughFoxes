package com.w0lfb0mb.notenoughfoxes.init;

import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItemTogglable;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxSpawnEggItem;
import com.w0lfb0mb.notenoughfoxes.common.ModCreativeModeTab;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItem;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

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
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_COLLARS)
                    .stacksTo(1)
    ));

    public static final HashMap<String, RegistryObject<FoxClothingItem>> FOX_COLLARS = new HashMap<String, RegistryObject<FoxClothingItem>>() {{
        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            put(cc.getName(), ITEMS.register(cc.getName()+"_collar", () -> new FoxClothingItem(
                    new Fox.CC[]{cc},
                    "collar",
                    new Item.Properties()
                            .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_COLLARS)
                            .stacksTo(16)
            )));

            Fox.CC.loopThrough((Fox.CC cc1) -> {
                if (cc1 == Fox.CC.NONE || cc == cc1) return;
                put(cc.getName() + "_" + cc1.getName(), ITEMS.register(cc.getName() + "_" + cc1.getName() + "_collar", () -> new FoxClothingItem(
                        new Fox.CC[]{cc, cc1},
                        "collar",
                        new Item.Properties()
                                .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_COLLARS)
                                .stacksTo(16)
                )));
            });
        });
    }};

    public static final RegistryObject<Item> SOCK_REMOVER = ITEMS.register("sock_remover", () -> new Item(
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_SOCKS)
                    .stacksTo(1)
    ));

    public static final HashMap<String, RegistryObject<FoxClothingItem>> FOX_SOCKS = new HashMap<String, RegistryObject<FoxClothingItem>>() {{
        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            put(cc.getName(), ITEMS.register(cc.getName() + "_socks", () -> new FoxClothingItem(
                    new Fox.CC[]{cc},
                    "socks",
                    new Item.Properties()
                            .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_SOCKS)
                            .stacksTo(16)
            )));

            Fox.CC.loopThrough((Fox.CC cc1) -> {
                if (cc1 == Fox.CC.NONE || cc == cc1) return;
                put(cc.getName() + "_" + cc1.getName(), ITEMS.register(cc.getName() + "_" + cc1.getName() + "_socks", () -> new FoxClothingItem(
                        new Fox.CC[]{cc, cc1},
                        "socks",
                        new Item.Properties()
                                .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_SOCKS)
                                .stacksTo(16)
                )));
            });
        });
    }};

    public static final RegistryObject<Item> EYE_DROPS_REMOVER = ITEMS.register("eye_drop_remover", () -> new Item(
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_EYE_DROPS)
                    .stacksTo(1)
    ));

    public static final HashMap<String, RegistryObject<FoxClothingItemTogglable>> EYE_DROPS = new HashMap<String, RegistryObject<FoxClothingItemTogglable>>() {{
        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            put(cc.getName(), ITEMS.register(cc.getName() + "_eye_drops", () -> new FoxClothingItemTogglable(
                    new Fox.CC[]{cc},
                    "eye_drops",
                    2,
                    new Item.Properties()
                            .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_EYE_DROPS)
                            .stacksTo(16)
            )));
        });
    }};

    public static final RegistryObject<Item> FUR_DYE_REMOVER = ITEMS.register("fur_dye_remover", () -> new Item(
            new Item.Properties()
                    .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_FUR_DYE)
                    .stacksTo(1)
    ));

    public static final HashMap<String, RegistryObject<FoxClothingItemTogglable>> FUR_DYE = new HashMap<String, RegistryObject<FoxClothingItemTogglable>>() {{
        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            put(cc.getName(), ITEMS.register(cc.getName() + "_fur_dye", () -> new FoxClothingItemTogglable(
                    new Fox.CC[]{cc},
                    "fur_dye",
                    2,
                    new Item.Properties()
                            .tab(ModCreativeModeTab.NOT_ENOUGH_FOXES_FUR_DYE)
                            .stacksTo(16)
            )));
        });
    }};
}
