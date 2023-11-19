package committee.nova.wisdompickedup.mixin.client.model.geom.builders;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
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

@Mixin(value = PartDefinition.class, priority = 500)
public class MixinPartDefinition {
    @Mutable
    @Shadow
    @Final
    private List<CubeDefinition> cubes;

    @Mutable
    @Shadow
    @Final
    private Map<String, PartDefinition> children;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(List<CubeDefinition> list, PartPose partPose, CallbackInfo ci) {
        this.cubes = FastList.newList(list);
        this.children = new UnifiedMap<>();
    }
}
