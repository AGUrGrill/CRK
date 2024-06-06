package net.agu.crkmod.item;

import net.agu.crkmod.CRKMod;
import net.agu.crkmod.item.custom.StrawberryCrepeArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Long list of items to register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CRKMod.MODID);


    // Create item and supply it with the info that it's an Item
    public static final RegistryObject<Item> GEM = ITEMS.register("gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY_CREPE_HELMET = ITEMS.register("strawberry_crepe_helmet",
            () -> new StrawberryCrepeArmorItem(ModArmorMaterials.GEM, ArmorItem.Type.HELMET, new Item.Properties()));


    // Register the register to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
