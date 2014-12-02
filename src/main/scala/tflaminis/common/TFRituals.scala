package tflaminis.common

import tflaminis.api.{IRitual, Rituals}
import tflaminis.common.lib.rituals.{RitualKnowledge, RitualTest}

object TFRituals{
  val KNOWLEDGE: IRitual = new RitualKnowledge;
  val TEST: IRitual = new RitualTest;

  def init(): Unit ={
    Rituals.registerRitual(KNOWLEDGE);
    Rituals.registerRitual(TEST);
  }
}