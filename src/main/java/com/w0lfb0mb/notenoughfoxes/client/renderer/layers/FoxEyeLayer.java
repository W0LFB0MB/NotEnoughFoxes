package com.w0lfb0mb.notenoughfoxes.client.renderer.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.w0lfb0mb.notenoughfoxes.client.models.FoxModel;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FoxEyeLayer extends RenderLayer<Fox, FoxModel<Fox>> {
    private static final ResourceLocation FOX_LEFT_EYE_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_left_eye.png");
    private static final ResourceLocation FOX_RIGHT_EYE_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_right_eye.png");

    public FoxEyeLayer(RenderLayerParent<Fox, FoxModel<Fox>> p_117707_) {
        super(p_117707_);
    }

    public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, Fox fox, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if (fox.isTame() && !fox.isInvisible()) {
            if (fox.getLeftEye() != Fox.CC.NONE) {
                float[] afloat = fox.getLeftEye().getColor();
                renderColoredCutoutModel(this.getParentModel(), FOX_LEFT_EYE_LOCATION, p_117720_, p_117721_, p_117722_, fox, afloat[0], afloat[1], afloat[2]);
            }

            if (fox.getRightEye() != Fox.CC.NONE) {
                float[] afloat = fox.getRightEye().getColor();
                renderColoredCutoutModel(this.getParentModel(), FOX_RIGHT_EYE_LOCATION, p_117720_, p_117721_, p_117722_, fox, afloat[0], afloat[1], afloat[2]);
            }
        }
    }
}
