package tflaminis.common.lib.karma

import net.minecraft.nbt.NBTTagCompound

class PlayerKarma{
  private var good: Float = 0.0F;
  private var bad: Float = 0.0F;

  def getBadKarma(): Float={
    return this.bad;
  }

  def getGoodKarma(): Float={
    return this.good;
  }

  def setGoodKarma(f: Float): Unit ={
    this.good = f;
  }

  def setBadKarma(f: Float): Unit ={
    this.bad = f;
  }

  def addGoodKarma(f: Float): Unit ={
    this.good = this.good + f;
  }

  def subGoodKarma(f: Float): Unit ={
    this.good = this.good - f;
  }

  def addBadKarma(f: Float): Unit ={
    this.bad = this.bad + f;
  }

  def subBadKarma(f: Float): Unit ={
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

  def load(comp: NBTTagCompound): Unit ={
    this.good = comp.getFloat("karma_good");
    this.bad = comp.getFloat("karma_bad");
  }

  def save(comp: NBTTagCompound): Unit ={
    comp.setFloat("karma_good", this.good);
    comp.setFloat("karma_bad", this.bad);
  }
}