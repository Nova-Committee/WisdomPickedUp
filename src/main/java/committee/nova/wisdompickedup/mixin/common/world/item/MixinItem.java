package committee.nova.wisdompickedup.mixin.common.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = Item.class, priority = 500)
public class MixinItem {
    @Mutable
    @Shadow
    @Final
    public static Map<Block, Item> BY_BLOCK;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void inject$clinit(CallbackInfo ci) {
        BY_BLOCK = new UnifiedMap<>(BY_BLOCK);
    }
}
