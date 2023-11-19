package committee.nova.wisdompickedup.mixin.common.world.level.timers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.timers.TimerCallback;
import net.minecraft.world.level.timers.TimerCallbacks;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = TimerCallbacks.class, priority = 500)
public class MixinTimerCallbacks<C> {
    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, TimerCallback.Serializer<C, ?>> idToSerializer;

    @Mutable
    @Shadow
    @Final
    private Map<Class<?>, TimerCallback.Serializer<C, ?>> classToSerializer;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.idToSerializer = new UnifiedMap<>(this.idToSerializer);
        this.classToSerializer = new UnifiedMap<>(this.classToSerializer);
    }
}
