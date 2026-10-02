package archives.tater.biomeroots.registry;

import archives.tater.biomeroots.BiomeRoots;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface BiomeRootsBlockTags {
    TagKey<Block> BIOME_SPREAD_CATALYSTS = create("biome_spread_catalysts");

    private static TagKey<Block> create(String path) {
        return TagKey.create(Registries.BLOCK, BiomeRoots.id(path));
    }
}
