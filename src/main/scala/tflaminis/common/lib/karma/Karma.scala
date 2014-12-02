package tflaminis.common.lib.karma

import net.minecraft.entity.player.EntityPlayer
import java.util

object Karma{
  private val instances: util.Map[EntityPlayer, PlayerKarma] = new util.HashMap[EntityPlayer, PlayerKarma]();

  def get(player: EntityPlayer): PlayerKarma ={
    return this.instances.get(player);
  }

  def put(player: EntityPlayer, karma: PlayerKarma): Unit ={
    this.instances.put(player, karma);
  }
}
