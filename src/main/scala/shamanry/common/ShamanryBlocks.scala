package shamanry.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import shamanry.common.block.{BlockShamanry, BlockAdobeMud, BlockRitualAltar}

object ShamanryBlocks{
  val blockAdobeBrick: Block = new BlockShamanry(Material.rock)
    .setHardness(2.0F)
    .setResistance(10.0F)
    .setStepSound(Block.soundTypePiston)
    .setBlockName("adobe_brick")
    .setCreativeTab(Shamanry.TAB)
    .setBlockTextureName("shamanry:adobe_bricks");
  val blockAdobeHard: Block = new BlockShamanry(Material.rock)
    .setHardness(2.0F)
    .setResistance(10.0F)
    .setStepSound(Block.soundTypePiston)
    .setCreativeTab(Shamanry.TAB)
    .setBlockName("adobe_hard")
    .setBlockTextureName("shamanry:adobe_smooth");

  def init(): Unit ={
    GameRegistry.registerBlock(BlockRitualAltar, "blockRitualAltar");
    GameRegistry.registerBlock(BlockAdobeMud, "blockAdobeMud");
    GameRegistry.registerBlock(blockAdobeBrick, "blockAdobeBrick");
    GameRegistry.registerBlock(blockAdobeHard, "blockAdobeHard");
  }
}