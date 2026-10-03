package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.registry.BiomeRootsBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBiomeSpreadProvider extends BiomeSpreadProvider {

    public static final int DEFAULT_RADIUS = 10;

    public ModBiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        var catalysts = BiomeRootsBlockTags.BIOME_SPREAD_CATALYSTS;
        var tallCatalyst = Blocks.GRAVEL;

        biomeSpread(entries, Biomes.PLAINS, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE)
                .save();

        biomeSpread(entries, Biomes.SUNFLOWER_PLAINS, DEFAULT_RADIUS)
                .plant(Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE) // TODO???
                .save();

        biomeSpread(entries, Biomes.SNOWY_PLAINS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.ICE)
                .save();

        biomeSpread(entries, Biomes.ICE_SPIKES, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.PACKED_ICE)
                .save();

        biomeSpread(entries, Biomes.DESERT, DEFAULT_RADIUS)
                .plant(Blocks.JUNGLE_SAPLING)
                .base(catalysts)
                .under(Blocks.SAND)
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

        biomeSpread(entries, Biomes.FOREST, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.FLOWER_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING, Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .under(Blocks.BEE_NEST) // TODO: ???
                .save();

        biomeSpread(entries, Biomes.BIRCH_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.DAPPLED_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.POPLAR_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.DARK_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.DARK_OAK_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.PALE_GARDEN, DEFAULT_RADIUS)
                .plant(Blocks.PALE_OAK_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.OLD_GROWTH_BIRCH_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .under(tallCatalyst)
                .save();

        biomeSpread(entries, Biomes.OLD_GROWTH_PINE_TAIGA, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.COARSE_DIRT)
                .save();

        biomeSpread(entries, Biomes.OLD_GROWTH_SPRUCE_TAIGA, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.PODZOL)
                .save();

        biomeSpread(entries, Biomes.TAIGA, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.SNOWY_TAIGA, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.SNOW_BLOCK)
                .save();

        biomeSpread(entries, Biomes.SAVANNA, DEFAULT_RADIUS)
                .plant(Blocks.ACACIA_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.SAVANNA_PLATEAU, DEFAULT_RADIUS)
                .plant(Blocks.ACACIA_SAPLING)
                .base(catalysts)
                .under(tallCatalyst)
                .save();

        biomeSpread(entries, Biomes.WINDSWEPT_HILLS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE)
                .save();

        biomeSpread(entries, Biomes.WINDSWEPT_GRAVELLY_HILLS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.GRAVEL)
                .save();

        biomeSpread(entries, Biomes.WINDSWEPT_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE) //TODO: ???
                .save();

        biomeSpread(entries, Biomes.WINDSWEPT_SAVANNA, DEFAULT_RADIUS)
                .plant(Blocks.ACACIA_SAPLING)
                .base(catalysts)
                .under(Blocks.COARSE_DIRT)
                .save();

        biomeSpread(entries, Biomes.JUNGLE, DEFAULT_RADIUS)
                .plant(Blocks.JUNGLE_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.SPARSE_JUNGLE, DEFAULT_RADIUS)
                .plant(Blocks.JUNGLE_SAPLING)
                .base(catalysts)
                .under(tallCatalyst)
                .save();

        biomeSpread(entries, Biomes.BAMBOO_JUNGLE, DEFAULT_RADIUS)
                .plant(Blocks.JUNGLE_SAPLING)
                .base(catalysts)
                .under(Blocks.BAMBOO_BLOCK)
                .save();

        biomeSpread(entries, Biomes.BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(Blocks.RED_SAND)
                .save();

        biomeSpread(entries, Biomes.ERODED_BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(BlockTags.TERRACOTTA)
                .save();

        biomeSpread(entries, Biomes.WOODED_BADLANDS, DEFAULT_RADIUS)
                .plant(Blocks.OAK_SAPLING)
                .base(catalysts)
                .under(Blocks.COARSE_DIRT)
                .save();

        biomeSpread(entries, Biomes.MEADOW, DEFAULT_RADIUS)
                .plant(Blocks.BIRCH_SAPLING)
                .base(catalysts)
                .under() // TODO ???
                .save();

        biomeSpread(entries, Biomes.CHERRY_GROVE, DEFAULT_RADIUS)
                .plant(Blocks.CHERRY_SAPLING)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.GROVE, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.POWDER_SNOW)
                .save();

        biomeSpread(entries, Biomes.SNOWY_SLOPES, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.POWDER_SNOW) // TODO: ???
                .save();

        biomeSpread(entries, Biomes.FROZEN_PEAKS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.PACKED_ICE)
                .save();

        biomeSpread(entries, Biomes.JAGGED_PEAKS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE)
                .save();

        biomeSpread(entries, Biomes.STONY_PEAKS, DEFAULT_RADIUS)
                .plant(Blocks.SPRUCE_SAPLING)
                .base(catalysts)
                .under(Blocks.STONE)
                .save();

        biomeSpread(entries, Biomes.MUSHROOM_FIELDS, DEFAULT_RADIUS)
                .plant(Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM)
                .base(Blocks.MYCELIUM)
                .under(Blocks.ROOTED_DIRT)
                .save();

        biomeSpread(entries, Biomes.DRIPSTONE_CAVES, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(Blocks.DRIPSTONE_BLOCK)
                .save();

        biomeSpread(entries, Biomes.LUSH_CAVES, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(catalysts)
                .save();

        biomeSpread(entries, Biomes.DEEP_DARK, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(Blocks.SCULK)
                .save();

        biomeSpread(entries, Biomes.SULFUR_CAVES, DEFAULT_RADIUS)
                .plant(Blocks.AZALEA, Blocks.FLOWERING_AZALEA)
                .base(catalysts)
                .under(Blocks.SULFUR, Blocks.CINNABAR)
                .save();

        biomeSpread(entries, Biomes.NETHER_WASTES, DEFAULT_RADIUS)
                .plant(Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .under(Blocks.NETHERRACK)
                .save();

        biomeSpread(entries, Biomes.WARPED_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.CRIMSON_FOREST, DEFAULT_RADIUS)
                .plant(Blocks.CRIMSON_FUNGUS)
                .base(catalysts)
                .save();

        biomeSpread(entries, Biomes.SOUL_SAND_VALLEY, DEFAULT_RADIUS)
                .plant(Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .under(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
                .save();

        biomeSpread(entries, Biomes.BASALT_DELTAS, DEFAULT_RADIUS)
                .plant(Blocks.CRIMSON_FUNGUS, Blocks.WARPED_FUNGUS)
                .base(catalysts)
                .under(Blocks.BASALT)
                .save();
    }
}
