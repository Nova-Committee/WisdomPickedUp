package committee.nova.wisdompickedup.mixin.client.gui.screens.packs;

import net.minecraft.client.gui.screens.packs.PackSelectionScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.PackRepository;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.Consumer;

@Mixin(value = PackSelectionScreen.class, priority = 500)
public class MixinPackSelectionScreen {
    @Mutable
    @Shadow
    @Final
    private Map<String, ResourceLocation> packIcons;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(PackRepository packRepository, Consumer<PackRepository> consumer, Path path, Component component, CallbackInfo ci) {
        this.packIcons = new UnifiedMap<>();
    }
}
