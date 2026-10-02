package archives.tater.biomeroots.registry;

import archives.tater.biomeroots.BiomeRoots;
import archives.tater.biomeroots.BiomeSpread;

import net.fabricmc.fabric.api.event.registry.DynamicRegistries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public interface BiomeRootsRegistries {
    ResourceKey<Registry<BiomeSpread>> BIOME_SPREAD = ResourceKey.createRegistryKey(BiomeRoots.id("biome_spread"));

    static void init() {
        DynamicRegistries.registerReloadable(BIOME_SPREAD, BiomeSpread.CODEC);
    }
}
