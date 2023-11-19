package committee.nova.wisdompickedup.mixin.client.model.geom;

import net.minecraft.client.model.geom.ModelPart;
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

@Mixin(value = ModelPart.class, priority = 500)
public class MixinModelPart {
    @Mutable
    @Shadow
    @Final
    private Map<String, ModelPart> children;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(List<ModelPart.Cube> list, Map<String, ModelPart> map, CallbackInfo ci) {
        this.children = new UnifiedMap<>(map);
    }
}
