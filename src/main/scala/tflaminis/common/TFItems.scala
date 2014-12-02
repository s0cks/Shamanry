package tflaminis.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.Item
import tflaminis.common.item.ItemRiteTablet

object TFItems{
  // Wands
  val itemShamanicCapUncharged = new Item()
    .setUnlocalizedName("capShamanicUncharged")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:capShamanicUncharged");
  val itemShamanicCapCharged = new Item()
    .setUnlocalizedName("capShamanicCharged")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:capShamanicCharged");
  val itemShamanicStaffCore = new Item()
    .setUnlocalizedName("shamanicStaffCore")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:staffCoreShamanic");

  // Misc
  val itemStoneKnife = new Item()
    .setUnlocalizedName("stone_knife")
    .setCreativeTab(ThaumicFlaminis.TAB)
    .setTextureName("tflaminis:stone_knife");

  // Rite Tablets
  val itemTabletKnowledge = new ItemRiteTablet(TFRituals.KNOWLEDGE);
  val itemTabletTest = new ItemRiteTablet(TFRituals.TEST);

  def init(): Unit ={
    // Wands
    GameRegistry.registerItem(itemShamanicStaffCore, "itemShamanicStaffCore");
    GameRegistry.registerItem(itemShamanicCapCharged, "itemShamanicCapCharged");
    GameRegistry.registerItem(itemShamanicCapUncharged, "itemShamanicCapUncharged");

    // Misc
    GameRegistry.registerItem(itemStoneKnife, "itemStoneKnife");

    // Rite Tablets
    GameRegistry.registerItem(itemTabletKnowledge, "itemTabletKnowledge");
    GameRegistry.registerItem(itemTabletTest, "itemTabletTest");
  }
}