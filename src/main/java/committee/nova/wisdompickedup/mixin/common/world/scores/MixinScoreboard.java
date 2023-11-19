package committee.nova.wisdompickedup.mixin.common.world.scores;

import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Score;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
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

@Mixin(value = Scoreboard.class, priority = 500)
public class MixinScoreboard {
    @Mutable
    @Shadow
    @Final
    private Map<String, Objective> objectivesByName;

    @Mutable
    @Shadow
    @Final
    private Map<ObjectiveCriteria, List<Objective>> objectivesByCriteria;

    @Mutable
    @Shadow
    @Final
    private Map<String, Map<Objective, Score>> playerScores;

    @Mutable
    @Shadow
    @Final
    private Map<String, PlayerTeam> teamsByName;

    @Mutable
    @Shadow
    @Final
    private Map<String, PlayerTeam> teamsByPlayer;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(CallbackInfo ci) {
        this.objectivesByName = new UnifiedMap<>();
        this.objectivesByCriteria = new UnifiedMap<>();
        this.playerScores = new UnifiedMap<>();
        this.teamsByName = new UnifiedMap<>();
        this.teamsByPlayer = new UnifiedMap<>();
    }
}
