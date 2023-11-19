package committee.nova.wisdompickedup.mixin.common.world.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(value = LightningBolt.class, priority = 500)
public class MixinLightningBolt {
    @Mutable
    @Shadow
    @Final
    private Set<Entity> hitEntities;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(EntityType<? extends LightningBolt> entityType, Level level, CallbackInfo ci) {
        this.hitEntities = new UnifiedSet<>(this.hitEntities);
    }
}
