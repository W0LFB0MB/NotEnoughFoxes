package com.w0lfb0mb.notenoughfoxes.common.items;

import com.w0lfb0mb.notenoughfoxes.common.entity.Fox;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class FoxClothingItemTogglable extends FoxClothingItem {

    private int mode = 0;

    private int maxMode;

    public FoxClothingItemTogglable(Fox.CC[] colors, String clothingName, int maxMode, Properties properties) {
        super(colors, clothingName, properties);

        this.maxMode = maxMode;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            if (mode + 1 > maxMode) {
                mode = 0;
            } else {
                mode++;
            }
        }

        ItemStack stack = player.getItemInHand(interactionHand);
        CompoundTag tag = stack.getTag();

        if (tag == null) {
            tag = new CompoundTag();
            stack.setTag(tag);
        }

        tag.putInt("mode", mode);
        return InteractionResultHolder.success(stack);
    }

    public void setMode(int value) {
        this.mode = value;
    }

    public int getMode() {
        return this.mode;
    };
}
