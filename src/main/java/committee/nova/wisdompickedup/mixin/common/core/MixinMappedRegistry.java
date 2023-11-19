package committee.nova.wisdompickedup.mixin.common.core;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = MappedRegistry.class, priority = 500)
public class MixinMappedRegistry<T> {
    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, Holder.Reference<T>> byLocation;

    @Mutable
    @Shadow
    @Final
    private Map<ResourceKey<T>, Holder.Reference<T>> byKey;

    @Inject(method = "<init>(Lnet/minecraft/resources/ResourceKey;Lcom/mojang/serialization/Lifecycle;Z)V", at = @At("RETURN"))
    private void inject$init(ResourceKey<? extends Registry<T>> resourceKey, Lifecycle lifecycle, boolean bl, CallbackInfo ci) {
        this.byLocation = new UnifiedMap<>(this.byLocation);
        this.byKey = new UnifiedMap<>(this.byKey);
    }
}
