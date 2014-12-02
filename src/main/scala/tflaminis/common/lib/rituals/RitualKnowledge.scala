package tflaminis.common.lib.rituals

import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import tflaminis.api.IRitual
import tflaminis.common.TFRecipes
import tflaminis.common.lib.karma.Karma
import thaumcraft.api.aspects.Aspect

class RitualKnowledge
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.MIND;
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean={
    return Karma.get(player).isNeutral();
  }

  override def getName: String ={
    return "riteKnowledge";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    if(Karma.get(player).isNeutral()){
      val dir: ForgeDirection = ForgeDirection.UP;
      val item: EntityItem = new EntityItem(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, TFRecipes.itemKnowledgeFrag.copy());
      world.spawnEntityInWorld(item);
    } else{
      player.addChatComponentMessage(new ChatComponentText("You must have nuetral karma to perform this ritual"));
    }
  }
}