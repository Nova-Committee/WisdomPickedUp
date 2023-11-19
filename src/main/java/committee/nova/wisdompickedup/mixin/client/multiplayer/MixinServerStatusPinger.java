package committee.nova.wisdompickedup.mixin.client.multiplayer;

import net.minecraft.client.multiplayer.ServerStatusPinger;
import net.minecraft.network.Connection;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.SynchronizedMutableList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ServerStatusPinger.class, priority = 500)
public class MixinServerStatusPinger {
    @Mutable
    @Shadow
    @Final
    private List<Connection> connections;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.connections = SynchronizedMutableList.of(new FastList<>());
    }
}
