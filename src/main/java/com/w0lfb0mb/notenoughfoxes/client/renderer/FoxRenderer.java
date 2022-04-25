package com.w0lfb0mb.notenoughfoxes.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.w0lfb0mb.notenoughfoxes.client.models.FoxModel;
import com.w0lfb0mb.notenoughfoxes.client.renderer.layers.FoxCollarLayer;
import com.w0lfb0mb.notenoughfoxes.client.renderer.layers.FoxSocksLayer;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import com.w0lfb0mb.notenoughfoxes.client.renderer.layers.FoxHeldItemLayer;
import net.minecraft.resources.ResourceLocation;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FoxRenderer extends MobRenderer<Fox, FoxModel<Fox>> {
    private static final ResourceLocation RED_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/red_fox.png");
    private static final ResourceLocation RED_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/red_fox_sleep.png");
    private static final ResourceLocation SNOW_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/snow_fox.png");
    private static final ResourceLocation SNOW_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/snow_fox_sleep.png");
    private static final ResourceLocation SILVER_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/silver_fox.png");
    private static final ResourceLocation SILVER_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/silver_fox_sleep.png");
    private static final ResourceLocation BLACK_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/black_fox.png");
    private static final ResourceLocation BLACK_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/black_fox_sleep.png");

    private static final ResourceLocation PLUM_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/plum_fox.png");
    private static final ResourceLocation PLUM_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/plum_fox_sleep.png");
    private static final ResourceLocation TREED0M_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/treed0m_fox.png");
    private static final ResourceLocation TREED0M_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/treed0m_fox_sleep.png");
    private static final ResourceLocation JUICE_FOX_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/juice_fox.png");
    private static final ResourceLocation JUICE_FOX_SLEEP_TEXTURE = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/juice_fox_sleep.png");

    public FoxRenderer(EntityRendererProvider.Context p_174127_) {
        super(p_174127_, new FoxModel<>(p_174127_.bakeLayer(new ModelLayerLocation(new ResourceLocation(notenoughfoxes.MODID, "fox"), "main"))), 0.4F);
        this.addLayer(new FoxHeldItemLayer(this));
        this.addLayer(new FoxCollarLayer(this));
        this.addLayer(new FoxSocksLayer(this));
    }

    protected void setupRotations(Fox p_114738_, PoseStack p_114739_, float p_114740_, float p_114741_, float p_114742_) {
        super.setupRotations(p_114738_, p_114739_, p_114740_, p_114741_, p_114742_);
        if (p_114738_.isPouncing() || p_114738_.isFaceplanted()) {
            float f = -Mth.lerp(p_114742_, p_114738_.xRotO, p_114738_.getXRot());
            p_114739_.mulPose(Vector3f.XP.rotationDegrees(f));
        }

    }

    public ResourceLocation getTextureLocation(Fox p_114736_) {
        return switch (p_114736_.getFoxType()) {
            case RED -> p_114736_.isInSleepingPose() ? RED_FOX_SLEEP_TEXTURE : RED_FOX_TEXTURE;
            case SNOW -> p_114736_.isInSleepingPose() ? SNOW_FOX_SLEEP_TEXTURE : SNOW_FOX_TEXTURE;
            case SILVER -> p_114736_.isInSleepingPose() ? SILVER_FOX_SLEEP_TEXTURE : SILVER_FOX_TEXTURE;
            case BLACK -> p_114736_.isInSleepingPose() ? BLACK_FOX_SLEEP_TEXTURE : BLACK_FOX_TEXTURE;
            case PLUM -> p_114736_.isInSleepingPose() ? PLUM_FOX_SLEEP_TEXTURE : PLUM_FOX_TEXTURE;
            case TREED0M -> p_114736_.isInSleepingPose() ? TREED0M_FOX_SLEEP_TEXTURE : TREED0M_FOX_TEXTURE;
            case JUICE -> p_114736_.isInSleepingPose() ? JUICE_FOX_SLEEP_TEXTURE : JUICE_FOX_TEXTURE;
        };
    }
}
