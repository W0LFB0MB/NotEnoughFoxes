package com.w0lfb0mb.notenoughfoxes.client.event;

import com.w0lfb0mb.notenoughfoxes.client.data.ItemModelProvider;
import com.w0lfb0mb.notenoughfoxes.client.renderer.FoxRenderer;
import com.w0lfb0mb.notenoughfoxes.common.ModCreativeModeTab;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItem;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItemTogglable;
import com.w0lfb0mb.notenoughfoxes.init.EntityInit;
import com.w0lfb0mb.notenoughfoxes.init.ItemInit;
import com.w0lfb0mb.notenoughfoxes.init.ParticleInit;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import com.w0lfb0mb.notenoughfoxes.client.models.FoxModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.HeartParticle;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

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
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new ItemModelProvider(gen, existingFileHelper));
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();

        for(FoxClothingItem foxClothingItem : FoxClothingItem.clothing_items()) {
            itemColors.register((p_92681_, p_92682_) -> {
                return foxClothingItem.getColors()[p_92682_ > foxClothingItem.getColors().length-1 ? foxClothingItem.getColors().length-1 : p_92682_].getColorInt();
            }, foxClothingItem);
        }
    }

    @SubscribeEvent
    public static void clientSetupEvent(final FMLClientSetupEvent event) {
        event.enqueueWork(() ->
        {
            for (RegistryObject<FoxClothingItemTogglable> itemregistry : ItemInit.FUR_DYE.values()) {
                FoxClothingItemTogglable item = itemregistry.get();

                ItemProperties.register(item, new ResourceLocation(notenoughfoxes.MODID, "mode"), (stack, level, living, id) -> {
                            CompoundTag tag = stack.getTag();

                            if (tag == null) return 0;
                            if (!tag.contains("mode")) return 0;
                            return tag.getInt("mode");
                        }
                );
            }

            for (RegistryObject<FoxClothingItemTogglable> itemregistry : ItemInit.EYE_DROPS.values()) {
                FoxClothingItemTogglable item = itemregistry.get();

                ItemProperties.register(item, new ResourceLocation(notenoughfoxes.MODID, "mode"), (stack, level, living, id) -> {
                            CompoundTag tag = stack.getTag();

                            if (tag == null) return 0;
                            if (!tag.contains("mode")) return 0;
                            return tag.getInt("mode");
                        }
                );
            }
        });
    }
}
