package shamanry.common.lib.karma

import java.util

import net.minecraft.entity.player.EntityPlayer

object Karma{
  private val instances: util.Map[EntityPlayer, PlayerKarma] = new util.HashMap[EntityPlayer, PlayerKarma]();

  def get(player: EntityPlayer): PlayerKarma ={
    return this.instances.get(player);
  }

  def put(player: EntityPlayer, karma: PlayerKarma): Unit ={
    this.instances.put(player, karma);
  }
}
