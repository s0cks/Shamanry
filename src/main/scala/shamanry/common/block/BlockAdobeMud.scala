package shamanry.common.block

import java.util.Random

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.Item
import shamanry.common.{ShamanryItems, Shamanry}

object BlockAdobeMud
extends Block(Material.clay){
  this.setCreativeTab(Shamanry.TAB);
  this.setBlockName("adobe");
  this.setStepSound(Block.soundTypeGravel);
  this.setHardness(0.06F);
  this.setBlockTextureName("adobe");

  override def getItemDropped(i: Int, rand: Random, j: Int): Item={
    return ShamanryItems.itemAdobeBall;
  }

  override def quantityDropped(rand: Random): Int={
    return 4;
  }
}