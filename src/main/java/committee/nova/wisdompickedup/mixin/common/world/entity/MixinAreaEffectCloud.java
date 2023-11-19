package committee.nova.wisdompickedup.mixin.common.world.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(value = AreaEffectCloud.class, priority = 500)
public class MixinAreaEffectCloud {
    @Mutable
    @Shadow
    @Final
    private List<MobEffectInstance> effects;

    @Mutable
    @Shadow
    @Final
    private Map<Entity, Integer> victims;

    @Inject(method = "<init>(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", at = @At("RETURN"))
    private void inject$init(EntityType<? extends AreaEffectCloud> entityType, Level level, CallbackInfo ci) {
        this.effects = new FastList<>();
        this.victims = new UnifiedMap<>();
    }
}
