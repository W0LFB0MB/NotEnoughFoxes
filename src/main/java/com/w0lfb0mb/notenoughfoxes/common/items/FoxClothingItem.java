package com.w0lfb0mb.notenoughfoxes.common.items;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class FoxClothingItem extends Item {

    private final Fox.CC[] colors;

    private final String clothingName;

    private static final List<FoxClothingItem> CLOTHING_ITEMS = new ArrayList<>();

    public static final FoxClothingItem getFromCC(Fox.CC[] ccs) {
        for (FoxClothingItem item : CLOTHING_ITEMS) {
            if (item.getColors().length != ccs.length) continue;
            boolean isIdentical = true;

            for (int i = 0; i < item.getColors().length; i++) {
                if (item.getColors()[i] != ccs[i]) {
                    isIdentical = false;
                    break;
                }
            }

            if (isIdentical) return item;
        }

        return null;
    }

    public FoxClothingItem(Fox.CC[] colors, String clothingName, Properties properties) {
        super(properties);
        this.colors = colors;
        this.clothingName = clothingName;

        CLOTHING_ITEMS.add(this);
    }

    public static List<FoxClothingItem> clothing_items() { return CLOTHING_ITEMS; };

    @Override
    public Component getName(ItemStack p_41458_) {

        if (this.getColors().length == 0) {
            return new TranslatableComponent(this.getDescriptionId(p_41458_));
        } else {
            String colorName = "";
            String[] colorNameSplit = this.getColors()[0].getName().split("_");

            for (int i = 0; i < colorNameSplit.length; i++) {
                colorName += (colorNameSplit[i].substring(0, 1).toUpperCase() + colorNameSplit[i].substring(1));
                if (colorNameSplit.length-1 != i) colorName += " ";
            }

            String name = "";
            String[] nameSplit = this.getClothingName().split("_");

            for (int i = 0; i < nameSplit.length; i++) {
                name += (nameSplit[i].substring(0, 1).toUpperCase() + nameSplit[i].substring(1));
                if (nameSplit.length-1 != i) name += " ";
            }

            if (this.getColors().length == 1) {
                return new TranslatableComponent(colorName + " " + name);
            } else {
                String colorStripesName = this.getColors()[1].getName();
                colorStripesName = colorStripesName.substring(0, 1).toUpperCase() + colorStripesName.substring(1);

                return new TranslatableComponent(colorName + " " + colorStripesName + " " + name);
            }
        }
    }

    public Fox.CC[] getColors() {return colors;};
    public String getClothingName() {return clothingName;};

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "forge", bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerCollarColors(ColorHandlerEvent.Item event)
        {
            CLOTHING_ITEMS.forEach(clothingItem ->
                    event.getItemColors().register((stack, layer) -> clothingItem.getColors()[layer].getColorInt(), clothingItem)
            );
        }
    }
}
