package committee.nova.wisdompickedup.mixin.common.world.level.storage;

import com.mojang.datafixers.DataFixer;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.Map;

@Mixin(value = DimensionDataStorage.class, priority = 500)
public class MixinDimensionDataStorage {
    @Mutable
    @Shadow
    @Final
    private Map<String, SavedData> cache;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(File file, DataFixer dataFixer, CallbackInfo ci) {
        this.cache = new UnifiedMap<>();
    }
}
