package tflaminis.common.item

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import tflaminis.api.IRitual
import tflaminis.common.ThaumicFlaminis

class ItemRiteTablet(rite: IRitual)
extends Item{
  this.setCreativeTab(ThaumicFlaminis.TAB);
  this.setUnlocalizedName("rite_tablet_" + rite.getName());
  this.setTextureName("tflaminis:tablet_writing");
  this.setMaxStackSize(1);

  override def onItemRightClick(stack: ItemStack, world: World, player: EntityPlayer): ItemStack={
    if(this.rite.hasRequiredKarma(player)){
      stack.stackSize = stack.stackSize - 1;
      player.addChatComponentMessage(new ChatComponentText("Ritual Learned"));
    } else{
      player.addChatComponentMessage(new ChatComponentText("You don't have the required karma to learn this ritual"));
    }
    return stack;
  }
}
