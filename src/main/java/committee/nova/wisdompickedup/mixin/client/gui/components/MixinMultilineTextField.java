package committee.nova.wisdompickedup.mixin.client.gui.components;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.MultilineTextField;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = MultilineTextField.class, priority = 500)
public class MixinMultilineTextField {
    @Mutable
    @Shadow
    @Final
    private List<MultilineTextField.StringView> displayLines;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Font font, int i, CallbackInfo ci) {
        this.displayLines = new FastList<>(this.displayLines);
    }
}
