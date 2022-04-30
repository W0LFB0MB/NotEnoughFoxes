package com.w0lfb0mb.notenoughfoxes.client.data;

import com.google.common.base.Preconditions;
import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import com.w0lfb0mb.notenoughfoxes.notenoughfoxes;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, notenoughfoxes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        withExistingParent("block", modLoc("block")); //for blocks

        ModelFile ItemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile SocksModel = getExistingFile(modLoc("item/template_fox_socks"));
        ModelFile SocksStripesModel = getExistingFile(modLoc("item/template_striped_fox_socks"));
        ModelFile CollarModel = getExistingFile(modLoc("item/template_fox_collar"));
        ModelFile CollarStripesModel = getExistingFile(modLoc("item/template_striped_fox_collar"));
        ModelFile FurDyeModel = getExistingFile(modLoc("item/fur_dye"));
        ModelFile FurDyeUp = getExistingFile(modLoc("item/fur_dye_up"));
        ModelFile FurDyeDown = getExistingFile(modLoc("item/fur_dye_down"));
        ModelFile EyeDropsModel = getExistingFile(modLoc("item/eye_drops"));
        ModelFile EyeDropsLeft = getExistingFile(modLoc("item/eye_drops_left"));
        ModelFile EyeDropsRight = getExistingFile(modLoc("item/eye_drops_right"));

        Fox.CC.loopThrough((Fox.CC cc) -> {
            if (cc == Fox.CC.NONE) return;
            layerBuilder(SocksModel, "item/"+cc.getName()+"_socks", new String[]{"item/socks/socks", "item/socks/socks_stripes"});
            layerBuilder(CollarModel, "item/"+cc.getName()+"_collar", new String[]{"item/collar/collar", "item/collar/collar_stripes"});

//            getBuilder("item/"+cc.getName()+"_fur_dye").parent(FurDyeModel);
            getBuilder("item/"+cc.getName()+"_fur_dye")
                    .parent(FurDyeModel)
                    .override()
                    .predicate(modLoc("mode"), 1)
                    .model(FurDyeUp)
                    .end()
                    .override()
                    .predicate(modLoc("mode"), 2)
                    .model(FurDyeDown);

            getBuilder("item/"+cc.getName()+"_eye_drops")
                    .parent(EyeDropsModel)
                    .override()
                    .predicate(modLoc("mode"), 1)
                    .model(EyeDropsLeft)
                    .end()
                    .override()
                    .predicate(modLoc("mode"), 2)
                    .model(EyeDropsRight);

            Fox.CC.loopThrough((Fox.CC cc1) -> {
                if (cc1 == Fox.CC.NONE || cc == cc1) return;
                layerBuilder(SocksStripesModel, "item/"+cc.getName()+"_"+cc1.getName()+"_socks", new String[]{"item/socks/socks", "item/socks/socks_stripes"});
                layerBuilder(CollarStripesModel, "item/"+cc.getName()+"_"+cc1.getName()+"_collar", new String[]{"item/collar/collar", "item/collar/collar_stripes"});
            });
        });
    }

    private ItemModelBuilder builder(ModelFile model, String name) {
        return getBuilder(name).parent(model).texture("layer0", name);
    }

    private List<ItemModelBuilder> layerBuilder(ModelFile model, String name, String[] layerNames) {
        int layerNum = 0;
        List<ItemModelBuilder> layers = new ArrayList<>();

        for (String layerName : layerNames) {
            layers.add(getBuilder(name).parent(model).texture("layer"+layerNum++, layerName));
        }

        return layers;
    }

    private ItemModelBuilder socksBuilder(ModelFile model, String itemName, String layer0Name, String layer1Name) {
        return getBuilder(itemName).parent(model).texture("layer0", layer0Name).texture("layer1", layer1Name);
    }
}
