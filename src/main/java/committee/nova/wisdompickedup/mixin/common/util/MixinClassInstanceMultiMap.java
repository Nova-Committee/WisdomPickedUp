package committee.nova.wisdompickedup.mixin.common.util;

import net.minecraft.util.ClassInstanceMultiMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(value = ClassInstanceMultiMap.class, priority = 500)
public class MixinClassInstanceMultiMap<T> {
    @Mutable
    @Shadow
    @Final
    private Map<Class<?>, List<T>> byClass;

    @Mutable
    @Shadow
    @Final
    private List<T> allInstances;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Class<T> class_, CallbackInfo ci) {
        this.byClass = new UnifiedMap<>();
        this.allInstances = new FastList<>();
    }
}
