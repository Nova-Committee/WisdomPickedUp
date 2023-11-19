package committee.nova.wisdompickedup.mixin.client.gui.screens.inventory;

import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BeaconMenu;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = BeaconScreen.class, priority = 500)
public class MixinBeaconScreen {
    @Mutable
    @Shadow
    @Final
    private List<BeaconScreen.BeaconButton> beaconButtons;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(BeaconMenu beaconMenu, Inventory inventory, Component component, CallbackInfo ci) {
        this.beaconButtons = new FastList<>(this.beaconButtons);
    }
}
