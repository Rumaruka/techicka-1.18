package com.rumaruka.techicka.utils;

import com.hollingsworth.arsnouveau.ArsNouveau;
import net.minecraftforge.fml.ModList;
import vazkii.botania.api.BotaniaAPI;
import wayoftime.bloodmagic.BloodMagic;

public class ModCheck {


   public static boolean isBotaniaLoaded(){
       return ModList.get().isLoaded(BotaniaAPI.MODID);
    }

    public static boolean isArsNouveauLoaded(){
        return ModList.get().isLoaded(ArsNouveau.MODID);
    }

    public static boolean isBloodMagicLoaded(){
        return ModList.get().isLoaded(BloodMagic.MODID);
    }
}
