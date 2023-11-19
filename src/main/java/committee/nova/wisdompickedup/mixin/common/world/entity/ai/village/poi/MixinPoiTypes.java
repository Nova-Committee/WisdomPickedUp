package committee.nova.wisdompickedup.mixin.common.world.entity.ai.village.poi;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = PoiTypes.class, priority = 500)
public class MixinPoiTypes {
    @Mutable
    @Shadow
    @Final
    private static Map<BlockState, Holder<PoiType>> TYPE_BY_STATE;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        TYPE_BY_STATE = new UnifiedMap<>(TYPE_BY_STATE);
    }
}
