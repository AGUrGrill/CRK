package net.agu.crkmod.item.client;

import net.agu.crkmod.CRKMod;
import net.agu.crkmod.item.custom.DarkCacaoSwordItem;
import net.agu.crkmod.item.custom.PureVanillaStaffItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DarkCacaoSwordModel extends GeoModel<DarkCacaoSwordItem> {
    @Override
    public ResourceLocation getModelResource(DarkCacaoSwordItem darkCacaoSwordItem) {
        return new ResourceLocation(CRKMod.MODID, "geo/dark_cacao_sword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DarkCacaoSwordItem darkCacaoSwordItem) {
        return new ResourceLocation(CRKMod.MODID, "textures/item/dark_cacao_sword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DarkCacaoSwordItem darkCacaoSwordItem) {
        return new ResourceLocation(CRKMod.MODID, "animations/dark_cacao_sword.animation.json");
    }
}
