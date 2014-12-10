package shamanry.client.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.IBlockAccess
import org.lwjgl.opengl.GL11
import shamanry.api.Rituals
import shamanry.client.model.ModelAltar
import shamanry.common.tile.TileRitualAltar
import shamanry.common.util.RenderHelper

class RenderAltar(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler{
  private val texture: ResourceLocation = new ResourceLocation("shamanry", "textures/models/ritualAltar.png");
  private val model: ModelAltar = new ModelAltar();

  override def renderTileEntityAt(tiles : TileEntity, x : Double, y : Double, z: Double, p_147500_8_ : Float): Unit ={
    val tile: TileRitualAltar = tiles.asInstanceOf[TileRitualAltar];

    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(x + 0.15F, y + 0.1F, z + 0.85F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    this.model.renderAltar();

    if(tile.getRitual != null){
      GL11.glTranslated(0.35F, -0.9F, 0.35F);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glRotatef(tile.getRot, 0.0F, 1.0F, 0.0F);
      RenderHelper.renderItem3D(Rituals.getTablet(tile.getRitual.getName));
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
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glScalef(1.25F, 1.25F, 1.25F);
    GL11.glTranslatef(0.0F, 0.0F, 0.75F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    this.model.renderAltar();
    GL11.glPopMatrix();
  }

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean ={
    return true;
  }
}
