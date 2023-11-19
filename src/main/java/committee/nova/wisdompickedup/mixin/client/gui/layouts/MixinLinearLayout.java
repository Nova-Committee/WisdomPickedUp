package committee.nova.wisdompickedup.mixin.client.gui.layouts;

import net.minecraft.client.gui.layouts.LinearLayout;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = LinearLayout.class, priority = 500)
public class MixinLinearLayout {
    @Mutable
    @Shadow
    @Final
    private List<LinearLayout.ChildContainer> children;

    @Inject(method = "<init>(IIIILnet/minecraft/client/gui/layouts/LinearLayout$Orientation;)V", at = @At("RETURN"))
    private void inject$init(int i, int j, int k, int l, LinearLayout.Orientation orientation, CallbackInfo ci) {
        this.children = new FastList<>();
    }
}
