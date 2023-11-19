package committee.nova.wisdompickedup.mixin.client.resources;

import net.minecraft.client.User;
import net.minecraft.client.resources.SplashManager;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SplashManager.class, priority = 500)
public class MixinSplashManager {
    @Mutable
    @Shadow
    @Final
    private List<String> splashes;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(User user, CallbackInfo ci) {
        this.splashes = new FastList<>();
    }
}
