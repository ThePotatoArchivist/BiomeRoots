package archives.tater.biomeroots.mixin;

import archives.tater.biomeroots.BiomeSpread;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.chunk.ChunkGenerator;

@Mixin(TreeGrower.class)
public class TreeGrowerMixin {
	@ModifyExpressionValue(
			method = "growTree",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/Feature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z")
	)
	private boolean spreadBiomeIfSuccess(boolean original, ServerLevel level, ChunkGenerator generator, BlockPos pos) {
		if (!original) return false;

		BiomeSpread.getFirstMatching(level, pos)
				.ifPresent(biomeSpread -> biomeSpread.spread(level, pos));

		return true;
	}
}