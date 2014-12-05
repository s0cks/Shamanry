package shamanry.common

import cpw.mods.fml.common.registry.GameRegistry
import shamanry.common.block.BlockRitualAltar

object ShamanryBlocks{
  def init(): Unit ={
    GameRegistry.registerBlock(BlockRitualAltar, "blockRitualAltar");
  }
}