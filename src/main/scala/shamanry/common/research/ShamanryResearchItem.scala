package shamanry.common.research

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.item.ItemStack
import net.minecraft.util.StatCollector
import thaumcraft.api.aspects.AspectList
import thaumcraft.api.research.ResearchItem

class ShamanryResearchItem(tag: String, cat: String, aspects: AspectList, row: Int, col: Int, complex: Int, stack: ItemStack)
extends ResearchItem(tag, cat, aspects, row, col, complex, stack){
  @SideOnly(Side.CLIENT)
  override def getName(): String={
    return StatCollector.translateToLocal("tf.name." + this.key);
  }

  @SideOnly(Side.CLIENT)
  override def getText(): String={
    return StatCollector.translateToLocal("tf.tag." + this.key);
  }
}