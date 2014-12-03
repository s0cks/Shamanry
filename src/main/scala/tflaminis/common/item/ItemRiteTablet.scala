package tflaminis.common.item

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import tflaminis.api.IRitual
import tflaminis.common.ThaumicFlaminis
import tflaminis.common.lib.ritual.Rites

class ItemRiteTablet(rite: IRitual)
extends Item{
  this.setCreativeTab(ThaumicFlaminis.TAB);
  this.setUnlocalizedName("rite_tablet_" + rite.getName());
  this.setTextureName("tflaminis:tablet_writing");
  this.setMaxStackSize(1);

  override def registerIcons(register: IIconRegister): Unit ={
    this.itemIcon = register.registerIcon("tflaminis:" + this.rite.getType.getTexture);
  }

  override def onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack={
    if(!world.isRemote){
      if(this.rite.hasRequiredKarma(player)){
        if(Rites.get(player).isUnlocked(this.rite.getName)){
          player.addChatComponentMessage(new ChatComponentText("Ritual is already unlocked"));
        } else{
          stack.stackSize = stack.stackSize - 1;
          Rites.get(player).unlock(this.rite.getName);
          player.addChatComponentMessage(new ChatComponentText("Ritual Learned"));
        }
      } else{
        player.addChatComponentMessage(new ChatComponentText("You don't have the required karma to learn this ritual"));
      }
    }

    return stack;
  }
}
