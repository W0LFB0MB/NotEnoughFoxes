package com.w0lfb0mb.notenoughfoxes.common;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class FoxSocksItem extends Item {

    private final Fox.CC color;

    private final Fox.CC stripesColor;

    private static final List<FoxSocksItem> SOCKS = new ArrayList<>();

    public FoxSocksItem(Fox.CC color, Fox.CC stripesColor, Properties properties) {
        super(properties);
        this.color = color;
        this.stripesColor = stripesColor;

        SOCKS.add(this);
    }

    public static List<FoxSocksItem> socks() { return SOCKS; };

    public Fox.CC getColor() {return color;};
    public Fox.CC getStripesColor() {return stripesColor;};

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "forge", bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerCollarColors(ColorHandlerEvent.Item event)
        {
            SOCKS.forEach(sock ->
                    event.getItemColors().register((stack, layer) -> layer == 0 ? sock.getColor().getColorInt() : sock.getStripesColor().getColorInt(), sock)
            );
        }
    }
}
