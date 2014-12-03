package tflaminis.common.wand

import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import tflaminis.common.TFItems
import thaumcraft.api.wands.IWandTriggerManager

object StoneWandTriggerManager
extends IWandTriggerManager{
  override def performTrigger(world: World, wand: ItemStack, player: EntityPlayer, x: Int, y: Int, z: Int, side: Int, event: Int): Boolean ={
    world.setBlockToAir(x, y, z);
    world.markBlockForUpdate(x, y, z);

    if(!world.isRemote){
      val dir: ForgeDirection = ForgeDirection.UP;
      val entityItem: EntityItem = new EntityItem(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, new ItemStack(TFItems.itemGoodTabletBlank, 1));
      world.spawnEntityInWorld(entityItem);
    }
    return true;
  }
}