package shamanry.common.item

import baubles.api.{BaubleType, IBauble}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import shamanry.common.Shamanry
import shamanry.common.lib.karma.Karma

object ItemCharmOfHeavens
extends Item
with IBauble{
  this.setUnlocalizedName("itemCharmOfHeavens");
  this.setTextureName("shamanry:amuletAngelic");
  this.setCreativeTab(Shamanry.TAB);

  override def getBaubleType(itemstack: ItemStack): BaubleType ={
    return BaubleType.AMULET;
  }

  override def onWornTick(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    if(Karma.get(player.asInstanceOf[EntityPlayer]).isSaint()){
      player.asInstanceOf[EntityPlayer].capabilities.allowFlying = true;
    } else{
      player.asInstanceOf[EntityPlayer].capabilities.allowFlying = false;
    }
  }

  override def canUnequip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }

  override def onUnequipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    player.asInstanceOf[EntityPlayer].capabilities.allowFlying = false;
  }

  override def onEquipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={

  }

  override def canEquip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }
}
