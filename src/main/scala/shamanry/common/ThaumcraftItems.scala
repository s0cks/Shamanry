package shamanry.common

import net.minecraft.item.ItemStack
import thaumcraft.api.ItemApi

object ThaumcraftItems {
  val itemKnowledgeFrag: ItemStack = ItemApi.getItem("itemResource", 9);
  val itemBalancedShard: ItemStack = ItemApi.getItem("itemShard", 6);

  val blockGreatwoodLog: ItemStack = ItemApi.getBlock("blockMagicalLog", 0);
  val blockArcaneStone = ItemApi.getBlock("blockCosmeticSolid", 6);
}