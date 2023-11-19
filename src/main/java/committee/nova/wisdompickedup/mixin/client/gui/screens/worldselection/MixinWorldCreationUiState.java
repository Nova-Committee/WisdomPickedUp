package committee.nova.wisdompickedup.mixin.client.gui.screens.worldselection;

import net.minecraft.client.gui.screens.worldselection.WorldCreationContext;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Consumer;

@Mixin(value = WorldCreationUiState.class, priority = 500)
public class MixinWorldCreationUiState {
    @Mutable
    @Shadow
    @Final
    private List<WorldCreationUiState.WorldTypeEntry> altPresetList;

    @Mutable
    @Shadow
    @Final
    private List<Consumer<WorldCreationUiState>> listeners;

    @Mutable
    @Shadow
    @Final
    private List<WorldCreationUiState.WorldTypeEntry> normalPresetList;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Path path, WorldCreationContext worldCreationContext, Optional<ResourceKey<WorldPreset>> optional, OptionalLong optionalLong, CallbackInfo ci) {
        this.listeners = new FastList<>(this.listeners);
        this.normalPresetList = new FastList<>(this.normalPresetList);
        this.altPresetList = new FastList<>(this.altPresetList);
    }
}
