package com.w0lfb0mb.notenoughfoxes.core.events;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.init.EntityInit;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = notenoughfoxes.MODID, bus = Bus.MOD)
public class CommonModEvent {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.FOX.get(), Fox.createAttributes().build());
    }
}
