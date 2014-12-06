package shamanry.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack
import shamanry.api.{IRitual, Rituals}
import shamanry.common.item.ItemRiteTablet
import shamanry.common.lib.rituals._

import scala.collection.JavaConversions._

object ShamanryRituals{
  def init(): Unit ={
    Rituals.registerRitual(RitualKnowledge);
    Rituals.registerRitual(RitualDivine);
    Rituals.registerRitual(RitualHell);
    // Rituals.registerRitual(RitualConjureVillager);
    Rituals.registerRitual(RitualNightfall);
    Rituals.registerRitual(RitualStorm);
  }

  def generateTablets(): Unit ={
    var tablet: ItemRiteTablet = null;
    for(rite: IRitual <- Rituals.getRituals){
      tablet = new ItemRiteTablet(rite);
      GameRegistry.registerItem(tablet, "itemRiteTablet_" + rite.getName());
      Rituals.registerTablet(rite.getName(), new ItemStack(tablet));;
      System.out.println(String.format("Registering Rite: %s", rite.getName()));
    }
  }
}