package committee.nova.wisdompickedup.mixin.common.stats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.RecipeBook;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(value = RecipeBook.class, priority = 500)
public class MixinRecipeBook {
    @Mutable
    @Shadow
    @Final
    protected Set<ResourceLocation> known;

    @Mutable
    @Shadow
    @Final
    protected Set<ResourceLocation> highlight;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.known = new UnifiedSet<>();
        this.highlight = new UnifiedSet<>();
    }
}
