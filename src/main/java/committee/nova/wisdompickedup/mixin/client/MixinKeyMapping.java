package committee.nova.wisdompickedup.mixin.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Set;

@Mixin(value = KeyMapping.class, priority = 500)
public class MixinKeyMapping {
    @Mutable
    @Shadow
    @Final
    private static Map<String, KeyMapping> ALL;

    @Mutable
    @Shadow
    @Final
    private static Map<InputConstants.Key, KeyMapping> MAP;

    @Mutable
    @Shadow
    @Final
    private static Set<String> CATEGORIES;

    @Mutable
    @Shadow
    @Final
    private static Map<String, Integer> CATEGORY_SORT_ORDER;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        ALL = new UnifiedMap<>();
        MAP = new UnifiedMap<>();
        CATEGORIES = new UnifiedSet<>();
        CATEGORY_SORT_ORDER = UnifiedMap.newMap(CATEGORY_SORT_ORDER);
    }
}
