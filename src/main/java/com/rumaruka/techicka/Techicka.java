package com.rumaruka.techicka;


import com.rumaruka.techicka.modules.common.base.init.TBlocks;
import com.rumaruka.techicka.modules.common.base.init.TItems;
import com.rumaruka.techicka.modules.common.mekanism.init.TMekBlocks;
import com.rumaruka.techicka.modules.common.mekanism.init.TMekItems;
import com.rumaruka.techicka.modules.common.thermal.init.TTherBlocks;
import com.rumaruka.techicka.modules.common.thermal.init.TTherItems;
import com.rumaruka.techicka.utils.ModCheck;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.rumaruka.techicka.Techicka.MODID;

@Mod(MODID)
public class Techicka {
    public static final String MODID = "techicka";

    public Techicka() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        TBlocks.setup();
        TItems.setup();
        //Thermal Series Module
        if (ModList.get().isLoaded("thermal")) {
            if (ModCheck.isBotaniaLoaded()) {
                TTherBlocks.BotaniaModule.setup();
                TTherItems.BotaniaModule.setup();
            }
            if(ModCheck.isArsNouveauLoaded()){
                TTherBlocks.ArsNouveauModule.setup();
                TTherItems.ArsNouveauModule.setup();
            }
            if(ModCheck.isBloodMagicLoaded()){
                TTherBlocks.BloodMagicModule.setup();
                TTherItems.BloodMagicModule.setup();
            }

        }
        //Mekanism Module
        if (ModList.get().isLoaded("mekanism")) {
            if (ModCheck.isBotaniaLoaded()) {
                TMekBlocks.setup();
                TMekItems.setup();
            }
            if(ModCheck.isArsNouveauLoaded()){
                TMekBlocks.setup();
                TMekItems.setup();
            }
            if(ModCheck.isBloodMagicLoaded()){
                TMekBlocks.setup();
                TMekItems.setup();
            }

        }

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }


}
