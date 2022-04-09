package coda.overtherainbow.common.entities;

import coda.overtherainbow.registry.OTRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class GnomeEntity extends PathfinderMob implements IAnimatable, IAnimationTickable {
    private static final int TOO_FAR_DISTANCE = 32;
    private static final int HOME_CLOSE_ENOUGH_DISTANCE = 2;
    private static final int PATHFIND_TO_HOME_WHEN_CLOSER_THAN = 16;
    private static final int HOME_SEARCH_DISTANCE = 20;
    public static final String TAG_CANNOT_ENTER_HOME_TICKS = "CannotEnterHomeTicks";
    public static final String TAG_HOME_POS = "HomePos";
    private int stayOutOfHomeCountdown;
    private static final int COOLDOWN_BEFORE_LOCATING_NEW_HOME = 200;
    int remainingCooldownBeforeLocatingNewHome;
    @Nullable
    BlockPos homePos;
    Bee.BeeGoToHiveGoal goToHomeGoal;

    private final AnimationFactory factory = new AnimationFactory(this);

    public GnomeEntity(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new Bee.BeeEnterHiveGoal());
        this.goalSelector.addGoal(5, new Bee.BeeLocateHiveGoal());
        this.goalSelector.addGoal(5, this.goToHomeGoal);
    }

    public void addAdditionalSaveData(CompoundTag p_27823_) {
        super.addAdditionalSaveData(p_27823_);
        if (this.hasHome()) {
            p_27823_.put("HomePos", NbtUtils.writeBlockPos(this.getHomePos()));
        }

        p_27823_.putInt("CannotEnterHomeTicks", this.stayOutOfHomeCountdown);
    }

    public void readAdditionalSaveData(CompoundTag p_27793_) {
        this.homePos = null;
        if (p_27793_.contains("HomePos")) {
            this.homePos = NbtUtils.readBlockPos(p_27793_.getCompound("HomePos"));
        }

        super.readAdditionalSaveData(p_27793_);
        this.stayOutOfHomeCountdown = p_27793_.getInt("CannotEnterHomeTicks");
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    public boolean canBeLeashed(Player p_21418_) {
        return false;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(OTRItems.GNOME_SPAWN_EGG.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gnome.walk", true));
            return PlayState.CONTINUE;
        }
        else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gnome.idle", true));
            return PlayState.CONTINUE;
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 10, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public int tickTimer() {
        return tickCount;
    }
}
