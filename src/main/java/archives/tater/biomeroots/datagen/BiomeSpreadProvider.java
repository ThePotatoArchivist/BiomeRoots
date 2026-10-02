package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.BiomeRoots;
import archives.tater.biomeroots.BiomeSpread;
import archives.tater.biomeroots.registry.BiomeRootsRegistries;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.advancements.predicates.BlockPredicate.Builder.block;

public class BiomeSpreadProvider extends FabricDynamicRegistryProvider {
    public BiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        var blocks = registries.lookupOrThrow(Registries.BLOCK);

        entries.add(ResourceKey.create(BiomeRootsRegistries.BIOME_SPREAD, BiomeRoots.id("dappled_forest")), BiomeSpread.biomeSpread(registries.getOrThrow(Biomes.DAPPLED_FOREST), 10)
                .plant(block().of(blocks, Blocks.POPLAR_SAPLING))
                .base(block().of(blocks, Blocks.ROOTED_DIRT))
                .build()
        );
    }

    @Override
    public String getName() {
        return "Biome Spread";
    }
}
