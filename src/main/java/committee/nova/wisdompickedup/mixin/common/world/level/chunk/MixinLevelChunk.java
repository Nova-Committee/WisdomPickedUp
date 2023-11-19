package committee.nova.wisdompickedup.mixin.common.world.level.chunk;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.ticks.LevelChunkTicks;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = LevelChunk.class, priority = 500)
public class MixinLevelChunk {
    @Mutable
    @Shadow
    @Final
    private Map<BlockPos, LevelChunk.RebindableTickingBlockEntityWrapper> tickersInLevel;

    @Inject(method = "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/ChunkPos;Lnet/minecraft/world/level/chunk/UpgradeData;Lnet/minecraft/world/ticks/LevelChunkTicks;Lnet/minecraft/world/ticks/LevelChunkTicks;J[Lnet/minecraft/world/level/chunk/LevelChunkSection;Lnet/minecraft/world/level/chunk/LevelChunk$PostLoadProcessor;Lnet/minecraft/world/level/levelgen/blending/BlendingData;)V", at = @At("RETURN"))
    private void inject$init(Level level, ChunkPos chunkPos, UpgradeData upgradeData, LevelChunkTicks<Block> levelChunkTicks, LevelChunkTicks<Fluid> levelChunkTicks2, long l, @Nullable LevelChunkSection[] levelChunkSections, @Nullable LevelChunk.PostLoadProcessor postLoadProcessor, @Nullable BlendingData blendingData, CallbackInfo ci) {
        this.tickersInLevel = new UnifiedMap<>();
    }
}
