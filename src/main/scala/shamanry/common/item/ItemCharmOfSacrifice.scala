package shamanry.common.item

import baubles.api.{BaubleType, IBauble}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import shamanry.common.Shamanry
import shamanry.common.lib.karma.Karma

object ItemCharmOfSacrifice
extends Item
with IBauble{
  private val karma_buff: Float = 0.5F;

  this.setUnlocalizedName("itemCharmOfSacrifice");
  this.setTextureName("shamanry:amuletDemonic");
  this.setCreativeTab(Shamanry.TAB);

  override def getBaubleType(itemstack: ItemStack): BaubleType={
    return BaubleType.AMULET;
  }

  override def onWornTick(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    // Ignore
  }

  override def canUnequip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }

  override def onUnequipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    Karma.get(player.asInstanceOf[EntityPlayer]).addGoodKarma(this.karma_buff);
  }

  override def onEquipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    Karma.get(player.asInstanceOf[EntityPlayer]).subGoodKarma(this.karma_buff);
  }

  override def canEquip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }
}
