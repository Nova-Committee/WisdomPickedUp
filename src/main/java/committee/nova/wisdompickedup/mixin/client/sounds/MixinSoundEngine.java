package committee.nova.wisdompickedup.mixin.client.sounds;

import net.minecraft.client.Options;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundEventListener;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(value = SoundEngine.class, priority = 500)
public class MixinSoundEngine {
    @Mutable
    @Shadow
    @Final
    private static Set<ResourceLocation> ONLY_WARN_ONCE;

    @Mutable
    @Shadow
    @Final
    private Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel;

    @Mutable
    @Shadow
    @Final
    private List<TickableSoundInstance> tickingSounds;

    @Mutable
    @Shadow
    @Final
    private Map<SoundInstance, Integer> queuedSounds;

    @Mutable
    @Shadow
    @Final
    private Map<SoundInstance, Integer> soundDeleteTime;

    @Mutable
    @Shadow
    @Final
    private List<SoundEventListener> listeners;

    @Mutable
    @Shadow
    @Final
    private List<TickableSoundInstance> queuedTickableSounds;

    @Mutable
    @Shadow
    @Final
    private List<Sound> preloadQueue;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(SoundManager soundManager, Options options, ResourceProvider resourceProvider, CallbackInfo ci) {
        this.instanceToChannel = new UnifiedMap<>();
        this.tickingSounds = new FastList<>();
        this.queuedSounds = new UnifiedMap<>();
        this.soundDeleteTime = new UnifiedMap<>();
        this.listeners = new FastList<>();
        this.queuedTickableSounds = new FastList<>();
        this.preloadQueue = new FastList<>();
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        ONLY_WARN_ONCE = new UnifiedSet<>();
    }
}
