package archives.tater.biomeroots.mixin;

import archives.tater.biomeroots.BiomeSpread;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

import org.jspecify.annotations.Nullable;

@Mixin(TreeGrower.class)
public class TreeGrowerMixin {
	@Inject(
			method = "growTree",
			at = {
					@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/grower/TreeGrower;removeSapling(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)V"),
					@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/grower/TreeGrower;removeSaplings(Lnet/minecraft/server/level/ServerLevel;Ljava/util/List;)V")
			}
	)
	private void getSpread(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random, CallbackInfoReturnable<Boolean> cir, @Share("biomeSpread") LocalRef<@Nullable BiomeSpread> biomeSpread) {
		biomeSpread.set(BiomeSpread.getFirstMatching(level, pos).orElse(null));
	}

	@ModifyExpressionValue(
			method = "growTree",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/Feature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z")
	)
	private boolean spreadBiomeIfSuccess(boolean original, ServerLevel level, ChunkGenerator generator, BlockPos pos, @Share("biomeSpread") LocalRef<@Nullable BiomeSpread> biomeSpread) {
		if (!original) return false;

		var biomeSpread1 = biomeSpread.get();
		if (biomeSpread1 != null) biomeSpread1.spread(level, pos);

		return true;
	}
}