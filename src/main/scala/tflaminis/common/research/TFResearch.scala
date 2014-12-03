package tflaminis.common.research

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.util.ResourceLocation
import tflaminis.api.LoreCollector
import tflaminis.common.TFItems
import tflaminis.common.block.BlockRitualAltar
import thaumcraft.api.aspects.{Aspect, AspectList}
import thaumcraft.api.research.{ResearchCategories, ResearchItem, ResearchPage}

object TFResearch{
  val RESEARCH_TAB: String = "ThaumicFlaminis";

  def init(): Unit ={
    ResearchCategories.registerCategory(RESEARCH_TAB, new ResourceLocation("tflaminis", "textures/items/stone_knife.png"), new ResourceLocation("tflaminis", "textures/gui/researchBack.png"));
    var research: ResearchItem = null;

    research = new TFResearchItem("ROD_SHAMANIC", RESEARCH_TAB, new AspectList(), 0, 0, 2, new ItemStack(TFItems.itemShamanicWandCore))
      .registerResearchItem();

    research = new TFResearchItem("STAFF_SHAMANIC", RESEARCH_TAB, new AspectList(), 0, 3, 2, new ItemStack(TFItems.itemShamanicStaffCore))
      .setParents("ROD_SHAMANIC")
      .setConcealed()
      .registerResearchItem();

    research = new TFResearchItem("RITUAL_ALTAR", RESEARCH_TAB, new AspectList(), 3, 0, 2, new ItemStack(BlockRitualAltar))
      .setAspectTriggers(Aspect.EXCHANGE, Aspect.CRAFT)
      .registerResearchItem();

    research = new TFResearchItem("TABALET_EVIL", RESEARCH_TAB, new AspectList(), 10, 0, 2, new ItemStack(TFItems.itemEvilTabletBlank))
      .setAutoUnlock()
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_evil")))
      .registerResearchItem();

    research = new TFResearchItem("TABLET_GOOD", RESEARCH_TAB, new AspectList(), 10, 1, 2, new ItemStack(TFItems.itemGoodTabletBlank))
      .setAutoUnlock()
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_good")))
      .registerResearchItem();
  }

  def recipePage(recipe: IRecipe): ResearchPage={
    return new ResearchPage(recipe);
  }
}