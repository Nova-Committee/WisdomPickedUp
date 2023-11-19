package committee.nova.wisdompickedup.mixin.client.gui.components;

import net.minecraft.client.GuiMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = ChatComponent.class, priority = 500)
public class MixinChatComponent {
    @Mutable
    @Shadow
    @Final
    private List<String> recentChat;

    @Mutable
    @Shadow
    @Final
    private List<GuiMessage> allMessages;

    @Mutable
    @Shadow
    @Final
    private List<GuiMessage.Line> trimmedMessages;

    @Mutable
    @Shadow
    @Final
    private List<ChatComponent.DelayedMessageDeletion> messageDeletionQueue;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Minecraft minecraft, CallbackInfo ci) {
        this.recentChat = new FastList<>(this.recentChat);
        this.allMessages = new FastList<>(this.allMessages);
        this.trimmedMessages = new FastList<>(this.trimmedMessages);
        this.messageDeletionQueue = new FastList<>(this.messageDeletionQueue);
    }
}
