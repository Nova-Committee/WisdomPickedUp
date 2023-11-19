package committee.nova.wisdompickedup.mixin.client.multiplayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ServerList.class, priority = 500)
public class MixinServerList {
    @Mutable
    @Shadow
    @Final
    private List<ServerData> serverList;

    @Mutable
    @Shadow
    @Final
    private List<ServerData> hiddenServerList;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, CallbackInfo ci) {
        this.serverList = new FastList<>(this.serverList);
        this.hiddenServerList = new FastList<>(this.hiddenServerList);
    }
}
