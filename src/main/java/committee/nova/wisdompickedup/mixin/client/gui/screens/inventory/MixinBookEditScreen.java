package committee.nova.wisdompickedup.mixin.client.gui.screens.inventory;

import net.minecraft.client.gui.screens.inventory.BookEditScreen;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = BookEditScreen.class, priority = 500)
public class MixinBookEditScreen {
    @Mutable
    @Shadow
    @Final
    private List<String> pages;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Player player, ItemStack itemStack, InteractionHand interactionHand, CallbackInfo ci) {
        this.pages = new FastList<>(this.pages);
    }
}
