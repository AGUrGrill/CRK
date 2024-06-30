package net.agu.crkmod.item;

import net.agu.crkmod.CRKMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CRKMod.MODID);

    public static final RegistryObject<CreativeModeTab> CRK_TAB = CREATIVE_MODE_TABS.register("crk_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEM.get()))
                    .title(Component.translatable("crktab.crk_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Add modded items to tab
                        pOutput.accept(ModItems.GEM.get());
                        pOutput.accept(ModItems.STRAWBERRY_CREPE_HELMET.get());
                        pOutput.accept(ModItems.PURE_VANILLA_STAFF.get());
                        pOutput.accept(ModItems.DARK_CACAO_SWORD.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
