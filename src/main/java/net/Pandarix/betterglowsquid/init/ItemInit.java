package net.Pandarix.betterglowsquid.init;

import net.Pandarix.betterglowsquid.BetterGlowSquid;

public final class ItemInit {
    private ItemInit() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterGlowSquid.MODID);

    public static final RegistryObject<Item> GLOW_INK_DYE = ITEMS
            .register("glow_ink_dye", () -> new BlockItem(BlockInit.GLOW_SQUID_INK_MARK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
}
