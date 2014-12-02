package tflaminis.common

import cpw.mods.fml.common.registry.GameRegistry
import tflaminis.common.block.BlockRitualAltar

object TFBlocks{
  def init(): Unit ={
    GameRegistry.registerBlock(BlockRitualAltar, "blockRitualAltar");
  }
}