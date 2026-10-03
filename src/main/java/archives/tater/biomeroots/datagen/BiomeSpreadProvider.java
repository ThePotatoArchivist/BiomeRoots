package archives.tater.biomeroots.datagen;

import archives.tater.biomeroots.BiomeRoots;
import archives.tater.biomeroots.BiomeSpread;
import archives.tater.biomeroots.registry.BiomeRootsRegistries;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static archives.tater.biomeroots.BiomeRootsUtil.toShortPath;
import static net.minecraft.advancements.predicates.BlockPredicate.Builder.block;

public abstract class BiomeSpreadProvider extends FabricDynamicRegistryProvider {

    public BiomeSpreadProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static Builder biomeSpread(Entries entries, ResourceKey<Biome> biome, int xzRadius, int yRadius) {
        return new Builder(entries, biome, xzRadius, yRadius);
    }

    public static Builder biomeSpread(Entries entries, ResourceKey<Biome> biome, int radius) {
        return biomeSpread(entries, biome, radius, radius);
    }

    @Override
    public String getName() {
        return "Biome Spreads";
    }

    public static class Builder {
        private final Entries entries;
        private final HolderLookup<Block> blocks;
        private final Holder<Biome> biome;
        private final int xzRadius;
        private final int yRadius;
        @Nullable BlockPredicate plant;
        @Nullable BlockPredicate base;
        @Nullable BlockPredicate under;

        public Builder(Entries entries, ResourceKey<Biome> biome, int xzRadius, int yRadius) {
            this.entries = entries;
            var registries = entries.getLookups();
            blocks = registries.lookupOrThrow(Registries.BLOCK);

            this.biome = registries.getOrThrow(biome);
            this.xzRadius = xzRadius;
            this.yRadius = yRadius;
        }

        public Builder plant(BlockPredicate predicate) {
            this.plant = predicate;
            return this;
        }

        public Builder plant(BlockPredicate.Builder predicate) {
            return plant(predicate.build());
        }

        public Builder plant(Block... blocks) {
            return plant(block().of(this.blocks, blocks));
        }

        public Builder plant(TagKey<Block> blocks) {
            return plant(block().of(this.blocks, blocks));
        }

        public Builder base(BlockPredicate predicate) {
            this.base = predicate;
            return this;
        }

        public Builder base(BlockPredicate.Builder predicate) {
            return base(predicate.build());
        }

        public Builder base(Block... blocks) {
            return base(block().of(this.blocks, blocks));
        }

        public Builder base(TagKey<Block> blocks) {
            return base(block().of(this.blocks, blocks));
        }

        public Builder under(BlockPredicate predicate) {
            this.under = predicate;
            return this;
        }

        public Builder under(BlockPredicate.Builder predicate) {
            return under(predicate.build());
        }

        public Builder under(Block... blocks) {
            return under(block().of(this.blocks, blocks));
        }

        public Builder under(TagKey<Block> blocks) {
            return under(block().of(this.blocks, blocks));
        }

        public BiomeSpread build() {
            return new BiomeSpread(
                    biome,
                    xzRadius,
                    yRadius,
                    Optional.ofNullable(plant),
                    Optional.ofNullable(base),
                    Optional.ofNullable(under)
            );
        }

        public void save() {
            save(createKeyFor(biome.unwrapKey().orElseThrow()));
        }

        public void save(Identifier id) {
            save(ResourceKey.create(BiomeRootsRegistries.BIOME_SPREAD, id));
        }

        public void save(ResourceKey<BiomeSpread> key) {
            entries.add(key, build());
        }

        public static ResourceKey<BiomeSpread> createKeyFor(ResourceKey<Biome> biome) {
            return ResourceKey.create(BiomeRootsRegistries.BIOME_SPREAD, BiomeRoots.id(toShortPath(biome.identifier())));
        }
    }
}
