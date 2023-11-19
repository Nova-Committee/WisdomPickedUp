package committee.nova.wisdompickedup.mixin.client.gui.narration;

import net.minecraft.client.gui.narration.ScreenNarrationCollector;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = ScreenNarrationCollector.class, priority = 500)
public class MixinScreenNarrationCollector {
    @Mutable
    @Shadow
    @Final
    Map<ScreenNarrationCollector.EntryKey, ScreenNarrationCollector.NarrationEntry> entries;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.entries = new UnifiedMap<>();
    }
}
