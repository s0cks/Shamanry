package shamanry.client.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.IBlockAccess
import org.lwjgl.opengl.GL11
import shamanry.client.model.ModelAltar
import shamanry.common.tile.TileRitualAltar

class RenderAltar(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler{
  private val texture: ResourceLocation = new ResourceLocation("shamanry", "textures/models/altar_good.png");
  private val model: ModelAltar = new ModelAltar();

  override def renderTileEntityAt(tiles : TileEntity, x : Double, y : Double, z: Double, p_147500_8_ : Float): Unit ={
    val tile: TileRitualAltar = tiles.asInstanceOf[TileRitualAltar];

    if(tile.getRitual != null){
      this.bindTexture(tile.getRitual.getType.getModelTexture);
    } else{
      this.bindTexture(this.texture);
    }

    GL11.glPushMatrix();
    GL11.glTranslated(x + 0.15F, y + 0.1F, z + 0.85F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    this.model.renderAltar();

    if(tile.getRitual != null){
      this.model.renderTablet();
    }

    GL11.glPopMatrix();
  }

  override def getRenderId: Int ={
    return this.id;
  }

  override def shouldRender3DInInventory(modelId: Int): Boolean ={
    return true;
  }

  override def renderInventoryBlock(block: Block, metadata: Int, modelId: Int, renderer: RenderBlocks): Unit ={

  }

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean ={
    return true;
  }
}
