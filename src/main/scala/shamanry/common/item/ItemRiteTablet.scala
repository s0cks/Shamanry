package shamanry.common.item

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.Item
import shamanry.api.IRitual
import shamanry.common.Shamanry

class ItemRiteTablet(rite: IRitual)
extends Item{
  this.setCreativeTab(Shamanry.TAB);
  this.setUnlocalizedName("rite_tablet_" + rite.getName());
  this.setMaxStackSize(1);

  def getRitual(): IRitual={
    return this.rite;
  }

  override def registerIcons(register: IIconRegister): Unit ={
    this.itemIcon = register.registerIcon("shamanry:" + this.rite.getType.getTexture);
  }

  /*
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
  */
}
