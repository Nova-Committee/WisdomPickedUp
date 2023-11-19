package committee.nova.wisdompickedup.mixin.common.server.players;

import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.stats.ServerStatsCounter;
import net.minecraft.world.level.storage.PlayerDataStorage;
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
import java.util.UUID;

@Mixin(value = PlayerList.class, priority = 500)
public class MixinPlayerList {
    @Mutable
    @Shadow
    @Final
    private List<ServerPlayer> players;

    @Mutable
    @Shadow
    @Final
    private Map<UUID, ServerPlayer> playersByUUID;

    @Mutable
    @Shadow
    @Final
    private Map<UUID, ServerStatsCounter> stats;

    @Mutable
    @Shadow
    @Final
    private Map<UUID, PlayerAdvancements> advancements;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(MinecraftServer minecraftServer, LayeredRegistryAccess<RegistryLayer> layeredRegistryAccess, PlayerDataStorage playerDataStorage, int i, CallbackInfo ci) {
        this.players = new FastList<>(this.players);
        this.playersByUUID = new UnifiedMap<>(this.playersByUUID);
        this.stats = new UnifiedMap<>(this.stats);
        this.advancements = new UnifiedMap<>(this.advancements);
    }
}
