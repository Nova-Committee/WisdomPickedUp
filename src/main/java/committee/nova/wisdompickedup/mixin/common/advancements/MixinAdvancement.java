package committee.nova.wisdompickedup.mixin.common.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.DisplayInfo;
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

@Mixin(value = Advancement.class, priority = 500)
public class MixinAdvancement {
    @Mutable
    @Shadow
    @Final
    private Map<String, Criterion> criteria;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ResourceLocation resourceLocation, Advancement advancement, DisplayInfo displayInfo, AdvancementRewards advancementRewards, Map<String, Criterion> map, String[][] strings, boolean bl, CallbackInfo ci) {
        this.criteria = new UnifiedMap<>(this.criteria);
    }
}
