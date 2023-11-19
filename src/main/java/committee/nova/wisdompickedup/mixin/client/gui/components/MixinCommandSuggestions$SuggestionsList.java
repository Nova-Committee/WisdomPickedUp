package committee.nova.wisdompickedup.mixin.client.gui.components;

import com.mojang.brigadier.suggestion.Suggestion;
import net.minecraft.client.gui.components.CommandSuggestions;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = CommandSuggestions.SuggestionsList.class, priority = 500)
public class MixinCommandSuggestions$SuggestionsList {
    @Mutable
    @Shadow
    @Final
    private List<Suggestion> suggestionList;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CommandSuggestions commandSuggestions, int i, int j, int k, List<Suggestion> list, boolean bl, CallbackInfo ci) {
        this.suggestionList = new FastList<>(list);
    }
}
