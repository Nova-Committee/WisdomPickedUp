package committee.nova.wisdompickedup.mixin.common.server.level;

import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.DistanceManager;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;
import java.util.concurrent.Executor;

@Mixin(value = DistanceManager.class, priority = 500)
public class MixinDistanceManager {
    @Mutable
    @Shadow
    @Final
    Set<ChunkHolder> chunksToUpdateFutures;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Executor executor, Executor executor2, CallbackInfo ci) {
        this.chunksToUpdateFutures = new UnifiedSet<>(this.chunksToUpdateFutures);
    }
}
