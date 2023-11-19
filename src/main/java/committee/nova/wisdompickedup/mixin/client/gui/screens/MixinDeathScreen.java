package committee.nova.wisdompickedup.mixin.client.gui.screens;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.DeathScreen;
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

@Mixin(value = DeathScreen.class, priority = 500)
public class MixinDeathScreen {
    @Mutable
    @Shadow
    @Final
    private List<Button> exitButtons;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Component component, boolean bl, CallbackInfo ci) {
        this.exitButtons = new FastList<>(this.exitButtons);
    }
}
