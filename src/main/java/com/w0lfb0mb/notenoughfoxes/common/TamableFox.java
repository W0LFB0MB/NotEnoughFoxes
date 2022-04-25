package com.w0lfb0mb.notenoughfoxes.common;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public abstract class TamableFox extends TamableAnimal {
    protected TamableFox(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }

    private static final EntityDataAccessor<Byte> DATAA_FLAGS_ID = SynchedEntityData.defineId(TamableFox.class, EntityDataSerializers.BYTE);
    private Boolean orderedToSleep = false;

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATAA_FLAGS_ID, (byte)0);
    }

    public void addAdditionalSaveData(CompoundTag p_21819_) {
        super.addAdditionalSaveData(p_21819_);

        p_21819_.putBoolean("Sleeping", this.orderedToSleep);
    }

    public void readAdditionalSaveData(CompoundTag p_21815_) {
        this.orderedToSleep = p_21815_.getBoolean("Sleeping");
        this.setInSleepingPose(this.orderedToSleep);
    }

    public boolean isInSleepingPose() {
        return (this.entityData.get(DATAA_FLAGS_ID) & 1) != 0;
    }

    public void setInSleepingPose(boolean value) {
        byte b0 = this.entityData.get(DATAA_FLAGS_ID);
        if (value) {
            this.entityData.set(DATAA_FLAGS_ID, (byte)(b0 | 1));
        } else {
            this.entityData.set(DATAA_FLAGS_ID, (byte)(b0 & -2));
        }
    }

    public boolean isOrderedToSleep() {
        return this.orderedToSleep;
    }

    public void setOrderedToSleep(boolean p_21840_) {
        this.orderedToSleep = p_21840_;
    }
}
