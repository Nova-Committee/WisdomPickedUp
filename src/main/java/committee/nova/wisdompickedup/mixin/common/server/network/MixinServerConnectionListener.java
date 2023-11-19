package committee.nova.wisdompickedup.mixin.common.server.network;

import io.netty.channel.ChannelFuture;
import net.minecraft.network.Connection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerConnectionListener;
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

@Mixin(value = ServerConnectionListener.class, priority = 500)
public class MixinServerConnectionListener {
    @Mutable
    @Shadow
    @Final
    List<Connection> connections;

    @Mutable
    @Shadow
    @Final
    private List<ChannelFuture> channels;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(MinecraftServer minecraftServer, CallbackInfo ci) {
        this.channels = SynchronizedMutableList.of(new FastList<>());
        this.connections = SynchronizedMutableList.of(new FastList<>());
    }
}
