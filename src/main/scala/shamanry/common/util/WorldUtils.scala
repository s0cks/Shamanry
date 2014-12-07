package shamanry.common.util

import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

object WorldUtils{
  def spawnItem(world: World, x: Int, y: Int, z: Int, dir: ForgeDirection, stack: ItemStack): Unit ={
    val item: EntityItem = new EntityItem(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, stack.copy());
    world.spawnEntityInWorld(item);
  }
}