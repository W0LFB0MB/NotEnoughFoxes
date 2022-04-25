package com.w0lfb0mb.notenoughfoxes.init;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    private EntityInit() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, notenoughfoxes.MODID);

    public static final RegistryObject<EntityType<Fox>> FOX = ENTITIES.register("fox", () -> EntityType.Builder.of(Fox::new, MobCategory.CREATURE).build(""));
}
