package committee.nova.wisdompickedup.mixin.client.gui.components;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.OptionsList;
import org.eclipse.collections.impl.map.immutable.ImmutableUnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = OptionsList.Entry.class, priority = 500)
public class MixinOptionsList$Entry {
    @Mutable
    @Shadow
    @Final
    Map<OptionInstance<?>, AbstractWidget> options;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Map<OptionInstance<?>, AbstractWidget> map, CallbackInfo ci) {
        this.options = new ImmutableUnifiedMap<>(map);
    }
}
