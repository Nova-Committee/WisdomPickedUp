package committee.nova.wisdompickedup.mixin.common.advancements;

import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.CriterionProgress;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = AdvancementProgress.class, priority = 500)
public class MixinAdvancementProgress {

    @Mutable
    @Shadow
    @Final
    Map<String, CriterionProgress> criteria;

    @Inject(method = "<init>(Ljava/util/Map;)V", at = @At("RETURN"))
    private void inject$init(Map<String, CriterionProgress> map, CallbackInfo ci) {
        this.criteria = new UnifiedMap<>(this.criteria);
    }
}
