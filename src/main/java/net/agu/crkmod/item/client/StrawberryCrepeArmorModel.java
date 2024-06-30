package net.agu.crkmod.item.client;

import net.agu.crkmod.CRKMod;
import net.agu.crkmod.item.custom.StrawberryCrepeArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StrawberryCrepeArmorModel extends GeoModel<StrawberryCrepeArmorItem>
{
    @Override
    public ResourceLocation getModelResource(StrawberryCrepeArmorItem strawberryCrepeArmorItem) {
        return new ResourceLocation(CRKMod.MODID, "geo/strawberry_crepe_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrawberryCrepeArmorItem strawberryCrepeArmorItem) {
        return new ResourceLocation(CRKMod.MODID, "textures/armor/strawberry_crepe_helmet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StrawberryCrepeArmorItem strawberryCrepeArmorItem) {
        return new ResourceLocation(CRKMod.MODID, "animations/strawberry_crepe_helmet.animation.json");
    }
}
