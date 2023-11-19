package committee.nova.wisdompickedup.mixin;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(value = Arrays.class, remap = false)
public class MixinArrays {
    @Inject(method = "asList", at = @At("HEAD"), cancellable = true, remap = false)
    private static <T> void inject$asList(T[] a, CallbackInfoReturnable<List<T>> cir) {
        cir.setReturnValue(FastList.wrapCopy(a));
    }
}
