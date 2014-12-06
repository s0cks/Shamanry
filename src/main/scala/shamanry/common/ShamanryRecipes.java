package shamanry.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import shamanry.api.Rituals;
import shamanry.common.block.BlockRitualAltar$;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;

public class ShamanryRecipes{
    public static ShapelessArcaneRecipe shamanRodRecipe = null;
    public static ShapelessArcaneRecipe goodTabletRecipe = null;
    public static ShapelessArcaneRecipe evilTabletRecipe = null;

    public static ShapedArcaneRecipe ritualAltarRecipe = null;

    public static InfusionRecipe shamanStaffCoreRecipe = null;
    public static InfusionRecipe knowledgeRiteRecipe = null;
    public static InfusionRecipe divineRiteRecipe = null;
    public static InfusionRecipe hellRiteRecipe = null;
    public static InfusionRecipe darknessRiteRecipe = null;
    public static InfusionRecipe stormRiteRecipe = null;

    public static void init(){
        // Arcane Crafting Recipes
        shamanRodRecipe = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "ROD_SHAMANIC",
                new ItemStack(ShamanryItems.itemShamanicWandCore()),
                new AspectList()
                        .add(Aspect.ENTROPY, 15)
                        .add(Aspect.EARTH, 15),
                ThaumcraftItems.blockGreatwoodLog(),
                new ItemStack(ShamanryItems.itemStoneKnife())
        );
        evilTabletRecipe = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "TABLET_EVIL",
                new ItemStack(ShamanryItems.itemEvilTabletBlank()),
                new AspectList()
                    .add(Aspect.EARTH, 15)
                    .add(Aspect.ENTROPY, 15)
                    .add(Aspect.ORDER, 15),
                new ItemStack(Items.netherbrick),
                new ItemStack(Items.netherbrick)
        );
        goodTabletRecipe = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "TABLET_GOOD",
                new ItemStack(ShamanryItems.itemGoodTabletBlank()),
                new AspectList()
                    .add(Aspect.EARTH, 15)
                    .add(Aspect.ENTROPY, 15)
                    .add(Aspect.ORDER, 15),
                new ItemStack(Blocks.stone),
                new ItemStack(Blocks.stone)
        );

        ritualAltarRecipe = ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUAL_ALTAR",
                new ItemStack(BlockRitualAltar$.MODULE$),
                new AspectList()
                    .add(Aspect.EARTH, 100)
                    .add(Aspect.AIR, 100)
                    .add(Aspect.WATER, 100)
                    .add(Aspect.FIRE, 100)
                    .add(Aspect.ORDER, 100)
                    .add(Aspect.ENTROPY, 100),
                "SWS",
                "SBS",
                "SSS",
                'S', Blocks.stone,
                'B', ThaumcraftItems.itemBalancedShard(),
                'W', new ItemStack(Items.skull, 1, 1)
        );

        // Regular Crafting Recipes
        GameRegistry.addShapedRecipe(
                new ItemStack(ShamanryItems.itemStoneKnife(), 1),
                "C",
                "S",
                'C', Blocks.cobblestone,
                'S', Items.stick
        );

        // Infusion Recipes
        shamanStaffCoreRecipe = ThaumcraftApi.addInfusionCraftingRecipe("STAFF_SHAMANIC",
                new ItemStack(ShamanryItems.itemShamanicStaffCore()), 1,
                new AspectList()
                        .add(Aspect.TOOL, 15)
                        .add(Aspect.MAGIC, 15)
                        .add(Aspect.ORDER, 15)
                        .add(Aspect.ENTROPY, 15),
                new ItemStack(ShamanryItems.itemShamanicWandCore()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard()
                }
        );
        knowledgeRiteRecipe = ThaumcraftApi.addInfusionCraftingRecipe("RITE_KNOWLEDGE",
                Rituals.getTablet("riteKnowledge"), 1,
                new AspectList()
                    .add(Aspect.MIND, 25)
                    .add(Aspect.MAGIC, 25)
                    .add(Aspect.SOUL, 25),
                new ItemStack(ShamanryItems.itemGoodTabletBlank()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        new ItemStack(Items.paper),
                        new ItemStack(Items.dye, 1, 0),
                        new ItemStack(Items.ender_pearl)
                }
        );
        divineRiteRecipe = ThaumcraftApi.addInfusionCraftingRecipe("RITE_DIVINES",
                Rituals.getTablet("riteDivine"), 1,
                new AspectList()
                    .add(Aspect.MAGIC, 25)
                    .add(Aspect.LIGHT, 25)
                    .add(Aspect.SOUL, 25),
                new ItemStack(ShamanryItems.itemGoodTabletBlank()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        new ItemStack(Items.nether_star)
                }
        );
        hellRiteRecipe = ThaumcraftApi.addInfusionCraftingRecipe("RITE_HELL",
                Rituals.getTablet("riteHell"), 1,
                new AspectList()
                    .add(Aspect.MAGIC, 25)
                    .add(Aspect.DARKNESS, 25)
                    .add(Aspect.SOUL, 25),
                new ItemStack(ShamanryItems.itemEvilTabletBlank()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        new ItemStack(Items.blaze_powder)
                }
        );
        darknessRiteRecipe = ThaumcraftApi.addInfusionCraftingRecipe("RITE_DARKNESS",
                Rituals.getTablet("riteDarkness"), 1,
                new AspectList()
                        .add(Aspect.MAGIC, 25)
                        .add(Aspect.DARKNESS, 25),
                new ItemStack(ShamanryItems.itemEvilTabletBlank()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        new ItemStack(Items.nether_star)
                }
        );
        stormRiteRecipe = ThaumcraftApi.addInfusionCraftingRecipe("RITE_STORM",
                Rituals.getTablet("riteStorm"), 1,
                new AspectList()
                    .add(Aspect.MAGIC, 25)
                    .add(Aspect.WEATHER, 25)
                    .add(Aspect.DARKNESS, 25),
                new ItemStack(ShamanryItems.itemEvilTabletBlank()),
                new ItemStack[]{
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        ThaumcraftItems.itemBalancedShard(),
                        new ItemStack(Items.nether_star),
                        new ItemStack(Items.diamond)
                }
        );
    }
}
