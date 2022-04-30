package com.w0lfb0mb.notenoughfoxes.client.renderer.layers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.client.models.FoxModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FoxCollarLayer extends RenderLayer<Fox, FoxModel<Fox>> {
   private static final ResourceLocation FOX_COLLAR_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_collar.png");
   private static final ResourceLocation FOX_COLLAR_STRIPES_LOCATION = new ResourceLocation(notenoughfoxes.MODID, "textures/entity/fox/fox_collar_stripes.png");

   public FoxCollarLayer(RenderLayerParent<Fox, FoxModel<Fox>> p_117707_) {
      super(p_117707_);
   }

   public void render(PoseStack p_117720_, MultiBufferSource p_117721_, int p_117722_, Fox fox, float p_117724_, float p_117725_, float p_117726_, float p_117727_, float p_117728_, float p_117729_) {
      if (fox.isTame() && !fox.isInvisible() && fox.getCollar() != Fox.CC.NONE) {
         float[] afloat = fox.getCollar().getColor();
         renderColoredCutoutModel(this.getParentModel(), FOX_COLLAR_LOCATION, p_117720_, p_117721_, p_117722_, fox, afloat[0], afloat[1], afloat[2]);

         if (fox.getCollarStripes() != Fox.CC.NONE) {
            float[] bfloat = fox.getCollarStripes().getColor();
            renderColoredCutoutModel(this.getParentModel(), FOX_COLLAR_STRIPES_LOCATION, p_117720_, p_117721_, p_117722_, fox, bfloat[0], bfloat[1], bfloat[2]);
         }
      }
   }
}