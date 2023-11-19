package committee.nova.wisdompickedup.mixin.common.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = CriteriaTriggers.class, priority = 500)
public class MixinCriteriaTriggers {
    @Mutable
    @Shadow
    @Final
    private static Map<ResourceLocation, CriterionTrigger<?>> CRITERIA;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        CRITERIA = new UnifiedMap<>(CRITERIA);
    }
}
