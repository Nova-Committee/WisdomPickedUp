package committee.nova.wisdompickedup.mixin.client.gui.components.toasts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ToastComponent.class, priority = 500)
public class MixinToastComponent {
    @Mutable
    @Shadow
    @Final
    private List<ToastComponent.ToastInstance<?>> visible;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, CallbackInfo ci) {
        this.visible = new FastList<>(this.visible);
    }
}
