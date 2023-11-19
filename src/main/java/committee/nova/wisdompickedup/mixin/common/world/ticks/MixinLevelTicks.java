package committee.nova.wisdompickedup.mixin.common.world.ticks;

import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.ticks.LevelTicks;
import net.minecraft.world.ticks.ScheduledTick;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Supplier;

@Mixin(value = LevelTicks.class, priority = 500)
public class MixinLevelTicks<T> {
    @Mutable
    @Shadow
    @Final
    private List<ScheduledTick<T>> alreadyRunThisTick;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(LongPredicate longPredicate, Supplier<ProfilerFiller> supplier, CallbackInfo ci) {
        this.alreadyRunThisTick = new FastList<>(this.alreadyRunThisTick);
    }
}
