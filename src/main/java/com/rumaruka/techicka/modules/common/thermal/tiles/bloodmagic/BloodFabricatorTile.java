package com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic;

import cofh.core.client.renderer.model.ModelUtils;
import cofh.core.network.packet.client.TileStatePacket;
import cofh.core.util.helpers.FluidHelper;
import cofh.lib.fluid.FluidStorageCoFH;
import cofh.lib.util.StorageGroup;
import cofh.thermal.core.config.ThermalCoreConfig;
import cofh.thermal.core.util.managers.dynamo.MagmaticFuelManager;
import cofh.thermal.lib.tileentity.DynamoTileBase;
import com.hollingsworth.arsnouveau.api.util.SourceUtil;
import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaDynamoTile;
import com.rumaruka.techicka.utils.ModEnergyFE;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import wayoftime.bloodmagic.altar.BloodAltar;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.common.tile.TileAltar;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BloodFabricatorTile extends BlockEntity implements ICapabilityProvider {


    public ModEnergyFE energy = new ModEnergyFE(100000,100);
    public FluidTank bloodTank;

    public int tickDelay = 10;
    private TileAltar tileAltar;
    private final LazyOptional<IFluidHandler> holder;
    public BloodFabricatorTile(BlockPos pWorldPosition, BlockState pBlockState) {
        super(TTherBlocks.BloodMagicModule.BLOOD_FABR_TE.get(), pWorldPosition, pBlockState);

        bloodTank = new FluidTank(8000) {
            @Override
            protected void onContentsChanged() {
                if (!level.isClientSide) {
                    setChanged();

                }
            }
        };
        this.holder= LazyOptional.of(()->{
            return this.bloodTank;
        });
    }
    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, BloodFabricatorTile pBlockEntity) {

        if(!pLevel.isClientSide()){


            int tick = pBlockEntity.tickDelay;
            pBlockEntity.tickDelay--;
            if(pBlockEntity.tickDelay==0){
                pBlockEntity.tickDelay=10;
                pLevel.blockUpdated(pPos,pState.getBlock());

            }



            boolean flag = pLevel.hasNeighborSignal(pPos) || pLevel.hasNeighborSignal(pPos.above());


            if (!flag) {
                pBlockEntity.bloodTank.fill(new FluidStack(BloodMagicBlocks.LIFE_ESSENCE_FLUID.get(),100), IFluidHandler.FluidAction.EXECUTE);


            }

        }

    }

    @Override
    public void load(CompoundTag tagCompound) {
        super.load(tagCompound);

    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
    }

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);
    private final LazyOptional<IFluidHandler> fluidCap = LazyOptional.of(() -> bloodTank);


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }
        if(cap==CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            return fluidCap.cast();
        }

        if(cap==CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY){
            return fluidCap.cast();
        }
        return super.getCapability(cap);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityEnergy.ENERGY) {
            return energyCap.cast();
        }

        if(cap==CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
            return fluidCap.cast();
        }
        if(cap==CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY){
            return fluidCap.cast();
        }
        return super.getCapability(cap, side);
    }
}
