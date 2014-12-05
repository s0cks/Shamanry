package shamanry.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Altar -
 * Created using Tabula 4.0.2
 */
public final class ModelAltar extends ModelBase {
    public ModelRenderer altarBase;
    public ModelRenderer altarTop;
    public ModelRenderer altarPillar_1;
    public ModelRenderer altarPillar_2;
    public ModelRenderer altarPillar_3;
    public ModelRenderer altarPillar_4;
    public ModelRenderer tabletBottom;
    public ModelRenderer tabletRight3;
    public ModelRenderer tabletRight2;
    public ModelRenderer tabletRight1;
    public ModelRenderer tabletCenter;
    public ModelRenderer tabletLeft1;
    public ModelRenderer tabletLeft;
    public ModelRenderer tabletLeft2;
    public ModelRenderer tabletRight;

    public ModelAltar() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tabletBottom = new ModelRenderer(this, 0, 42);
        this.tabletBottom.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletBottom.addBox(-4.0F, 15.0F, 0.0F, 9, 1, 1);
        this.setRotateAngle(tabletBottom, -1.3526301702956054F, 0.0F, 0.0F);
        this.tabletRight = new ModelRenderer(this, 28, 26);
        this.tabletRight.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletRight.addBox(3.0F, 1.0F, 0.0F, 1, 14, 1);
        this.setRotateAngle(tabletRight, -1.3526301702956054F, 0.0F, 0.0F);
        this.altarTop = new ModelRenderer(this, 0, 14);
        this.altarTop.setRotationPoint(6.0F, -10.0F, 6.0F);
        this.altarTop.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10);
        this.setRotateAngle(altarTop, 0.2181661564992912F, 0.0F, 0.0F);
        this.tabletLeft2 = new ModelRenderer(this, 8, 26);
        this.tabletLeft2.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletLeft2.addBox(-5.0F, 1.0F, 0.0F, 2, 14, 1);
        this.setRotateAngle(tabletLeft2, -1.3526301702956054F, 0.0F, 0.0F);
        this.altarPillar_4 = new ModelRenderer(this, 48, 0);
        this.altarPillar_4.setRotationPoint(11.0F, 0.0F, 11.0F);
        this.altarPillar_4.addBox(-2.0F, -10.0F, -2.0F, 2, 10, 2);
        this.setRotateAngle(altarPillar_4, 0.2792526803190927F, 0.0F, -0.2617993877991494F);
        this.tabletRight2 = new ModelRenderer(this, 36, 26);
        this.tabletRight2.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletRight2.addBox(5.0F, 3.0F, 0.0F, 1, 11, 1);
        this.setRotateAngle(tabletRight2, -1.3526301702956054F, 0.0F, 0.0F);
        this.tabletRight1 = new ModelRenderer(this, 32, 26);
        this.tabletRight1.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletRight1.addBox(4.0F, 2.0F, 0.0F, 1, 13, 1);
        this.setRotateAngle(tabletRight1, -1.3526301702956054F, 0.0F, 0.0F);
        this.altarPillar_1 = new ModelRenderer(this, 48, 0);
        this.altarPillar_1.setRotationPoint(1.0F, 0.0F, 1.0F);
        this.altarPillar_1.addBox(0.0F, -10.0F, 0.0F, 2, 10, 2);
        this.setRotateAngle(altarPillar_1, -0.2617993877991494F, 0.0F, 0.2617993877991494F);
        this.altarBase = new ModelRenderer(this, 0, 0);
        this.altarBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.altarBase.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12);
        this.tabletCenter = new ModelRenderer(this, 14, 26);
        this.tabletCenter.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletCenter.addBox(-3.0F, 0.0F, 0.0F, 6, 15, 1);
        this.setRotateAngle(tabletCenter, -1.3526301702956054F, 0.0F, 0.0F);
        this.altarPillar_3 = new ModelRenderer(this, 48, 0);
        this.altarPillar_3.setRotationPoint(1.0F, 0.0F, 11.0F);
        this.altarPillar_3.addBox(0.0F, -10.0F, -2.0F, 2, 10, 2);
        this.setRotateAngle(altarPillar_3, 0.2617993877991494F, 0.0F, 0.2617993877991494F);
        this.tabletLeft = new ModelRenderer(this, 0, 26);
        this.tabletLeft.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletLeft.addBox(-7.0F, 3.0F, 0.0F, 1, 8, 1);
        this.setRotateAngle(tabletLeft, -1.3526301702956054F, 0.0F, 0.0F);
        this.tabletLeft1 = new ModelRenderer(this, 4, 26);
        this.tabletLeft1.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletLeft1.addBox(-6.0F, 2.0F, 0.0F, 1, 11, 1);
        this.setRotateAngle(tabletLeft1, -1.3526301702956054F, 0.0F, 0.0F);
        this.altarPillar_2 = new ModelRenderer(this, 48, 0);
        this.altarPillar_2.setRotationPoint(11.0F, 0.0F, 1.0F);
        this.altarPillar_2.addBox(-2.0F, -10.0F, 0.0F, 2, 10, 2);
        this.setRotateAngle(altarPillar_2, -0.2617993877991494F, 0.0F, -0.2617993877991494F);
        this.tabletRight3 = new ModelRenderer(this, 40, 26);
        this.tabletRight3.setRotationPoint(5.899999999999974F, -11.299999999999981F, 9.799999999999988F);
        this.tabletRight3.addBox(6.0F, 4.0F, 0.0F, 1, 9, 1);
        this.setRotateAngle(tabletRight3, -1.3526301702956054F, 0.0F, 0.0F);
    }


    public void renderAltar(){
        float f = 0.0625F;
        this.altarBase.render(f);
        this.altarTop.render(f);
        this.altarPillar_1.render(f);
        this.altarPillar_2.render(f);
        this.altarPillar_3.render(f);
        this.altarPillar_4.render(f);
    }

    public void renderTablet(){
        float f5 = 0.0625F;
        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletBottom.offsetX, this.tabletBottom.offsetY, this.tabletBottom.offsetZ);
        GL11.glTranslatef(this.tabletBottom.rotationPointX * f5, this.tabletBottom.rotationPointY * f5, this.tabletBottom.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletBottom.offsetX, -this.tabletBottom.offsetY, -this.tabletBottom.offsetZ);
        GL11.glTranslatef(-this.tabletBottom.rotationPointX * f5, -this.tabletBottom.rotationPointY * f5, -this.tabletBottom.rotationPointZ * f5);
        this.tabletBottom.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletRight.offsetX, this.tabletRight.offsetY, this.tabletRight.offsetZ);
        GL11.glTranslatef(this.tabletRight.rotationPointX * f5, this.tabletRight.rotationPointY * f5, this.tabletRight.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletRight.offsetX, -this.tabletRight.offsetY, -this.tabletRight.offsetZ);
        GL11.glTranslatef(-this.tabletRight.rotationPointX * f5, -this.tabletRight.rotationPointY * f5, -this.tabletRight.rotationPointZ * f5);
        this.tabletRight.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletLeft2.offsetX, this.tabletLeft2.offsetY, this.tabletLeft2.offsetZ);
        GL11.glTranslatef(this.tabletLeft2.rotationPointX * f5, this.tabletLeft2.rotationPointY * f5, this.tabletLeft2.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletLeft2.offsetX, -this.tabletLeft2.offsetY, -this.tabletLeft2.offsetZ);
        GL11.glTranslatef(-this.tabletLeft2.rotationPointX * f5, -this.tabletLeft2.rotationPointY * f5, -this.tabletLeft2.rotationPointZ * f5);
        this.tabletLeft2.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletRight2.offsetX, this.tabletRight2.offsetY, this.tabletRight2.offsetZ);
        GL11.glTranslatef(this.tabletRight2.rotationPointX * f5, this.tabletRight2.rotationPointY * f5, this.tabletRight2.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletRight2.offsetX, -this.tabletRight2.offsetY, -this.tabletRight2.offsetZ);
        GL11.glTranslatef(-this.tabletRight2.rotationPointX * f5, -this.tabletRight2.rotationPointY * f5, -this.tabletRight2.rotationPointZ * f5);
        this.tabletRight2.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletRight1.offsetX, this.tabletRight1.offsetY, this.tabletRight1.offsetZ);
        GL11.glTranslatef(this.tabletRight1.rotationPointX * f5, this.tabletRight1.rotationPointY * f5, this.tabletRight1.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletRight1.offsetX, -this.tabletRight1.offsetY, -this.tabletRight1.offsetZ);
        GL11.glTranslatef(-this.tabletRight1.rotationPointX * f5, -this.tabletRight1.rotationPointY * f5, -this.tabletRight1.rotationPointZ * f5);
        this.tabletRight1.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletCenter.offsetX, this.tabletCenter.offsetY, this.tabletCenter.offsetZ);
        GL11.glTranslatef(this.tabletCenter.rotationPointX * f5, this.tabletCenter.rotationPointY * f5, this.tabletCenter.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletCenter.offsetX, -this.tabletCenter.offsetY, -this.tabletCenter.offsetZ);
        GL11.glTranslatef(-this.tabletCenter.rotationPointX * f5, -this.tabletCenter.rotationPointY * f5, -this.tabletCenter.rotationPointZ * f5);
        this.tabletCenter.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletLeft.offsetX, this.tabletLeft.offsetY, this.tabletLeft.offsetZ);
        GL11.glTranslatef(this.tabletLeft.rotationPointX * f5, this.tabletLeft.rotationPointY * f5, this.tabletLeft.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletLeft.offsetX, -this.tabletLeft.offsetY, -this.tabletLeft.offsetZ);
        GL11.glTranslatef(-this.tabletLeft.rotationPointX * f5, -this.tabletLeft.rotationPointY * f5, -this.tabletLeft.rotationPointZ * f5);
        this.tabletLeft.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletLeft1.offsetX, this.tabletLeft1.offsetY, this.tabletLeft1.offsetZ);
        GL11.glTranslatef(this.tabletLeft1.rotationPointX * f5, this.tabletLeft1.rotationPointY * f5, this.tabletLeft1.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletLeft1.offsetX, -this.tabletLeft1.offsetY, -this.tabletLeft1.offsetZ);
        GL11.glTranslatef(-this.tabletLeft1.rotationPointX * f5, -this.tabletLeft1.rotationPointY * f5, -this.tabletLeft1.rotationPointZ * f5);
        this.tabletLeft1.render(f5);
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef(this.tabletRight3.offsetX, this.tabletRight3.offsetY, this.tabletRight3.offsetZ);
        GL11.glTranslatef(this.tabletRight3.rotationPointX * f5, this.tabletRight3.rotationPointY * f5, this.tabletRight3.rotationPointZ * f5);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        GL11.glTranslatef(-this.tabletRight3.offsetX, -this.tabletRight3.offsetY, -this.tabletRight3.offsetZ);
        GL11.glTranslatef(-this.tabletRight3.rotationPointX * f5, -this.tabletRight3.rotationPointY * f5, -this.tabletRight3.rotationPointZ * f5);
        this.tabletRight3.render(f5);
        GL11.glPopMatrix();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
