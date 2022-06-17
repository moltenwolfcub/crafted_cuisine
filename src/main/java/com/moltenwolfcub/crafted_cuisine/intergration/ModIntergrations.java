package com.moltenwolfcub.crafted_cuisine.intergration;

import net.minecraftforge.fml.ModList;

public class ModIntergrations {
    public boolean getLoaded(String id){
        return ModList.get().isLoaded(id);
    }
}
