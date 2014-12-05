package shamanry.common.research

import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import shamanry.api.{LoreCollector, Rituals}
import shamanry.common.block.BlockRitualAltar
import shamanry.common.{ShamanryItems, ShamanryRecipes}
import thaumcraft.api.aspects.{Aspect, AspectList}
import thaumcraft.api.research.{ResearchCategories, ResearchItem, ResearchPage}

object ShamanryResearch{
  val RESEARCH_TAB: String = "ThaumicFlaminis";

  def init(): Unit ={
    ResearchCategories.registerCategory(RESEARCH_TAB, new ResourceLocation("shamanry", "textures/gui/researchShaman.png"), new ResourceLocation("shamanry", "textures/gui/researchBack.png"));

    var research: ResearchItem = null;

    research = new ShamanryResearchItem("ROD_SHAMANIC", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.TOOL, 1).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1), 0, 0, 0, new ItemStack(ShamanryItems.itemShamanicWandCore))
      .setPages(new ResearchPage(ShamanryRecipes.shamanRodRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("STAFF_SHAMANIC", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.TOOL, 1).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1), 0, 3, 2, new ItemStack(ShamanryItems.itemShamanicStaffCore))
      .setParents("ROD_SHAMANIC")
      .setPages(new ResearchPage(ShamanryRecipes.shamanStaffCoreRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("TABLET_EVIL", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.DARKNESS, 1), 10, 0, 2, new ItemStack(ShamanryItems.itemEvilTabletBlank))
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_evil")), new ResearchPage(ShamanryRecipes.evilTabletRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("TABLET_GOOD", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.LIGHT, 1), 10, 1, 2, new ItemStack(ShamanryItems.itemGoodTabletBlank))
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_good")), new ResearchPage(ShamanryRecipes.goodTabletRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITUAL_ALTAR", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 1).add(Aspect.SOUL, 1).add(Aspect.DARKNESS, 1), 3, 0, 2, new ItemStack(BlockRitualAltar))
      .setParents("STAFF_SHAMANIC", "TABLET_EVIL", "TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("ritual_altar")), new ResearchPage(ShamanryRecipes.ritualAltarRecipe))
      .setHidden()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_KNOWLEDGE", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 1), 10, 3, 2, Rituals.getTablet("riteKnowledge"))
      .setParents("TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_knowledge")), new ResearchPage(ShamanryRecipes.knowledgeRiteRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_DIVINES", RESEARCH_TAB, new AspectList().add(Aspect.LIGHT, 10), 13, 1, 2, Rituals.getTablet("riteDivine"))
      .setParents("TABLET_GOOD", "TABLET_EVIL")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_divines")), new ResearchPage(ShamanryRecipes.divineRiteRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_HELL", RESEARCH_TAB, new AspectList().add(Aspect.DARKNESS, 10), 13, 0, 2, Rituals.getTablet("riteHell"))
      .setParents("TABLET_EVIL", "TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_Hell")), new ResearchPage(ShamanryRecipes.hellRiteRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_DARKNESS", RESEARCH_TAB, new AspectList().add(Aspect.DARKNESS, 20), 10, -5, 2, Rituals.getTablet("riteDarkness"))
      .setPages(new ResearchPage(LoreCollector.getLore("rite_darknes")), new ResearchPage(ShamanryRecipes.darknessRiteRecipe))
      .setParents("TABLET_EVIL")
      .setSecondary()
      .registerResearchItem();
  }
}