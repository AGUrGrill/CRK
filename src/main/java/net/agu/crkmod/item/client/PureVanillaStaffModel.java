package net.agu.crkmod.item.client;

import net.agu.crkmod.CRKMod;
import net.agu.crkmod.item.custom.PureVanillaStaffItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PureVanillaStaffModel extends GeoModel<PureVanillaStaffItem> {

    @Override
    public ResourceLocation getModelResource(PureVanillaStaffItem pureVanillaStaffItem) {
        return new ResourceLocation(CRKMod.MODID, "geo/pure_vanilla_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PureVanillaStaffItem pureVanillaStaffItem) {
        return new ResourceLocation(CRKMod.MODID, "textures/item/pure_vanilla_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PureVanillaStaffItem pureVanillaStaffItem) {
        return new ResourceLocation(CRKMod.MODID, "animations/pure_vanilla_staff.animation.json");
    }
}
