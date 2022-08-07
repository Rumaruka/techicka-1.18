package com.rumaruka.techicka.modules.common.thermal.blocks.bloodmagic;

import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodDynamoTile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.common.item.BloodMagicItems;

public class BloodDynamoBlock extends BaseEntityBlock {
    public BloodDynamoBlock() {
        super(Properties.of(Material.HEAVY_METAL).destroyTime(1.9f));
    }


    @Override
    @NotNull
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BloodDynamoTile bloodDynamoTile = (BloodDynamoTile) pLevel.getBlockEntity(pPos);
        if (bloodDynamoTile != null) {

            if (pPlayer.getItemInHand(pHand).getItem() == BloodMagicItems.DIVINATION_SIGIL.get()) {
                if (!pLevel.isClientSide) {
                    pPlayer.sendMessage(new TextComponent("Energy: " + bloodDynamoTile.energy.getEnergyStored() + "/" + bloodDynamoTile.energy.getMaxEnergyStored()), pPlayer.getUUID());
                    pPlayer.sendMessage(new TextComponent("Life Essence: " + bloodDynamoTile.bloodTank.getFluidAmount() + "/" + bloodDynamoTile.bloodTank.getCapacity()), pPlayer.getUUID());
                }

            }


            return InteractionResult.SUCCESS;
        }



        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BloodDynamoTile(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153273_, BlockState p_153274_, BlockEntityType<T> p_153275_) {

        return createTickerHelper(p_153275_, TTherBlocks.BloodMagicModule.BLOOD_DYNAMO_TE.get(), BloodDynamoTile::serverTick);
    }

}
