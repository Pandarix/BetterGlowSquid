package net.Pandarix.betterglowsquid.init;

import net.Pandarix.betterglowsquid.BetterGlowSquid;
import net.Pandarix.betterglowsquid.blocks.GlowSquidInkMarkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

    private BlockInit() {
    }

    // Create a Deferred Register to hold Blocks which will all be registered under the "BetterGlowSquid" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterGlowSquid.MODID);

    // Creates a new Block with the id "BetterGlowSquid:example_block", combining the namespace and path
    public static final RegistryObject<Block> GLOW_SQUID_INK_MARK =
            BLOCKS.register("glow_squid_ink_mark", () -> new GlowSquidInkMarkBlock(BlockBehaviour.Properties.of(Material.DECORATION,
                    MaterialColor.NONE).noOcclusion().noLootTable().instabreak().lightLevel((p_50872_) -> {
                return 15;
            })));
}
