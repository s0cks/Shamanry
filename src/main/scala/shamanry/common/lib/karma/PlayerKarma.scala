package shamanry.common.lib.karma

import net.minecraft.nbt.NBTTagCompound
import shamanry.common.lib.ISaveable

class PlayerKarma
extends ISaveable{
  private var good: Double = 0.0F;
  private var bad: Double = 0.0F;

  def getBadKarma(): Double={
    return this.bad;
  }

  def getGoodKarma(): Double={
    return this.good;
  }

  def setGoodKarma(f: Double): Unit ={
    this.good = f;
  }

  def setBadKarma(f: Double): Unit ={
    this.bad = f;
  }

  def addGoodKarma(f: Double): Unit ={
    this.good = this.good + f;
  }

  def subGoodKarma(f: Double): Unit ={
    this.good = this.good - f;
  }

  def addBadKarma(f: Double): Unit ={
    this.bad = this.bad + f;
  }

  def subBadKarma(f: Double): Unit ={
    this.bad = this.bad - f;
  }

  def isNeutral(): Boolean={
    return this.bad == this.good;
  }

  def isEvil(): Boolean={
    return this.bad > this.good;
  }

  def isSaint(): Boolean={
    return this.good > this.bad;
  }

  override def load(comp: NBTTagCompound): Unit ={
    this.good = comp.getDouble("karma_good");
    this.bad = comp.getDouble("karma_bad");
  }

  override def save(comp: NBTTagCompound): Unit ={
    comp.setDouble("karma_good", this.good);
    comp.setDouble("karma_bad", this.bad);
  }
}