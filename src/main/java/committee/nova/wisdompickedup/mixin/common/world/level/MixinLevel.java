package committee.nova.wisdompickedup.mixin.common.world.level;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.storage.WritableLevelData;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Supplier;

@Mixin(value = Level.class, priority = 500)
public class MixinLevel {
    @Mutable
    @Shadow
    @Final
    protected List<TickingBlockEntity> blockEntityTickers;

    @Mutable
    @Shadow
    @Final
    private List<TickingBlockEntity> pendingBlockEntityTickers;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(WritableLevelData writableLevelData, ResourceKey resourceKey, RegistryAccess registryAccess, Holder holder, Supplier supplier, boolean bl, boolean bl2, long l, int i, CallbackInfo ci) {
        this.blockEntityTickers = new FastList<>();
        this.pendingBlockEntityTickers = new FastList<>();
    }
}
