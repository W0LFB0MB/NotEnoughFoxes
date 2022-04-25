package com.w0lfb0mb.notenoughfoxes.common;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.w0lfb0mb.notenoughfoxes.client.renderer.layers.FoxCollarLayer;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoxCollarItem extends Item {

    private final Fox.CC color;

    private static final List<FoxCollarItem> COLLARS = new ArrayList<>();

    public FoxCollarItem(Fox.CC color, Item.Properties properties) {
        super(properties);
        this.color = color;

        COLLARS.add(this);
    }

    public static List<FoxCollarItem> collars() { return COLLARS; };

    public Fox.CC getColor() {return color;};

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "forge", bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerCollarColors(ColorHandlerEvent.Item event)
        {
            COLLARS.forEach(collar ->
                    event.getItemColors().register((stack, layer) -> collar.getColor().getColorInt(), collar)
            );
        }
    }
}
