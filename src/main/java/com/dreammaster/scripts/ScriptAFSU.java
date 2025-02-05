package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AFSU;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptAFSU implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AFSU";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(new String[] { AFSU.ID });
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AFSU.ID, "AFSU", 1),
                new Object[] { "cableGt01Platinum", "itemCasingTungstenSteel", "cableGt01Platinum",
                        "itemCasingTungstenSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 15),
                        "itemCasingTungstenSteel", "circuitMaster", getModItem(AFSU.ID, "ALC", 1), "circuitMaster" });

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                        ItemList.Energy_LapotronicOrb.get(1L), GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(AFSU.ID, "ALC", 1),
                2400,
                1920);
    }
}
