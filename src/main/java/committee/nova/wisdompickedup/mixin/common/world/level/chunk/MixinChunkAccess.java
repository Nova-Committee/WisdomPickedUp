package committee.nova.wisdompickedup.mixin.common.world.level.chunk;

import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.levelgen.blending.BlendingData;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
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

@Mixin(value = ChunkAccess.class, priority = 500)
public class MixinChunkAccess {
    @Mutable
    @Shadow
    @Final
    private Map<Structure, StructureStart> structureStarts;

    @Mutable
    @Shadow
    @Final
    private Map<Structure, LongSet> structuresRefences;

    @Mutable
    @Shadow
    @Final
    protected Map<BlockPos, CompoundTag> pendingBlockEntities;

    @Mutable
    @Shadow
    @Final
    protected Map<BlockPos, BlockEntity> blockEntities;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ChunkPos chunkPos, UpgradeData upgradeData, LevelHeightAccessor levelHeightAccessor, Registry<Biome> registry, long l, @Nullable LevelChunkSection[] levelChunkSections, @Nullable BlendingData blendingData, CallbackInfo ci) {
        this.structureStarts = new UnifiedMap<>(this.structureStarts);
        this.structuresRefences = new UnifiedMap<>(this.structuresRefences);
        this.pendingBlockEntities = new UnifiedMap<>(this.pendingBlockEntities);
        this.blockEntities = new UnifiedMap<>(this.blockEntities);
    }
}
