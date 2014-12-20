package shamanry.common.lib.rituals

import net.minecraft.entity.passive.EntityVillager
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import shamanry.api.{IRitual, RitualType}
import shamanry.common.lib.karma.Karma
import shamanry.common.util.SoundUtils
import thaumcraft.api.aspects.Aspect

object RitualConjureVillager
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.LIFE;
  }

  override def getType: RitualType ={
    return RitualType.EVIL;
  }

  override def getName: String ={
    return "riteRebirth";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    if(!world.isRemote){
      world.spawnEntityInWorld(new EntityVillager(world));
    }

    SoundUtils.playThunderEffect(world, x, y, z);
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }
}