package com.rumaruka.techicka.modules.common.thermal.blocks.bloodmagic;

import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodDynamoTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodFabricatorTile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import wayoftime.bloodmagic.common.item.BloodMagicItems;

public class BloodFabricatorBlock extends BaseEntityBlock {
    public BloodFabricatorBlock() {
        super(Properties.of(Material.HEAVY_METAL).destroyTime(1.9f));
    }




    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BloodFabricatorTile(pPos, pState);
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
