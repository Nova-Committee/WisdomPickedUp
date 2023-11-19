package committee.nova.wisdompickedup.mixin.common.server.level;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.UnmodifiableMutableSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(value = ServerBossEvent.class, priority = 500)
public class MixinServerBossEvent {
    @Mutable
    @Shadow
    @Final
    private Set<ServerPlayer> players;

    @Mutable
    @Shadow
    @Final
    private Set<ServerPlayer> unmodifiablePlayers;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Component component, BossEvent.BossBarColor bossBarColor, BossEvent.BossBarOverlay bossBarOverlay, CallbackInfo ci) {
        this.players = new UnifiedSet<>();
        this.unmodifiablePlayers = UnmodifiableMutableSet.of(this.players);
    }
}
