package committee.nova.wisdompickedup.mixin.client.gui.components.toasts;

import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SystemToast.class, priority = 500)
public class MixinSystemToast {
    @Shadow
    private List<FormattedCharSequence> messageLines;

    @Inject(method = "<init>(Lnet/minecraft/client/gui/components/toasts/SystemToast$SystemToastIds;Lnet/minecraft/network/chat/Component;Ljava/util/List;I)V", at = @At("RETURN"))
    private void inject$init(SystemToast.SystemToastIds systemToastIds, Component component, List<FormattedCharSequence> list, int i, CallbackInfo ci) {
        this.messageLines = new FastList<>(this.messageLines);
    }
}
