package shamanry.common.lib

import net.minecraft.nbt.NBTTagCompound

trait ISaveable{
  def load(comp: NBTTagCompound);
  def save(comp: NBTTagCompound);
}