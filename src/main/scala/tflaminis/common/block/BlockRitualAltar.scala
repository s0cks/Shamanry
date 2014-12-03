package tflaminis.common.block

import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import tflaminis.common.ThaumicFlaminis
import tflaminis.common.lib.ritual.rituals.RitualKnowledge
import tflaminis.common.tile.TileRitualAltar

object BlockRitualAltar
extends BlockContainer(Material.rock){
  this.setCreativeTab(ThaumicFlaminis.TAB);
  this.setBlockName("ritual_altar");

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, i: Int, f: Float, j: Float, k: Float): Boolean = {
    val tile: TileRitualAltar = world.getTileEntity(x, y, z).asInstanceOf[TileRitualAltar];
    tile.activate(RitualKnowledge, player);
    return true;
  }

    override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity ={
    return new TileRitualAltar();
  }
}