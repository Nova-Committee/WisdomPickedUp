package committee.nova.wisdompickedup.mixin.client.gui.screens.inventory;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(value = AbstractContainerScreen.class, priority = 500)
public class MixinAbstractContainerScreen {
    @Mutable
    @Shadow
    @Final
    protected Set<Slot> quickCraftSlots;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(AbstractContainerMenu abstractContainerMenu, Inventory inventory, Component component, CallbackInfo ci) {
        this.quickCraftSlots = new UnifiedSet<>();
    }
}
