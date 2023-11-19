package committee.nova.wisdompickedup.mixin.client.multiplayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(value = ClientSuggestionProvider.class, priority = 500)
public class MixinClientSuggestionProvider {
    @Mutable
    @Shadow
    @Final
    private Set<String> customCompletionSuggestions;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ClientPacketListener clientPacketListener, Minecraft minecraft, CallbackInfo ci) {
        this.customCompletionSuggestions = new UnifiedSet<>();
    }
}
