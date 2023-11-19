package committee.nova.wisdompickedup.mixin.client.gui.screens.packs;

import net.minecraft.client.gui.screens.packs.PackSelectionModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackRepository;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Mixin(value = PackSelectionModel.class, priority = 500)
public class MixinPackSelectionModel {
    @Mutable
    @Shadow
    @Final
    List<Pack> selected;

    @Mutable
    @Shadow
    @Final
    List<Pack> unselected;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(
            Runnable runnable, Function<Pack, ResourceLocation> function,
            PackRepository packRepository, Consumer<PackRepository> consumer, CallbackInfo ci) {
        this.selected = new FastList<>(selected);
        this.unselected = new FastList<>(unselected);
    }
}
