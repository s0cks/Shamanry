package shamanry.common.lib.rituals

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.Potion
import net.minecraft.world.World
import shamanry.api.{RitualType, IRitual}
import shamanry.common.lib.karma.Karma
import shamanry.common.util.SoundHelper
import thaumcraft.api.aspects.Aspect

object RitualCleansing
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.LIGHT;
  }

  override def getType: RitualType ={
    return RitualType.GOOD;
  }

  override def getName: String ={
    return "riteCleansing";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    for(p: Potion <- Potion.potionTypes){
      if(player.isPotionActive(p) && p.isBadEffect){
        player.removePotionEffect(p.getId());
      }
    }
    SoundHelper.playThunderEffect(world, x, y, z);
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean ={
    return Karma.get(player).isSaint();
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isSaint();
  }
}