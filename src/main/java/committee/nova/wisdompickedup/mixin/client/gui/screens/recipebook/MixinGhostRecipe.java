package committee.nova.wisdompickedup.mixin.client.gui.screens.recipebook;

import net.minecraft.client.gui.screens.recipebook.GhostRecipe;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = GhostRecipe.class, priority = 500)
public class MixinGhostRecipe {
    @Mutable
    @Shadow
    @Final
    private List<GhostRecipe.GhostIngredient> ingredients;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.ingredients = new FastList<>();
    }
}
