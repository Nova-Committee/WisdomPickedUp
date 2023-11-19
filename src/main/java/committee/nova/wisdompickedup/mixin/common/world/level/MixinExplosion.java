package committee.nova.wisdompickedup.mixin.common.world.level;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = Explosion.class, priority = 500)
public class MixinExplosion {
    @Mutable
    @Shadow
    @Final
    private Map<Player, Vec3> hitPlayers;

    @Inject(method = "<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/level/ExplosionDamageCalculator;DDDFZLnet/minecraft/world/level/Explosion$BlockInteraction;)V", at = @At("RETURN"))
    private void inject$init(Level level, Entity entity, DamageSource damageSource, ExplosionDamageCalculator explosionDamageCalculator, double d, double e, double f, float g, boolean bl, Explosion.BlockInteraction blockInteraction, CallbackInfo ci) {
        this.hitPlayers = new UnifiedMap<>(this.hitPlayers);
    }
}
