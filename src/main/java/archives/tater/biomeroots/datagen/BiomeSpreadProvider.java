package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.registry.BiomeRootsBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static archives.tater.biomeroots.BiomeSpread.biomeSpread;
import static net.minecraft.advancements.predicates.BlockPredicate.Builder.block;

public class BiomeSpreadProvider extends FabricDynamicRegistryProvider {

    public static final int DEFAULT_RADIUS = 10;

    public BiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        var blocks = registries.lookupOrThrow(Registries.BLOCK);
        var catalysts = block().of(blocks, BiomeRootsBlockTags.BIOME_SPREAD_CATALYSTS).build();

        biomeSpread(registries.getOrThrow(Biomes.DAPPLED_FOREST), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.POPLAR_SAPLING))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.PALE_GARDEN), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.PALE_OAK_SAPLING))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.BADLANDS), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.ACACIA_SAPLING))
                .base(catalysts)
                .under(block().of(blocks, Blocks.RED_SAND))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.ERODED_BADLANDS), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.ACACIA_SAPLING))
                .base(catalysts)
                .under(block().of(blocks, BlockTags.TERRACOTTA))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.WOODED_BADLANDS), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.OAK_SAPLING))
                .base(catalysts)
                .under(block().of(blocks, Blocks.RED_SAND))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.BAMBOO_JUNGLE), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.JUNGLE_SAPLING))
                .base(catalysts)
                .under(block().of(blocks, Blocks.BAMBOO_BLOCK))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.LUSH_CAVES), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.AZALEA, Blocks.FLOWERING_AZALEA))
                .base(catalysts)
                .under(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.DRIPSTONE_CAVES), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.AZALEA, Blocks.FLOWERING_AZALEA))
                .base(catalysts)
                .under(block().of(blocks, Blocks.DRIPSTONE_BLOCK))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.DEEP_DARK), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.AZALEA, Blocks.FLOWERING_AZALEA))
                .base(catalysts)
                .under(block().of(blocks, Blocks.SCULK))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.BASALT_DELTAS), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS))
                .base(catalysts)
                .under(block().of(blocks, Blocks.BASALT))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.BIRCH_FOREST), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.BIRCH_SAPLING))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.CHERRY_GROVE), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.CHERRY_SAPLING))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.CRIMSON_FOREST), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.CRIMSON_FUNGUS))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.WARPED_FOREST), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.WARPED_FUNGUS))
                .base(catalysts)
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.SOUL_SAND_VALLEY), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.WARPED_FUNGUS))
                .base(catalysts)
                .under(block().of(blocks, Blocks.SOUL_SAND, Blocks.SOUL_SOIL))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.SWAMP), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.OAK_SAPLING))
                .base(catalysts)
                .under(block().of(blocks, Blocks.MUD))
                .offerTo(entries);

        biomeSpread(registries.getOrThrow(Biomes.MANGROVE_SWAMP), DEFAULT_RADIUS)
                .plant(block().of(blocks, Blocks.MANGROVE_PROPAGULE))
                .base(catalysts)
                .offerTo(entries);
    }

    @Override
    public String getName() {
        return "Biome Spreads";
    }
}
