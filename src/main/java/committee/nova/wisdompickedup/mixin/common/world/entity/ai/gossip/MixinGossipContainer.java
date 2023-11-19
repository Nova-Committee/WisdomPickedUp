package committee.nova.wisdompickedup.mixin.common.world.entity.ai.gossip;

import net.minecraft.world.entity.ai.gossip.GossipContainer;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.UUID;

@Mixin(value = GossipContainer.class, priority = 500)
public class MixinGossipContainer {
    @Mutable
    @Shadow
    @Final
    private Map<UUID, GossipContainer.EntityGossips> gossips;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.gossips = new UnifiedMap<>(this.gossips);
    }
}
