package shamanry.common.lib.ritual.rituals

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import shamanry.api.{RitualType, IRitual}
import shamanry.common.lib.karma.Karma
import thaumcraft.api.aspects.Aspect

object RitualDivine
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.LIGHT;
  }

  override def getType: RitualType ={
    return RitualType.GOOD;
  }

  override def getName: String ={
    return "riteDivine";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    Karma.get(player).addGoodKarma(0.1);
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean ={
    return Karma.get(player).isNeutral();
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isNeutral() && player.dimension != -1;
  }
}