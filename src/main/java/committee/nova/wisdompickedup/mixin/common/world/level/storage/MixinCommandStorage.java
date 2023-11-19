package committee.nova.wisdompickedup.mixin.common.world.level.storage;

import net.minecraft.world.level.storage.CommandStorage;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = CommandStorage.class, priority = 500)
public class MixinCommandStorage {
    @Mutable
    @Shadow
    @Final
    private Map<String, CommandStorage.Container> namespaces;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(DimensionDataStorage dimensionDataStorage, CallbackInfo ci) {
        this.namespaces = new UnifiedMap<>();
    }
}
