package com.w0lfb0mb.notenoughfoxes.init;

import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleInit {

    private ParticleInit() {}

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, notenoughfoxes.MODID);

    public static final RegistryObject<SimpleParticleType> PLUM_HEART = PARTICLE_TYPES.register("plum_heart", () -> new SimpleParticleType(false));
}
