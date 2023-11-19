package committee.nova.wisdompickedup.mixin.common.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;
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

@Mixin(value = AdvancementList.class, priority = 500)
public class MixinAdvancementList {
    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, Advancement> advancements;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.advancements = new UnifiedMap<>(this.advancements);
    }
}
