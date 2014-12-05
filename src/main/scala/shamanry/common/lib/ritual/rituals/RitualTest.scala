package shamanry.common.lib.ritual.rituals

import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import shamanry.api.{IRitual, RitualType}
import thaumcraft.api.aspects.Aspect

object RitualTest
extends IRitual{
  override def getAspect: Aspect ={
    return Aspect.MIND;
  }

  override def getName: String ={
    return "riteTest";
  }

  override def getType(): RitualType={
    return RitualType.EVIL;
  }

  override def hasRequiredKarma(player: EntityPlayer): Boolean={
    return true;
  }

  override def perform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Unit ={
    val dir: ForgeDirection = ForgeDirection.NORTH;
    val item: EntityItem = new EntityItem(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, new ItemStack(Items.diamond));
    world.spawnEntityInWorld(item);
  }

  override def canPerform(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean ={
    return true;
  }
}