package shamanry.common.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import shamanry.common.Shamanry

class BlockShamanry(mat: Material)
extends Block(mat){
  this.setCreativeTab(Shamanry.TAB);
}