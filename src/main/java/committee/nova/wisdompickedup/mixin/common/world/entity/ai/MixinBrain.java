package committee.nova.wisdompickedup.mixin.common.world.entity.ai;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.ExpirableValue;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

@Mixin(value = Brain.class, priority = 500)
public class MixinBrain<E extends LivingEntity> {
    @Mutable
    @Shadow
    @Final
    private Map<MemoryModuleType<?>, Optional<? extends ExpirableValue<?>>> memories;

    @Mutable
    @Shadow
    @Final
    private Map<Activity, Set<Pair<MemoryModuleType<?>, MemoryStatus>>> activityRequirements;

    @Mutable
    @Shadow
    @Final
    private Map<Activity, Set<MemoryModuleType<?>>> activityMemoriesToEraseWhenStopped;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Collection<? extends MemoryModuleType<?>> collection, Collection<? extends SensorType<? extends Sensor<? super E>>> collection2, ImmutableList<?> immutableList, Supplier<Codec<Brain<E>>> supplier, CallbackInfo ci) {
        this.memories = new UnifiedMap<>(this.memories);
        this.activityRequirements = new UnifiedMap<>(this.activityRequirements);
        this.activityMemoriesToEraseWhenStopped = new UnifiedMap<>(this.activityMemoriesToEraseWhenStopped);
    }
}
