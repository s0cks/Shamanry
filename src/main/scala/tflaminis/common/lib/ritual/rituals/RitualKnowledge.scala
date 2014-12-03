package tflaminis.common.lib.ritual.rituals

import java.util.Random

import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import tflaminis.api.{IRitual, RitualType}
import tflaminis.common.ThaumcraftItems
import tflaminis.common.lib.karma.Karma
import thaumcraft.api.aspects.Aspect

object RitualKnowledge
extends IRitual{
  private val rand: Random = new Random();

  override def getAspect: Aspect ={
    return Aspect.MIND;
  }

  override def getType(): RitualType={
    return RitualType.GOOD;
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean={
    return Karma.get(player).isNeutral();
  }

  override def getName: String ={
    return "riteKnowledge";
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    if(Karma.get(player).isSaint()){
      val dir: ForgeDirection = ForgeDirection.UP;
      val item: EntityItem = new EntityItem(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, ThaumcraftItems.itemKnowledgeFrag.copy());
      world.playSoundEffect(x, y, z, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat * 0.2F)
      world.playSoundEffect(x, y, z, "random.explode", 2.0F, 0.5F + this.rand.nextFloat * 0.2F)
      world.spawnEntityInWorld(item);
    } else{
      if(!world.isRemote){
        player.addChatComponentMessage(new ChatComponentText("You must have nuetral karma to perform this ritual"));
      }
    }
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isSaint();
  }
}