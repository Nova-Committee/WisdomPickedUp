package committee.nova.wisdompickedup.mixin.client.gui.screens;

import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = Screen.class, priority = 500)
public class MixinScreen {
    @Mutable
    @Shadow
    @Final
    private List<GuiEventListener> children;

    @Mutable
    @Shadow
    @Final
    private List<NarratableEntry> narratables;

    @Mutable
    @Shadow
    @Final
    private List<Renderable> renderables;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Component component, CallbackInfo ci) {
        this.children = new FastList<>();
        this.narratables = new FastList<>();
        this.renderables = new FastList<>();
    }
}
