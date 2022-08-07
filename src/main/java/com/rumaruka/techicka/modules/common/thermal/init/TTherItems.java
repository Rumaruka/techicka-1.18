package com.rumaruka.techicka.modules.common.thermal.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.techicka.Techicka.MODID;

public class TTherItems {
    public static class BloodMagicModule{
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        public static void setup() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());


        }
        //  public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
        // public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
    }

    public static class ArsNouveauModule{
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        public static void setup() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());


        }
        //  public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
        // public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
    }
    public static class BotaniaModule{

        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

        public static void setup() {

            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());



        }
        //  public static final RegistryObject<Block> MANA_DYNAMO = BLOCKS.register("mana_dynamo", ManaDynamoBlock::new);
        // public static final RegistryObject<BlockItem> MANA_DYNAMO_ITEM = BLOCKITEMS.register("mana_dynamo", () -> new BlockItem(MANA_DYNAMO.get(), new Item.Properties().tab(ModSetup.TECHICKA_TAB)));
    }
}
