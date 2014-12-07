package shamanry.common.util

import java.util.Random

import net.minecraft.world.World

object SoundHelper{
  private val rand = new Random();

  def playThunderEffect(world: World, x: Int, y: Int, z: Int): Unit ={
    world.playSoundEffect(x, y, z, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat * 0.2F)
    world.playSoundEffect(x, y, z, "random.explode", 2.0F, 0.5F + this.rand.nextFloat * 0.2F)
  }
}