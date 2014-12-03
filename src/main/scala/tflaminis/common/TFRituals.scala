package tflaminis.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.ItemStack
import tflaminis.api.{IRitual, Rituals}
import tflaminis.common.item.ItemRiteTablet
import tflaminis.common.lib.ritual.rituals.{RitualKnowledge, RitualTest}
import scala.collection.JavaConversions._

object TFRituals{
  def init(): Unit ={
    Rituals.registerRitual(RitualKnowledge);
    Rituals.registerRitual(RitualTest);
  }

  def generateTablets(): Unit ={
    var tablet: ItemRiteTablet = null;
    for(rite: IRitual <- Rituals.getRituals){
      tablet = new ItemRiteTablet(rite);
      GameRegistry.registerItem(tablet, "itemRiteTablet_" + rite.getName());
      Rituals.registerTablet(rite.getName(), new ItemStack(tablet));;
    }
  }
}