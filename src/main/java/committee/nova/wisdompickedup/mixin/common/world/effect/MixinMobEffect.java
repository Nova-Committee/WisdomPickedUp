package committee.nova.wisdompickedup.mixin.common.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = MobEffect.class, priority = 500)
public class MixinMobEffect {
    @Mutable
    @Shadow
    @Final
    private Map<Attribute, AttributeModifier> attributeModifiers;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(MobEffectCategory mobEffectCategory, int i, CallbackInfo ci) {
        this.attributeModifiers = new UnifiedMap<>();
    }
}
