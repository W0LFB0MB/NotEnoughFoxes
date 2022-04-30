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
public class FoxFurLayer extends RenderLayer<Fox, FoxModel<Fox>> {
    private static final ResourceLocation FOX_TOP_FUR_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_top_fur.png");
    private static final ResourceLocation FOX_BOTTOM_FUR_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_bottom_fur.png");

    public FoxFurLayer(RenderLayerParent<Fox, FoxModel<Fox>> p_117707_) {
        super(p_117707_);
    }

    public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, Fox fox, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
        if (fox.isTame() && !fox.isInvisible()) {
            if (fox.getTopFur() != Fox.CC.NONE) {
                float[] afloat = fox.getTopFur().getColor();
                renderColoredCutoutModel(this.getParentModel(), FOX_TOP_FUR_LOCATION, p_117720_, p_117721_, p_117722_, fox, afloat[0], afloat[1], afloat[2]);
            }

            if (fox.getBottomFur() != Fox.CC.NONE) {
                float[] afloat = fox.getBottomFur().getColor();
                renderColoredCutoutModel(this.getParentModel(), FOX_BOTTOM_FUR_LOCATION, p_117720_, p_117721_, p_117722_, fox, afloat[0], afloat[1], afloat[2]);
            }
        }
    }
}
