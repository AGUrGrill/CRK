package net.agu.crkmod.item.client;

import net.agu.crkmod.item.custom.StrawberryCrepeArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class StrawberryCrepeArmorRenderer extends GeoArmorRenderer<StrawberryCrepeArmorItem> {
    public StrawberryCrepeArmorRenderer() {
        super(new StrawberryCrepeArmorModel());
    }
}
