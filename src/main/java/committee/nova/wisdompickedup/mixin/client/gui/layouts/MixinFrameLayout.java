package committee.nova.wisdompickedup.mixin.client.gui.layouts;

import net.minecraft.client.gui.layouts.FrameLayout;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = FrameLayout.class, priority = 500)
public class MixinFrameLayout {
    @Mutable
    @Shadow
    @Final
    private List<FrameLayout.ChildContainer> children;

    @Inject(method = "<init>(IIII)V", at = @At("RETURN"))
    private void inject$init(int i, int j, int k, int l, CallbackInfo ci) {
        this.children = new FastList<>(this.children);
    }
}
