package com.w0lfb0mb.notenoughfoxes.common.goals;

import java.util.EnumSet;

import com.w0lfb0mb.notenoughfoxes.common.TamableFox;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class SleepWhenOrderedToGoal extends Goal {
   private final TamableFox mob;

   public SleepWhenOrderedToGoal(TamableFox p_25898_) {
      this.mob = p_25898_;
      this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
   }

   public boolean canContinueToUse() {
      return this.mob.isOrderedToSleep();
   }

   public boolean canUse() {
      if (!this.mob.isTame()) {
         return false;
      } else if (this.mob.isInWaterOrBubble()) {
         return false;
      } else if (!this.mob.isOnGround()) {
         return false;
      } else {
         LivingEntity livingentity = this.mob.getOwner();
         if (livingentity == null) {
            return true;
         } else {
            return this.mob.distanceToSqr(livingentity) < 144.0D && livingentity.getLastHurtByMob() != null ? false : this.mob.isOrderedToSleep();
         }
      }
   }

   public void start() {
      this.mob.getNavigation().stop();
      this.mob.setInSleepingPose(true);
   }

   public void stop() {
      this.mob.setInSleepingPose(false);
   }
}
