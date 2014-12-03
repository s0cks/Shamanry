package tflaminis.common.lib.ritual

import java.util

import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import tflaminis.common.lib.ISaveable
import scala.collection.JavaConversions._

class PlayerRituals
extends ISaveable{
  private val rituals: util.List[String] = new util.LinkedList[String]();

  def unlock(str: String): Unit ={
    this.rituals.add(str);
  }

  def isUnlocked(str: String): Boolean={
    return this.rituals.contains(str);
  }

  override def load(comp: NBTTagCompound): Unit ={
    val rites: NBTTagList = comp.getTagList("tflaminis.rites", 10);
    for(i: Int <- 0 to rites.tagCount()){
      val comp: NBTTagCompound = rites.getCompoundTagAt(i);
      if(!comp.getString("key").isEmpty()){
        this.rituals.add(comp.getString("key"));
      }
    }
    System.out.println("Loaded " + this.rituals.size() + " Unlocked Rituals");
  }

  override def save(comp: NBTTagCompound): Unit ={
    val rites: NBTTagList = new NBTTagList();
    for(str: String <- this.rituals){
      if(!str.isEmpty()){
        val comp: NBTTagCompound = new NBTTagCompound();
        comp.setString("key", str);
        rites.appendTag(comp);
      }
    }

    comp.setTag("tflaminis.rites", rites);
  }
}