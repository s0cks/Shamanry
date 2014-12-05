package shamanry.common

import cpw.mods.fml.common.registry.GameRegistry
import shamanry.common.tile.TileRitualAltar

object ShamanryTiles{
  def init(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileRitualAltar], "tileRitualAltar");
  }
}
