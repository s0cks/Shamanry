package shamanry.common.item

import baubles.api.{BaubleType, IBauble}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import shamanry.common.Shamanry
import shamanry.common.lib.karma.Karma

object ItemCharmOfBlessing
extends Item
with IBauble{
  private val karma_buff: Float = 0.5F;

  this.setUnlocalizedName("itemCharmOfBlessings");
  this.setTextureName("shamanry:amuletAngelic");
  this.setCreativeTab(Shamanry.TAB);

  override def getBaubleType(itemstack: ItemStack): BaubleType ={
    return BaubleType.AMULET;
  }

  override def onWornTick(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    // Ignore
  }

  override def canUnequip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }

  override def onUnequipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    Karma.get(player.asInstanceOf[EntityPlayer]).addBadKarma(this.karma_buff);
  }

  override def onEquipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    Karma.get(player.asInstanceOf[EntityPlayer]).subBadKarma(this.karma_buff);
  }


  override def canEquip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }
}