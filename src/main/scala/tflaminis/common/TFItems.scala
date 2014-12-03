package tflaminis.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.ResourceLocation
import thaumcraft.api.wands.WandRod

object TFItems{
  // Wands
  val itemShamanicCapUncharged: Item = new Item()
    .setUnlocalizedName("capShamanicUncharged")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:capShamanicUncharged");
  val itemShamanicCapCharged: Item = new Item()
    .setUnlocalizedName("capShamanicCharged")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:capShamanicCharged");
  val itemShamanicStaffCore: Item = new Item()
    .setUnlocalizedName("shamanicStaffCore")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:staffCoreShamanic");
  val itemShamanicWandCore: Item = new Item()
    .setUnlocalizedName("shamanicWandCore")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:wandCoreShamanic");
  val itemGoodTabletBlank: Item = new Item()
    .setUnlocalizedName("stoneTabletBlank")
    .setMaxStackSize(1)
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:good_tablet_raw");
  val itemEvilTabletBlank: Item = new Item()
    .setUnlocalizedName("evilTabletBlank")
    .setMaxStackSize(1)
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:evil_tablet_raw");

  // Misc
  val itemStoneKnife: Item = new Item()
    .setUnlocalizedName("stone_knife")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:stone_knife");

  val WAND_SHAMANIC: WandRod = new WandRod("SHAMANIC", 100, new ItemStack(TFItems.itemShamanicWandCore), 15, null, new ResourceLocation("tflaminis", "textures/models/wandCoreShamanic.png"));

  def init(): Unit ={
    // Wands
    GameRegistry.registerItem(itemShamanicStaffCore, "itemShamanicStaffCore");
    GameRegistry.registerItem(itemShamanicWandCore, "itemShamanicWandCore");
    GameRegistry.registerItem(itemShamanicCapCharged, "itemShamanicCapCharged");
    GameRegistry.registerItem(itemShamanicCapUncharged, "itemShamanicCapUncharged");

    // Misc
    GameRegistry.registerItem(itemStoneKnife, "itemStoneKnife");

    // Rite Tablets
    GameRegistry.registerItem(itemGoodTabletBlank, "itemGoodTabletBlank");
    GameRegistry.registerItem(itemEvilTabletBlank, "itemEvilTabletBlank");
  }
}