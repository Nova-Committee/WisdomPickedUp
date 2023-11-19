package committee.nova.wisdompickedup.mixin.client.sounds;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.client.sounds.Weighted;
import net.minecraft.resources.ResourceLocation;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = WeighedSoundEvents.class, priority = 500)
public class MixinWeighedSoundEvents {
    @Mutable
    @Shadow
    @Final
    private List<Weighted<Sound>> list;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ResourceLocation resourceLocation, String string, CallbackInfo ci) {
        this.list = new FastList<>();
    }
}
