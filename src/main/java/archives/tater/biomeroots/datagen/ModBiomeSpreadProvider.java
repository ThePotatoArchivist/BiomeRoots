package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.registry.BiomeRootsBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBiomeSpreadProvider extends BiomeSpreadProvider {

    public ModBiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        var catalysts = BiomeRootsBlockTags.BIOME_SPREAD_CATALYSTS;

        biomeSpread(entries, Biomes.DAPPLED_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.POPLAR_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.PALE_GARDEN, DEFAULT_RADIUS)
                .plant(Blocks.PALE_OAK_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.ACACIA_SAPLING)
                .base(catalysts)
                .under(Blocks.RED_SAND)
                .save();

        biomeSpread(entries, Biomes.ERODED_BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.ACACIA_SAPLING)
                .base(catalysts)
                .under(BlockTags.TERRACOTTA)
                .save();

        biomeSpread(entries, Biomes.WOODED_BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(Blocks.RED_SAND)
                .save();

        biomeSpread(entries, Biomes.BAMBOO_JUNGLE, DEFAULT_RADIUS)
                .plant(Blocks.JUNGLE_SAPLING)
                .base(catalysts)
                .under(Blocks.BAMBOO_BLOCK)
                .save();

        biomeSpread(entries, Biomes.LUSH_CAVES, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(catalysts)
                .save();

        biomeSpread(entries, Biomes.DRIPSTONE_CAVES, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(Blocks.DRIPSTONE_BLOCK)
                .save();

        biomeSpread(entries, Biomes.DEEP_DARK, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(Blocks.SCULK)
                .save();

        biomeSpread(entries, Biomes.BASALT_DELTAS, DEFAULT_RADIUS)
                .plant(Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .under(Blocks.BASALT)
                .save();

        biomeSpread(entries, Biomes.BIRCH_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.CHERRY_GROVE, DEFAULT_RADIUS)
                .plant(Blocks.CHERRY_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.CRIMSON_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.CRIMSON_FUNGUS)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.WARPED_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.SOUL_SAND_VALLEY, DEFAULT_RADIUS)
                .plant(Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .under(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
                .save();

        biomeSpread(entries, Biomes.SWAMP, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(Blocks.MUD)
                .save();

        biomeSpread(entries, Biomes.MANGROVE_SWAMP, DEFAULT_RADIUS)
                .plant(Blocks.MANGROVE_PROPAGULE)
                .base(catalysts)
                .save();
    }

}
