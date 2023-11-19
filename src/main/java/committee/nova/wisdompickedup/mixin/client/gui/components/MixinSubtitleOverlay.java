package committee.nova.wisdompickedup.mixin.client.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.SubtitleOverlay;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SubtitleOverlay.class, priority = 500)
public class MixinSubtitleOverlay {
    @Mutable
    @Shadow
    @Final
    private List<SubtitleOverlay.Subtitle> subtitles;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, CallbackInfo ci) {
        this.subtitles = new FastList<>();
    }
}
