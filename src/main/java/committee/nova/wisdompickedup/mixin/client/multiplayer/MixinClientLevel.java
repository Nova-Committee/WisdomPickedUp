package committee.nova.wisdompickedup.mixin.client.multiplayer;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
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
import java.util.function.Supplier;

@Mixin(value = ClientLevel.class, priority = 500)
public class MixinClientLevel {
    @Mutable
    @Shadow
    @Final
    List<AbstractClientPlayer> players;

    @Mutable
    @Shadow
    @Final
    private Map<String, MapItemSavedData> mapData;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ClientPacketListener clientPacketListener, ClientLevel.ClientLevelData clientLevelData, ResourceKey<Level> resourceKey, Holder<DimensionType> holder, int i, int j, Supplier<ProfilerFiller> supplier, LevelRenderer levelRenderer, boolean bl, long l, CallbackInfo ci) {
        this.players = new FastList<>(this.players);
        this.mapData = new UnifiedMap<>(this.mapData);
    }
}
