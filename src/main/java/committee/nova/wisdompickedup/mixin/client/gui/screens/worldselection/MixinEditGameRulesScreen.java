package committee.nova.wisdompickedup.mixin.client.gui.screens.worldselection;

import net.minecraft.client.gui.screens.worldselection.EditGameRulesScreen;
import net.minecraft.world.level.GameRules;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Mixin(value = EditGameRulesScreen.class, priority = 500)
public class MixinEditGameRulesScreen {
    @Mutable
    @Shadow
    @Final
    private Set<EditGameRulesScreen.RuleEntry> invalidEntries;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(GameRules gameRules, Consumer<Optional<GameRules>> consumer, CallbackInfo ci) {
        this.invalidEntries = new UnifiedSet<>(this.invalidEntries);
    }
}
