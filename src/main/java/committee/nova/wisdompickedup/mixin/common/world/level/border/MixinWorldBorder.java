package committee.nova.wisdompickedup.mixin.common.world.level.border;

import net.minecraft.world.level.border.BorderChangeListener;
import net.minecraft.world.level.border.WorldBorder;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = WorldBorder.class, priority = 500)
public class MixinWorldBorder {
    @Mutable
    @Shadow
    @Final
    private List<BorderChangeListener> listeners;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.listeners = new FastList<>(this.listeners);
    }
}
