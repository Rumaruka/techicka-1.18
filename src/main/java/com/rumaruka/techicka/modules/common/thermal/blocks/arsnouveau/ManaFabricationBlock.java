package com.rumaruka.techicka.modules.common.thermal.blocks.arsnouveau;

import com.hollingsworth.arsnouveau.common.block.SourcelinkBlock;
import com.hollingsworth.arsnouveau.common.block.TickableModBlock;
import com.hollingsworth.arsnouveau.common.block.tile.SourcelinkTile;
import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaDynamoTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaFabricatorTile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ManaFabricationBlock extends TickableModBlock {
    public ManaFabricationBlock( ) {
        super(Properties.of(Material.HEAVY_METAL));

    }

    public boolean isRandomlyTicking(BlockState p_149653_1_) {
        return true;
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
        SourcelinkTile tile = (SourcelinkTile)worldIn.getBlockEntity(pos);
        if (tile != null) {
            tile.doRandomAction();
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ManaFabricatorTile(pPos,pState);
    }

}
