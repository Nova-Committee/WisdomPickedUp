package committee.nova.wisdompickedup.mixin.client.gui.screens.multiplayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ServerSelectionList.class, priority = 500)
public class MixinServerSelectionList {
    @Mutable
    @Shadow
    @Final
    private List<ServerSelectionList.OnlineServerEntry> onlineServers;

    @Mutable
    @Shadow
    @Final
    private List<ServerSelectionList.NetworkServerEntry> networkServers;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(JoinMultiplayerScreen joinMultiplayerScreen, Minecraft minecraft, int i, int j, int k, int l, int m, CallbackInfo ci) {
        this.onlineServers = new FastList<>(this.onlineServers);
        this.networkServers = new FastList<>(this.networkServers);
    }
}
