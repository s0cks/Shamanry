package shamanry.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.ForgeDirection;
import shamanry.api.IRitual;
import shamanry.api.Rituals;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaTransport;

public class TileRitualAltar
extends TileEntity
implements IEssentiaTransport{
    private IRitual ritual;
    private int currentEssentia;
    private boolean active = false;
    private EntityPlayer player;
    private float rot = 0.0F;
    private float rotation = 90.0F;

    private static final int ESSENTIA_CAPACITY = 16;

    @Override
    public void readFromNBT(NBTTagCompound comp){
        super.readFromNBT(comp);
        this.ritual = Rituals.getRitualByName(comp.getString("ritual"));
        this.currentEssentia = comp.getInteger("currentEssentia");
        this.active = comp.getBoolean("active");
        this.rotation = comp.getFloat("rotation");
    }

    @Override
    public void writeToNBT(NBTTagCompound comp){
        super.writeToNBT(comp);
        comp.setInteger("currentEssentia", this.currentEssentia);
        comp.setString("ritual", this.ritual != null ? this.ritual.getName() : "default");
        comp.setBoolean("active", this.active);
        comp.setFloat("rotation", this.rotation);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pck){
        super.onDataPacket(net, pck);
        this.readFromNBT(pck.func_148857_g());
    }

    @Override
    public S35PacketUpdateTileEntity getDescriptionPacket(){
        NBTTagCompound comp = new NBTTagCompound();
        this.writeToNBT(comp);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, -999, comp);
    }

    public void setRitual(IRitual ritual){
        this.ritual = ritual;
    }

    public void clearEssentia(){
        this.currentEssentia = 0;
    }

    public void activate(EntityPlayer player){
        if(!this.worldObj.isRemote){
            if(ritual.canPerform(this.worldObj, this.xCoord, this.yCoord, this.zCoord, player)){
                this.player = player;
                this.active = true;
                this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            } else{
                player.addChatComponentMessage(new ChatComponentText("You do not have the required karma level(s) to perform this ritual"));
            }
        }
    }

    public IRitual getRitual(){
        return this.ritual;
    }

    public float getRot(){
        return this.rot;
    }

    public float getRotation(){
        return this.rotation;
    }

    public void setRotation(float rotation){
        this.rotation = rotation;
    }

    @Override
    public void updateEntity(){
        if(this.ritual != null){
            this.rot += 2.0F;

            if(this.rot > 360.0F){
                this.rot = 0.0F;
            }
        } else{
            this.rot = 0.0F;
        }

        if(this.currentEssentia < ESSENTIA_CAPACITY){
            this.fill();
        }

        if(this.active && this.currentEssentia == ESSENTIA_CAPACITY){
            if(this.player != null && this.ritual != null){
                this.ritual.perform(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.player);
                this.currentEssentia = 0;
                this.active = false;
                this.player = null;
            }
        }
    }

    private void fill(){
        TileEntity tile = ThaumcraftApiHelper.getConnectableTile(this.worldObj, this.xCoord, this.yCoord, this.zCoord, ForgeDirection.DOWN);
        if(tile != null){
            IEssentiaTransport trans = (IEssentiaTransport) tile;
            if(!trans.canOutputTo(ForgeDirection.UP)){
                return;
            }

            Aspect aspect = this.ritual != null ? this.ritual.getAspect() : null;
            if(trans.getEssentiaAmount(ForgeDirection.UP) > 0 &&
               trans.getSuctionAmount(ForgeDirection.UP) < this.getSuctionAmount(ForgeDirection.UP) &&
               getSuctionAmount(ForgeDirection.UP) >= trans.getMinimumSuction()){

                aspect = trans.getEssentiaType(ForgeDirection.UP);
            }

            if(aspect != null &&
               trans.getSuctionAmount(ForgeDirection.UP) < this.getSuctionAmount(ForgeDirection.DOWN)){
                this.addEssentia(aspect, trans.takeEssentia(aspect, 1, ForgeDirection.UP), ForgeDirection.DOWN);
            }
        }
    }

    @Override
    public boolean isConnectable(ForgeDirection face){
        return face == ForgeDirection.DOWN;
    }

    @Override
    public boolean canInputFrom(ForgeDirection face){
        return face == ForgeDirection.DOWN;
    }

    @Override
    public boolean canOutputTo(ForgeDirection face){
        return false;
    }

    @Override
    public void setSuction(Aspect aspect, int amount){
        // Ignore
    }

    @Override
    public Aspect getSuctionType(ForgeDirection face){
        return face == ForgeDirection.DOWN ? ritual.getAspect() : null;
    }

    @Override
    public int getSuctionAmount(ForgeDirection face){
        return face == ForgeDirection.DOWN ? 128 : 0;
    }

    @Override
    public int takeEssentia(Aspect aspect, int amount, ForgeDirection face){
        return 0;
    }

    @Override
    public int addEssentia(Aspect aspect, int amount, ForgeDirection face){
        int filled = ESSENTIA_CAPACITY - this.currentEssentia;
        if(amount < filled){
            this.currentEssentia += amount;
            filled = amount;
        } else{
            this.currentEssentia = ESSENTIA_CAPACITY;
        }

        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        return filled;
    }

    @Override
    public Aspect getEssentiaType(ForgeDirection face){
        return face == ForgeDirection.DOWN && this.ritual != null ? this.ritual.getAspect() : null;
    }

    @Override
    public int getEssentiaAmount(ForgeDirection face){
        return 0;
    }

    @Override
    public int getMinimumSuction(){
        return 0;
    }

    @Override
    public boolean renderExtendedTube(){
        return false;
    }
}