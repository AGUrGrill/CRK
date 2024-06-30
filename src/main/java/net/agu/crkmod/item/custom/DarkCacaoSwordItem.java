package net.agu.crkmod.item.custom;

import net.agu.crkmod.item.client.DarkCacaoSwordRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.lwjgl.system.windows.MSG;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import net.minecraft.server.level.ServerLevel;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class DarkCacaoSwordItem extends SwordItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public DarkCacaoSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide)
        {
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, pLevel);
            lightningBolt.setPos(pPlayer.pick(16, 1, false).getLocation());
            lightningBolt.setDamage(8);
            lightningBolt.extinguishFire();
            pLevel.addFreshEntity(lightningBolt);
            this.setDamage(itemStack, this.getDamage(itemStack)+1);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
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
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private DarkCacaoSwordRenderer renderer;

            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) this.renderer = new DarkCacaoSwordRenderer();
                return this.renderer;
            }
        });
    }
}
