package committee.nova.wisdompickedup.mixin.client.gui.font;

import com.mojang.blaze3d.font.GlyphProvider;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(value = FontManager.class, priority = 500)
public class MixinFontManager {
    @Mutable
    @Shadow
    @Final
    private List<GlyphProvider> providersToClose;

    @Mutable
    @Shadow
    @Final
    private Map<ResourceLocation, FontSet> fontSets;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(TextureManager textureManager, CallbackInfo ci) {
        this.providersToClose = new FastList<>(this.providersToClose);
        this.fontSets = new UnifiedMap<>(this.fontSets);
    }
}
