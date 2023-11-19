package committee.nova.wisdompickedup.mixin.common.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = SpawnPlacements.class, priority = 500)
public class MixinSpawnPlacements {
    @Mutable
    @Shadow
    @Final
    private static Map<EntityType<?>, SpawnPlacements.Data> DATA_BY_TYPE;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        DATA_BY_TYPE = new UnifiedMap<>(DATA_BY_TYPE);
    }
}
