package committee.nova.wisdompickedup.mixin.client.gui.screens.social;

import com.mojang.authlib.minecraft.UserApiService;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.social.PlayerSocialManager;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Mixin(value = PlayerSocialManager.class, priority = 500)
public class MixinPlayerSocialManager {
    @Mutable
    @Shadow
    @Final
    private Set<UUID> hiddenPlayers;

    @Mutable
    @Shadow
    @Final
    private Map<String, UUID> discoveredNamesToUUID;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, UserApiService userApiService, CallbackInfo ci) {
        this.hiddenPlayers = new UnifiedSet<>(this.hiddenPlayers);
        this.discoveredNamesToUUID = new UnifiedMap<>(this.discoveredNamesToUUID);
    }
}
