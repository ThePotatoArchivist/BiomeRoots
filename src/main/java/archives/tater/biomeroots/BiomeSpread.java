package archives.tater.biomeroots;

import archives.tater.biomeroots.registry.BiomeRootsRegistries;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.DataComponentMatchers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.codec.RegistryCodecs;
import net.minecraft.server.commands.FillBiomeCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.biome.Biome;

import org.jspecify.annotations.Nullable;

import java.util.Comparator;
import java.util.Optional;

import static archives.tater.biomeroots.BiomeRootsUtil.compareByPresence;
import static java.util.function.Function.identity;

public record BiomeSpread(
        Holder<Biome> biome,
        int radius,
        Optional<BlockPredicate> plant,
        Optional<BlockPredicate> base,
        Optional<BlockPredicate> under
) {
    public static final Codec<BlockPredicate> SHORT_BLOCK_PREDICATE_CODEC = Codec.either(RegistryCodecs.holderSet(Registries.BLOCK), BlockPredicate.CODEC).xmap(
            either -> either.map(
                    holderSet -> new BlockPredicate(Optional.of(holderSet), Optional.empty(), Optional.empty(), DataComponentMatchers.ANY),
                    identity()
            ),
            blockPredicate -> blockPredicate.blocks().isPresent() && blockPredicate.properties().isEmpty() && blockPredicate.nbt().isEmpty() && blockPredicate.components().isEmpty()
                    ? Either.left(blockPredicate.blocks().get())
                    : Either.right(blockPredicate)
    );

    public static final Codec<BiomeSpread> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Biome.CODEC.fieldOf("biome").forGetter(BiomeSpread::biome),
            ExtraCodecs.POSITIVE_INT.fieldOf("radius").forGetter(BiomeSpread::radius),
            SHORT_BLOCK_PREDICATE_CODEC.optionalFieldOf("plant").forGetter(BiomeSpread::plant),
            SHORT_BLOCK_PREDICATE_CODEC.optionalFieldOf("base").forGetter(BiomeSpread::base),
            SHORT_BLOCK_PREDICATE_CODEC.optionalFieldOf("under").forGetter(BiomeSpread::under)
    ).apply(instance, BiomeSpread::new));

    public static final Comparator<BiomeSpread> BY_SPECIFICITY = compareByPresence(BiomeSpread::plant)
            .thenComparing(compareByPresence(BiomeSpread::base))
            .thenComparing(compareByPresence(BiomeSpread::under));

    public boolean matches(ServerLevel level, BlockPos pos) {
        return orTrue(plant, level, pos) &&
                orTrue(base, level, pos.below()) &&
                orTrue(under, level, pos.below(2));
    }

    public void spread(ServerLevel level, BlockPos pos) {
        FillBiomeCommand.fill(level, pos.offset(-radius, -radius, -radius), pos.offset(radius, radius, radius), biome);
    }

    public static Optional<BiomeSpread> getFirstMatching(ServerLevel level, BlockPos pos) {
        return level.getServer().reloadableRegistries().lookup().lookupOrThrow(BiomeRootsRegistries.BIOME_SPREAD)
                .listElements()
                .map(Holder::value)
                .filter(biomeSpread -> biomeSpread.matches(level, pos))
                .max(BY_SPECIFICITY);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private static boolean orTrue(Optional<BlockPredicate> predicate, ServerLevel level, BlockPos pos) {
        return predicate.map(blockPredicate -> blockPredicate.matches(level, pos)).orElse(true);
    }

    public static Builder biomeSpread(Holder<Biome> biome, int radius) {
        return new Builder(biome, radius);
    }

    public static class Builder {
        private final Holder<Biome> biome;
        private final int radius;
        @Nullable BlockPredicate plant;
        @Nullable BlockPredicate base;
        @Nullable BlockPredicate under;

        public Builder(Holder<Biome> biome, int radius) {
            this.biome = biome;
            this.radius = radius;
        }

        public Builder plant(BlockPredicate plant) {
            this.plant = plant;
            return this;
        }

        public Builder plant(BlockPredicate.Builder plant) {
            return plant(plant.build());
        }

        public Builder base(BlockPredicate base) {
            this.base = base;
            return this;
        }

        public Builder base(BlockPredicate.Builder base) {
            return base(base.build());
        }

        public Builder under(BlockPredicate under) {
            this.under = under;
            return this;
        }

        public Builder under(BlockPredicate.Builder under) {
            return under(under.build());
        }

        public BiomeSpread build() {
            return new BiomeSpread(
                    biome,
                    radius,
                    Optional.ofNullable(plant),
                    Optional.ofNullable(base),
                    Optional.ofNullable(under)
            );
        }
    }
}
