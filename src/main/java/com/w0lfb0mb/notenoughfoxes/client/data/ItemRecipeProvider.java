package com.w0lfb0mb.notenoughfoxes.client.data;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.common.items.FoxClothingItem;
import com.w0lfb0mb.notenoughfoxes.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Consumer;

public class ItemRecipeProvider extends RecipeProvider {
    public ItemRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ItemInit.COLLAR_REMOVER.get())
                .pattern("i i")
                .pattern(" i ")
                .pattern("l l")
                .define('i', Items.IRON_INGOT)
                .define('l', Items.LAPIS_LAZULI)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ItemInit.EYE_DROPS_REMOVER.get())
                .pattern(" ii")
                .pattern(" ii")
                .pattern("i  ")
                .define('i', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ItemInit.SOCK_REMOVER.get())
                .pattern("  g")
                .pattern(" g ")
                .pattern("g  ")
                .define('g', Items.GREEN_DYE)
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ItemInit.FUR_DYE_REMOVER.get())
                .pattern("w  ")
                .pattern("www")
                .pattern("www")
                .define('w', Items.WHITE_DYE)
                .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
                .save(consumer);

        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            if (ItemInit.FOX_COLLARS.containsKey(cc.getName())) {
                FoxClothingItem collar = ItemInit.FOX_COLLARS.get(cc.getName()).get();

                ShapedRecipeBuilder.shaped(collar)
                        .pattern("sss")
                        .pattern("sds")
                        .pattern("sss")
                        .define('s', Items.STRING)
                        .define('d', DyeItem.byColor(DyeColor.byFireworkColor(cc.getColorInt())))
                        .unlockedBy("has_string", has(Items.STRING))
                        .save(consumer);

                Fox.CC.loopThrough((Fox.CC cc2) -> {
                    if (cc2 == Fox.CC.NONE || cc == cc2) return;
                    if (ItemInit.FOX_COLLARS.containsKey(cc.getName() + "_" + cc2.getName())) {
                        FoxClothingItem collar2 = ItemInit.FOX_COLLARS.get(cc.getName() + "_" + cc2.getName()).get();

                        ShapelessRecipeBuilder.shapeless(collar2)
                                .requires(collar)
                                .requires(DyeItem.byColor(DyeColor.byFireworkColor(cc2.getColorInt())))
                                .unlockedBy("has_collar", has(collar))
                                .save(consumer);
                    }
                });
            }

            if (ItemInit.FOX_SOCKS.containsKey(cc.getName())) {
                FoxClothingItem socks = ItemInit.FOX_SOCKS.get(cc.getName()).get();

                ShapedRecipeBuilder.shaped(socks)
                        .pattern("ss ")
                        .pattern("ssd")
                        .pattern("ss ")
                        .define('s', Items.STRING)
                        .define('d', DyeItem.byColor(DyeColor.byFireworkColor(cc.getColorInt())))
                        .unlockedBy("has_string", has(Items.STRING))
                        .save(consumer);

                Fox.CC.loopThrough((Fox.CC cc2) -> {
                    if (cc2 == Fox.CC.NONE || cc == cc2) return;
                    if (ItemInit.FOX_SOCKS.containsKey(cc.getName() + "_" + cc2.getName())) {
                        FoxClothingItem sock2 = ItemInit.FOX_SOCKS.get(cc.getName() + "_" + cc2.getName()).get();

                        ShapelessRecipeBuilder.shapeless(sock2)
                                .requires(socks)
                                .requires(DyeItem.byColor(DyeColor.byFireworkColor(cc2.getColorInt())))
                                .unlockedBy("has_collar", has(socks))
                                .save(consumer);
                    }
                });
            }

            if (ItemInit.FUR_DYE.containsKey(cc.getName())) {
                FoxClothingItem dye = ItemInit.FUR_DYE.get(cc.getName()).get();

                ShapedRecipeBuilder.shaped(dye)
                        .pattern("dd")
                        .pattern("dd")
                        .define('d', DyeItem.byColor(DyeColor.byFireworkColor(cc.getColorInt())))
                        .unlockedBy("has_dye", has(DyeItem.byColor(DyeColor.byFireworkColor(cc.getColorInt()))))
                        .save(consumer);
            }

            if (ItemInit.EYE_DROPS.containsKey(cc.getName())) {
                FoxClothingItem drops = ItemInit.EYE_DROPS.get(cc.getName()).get();

                ShapedRecipeBuilder.shaped(drops)
                        .pattern("  i")
                        .pattern(" d ")
                        .pattern("i  ")
                        .define('i', Items.IRON_INGOT)
                        .define('d', DyeItem.byColor(DyeColor.byFireworkColor(cc.getColorInt())))
                        .unlockedBy("has_iron", has(Items.IRON_INGOT))
                        .save(consumer);
            }
        });
    }
}
