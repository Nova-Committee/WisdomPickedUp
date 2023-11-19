package committee.nova.wisdompickedup.mixin.common.server;

import com.mojang.datafixers.DataFixer;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;
import java.util.Set;

@Mixin(value = PlayerAdvancements.class, priority = 500)
public class MixinPlayerAdvancements {
    @Mutable
    @Shadow
    @Final
    private Set<Advancement> visible;

    @Mutable
    @Shadow
    @Final
    private Set<Advancement> progressChanged;

    @Mutable
    @Shadow
    @Final
    private Set<Advancement> rootsToUpdate;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(DataFixer dataFixer, PlayerList playerList, ServerAdvancementManager serverAdvancementManager, Path path, ServerPlayer serverPlayer, CallbackInfo ci) {
        this.visible = new UnifiedSet<>(this.visible);
        this.progressChanged = new UnifiedSet<>(this.progressChanged);
        this.rootsToUpdate = new UnifiedSet<>(this.rootsToUpdate);
    }
}
