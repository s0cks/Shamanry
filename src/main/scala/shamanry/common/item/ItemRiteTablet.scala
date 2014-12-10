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
}
