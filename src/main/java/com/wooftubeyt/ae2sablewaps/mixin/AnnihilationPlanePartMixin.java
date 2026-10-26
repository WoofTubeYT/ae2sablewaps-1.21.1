package com.wooftubeyt.ae2sablewaps.mixin;



import appeng.api.behaviors.PickupStrategy;
import appeng.parts.automation.AnnihilationPlanePart;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.wooftubeyt.ae2sablewaps.ae2sablewaps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;


@Mixin(AnnihilationPlanePart.class)
public class AnnihilationPlanePartMixin {
    @ModifyExpressionValue(
            method = "tickingRequest",
            at = @At(value = "INVOKE", target = "Lappeng/parts/automation/AnnihilationPlanePart;getPickupStrategies()Ljava/util/List;")
    )
    private List<PickupStrategy> doNothing(List<PickupStrategy> original) {
        ae2sablewaps.LOGGER.info(original.toString());
        return original;
    }
}

    /*@Inject(
            method = "getPickupStrategies",
            at = @At("HEAD"),
            cancellable = false
    ) private void logPls(CallbackInfoReturnable<List<PickupStrategy>> cir){
        BlockPos blockPos = self.getBlockPos();
        Level level = self.getLevel();
        Vector3d position = new Vector3d(
                original.getX(),
                original.getY(),
                original.getZ()
        );


        // its so peak...
        position = SableCompanion.INSTANCE.projectOutOfSubLevel(position);
    }*/
