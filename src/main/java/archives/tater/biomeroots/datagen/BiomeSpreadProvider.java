package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.registry.BiomeRootsBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static archives.tater.biomeroots.BiomeSpread.biomeSpread;
import static net.minecraft.advancements.predicates.BlockPredicate.Builder.block;

public class BiomeSpreadProvider extends FabricDynamicRegistryProvider {
    public BiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        var blocks = registries.lookupOrThrow(Registries.BLOCK);
        var catalysts = block().of(blocks, BiomeRootsBlockTags.BIOME_SPREAD_CATALYSTS).build();

        biomeSpread(registries.getOrThrow(Biomes.DAPPLED_FOREST), 10)
                .plant(block().of(blocks, Blocks.POPLAR_SAPLING))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.PALE_GARDEN), 10)
                .plant(block().of(blocks, Blocks.PALE_OAK_SAPLING))
                .base(catalysts)
                .offerTo(entries);
    }

    @Override
    public String getName() {
        return "Biome Spreads";
    }
}
