package shamanry.common.lib.rituals

import java.util.Random

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import shamanry.api.{IRitual, RitualType}
import shamanry.common.util.SoundHelper;
import shamanry.common.lib.karma.Karma
import thaumcraft.api.aspects.Aspect

object RitualNightfall
extends IRitual{
  private val rand: Random = new Random();

  override def getAspect: Aspect ={
    return Aspect.DARKNESS;
  }

  override def getType: RitualType ={
    return RitualType.EVIL;
  }

  override def getName: String ={
    return "riteDarkness";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    if(Karma.get(player).isEvil()){
      SoundHelper.playThunderEffect(world, x, y, z);

      if(!world.isRemote){
        world.setWorldTime(18000);
      }
    } else{
      if(!world.isRemote){
        player.addChatComponentMessage(new ChatComponentText("You must have bad karma to perform this ritual"));
      }
    }
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isEvil();
  }
}