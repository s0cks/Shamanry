package shamanry.common.block

import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import shamanry.api.Rituals
import shamanry.common.Shamanry
import shamanry.common.item.ItemRiteTablet
import shamanry.common.tile.TileRitualAltar
import shamanry.common.util.RotationHelper
import thaumcraft.api.ThaumcraftApiHelper
import thaumcraft.api.aspects.{Aspect, AspectList}
import thaumcraft.api.wands.IWandable

object BlockRitualAltar
extends BlockContainer(Material.rock)
with IWandable{
  private val cost = new AspectList()
    .add(Aspect.AIR, 1500)
    .add(Aspect.EARTH, 1500)
    .add(Aspect.FIRE, 1500)
    .add(Aspect.WATER, 1500)
    .add(Aspect.ORDER, 1500)
    .add(Aspect.ENTROPY, 1500);

  private var renderID: Int = -1;

  this.setCreativeTab(Shamanry.TAB);
  this.setBlockName("ritual_altar");
  this.setHardness(2.0F);
  this.setResistance(10.0F);

  def setRenderType(i: Int): Unit ={
    this.renderID = i;
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, living: EntityLivingBase, stack: ItemStack): Unit ={
    val tile: TileRitualAltar = world.getTileEntity(x, y, z).asInstanceOf[TileRitualAltar];
    tile.setRotation(RotationHelper.get3DRotation(living));
  }

    override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, i: Int, f: Float, j: Float, k: Float): Boolean = {
    val tile: TileRitualAltar = world.getTileEntity(x, y, z).asInstanceOf[TileRitualAltar];
    if(player.getCurrentEquippedItem != null){
      if(player.getCurrentEquippedItem.getItem.isInstanceOf[ItemRiteTablet]){
        val tablet: ItemRiteTablet = player.getCurrentEquippedItem.getItem.asInstanceOf[ItemRiteTablet];
        tile.setRitual(tablet.getRitual());
        player.getCurrentEquippedItem.stackSize = player.getCurrentEquippedItem.stackSize - 1;
      }
    } else{
      if(player.isSneaking() && tile.getRitual != null) {
        if (!world.isRemote) {
          val stack: ItemStack = Rituals.getTablet(tile.getRitual.getName);
          val item: EntityItem = new EntityItem(world, x, y, z, stack);
          world.spawnEntityInWorld(item);
        }
        tile.setRitual(null);
        tile.clearEssentia();
      }
    }
    world.markBlockForUpdate(x, y, z);
    return true;
  }

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity ={
    return new TileRitualAltar();
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }

  override def getRenderType(): Int={
    return this.renderID;
  }

  override def onWandRightClick(world: World, wandstack: ItemStack, player: EntityPlayer, x: Int, y: Int, z: Int, side: Int, md: Int): Int ={
    if(ThaumcraftApiHelper.consumeVisFromInventory(player, cost)){
      val tile = world.getTileEntity(x, y, z).asInstanceOf[TileRitualAltar];
      tile.activate(player);
    }
    return 0;
  }

  override def onWandStoppedUsing(wandstack: ItemStack, world: World, player: EntityPlayer, count: Int): Unit ={

  }

  override def onUsingWandTick(wandstack: ItemStack, player: EntityPlayer, count: Int): Unit ={

  }

  override def onWandRightClick(world: World, wandstack: ItemStack, player: EntityPlayer): ItemStack ={
    return wandstack;
  }
}