package committee.nova.wisdompickedup.mixin.client.gui.components.toasts;

import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.world.item.crafting.Recipe;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = RecipeToast.class, priority = 500)
public class MixinRecipeToast {
    @Mutable
    @Shadow
    @Final
    private List<Recipe<?>> recipes;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Recipe<?> recipe, CallbackInfo ci) {
        this.recipes = new FastList<>(this.recipes);
    }
}
