package com.rumaruka.techicka.modules.common.thermal.blocks.arsnouveau;

import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaDynamoTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodDynamoTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class ManaDynamoBlock extends BaseEntityBlock {
    public ManaDynamoBlock( ) {
        super(Properties.of(Material.HEAVY_METAL));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ManaDynamoTile(pPos,pState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153273_, BlockState p_153274_, BlockEntityType<T> p_153275_) {

        return createTickerHelper(p_153275_, TTherBlocks.ArsNouveauModule.MANA_DYNAMO_BE.get(), ManaDynamoTile::serverTick);
    }
}
