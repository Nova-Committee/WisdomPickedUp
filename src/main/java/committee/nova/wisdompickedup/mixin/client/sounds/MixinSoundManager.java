package committee.nova.wisdompickedup.mixin.client.sounds;

import net.minecraft.client.Options;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
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

@Mixin(value = SoundManager.class, priority = 500)
public class MixinSoundManager {
    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, Resource> soundCache;

    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, WeighedSoundEvents> registry;

    @Mutable
    @Shadow
    @Final
    private SoundEngine soundEngine;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Options options, CallbackInfo ci) {
        this.registry = new UnifiedMap<>();
        this.soundCache = new UnifiedMap<>();
        this.soundEngine = new SoundEngine((SoundManager) (Object) this, options, ResourceProvider.fromMap(this.soundCache));
    }
}
