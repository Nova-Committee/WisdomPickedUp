package committee.nova.wisdompickedup.mixin.common.server.bossevents;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.bossevents.CustomBossEvent;
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

@Mixin(value = CustomBossEvent.class, priority = 500)
public class MixinCustomBossEvent {
    @Mutable
    @Shadow
    @Final
    private Set<UUID> players;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ResourceLocation resourceLocation, Component component, CallbackInfo ci) {
        this.players = new UnifiedSet<>();
    }
}
