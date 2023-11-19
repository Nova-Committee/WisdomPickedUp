package committee.nova.wisdompickedup.mixin.common.world.level.entity;

import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntityPersistentStorage;
import net.minecraft.world.level.entity.LevelCallback;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;
import java.util.UUID;

@Mixin(value = PersistentEntitySectionManager.class, priority = 500)
public class MixinPersistentEntitySectionManager<T extends EntityAccess> {
    @Mutable
    @Shadow
    @Final
    Set<UUID> knownUuids;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Class<T> class_, LevelCallback<T> levelCallback, EntityPersistentStorage<T> entityPersistentStorage, CallbackInfo ci) {
        this.knownUuids = new UnifiedSet<>();
    }
}
