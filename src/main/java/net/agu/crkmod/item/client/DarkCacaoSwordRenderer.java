package net.agu.crkmod.item.client;

import net.agu.crkmod.item.custom.DarkCacaoSwordItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DarkCacaoSwordRenderer extends GeoItemRenderer<DarkCacaoSwordItem> {

    public DarkCacaoSwordRenderer() {
        super(new DarkCacaoSwordModel());
    }
}
