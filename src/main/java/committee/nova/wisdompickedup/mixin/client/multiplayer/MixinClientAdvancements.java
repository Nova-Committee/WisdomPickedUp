package committee.nova.wisdompickedup.mixin.client.multiplayer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.minecraft.client.telemetry.WorldSessionTelemetryManager;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = ClientAdvancements.class, priority = 500)
public class MixinClientAdvancements {
    @Mutable
    @Shadow
    @Final
    private Map<Advancement, AdvancementProgress> progress;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, WorldSessionTelemetryManager worldSessionTelemetryManager, CallbackInfo ci) {
        this.progress = new UnifiedMap<>();
    }
}
