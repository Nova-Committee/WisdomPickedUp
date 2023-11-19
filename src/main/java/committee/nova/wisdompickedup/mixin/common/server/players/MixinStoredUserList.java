package committee.nova.wisdompickedup.mixin.common.server.players;

import net.minecraft.server.players.StoredUserEntry;
import net.minecraft.server.players.StoredUserList;
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

@Mixin(value = StoredUserList.class, priority = 500)
public class MixinStoredUserList<K, V extends StoredUserEntry<K>> {
    @Mutable
    @Shadow
    @Final
    private Map<String, V> map;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(File file, CallbackInfo ci) {
        this.map = new UnifiedMap<>(this.map);
    }
}
