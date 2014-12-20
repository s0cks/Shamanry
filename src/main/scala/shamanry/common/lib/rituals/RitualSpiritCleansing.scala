package shamanry.common.lib.rituals

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import shamanry.api.{RitualType, IRitual}
import thaumcraft.api.aspects.Aspect

object RitualSpiritCleansing
extends IRitual{
  override def getAspect: Aspect ={
    return null;
  }

  override def getType: RitualType ={
    return null;
  }

  override def getName: String ={
    return "";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean = {
    return true;
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return true;
  }
}