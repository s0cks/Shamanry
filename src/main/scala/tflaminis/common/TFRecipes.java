package tflaminis.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class TFRecipes{
    public static void init(){
        // Arcane Crafting Recipes
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "ROD_SHAMANIC",
                new ItemStack(TFItems.itemShamanicWandCore()),
                new AspectList()
                        .add(Aspect.ENTROPY, 15)
                        .add(Aspect.EARTH, 15),
                ThaumcraftItems.blockGreatwoodLog(),
                new ItemStack(TFItems.itemStoneKnife())
        );

        // Regular Crafting Recipes
        GameRegistry.addRecipe(
                new ItemStack(TFItems.itemStoneKnife(), 1),
                "C",
                "S",
                'C', Blocks.cobblestone,
                'S', Items.stick
        );
    }
}
