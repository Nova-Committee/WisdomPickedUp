package committee.nova.wisdompickedup.mixin.client;

import net.minecraft.client.ComponentCollector;
import net.minecraft.network.chat.FormattedText;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ComponentCollector.class, priority = 500)
public class MixinComponentCollector {
    @Mutable
    @Shadow
    @Final
    private List<FormattedText> parts;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.parts = new FastList<>(this.parts);
    }
}
