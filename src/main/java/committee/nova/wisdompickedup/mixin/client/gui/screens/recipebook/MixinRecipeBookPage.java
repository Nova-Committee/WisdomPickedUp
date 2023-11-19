package committee.nova.wisdompickedup.mixin.client.gui.screens.recipebook;

import net.minecraft.client.gui.screens.recipebook.RecipeBookPage;
import net.minecraft.client.gui.screens.recipebook.RecipeButton;
import net.minecraft.client.gui.screens.recipebook.RecipeShownListener;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = RecipeBookPage.class, priority = 500)
public class MixinRecipeBookPage {
    @Mutable
    @Shadow
    @Final
    private List<RecipeButton> buttons;

    @Mutable
    @Shadow
    @Final
    private List<RecipeShownListener> showListeners;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.buttons = new FastList<>(this.buttons);
        this.showListeners = new FastList<>(this.showListeners);
    }
}
