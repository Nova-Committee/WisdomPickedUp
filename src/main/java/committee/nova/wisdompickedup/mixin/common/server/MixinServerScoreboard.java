package committee.nova.wisdompickedup.mixin.common.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerScoreboard;
import net.minecraft.world.scores.Objective;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;

@Mixin(ServerScoreboard.class)
public class MixinServerScoreboard {
    @Mutable
    @Shadow
    @Final
    private List<Runnable> dirtyListeners;

    @Mutable
    @Shadow
    @Final
    private Set<Objective> trackedObjectives;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(MinecraftServer minecraftServer, CallbackInfo ci) {
        this.trackedObjectives = new UnifiedSet<>();
        this.dirtyListeners = new FastList<>();
    }
}
