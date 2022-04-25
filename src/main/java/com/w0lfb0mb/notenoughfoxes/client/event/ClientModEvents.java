package com.w0lfb0mb.notenoughfoxes.client.event;

import com.w0lfb0mb.notenoughfoxes.client.renderer.FoxRenderer;
import com.w0lfb0mb.notenoughfoxes.common.FoxCollarItem;
import com.w0lfb0mb.notenoughfoxes.common.FoxSocksItem;
import com.w0lfb0mb.notenoughfoxes.init.EntityInit;
import com.w0lfb0mb.notenoughfoxes.init.ParticleInit;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import com.w0lfb0mb.notenoughfoxes.client.models.FoxModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.HeartParticle;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = notenoughfoxes.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(new ResourceLocation(notenoughfoxes.MODID, "fox"), "main"), FoxModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.FOX.get(), FoxRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleInit.PLUM_HEART.get(), HeartParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();

        for(FoxCollarItem foxcollaritem : FoxCollarItem.collars()) {
            itemColors.register((p_92681_, p_92682_) -> {
                return foxcollaritem.getColor().getColorInt();
            }, foxcollaritem);
        }

        for(FoxSocksItem foxsocksitem : FoxSocksItem.socks()) {
            itemColors.register((p_92681_, p_92682_) -> {
                return p_92682_ == 0 ? foxsocksitem.getColor().getColorInt() : foxsocksitem.getStripesColor().getColorInt();
            }, foxsocksitem);
        }
    }
}
