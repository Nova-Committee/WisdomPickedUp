package committee.nova.wisdompickedup.mixin.common.world.damagesource;

import net.minecraft.world.damagesource.CombatEntry;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.entity.LivingEntity;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = CombatTracker.class, priority = 500)
public class MixinCombatTracker {
    @Mutable
    @Shadow
    @Final
    private List<CombatEntry> entries;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(LivingEntity livingEntity, CallbackInfo ci) {
        this.entries = new FastList<>(this.entries);
    }
}
