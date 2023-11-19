package committee.nova.wisdompickedup.mixin.client.gui.screens.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.advancements.AdvancementTab;
import net.minecraft.client.gui.screens.advancements.AdvancementWidget;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = AdvancementWidget.class, priority = 500)
public class MixinAdvancementWidget {
    @Mutable
    @Shadow
    @Final
    private List<AdvancementWidget> children;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(AdvancementTab advancementTab, Minecraft minecraft, Advancement advancement, DisplayInfo displayInfo, CallbackInfo ci) {
        this.children = new FastList<>(this.children);
    }
}
