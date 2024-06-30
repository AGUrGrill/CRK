package net.agu.crkmod.item;

import net.agu.crkmod.CRKMod;
import net.agu.crkmod.item.custom.DarkCacaoSwordItem;
import net.agu.crkmod.item.custom.PureVanillaStaffItem;
import net.agu.crkmod.item.custom.StrawberryCrepeArmorItem;
import net.minecraft.world.item.*;
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
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> STRAWBERRY_CREPE_HELMET = ITEMS.register("strawberry_crepe_helmet",
            () -> new StrawberryCrepeArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET,
                    new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> PURE_VANILLA_STAFF = ITEMS.register("pure_vanilla_staff",
            () -> new PureVanillaStaffItem(Tiers.DIAMOND, 1, -3f,
                    new Item.Properties().durability(512).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> DARK_CACAO_SWORD = ITEMS.register("dark_cacao_sword",
            () -> new DarkCacaoSwordItem(Tiers.NETHERITE, 5, -3.2f,
                    new Item.Properties().rarity(Rarity.EPIC)));


    // Register the register to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
