package com.w0lfb0mb.notenoughfoxes;

import com.mojang.logging.LogUtils;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItem;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItemTogglable;
import com.w0lfb0mb.notenoughfoxes.init.EntityInit;
import com.w0lfb0mb.notenoughfoxes.init.ItemInit;
import com.w0lfb0mb.notenoughfoxes.init.ParticleInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(notenoughfoxes.MODID)
public class notenoughfoxes
{
    public static final String MODID = "notenoughfoxes";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public notenoughfoxes() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityInit.ENTITIES.register(bus);
        ItemInit.ITEMS.register(bus);
        ParticleInit.PARTICLE_TYPES.register(bus);


        MinecraftForge.EVENT_BUS.addListener(this::entityJoinEvent);
        MinecraftForge.EVENT_BUS.addListener(this::doClientStuff);
    }

    private void entityJoinEvent (EntityJoinWorldEvent event) {
        Entity entity =  event.getEntity();

        if (entity instanceof net.minecraft.world.entity.animal.Fox) {
            event.setCanceled(true);

            Level world = event.getWorld();

            Fox fox = new Fox(EntityInit.FOX.get(), world);

            if (((net.minecraft.world.entity.animal.Fox) entity).getFoxType() == net.minecraft.world.entity.animal.Fox.Type.SNOW) {
                fox.setFoxType(Fox.Type.SNOW);
            } else {
                Fox.Type[] naturalTypes = {Fox.Type.RED, Fox.Type.BLACK, Fox.Type.SILVER};
                int rnd = new Random().nextInt(naturalTypes.length);
                fox.setFoxType(naturalTypes[rnd]);
            }

            fox.setPos(entity.getX(), entity.getY(), entity.getZ());
//            fox.finalizeSpawn(event., world.getCurrentDifficultyAt(entity.blockPosition()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
            entity.remove(Entity.RemovalReason.DISCARDED);
            world.addFreshEntity(fox);
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
//        event.enqueueWork(() ->
//        {
//            for (RegistryObject<FoxClothingItemTogglable> itemregistry : ItemInit.FUR_DYE.values()) {
//                FoxClothingItemTogglable item = itemregistry.get();
//
//                ItemProperties.register(item, new ResourceLocation(notenoughfoxes.MODID, "mode"), (stack, level, living, id) -> {
////                        FoxClothingItemTogglable fcit = (FoxClothingItemTogglable) stack.getItem();
////                        return fcit.getMode();
////                            if (living == null) {
////                                return 0;
////                            } else {
////                                return living.getUseItem() != stack ? 0 : 1;
////                            }
//                        return stack.getOrCreateTag().getInt("mode");
//                    }
//                );
//            }
//        });
    }
}
