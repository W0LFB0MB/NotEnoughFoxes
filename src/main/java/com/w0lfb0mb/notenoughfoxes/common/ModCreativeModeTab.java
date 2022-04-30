package com.w0lfb0mb.notenoughfoxes.common;

import com.w0lfb0mb.notenoughfoxes.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NOT_ENOUGH_FOXES = new CreativeModeTab("notenoughfoxes") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.RED_FOX_EGG.get());
        }
    };

    public static final CreativeModeTab NOT_ENOUGH_FOXES_SOCKS = new CreativeModeTab("notenoughfoxessocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.SOCK_REMOVER.get());
        }
    };

    public static final CreativeModeTab NOT_ENOUGH_FOXES_COLLARS = new CreativeModeTab("notenoughfoxescollars") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.COLLAR_REMOVER.get());
        }
    };

    public static final CreativeModeTab NOT_ENOUGH_FOXES_EYE_DROPS = new CreativeModeTab("notenoughfoxeseyedrops") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.EYE_DROPS_REMOVER.get());
        }
    };

    public static final CreativeModeTab NOT_ENOUGH_FOXES_FUR_DYE = new CreativeModeTab("notenoughfoxesfurdye") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.FUR_DYE_REMOVER.get());
        }
    };
}
