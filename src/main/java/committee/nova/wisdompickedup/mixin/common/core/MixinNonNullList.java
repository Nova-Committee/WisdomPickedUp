package committee.nova.wisdompickedup.mixin.common.core;

import net.minecraft.core.NonNullList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = NonNullList.class, priority = 500)
public class MixinNonNullList<E> {
    @Mutable
    @Shadow
    @Final
    private List<E> list;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(List<E> list, Object object, CallbackInfo ci) {
        this.list = new FastList<>(this.list);
    }
}
