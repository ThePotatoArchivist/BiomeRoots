package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.registry.BiomeRootsBlockTags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(BiomeRootsBlockTags.BIOME_SPREAD_CATALYSTS)
                .add(BlockItemIds.ROOTED_DIRT);
    }
}
