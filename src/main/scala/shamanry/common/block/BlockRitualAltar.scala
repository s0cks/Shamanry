package shamanry.common.block

import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import shamanry.api.Rituals
import shamanry.common.Shamanry
import shamanry.common.item.ItemRiteTablet
import shamanry.common.tile.TileRitualAltar

object BlockRitualAltar
extends BlockContainer(Material.rock){
  this.setCreativeTab(Shamanry.TAB);
  this.setBlockName("ritual_altar");

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, i: Int, f: Float, j: Float, k: Float): Boolean = {
    val tile: TileRitualAltar = world.getTileEntity(x, y, z).asInstanceOf[TileRitualAltar];
    if(player.getCurrentEquippedItem != null){
      if(player.getCurrentEquippedItem.getItem.isInstanceOf[ItemRiteTablet]){
        val tablet: ItemRiteTablet = player.getCurrentEquippedItem.getItem.asInstanceOf[ItemRiteTablet];
        tile.setRitual(tablet.getRitual());
        player.getCurrentEquippedItem.stackSize = player.getCurrentEquippedItem.stackSize - 1;
      }
    } else{
      if(player.isSneaking() && tile.getRitual != null){
        val stack: ItemStack = Rituals.getTablet(tile.getRitual.getName);
        val item: EntityItem = new EntityItem(world, x, y, z, stack);
        if(!world.isRemote){
          world.spawnEntityInWorld(item);
        }
        tile.setRitual(null);
      } else{
        if(tile.getRitual != null){
          tile.activate(player);
        }
      }
    }
    world.markBlockForUpdate(x, y, z);
    return true;
  }

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity ={
    return new TileRitualAltar();
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }

  override def getRenderType(): Int={
    return -1;
  }
}