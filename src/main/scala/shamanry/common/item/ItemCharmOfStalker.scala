package shamanry.common.item

import baubles.api.{BaubleType, IBauble}
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import shamanry.common.Shamanry
import shamanry.common.lib.karma.Karma

object ItemCharmOfStalker
extends Item
with IBauble{
  this.setUnlocalizedName("itemCharmOfStalker");
  this.setTextureName("shamanry:amuletDemonic");
  this.setCreativeTab(Shamanry.TAB);

  override def getBaubleType(itemstack: ItemStack): BaubleType ={
    return BaubleType.AMULET;
  }

  override def onWornTick(itemstack: ItemStack, player: EntityLivingBase): Unit ={
    if(player.isSneaking && Karma.get(player.asInstanceOf[EntityPlayer]).isEvil()){
      player.setInvisible(true);
    } else{
      player.setInvisible(false);
    }
  }

  override def canUnequip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }

  override def onUnequipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={}

  override def onEquipped(itemstack: ItemStack, player: EntityLivingBase): Unit ={}

  override def canEquip(itemstack: ItemStack, player: EntityLivingBase): Boolean ={
    return true;
  }
}