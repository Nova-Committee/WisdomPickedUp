package committee.nova.wisdompickedup.mixin.common.network.chat;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = MutableComponent.class, priority = 500)
public class MixinMutableComponent {
    @Mutable
    @Shadow
    @Final
    private List<Component> siblings;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ComponentContents componentContents, List<Component> list, Style style, CallbackInfo ci) {
        this.siblings = new FastList<>(this.siblings);
    }

}
