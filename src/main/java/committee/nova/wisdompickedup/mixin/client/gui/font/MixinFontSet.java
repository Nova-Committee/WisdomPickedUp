package committee.nova.wisdompickedup.mixin.client.gui.font;

import com.mojang.blaze3d.font.GlyphProvider;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.font.FontTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = FontSet.class, priority = 500)
public class MixinFontSet {
    @Mutable
    @Shadow
    @Final
    private List<GlyphProvider> providers;

    @Mutable
    @Shadow
    @Final
    private List<FontTexture> textures;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(TextureManager textureManager, ResourceLocation resourceLocation, CallbackInfo ci) {
        this.providers = new FastList<>(this.providers);
        this.textures = new FastList<>(this.textures);
    }
}
