package tflaminis.common

import cpw.mods.fml.common.registry.GameRegistry
import tflaminis.common.tile.TileRitualAltar

object TFTiles{
  def init(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileRitualAltar], "tileRitualAltar");
  }
}
