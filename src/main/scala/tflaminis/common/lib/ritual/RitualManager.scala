package tflaminis.common.lib.ritual

import java.io.{File, FileInputStream, FileOutputStream}

import cpw.mods.fml.common.ObfuscationReflectionHelper
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.{CompressedStreamTools, NBTTagCompound}
import net.minecraft.server.MinecraftServer
import net.minecraft.world.storage.{IPlayerFileData, SaveHandler}

object RitualManager {
  def loadPlayerData(p: EntityPlayer): Unit ={
    val pNBTManagerObj: IPlayerFileData = MinecraftServer.getServer.worldServerForDimension(0).getSaveHandler.getSaveHandler;
    val sh: SaveHandler = pNBTManagerObj.asInstanceOf[SaveHandler];
    val dir: File = ObfuscationReflectionHelper.getPrivateValue(classOf[SaveHandler], sh, "playersDirectory", "field_75771_c");
    val file: File = new File(dir, p.getDisplayName + ".ritual");
    val comp: NBTTagCompound = this.load(file);
    val rituals: PlayerRituals = new PlayerRituals();
    rituals.load(comp);
    Rites.put(p, rituals);
  }

  def savePlayerData(p: EntityPlayer): Unit ={
    val pNBTManagerObj: IPlayerFileData = MinecraftServer.getServer.worldServerForDimension(0).getSaveHandler.getSaveHandler;
    val sh: SaveHandler = pNBTManagerObj.asInstanceOf[SaveHandler];
    val dir: File = ObfuscationReflectionHelper.getPrivateValue(classOf[SaveHandler], sh, "playersDirectory", "field_75771_c");
    val file: File = new File(dir, p.getDisplayName + ".ritual");
    val comp: NBTTagCompound = new NBTTagCompound();
    Rites.get(p).save(comp);
    this.save(comp, file);
  }

  private def load(file: File): NBTTagCompound={
    try{
      var comp: NBTTagCompound = new NBTTagCompound();
      if(file != null && file.exists()){
        try{
          val fis: FileInputStream = new FileInputStream(file);
          comp = CompressedStreamTools.readCompressed(fis);
        } catch{
          case ex: Exception=>{
            ex.printStackTrace(System.err);
          }
        }
      }
      return comp;
    } catch{
      case ex: Exception=>{
        ex.printStackTrace(System.err);
        return new NBTTagCompound();
      }
    }
  }

  private def save(comp: NBTTagCompound, file: File): Unit ={
    try{
      val fos: FileOutputStream = new FileOutputStream(file);
      CompressedStreamTools.writeCompressed(comp, fos);
      fos.close();
    } catch{
      case ex: Exception =>{
        ex.printStackTrace(System.err);
      }
    }
  }
}
