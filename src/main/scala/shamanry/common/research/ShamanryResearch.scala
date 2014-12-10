package shamanry.common.research

import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import shamanry.api.Rituals
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
      .setPages(new ResearchPage(LoreCollector.getLore("shamanwand")), new ResearchPage(ShamanryRecipes.shamanRodRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("ROD_SHAMANIC_staff", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.TOOL, 1).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1), 0, 3, 2, new ItemStack(ShamanryItems.itemShamanicStaffCore))
      .setParents("ROD_SHAMANIC")
      .setPages(new ResearchPage(LoreCollector.getLore("shamanstaff")), new ResearchPage(ShamanryRecipes.shamanStaffCoreRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("TABLET_EVIL", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.DARKNESS, 1), 3, 5, 2, new ItemStack(ShamanryItems.itemEvilTabletBlank))
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_nether")), new ResearchPage(ShamanryRecipes.evilTabletRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("TABLET_GOOD", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.LIGHT, 1), 7, 5, 2, new ItemStack(ShamanryItems.itemGoodTabletBlank))
      .setPages(new ResearchPage(LoreCollector.getLore("tablet_stone")), new ResearchPage(ShamanryRecipes.goodTabletRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITUAL_ALTAR", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 1).add(Aspect.SOUL, 1).add(Aspect.DARKNESS, 1), 3, 0, 2, new ItemStack(BlockRitualAltar))
      .setParents("ROD_SHAMANIC_staff", "TABLET_EVIL", "TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("ritual_altar")), new ResearchPage(LoreCollector.getLore("ritual_altar_2")), new ResearchPage(ShamanryRecipes.ritualAltarRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_KNOWLEDGE", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MIND, 1), 10, 5, 2, Rituals.getTablet("riteKnowledge"))
      .setParents("TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_knowledge")), new ResearchPage(LoreCollector.getLore("rite_knowledge_2")), new ResearchPage(ShamanryRecipes.knowledgeRiteRecipe))
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_DIVINES", RESEARCH_TAB, new AspectList().add(Aspect.LIGHT, 10), 6, 5, 2, Rituals.getTablet("riteDivine"))
      .setParents("TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_divines")), new ResearchPage(ShamanryRecipes.divineRiteRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_CLEANSING", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 20).add(Aspect.POISON, 20), 6, 6, 2, Rituals.getTablet("riteCleansing"))
      .setParents("TABLET_GOOD")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_cleansing")))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_HELL", RESEARCH_TAB, new AspectList().add(Aspect.DARKNESS, 10), 4, 5, 2, Rituals.getTablet("riteHell"))
      .setParents("TABLET_EVIL")
      .setPages(new ResearchPage(LoreCollector.getLore("rite_Hell")), new ResearchPage(ShamanryRecipes.hellRiteRecipe))
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_DARKNESS", RESEARCH_TAB, new AspectList().add(Aspect.DARKNESS, 20), 5, 7, 2, Rituals.getTablet("riteDarkness"))
      .setPages(new ResearchPage(LoreCollector.getLore("rite_darknes")), new ResearchPage(ShamanryRecipes.darknessRiteRecipe))
      .setParents("TABLET_EVIL")
      .setSecondary()
      .registerResearchItem();

    research = new ShamanryResearchItem("RITE_STORM", RESEARCH_TAB, new AspectList().add(Aspect.MAGIC, 15).add(Aspect.WEATHER, 15), 3, 7, 2, Rituals.getTablet("riteStorm"))
      .setPages(new ResearchPage(LoreCollector.getLore("rite_storm")), new ResearchPage(ShamanryRecipes.stormRiteRecipe))
      .setParents("TABLET_EVIL")
      .setSecondary()
      .registerResearchItem();
  }
}