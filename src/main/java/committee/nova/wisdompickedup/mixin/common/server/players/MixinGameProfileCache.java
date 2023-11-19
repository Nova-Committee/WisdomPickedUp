package committee.nova.wisdompickedup.mixin.common.server.players;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import net.minecraft.server.players.GameProfileCache;
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Mixin(value = GameProfileCache.class, priority = 500)
public class MixinGameProfileCache {
    @Mutable
    @Shadow
    @Final
    private Map<String, GameProfileCache.GameProfileInfo> profilesByName;

    @Mutable
    @Shadow
    @Final
    private Map<UUID, GameProfileCache.GameProfileInfo> profilesByUUID;

    @Mutable
    @Shadow
    @Final
    private Map<String, CompletableFuture<Optional<GameProfile>>> requests;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(GameProfileRepository gameProfileRepository, File file, CallbackInfo ci) {
        this.profilesByName = ConcurrentHashMap.newMap(this.profilesByName);
        this.profilesByUUID = ConcurrentHashMap.newMap(this.profilesByUUID);
        this.requests = ConcurrentHashMap.newMap(this.requests);
    }
}
