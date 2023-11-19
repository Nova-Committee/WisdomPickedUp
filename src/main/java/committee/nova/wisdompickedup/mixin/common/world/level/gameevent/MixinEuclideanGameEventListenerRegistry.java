package committee.nova.wisdompickedup.mixin.common.world.level.gameevent;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gameevent.EuclideanGameEventListenerRegistry;
import net.minecraft.world.level.gameevent.GameEventListener;
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

@Mixin(value = EuclideanGameEventListenerRegistry.class, priority = 500)
public class MixinEuclideanGameEventListenerRegistry {
    @Mutable
    @Shadow
    @Final
    private List<GameEventListener> listeners;

    @Mutable
    @Shadow
    @Final
    private List<GameEventListener> listenersToAdd;

    @Mutable
    @Shadow
    @Final
    private Set<GameEventListener> listenersToRemove;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ServerLevel serverLevel, int i, EuclideanGameEventListenerRegistry.OnEmptyAction onEmptyAction, CallbackInfo ci) {
        this.listeners = new FastList<>(this.listeners);
        this.listenersToAdd = new FastList<>(this.listenersToAdd);
        this.listenersToRemove = new UnifiedSet<>(this.listenersToRemove);
    }
}
