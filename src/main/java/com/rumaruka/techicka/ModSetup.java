package com.rumaruka.techicka;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModSetup {


    public static CreativeModeTab TECHICKA_TAB = new CreativeModeTab(Techicka.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
