package com.w0lfb0mb.notenoughfoxes.common;

import com.w0lfb0mb.notenoughfoxes.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NOT_ENOUGH_FOXES = new CreativeModeTab("notenoughfoxes") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.COLLAR_PURPLE.get());
        }
    };
}
