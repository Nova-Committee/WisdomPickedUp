package committee.nova.wisdompickedup.mixin.common.world.level.chunk;

import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.ticks.SavedTick;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = UpgradeData.class, priority = 500)
public class MixinUpgradeData {
    @Mutable
    @Shadow
    @Final
    private List<SavedTick<Block>> neighborBlockTicks;

    @Mutable
    @Shadow
    @Final
    private List<SavedTick<Fluid>> neighborFluidTicks;

    @Inject(method = "<init>(Lnet/minecraft/world/level/LevelHeightAccessor;)V", at = @At("RETURN"))
    private void inject$init(LevelHeightAccessor levelHeightAccessor, CallbackInfo ci) {
        this.neighborBlockTicks = new FastList<>(this.neighborBlockTicks);
        this.neighborFluidTicks = new FastList<>(this.neighborFluidTicks);
    }
}
