package committee.nova.wisdompickedup.mixin.client.gui.layouts;

import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = GridLayout.class, priority = 500)
public class MixinGridLayout {
    @Mutable
    @Shadow
    @Final
    private List<LayoutElement> children;

    @Mutable
    @Shadow
    @Final
    private List<GridLayout.CellInhabitant> cellInhabitants;

    @Inject(method = "<init>(II)V", at = @At("RETURN"))
    private void inject$init(int i, int j, CallbackInfo ci) {
        this.children = new FastList<>(this.children);
        this.cellInhabitants = new FastList<>(this.cellInhabitants);
    }
}
