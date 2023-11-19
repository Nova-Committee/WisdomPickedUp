package committee.nova.wisdompickedup.mixin.client.sounds;

import com.mojang.blaze3d.audio.SoundBuffer;
import net.minecraft.client.sounds.SoundBufferLibrary;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mixin(value = SoundBufferLibrary.class, priority = 500)
public class MixinSoundBufferLibrary {
    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, CompletableFuture<SoundBuffer>> cache;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(ResourceProvider resourceProvider, CallbackInfo ci) {
        this.cache = new UnifiedMap<>(this.cache);
    }
}
