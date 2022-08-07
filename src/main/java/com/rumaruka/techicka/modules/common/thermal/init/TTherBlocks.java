package com.rumaruka.techicka.modules.common.thermal.init;

import com.rumaruka.techicka.ModSetup;
import com.rumaruka.techicka.modules.common.thermal.blocks.arsnouveau.ManaDynamoBlock;
import com.rumaruka.techicka.modules.common.thermal.blocks.arsnouveau.ManaFabricationBlock;
import com.rumaruka.techicka.modules.common.thermal.blocks.bloodmagic.BloodDynamoBlock;
import com.rumaruka.techicka.modules.common.thermal.blocks.bloodmagic.BloodFabricatorBlock;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaDynamoTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.arsnouveau.ManaFabricatorTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodDynamoTile;
import com.rumaruka.techicka.modules.common.thermal.tiles.bloodmagic.BloodFabricatorTile;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.rumaruka.techicka.Techicka.MODID;

public class TTherBlocks {

    public static class BloodMagicModule {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
        private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        private static final DeferredRegister<BlockEntityType<?>> BE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

        public static void setup() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BE.register(FMLJavaModLoadingContext.get().getModEventBus());


        }

        public static final RegistryObject<Block> BLOOD_DYNAMO = BLOCKS.register("blood_dynamo", BloodDynamoBlock::new);
        public static final RegistryObject<Block> BLOOD_FABR= BLOCKS.register("blood_fabr", BloodFabricatorBlock::new);
        public static final RegistryObject<BlockEntityType<BloodDynamoTile>> BLOOD_DYNAMO_TE = BE.register("blood_dynamo", () -> BlockEntityType.Builder.of(BloodDynamoTile::new, BLOOD_DYNAMO.get()).build(null));
        public static final RegistryObject<BlockEntityType<BloodFabricatorTile>> BLOOD_FABR_TE = BE.register("blood_fabr", () -> BlockEntityType.Builder.of(BloodFabricatorTile::new, BLOOD_FABR.get()).build(null));
        public static final RegistryObject<BlockItem> BLOOD_DYNAMO_ITEM = BLOCKITEMS.register("blood_dynamo", () -> new BlockItem(BLOOD_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
        public static final RegistryObject<BlockItem> BLOOD_FABR_ITEM = BLOCKITEMS.register("blood_fabr", () -> new BlockItem(BLOOD_FABR.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
    }

    public static class BotaniaModule {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
        private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        private static final DeferredRegister<BlockEntityType<?>> BE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

        public static void setup() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BE.register(FMLJavaModLoadingContext.get().getModEventBus());


        }
        //  public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
        // public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
    }

    public static class ArsNouveauModule {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
        private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        private static final DeferredRegister<BlockEntityType<?>> BE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

        public static void setup() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BE.register(FMLJavaModLoadingContext.get().getModEventBus());


        }

        public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
        public static final RegistryObject<Block> MANA_FABR = BLOCKS.register("mana_fabrication", ManaFabricationBlock::new);
        public static final RegistryObject<BlockEntityType<ManaDynamoTile>> MANA_DYNAMO_BE = BE.register("mana_dynamo", () -> BlockEntityType.Builder.of(ManaDynamoTile::new, MANA_DYNAMO.get()).build(null));
        public static final RegistryObject<BlockEntityType<ManaFabricatorTile>> MANA_FABR_BE = BE.register("mana_fabrication", () -> BlockEntityType.Builder.of(ManaFabricatorTile::new, MANA_FABR.get()).build(null));
        public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TextComponent("Install with Ars Nouveau").withStyle(ChatFormatting.YELLOW));
                }
            });
        public static final RegistryObject<BlockItem> MANA_FABR_ITEM = BLOCKITEMS.register("mana_fabrication", () -> new BlockItem(MANA_FABR.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TextComponent("Install with Ars Nouveau").withStyle(ChatFormatting.YELLOW));
            }
        });
        }


}
