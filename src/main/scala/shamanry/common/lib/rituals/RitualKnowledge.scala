package shamanry.common.lib.rituals

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import shamanry.api.{IRitual, RitualType}
import shamanry.common.ThaumcraftItems
import shamanry.common.lib.karma.Karma
import shamanry.common.util.{SoundUtils, WorldUtils}
import thaumcraft.api.aspects.Aspect

object RitualKnowledge
extends IRitual{
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
    WorldUtils.spawnItem(world, x, y, z, ForgeDirection.UP, ThaumcraftItems.itemKnowledgeFrag);
    SoundUtils.playThunderEffect(world, x, y, z);
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return Karma.get(player).isSaint();
  }
}