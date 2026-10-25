package com.wooftubeyt.ae2sablewaps.mixin;

import appeng.api.util.DimensionalBlockPos;
import appeng.helpers.WirelessTerminalMenuHost;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.ryanhcode.sable.companion.SableCompanion;

import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;



@Mixin(WirelessTerminalMenuHost.class)
public class WirelessTerminalMenuHostMixin {

    @ModifyExpressionValue(
            method = "getAccessPointSignal",
            at = @At(value = "INVOKE", target = "Lappeng/api/implementations/blockentities/IWirelessAccessPoint;getLocation()Lappeng/api/util/DimensionalBlockPos;")
    )
        private DimensionalBlockPos getTransformedLocation(DimensionalBlockPos original){

        Vector3d position = new Vector3d(
                original.getPos().getX(),
                original.getPos().getY(),
                original.getPos().getZ()
        );


        // its so peak...
        position = SableCompanion.INSTANCE.projectOutOfSubLevel(original.getLevel(), position);
        return new DimensionalBlockPos(original.getLevel(), (int) position.x(), (int) position.y(),(int) position.z());
    }

}
