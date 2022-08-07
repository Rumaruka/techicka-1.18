package com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau;

import com.hollingsworth.arsnouveau.api.source.ISourceTile;
import com.hollingsworth.arsnouveau.api.util.SourceUtil;
import com.hollingsworth.arsnouveau.client.particle.ParticleUtil;
import com.hollingsworth.arsnouveau.common.block.tile.SourcelinkTile;
import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.utils.ModEnergyFE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaFabricatorTile extends SourcelinkTile implements ICapabilityProvider {

    public ModEnergyFE energy = new ModEnergyFE(100000, 100);
    // public boolean markedForUpdate = false;
    public int tickDelay = 10;

    public ManaFabricatorTile(BlockPos pWorldPosition, BlockState pBlockState) {
        super(TTherBlocks.ArsNouveauModule.MANA_FABR_BE.get(), pWorldPosition, pBlockState);
    }

    public void tick() {
        BlockPos jarPos = SourceUtil.canGiveSourceClosest(this.worldPosition, this.level, 5);
        addSource(10);

        if(energy.getEnergyStored()>10000){

            if(jarPos!=null){
                this.transferSource(this, (ISourceTile)this.level.getBlockEntity(jarPos));
                ParticleUtil.spawnFollowProjectile(this.level, this.worldPosition, jarPos);
                energy.extractEnergyInternal(10000,false);
            }
        }





    }

    @Override
    public void getManaEvent(BlockPos sourcePos, int total) {
        this.addSource(total);
        ParticleUtil.spawnFollowProjectile(this.level, sourcePos, this.worldPosition);

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

    @Override
    public int getTransferRate() {
        return 1000;
    }
}
