package committee.nova.wisdompickedup.mixin.client.gui.screens.social;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.client.gui.screens.social.SocialInteractionsPlayerList;
import net.minecraft.client.gui.screens.social.SocialInteractionsScreen;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SocialInteractionsPlayerList.class, priority = 500)
public class MixinSocialInteractionsPlayerList {
    @Mutable
    @Shadow
    @Final
    private List<PlayerEntry> players;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(SocialInteractionsScreen socialInteractionsScreen, Minecraft minecraft, int i, int j, int k, int l, int m, CallbackInfo ci) {
        this.players = new FastList<>();
    }
}
