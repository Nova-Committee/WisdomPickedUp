package committee.nova.wisdompickedup.mixin.common.server.level;

import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.level.chunk.ChunkStatus;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ServerChunkCache.class, priority = 500)
public class MixinServerChunkCache {
    @Mutable
    @Shadow
    @Final
    private static List<ChunkStatus> CHUNK_STATUSES;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        CHUNK_STATUSES = new FastList<>(CHUNK_STATUSES);
    }
}
