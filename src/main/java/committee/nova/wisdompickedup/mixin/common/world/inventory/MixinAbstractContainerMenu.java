package committee.nova.wisdompickedup.mixin.common.world.inventory;

import net.minecraft.world.inventory.*;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;

@Mixin(value = AbstractContainerMenu.class, priority = 500)
public class MixinAbstractContainerMenu {
    @Mutable
    @Shadow
    @Final
    private List<DataSlot> dataSlots;

    @Mutable
    @Shadow
    @Final
    private Set<Slot> quickcraftSlots;

    @Mutable
    @Shadow
    @Final
    private List<ContainerListener> containerListeners;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(MenuType<?> menuType, int i, CallbackInfo ci) {
        this.dataSlots = new FastList<>();
        this.quickcraftSlots = new UnifiedSet<>();
        this.containerListeners = new FastList<>();
    }
}
