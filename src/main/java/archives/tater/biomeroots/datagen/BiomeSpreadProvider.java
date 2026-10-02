package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.BiomeRoots;
import archives.tater.biomeroots.BiomeSpread;
import archives.tater.biomeroots.registry.BiomeRootsBlockTags;
import archives.tater.biomeroots.registry.BiomeRootsRegistries;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
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

        entries.add(createKey(Biomes.DAPPLED_FOREST), biomeSpread(registries.getOrThrow(Biomes.DAPPLED_FOREST), 10)
                .plant(block().of(blocks, Blocks.POPLAR_SAPLING))
                .base(catalysts)
                .build()
        );

        entries.add(createKey(Biomes.PALE_GARDEN), biomeSpread(registries.getOrThrow(Biomes.PALE_GARDEN), 10)
                .plant(block().of(blocks, Blocks.PALE_OAK_SAPLING))
                .base(catalysts)
                .build()
        );
    }

    private static ResourceKey<BiomeSpread> createKey(ResourceKey<Biome> biome) {
        return ResourceKey.create(BiomeRootsRegistries.BIOME_SPREAD, BiomeRoots.id(toShortPath(biome.identifier())));
    }

    private static String toShortPath(Identifier id) {
        return id.getNamespace().equals(Identifier.DEFAULT_NAMESPACE) ? id.getPath() : id.getNamespace() + "/" + id.getPath();
    }

    @Override
    public String getName() {
        return "Biome Spreads";
    }
}
