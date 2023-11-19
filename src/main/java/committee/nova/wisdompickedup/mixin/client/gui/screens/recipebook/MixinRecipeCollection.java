package committee.nova.wisdompickedup.mixin.client.gui.screens.recipebook;

import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.Recipe;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;

@Mixin(value = RecipeCollection.class, priority = 500)
public class MixinRecipeCollection {
    @Mutable
    @Shadow
    @Final
    private Set<Recipe<?>> craftable;

    @Mutable
    @Shadow
    @Final
    private Set<Recipe<?>> fitsDimensions;

    @Mutable
    @Shadow
    @Final
    private Set<Recipe<?>> known;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(RegistryAccess registryAccess, List<Recipe<?>> list, CallbackInfo ci) {
        this.craftable = new UnifiedSet<>(this.craftable);
        this.fitsDimensions = new UnifiedSet<>(this.fitsDimensions);
        this.known = new UnifiedSet<>(this.known);
    }
}
