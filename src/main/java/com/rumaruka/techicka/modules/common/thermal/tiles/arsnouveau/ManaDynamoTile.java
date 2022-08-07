package com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau;

import com.hollingsworth.arsnouveau.api.util.ManaUtil;
import com.hollingsworth.arsnouveau.api.util.SourceUtil;
import com.hollingsworth.arsnouveau.client.particle.ParticleUtil;
import com.hollingsworth.arsnouveau.common.capability.ManaCap;
import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodDynamoTile;
import com.rumaruka.techicka.utils.ModEnergyFE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaDynamoTile extends BlockEntity implements ICapabilityProvider {


    public ModEnergyFE energy = new ModEnergyFE(100000,100);
    // public boolean markedForUpdate = false;
    public int tickDelay = 10;
    public ManaDynamoTile(BlockPos pWorldPosition, BlockState pBlockState) {
        super(TTherBlocks.ArsNouveauModule.MANA_DYNAMO_BE.get(), pWorldPosition, pBlockState);


    }
    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, ManaDynamoTile pBlockEntity) {

        if(!pLevel.isClientSide()){
            boolean flag = true;
            if(flag){
                int tick = pBlockEntity.tickDelay;
                pBlockEntity.tickDelay--;
                if(pBlockEntity.tickDelay==0){
                    pBlockEntity.tickDelay=10;
                    pLevel.blockUpdated(pPos,pState.getBlock());

                }
            }

            if(SourceUtil.hasSourceNearby(pPos,pLevel,2,200)){
                SourceUtil.takeSourceNearbyWithParticles(pPos,pLevel,2,200);
                pBlockEntity.energy.generatePower(10);

            }
        }

    }



    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }


        return super.getCapability(cap);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }


        return super.getCapability(cap, side);
    }
}
