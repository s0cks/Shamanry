package shamanry.common

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.ResourceLocation
import shamanry.common.item.{ItemCharmOfHeavens, ItemCharmOfStalker, ItemCharmOfSacrifice, ItemCharmOfBlessing}
import thaumcraft.api.wands.{StaffRod, WandRod}

object ShamanryItems{
  // Wands
  val itemShamanicStaffCore: Item = new Item()
    .setUnlocalizedName("shamanicStaffCore")
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:staffCoreShamanic");
  val itemShamanicWandCore: Item = new Item()
    .setUnlocalizedName("shamanicWandCore")
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:wandCoreShamanic");
  val itemGoodTabletBlank: Item = new Item()
    .setUnlocalizedName("stoneTabletBlank")
    .setMaxStackSize(1)
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:good_tablet_raw");
  val itemEvilTabletBlank: Item = new Item()
    .setUnlocalizedName("evilTabletBlank")
    .setMaxStackSize(1)
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:evil_tablet_raw");
  val itemAdobeBall = new Item()
    .setUnlocalizedName("adobe")
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:adobe_ball");
  val itemAdobeBrick = new Item()
    .setUnlocalizedName("adobe_brick")
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:adobe_brick");

  // Misc
  val itemStoneKnife: Item = new Item()
    .setUnlocalizedName("stone_knife")
    .setCreativeTab(Shamanry.TAB)
    .setTextureName("shamanry:stone_knife");

  val WAND_SHAMANIC: WandRod = new WandRod("SHAMANIC", 100, new ItemStack(ShamanryItems.itemShamanicWandCore), 15, null, new ResourceLocation("shamanry", "textures/models/wandCoreShamanic.png"));
  val STAFF_SHAMANIC: StaffRod = new StaffRod("SHAMANIC", 200, new ItemStack(ShamanryItems.itemShamanicStaffCore), 30, null, new ResourceLocation("shamanry", "textures/models/wandCoreShamanic.png"));


  def init(): Unit ={
    // Wands
    GameRegistry.registerItem(itemShamanicStaffCore, "itemShamanicStaffCore");
    GameRegistry.registerItem(itemShamanicWandCore, "itemShamanicWandCore");

    // Misc
    GameRegistry.registerItem(itemStoneKnife, "itemStoneKnife");
    GameRegistry.registerItem(itemAdobeBall, "itemAdobeBall");
    GameRegistry.registerItem(itemAdobeBrick, "itemAdobeBrick");

    // Rite Tablets
    GameRegistry.registerItem(itemGoodTabletBlank, "itemGoodTabletBlank");
    GameRegistry.registerItem(itemEvilTabletBlank, "itemEvilTabletBlank");

    // Baubles
    GameRegistry.registerItem(ItemCharmOfBlessing, "itemCharmOfBlessing");
    GameRegistry.registerItem(ItemCharmOfSacrifice, "itemCharmOfSacrifice");
    GameRegistry.registerItem(ItemCharmOfStalker, "itemCharmOfStalker");
    GameRegistry.registerItem(ItemCharmOfHeavens, "itemCharmOfHeavens");
  }
}