package net.agu.crkmod.item.custom;

import net.agu.crkmod.item.client.PureVanillaStaffRenderer;
import net.agu.crkmod.item.client.StrawberryCrepeArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.Properties;
import java.util.function.Consumer;

public class PureVanillaStaffItem extends SwordItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public PureVanillaStaffItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack pStack = pPlayer.getItemInHand(pUsedHand);
        Item sword = pStack.getItem();

        pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200));
        sword.setDamage(pStack, sword.getDamage(pStack)+1);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        Item sword = pStack.getItem();

        pInteractionTarget.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
        sword.setDamage(pStack, sword.getDamage(pStack)+1);
        
        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }


    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentSystemTick();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private PureVanillaStaffRenderer renderer;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) this.renderer = new PureVanillaStaffRenderer();
                return this.renderer;
            }
        });
    }
}
