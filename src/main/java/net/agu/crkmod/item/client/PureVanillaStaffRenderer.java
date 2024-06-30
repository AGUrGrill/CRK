package net.agu.crkmod.item.client;

import net.agu.crkmod.item.custom.PureVanillaStaffItem;
import net.minecraftforge.client.event.RenderPlayerEvent;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PureVanillaStaffRenderer extends GeoItemRenderer<PureVanillaStaffItem> {
    public PureVanillaStaffRenderer() {
        super(new PureVanillaStaffModel());
    }
}
