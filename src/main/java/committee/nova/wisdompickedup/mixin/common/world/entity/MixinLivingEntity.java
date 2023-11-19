package committee.nova.wisdompickedup.mixin.common.world.entity;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = LivingEntity.class, priority = 500)
public class MixinLivingEntity {
    @Mutable
    @Shadow
    @Final
    private Map<MobEffect, MobEffectInstance> activeEffects;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(EntityType<? extends LivingEntity> entityType, Level level, CallbackInfo ci) {
        this.activeEffects = new UnifiedMap<>();
    }
}
