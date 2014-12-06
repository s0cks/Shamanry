package shamanry.common.lib.rituals

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import shamanry.api.{IRitual, RitualType}
import shamanry.common.lib.karma.Karma
import thaumcraft.api.aspects.Aspect

object RitualStorm
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.WEATHER;
  }

  override def getType: RitualType ={
    return RitualType.EVIL;
  }

  override def getName: String ={
    return "riteStorm";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    world.getWorldInfo.setRainTime((30 * 20) * 60);
    world.getWorldInfo.setRaining(true);
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }
}