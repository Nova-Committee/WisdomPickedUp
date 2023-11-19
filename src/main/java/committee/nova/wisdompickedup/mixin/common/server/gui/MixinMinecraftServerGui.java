package committee.nova.wisdompickedup.mixin.common.server.gui;

import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.gui.MinecraftServerGui;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(MinecraftServerGui.class)
public class MixinMinecraftServerGui {
    @Mutable
    @Shadow
    @Final
    private Collection<Runnable> finalizers;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(DedicatedServer dedicatedServer, CallbackInfo ci) {
        this.finalizers = new FastList<>(this.finalizers);
    }

}
