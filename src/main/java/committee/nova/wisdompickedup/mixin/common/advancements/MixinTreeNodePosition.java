package committee.nova.wisdompickedup.mixin.common.advancements;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.TreeNodePosition;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = TreeNodePosition.class, priority = 500)
public class MixinTreeNodePosition {
    @Mutable
    @Shadow
    @Final
    private List<TreeNodePosition> children;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(Advancement advancement, TreeNodePosition treeNodePosition, TreeNodePosition treeNodePosition2, int i, int j, CallbackInfo ci) {
        this.children = new FastList<>(this.children);
    }
}
