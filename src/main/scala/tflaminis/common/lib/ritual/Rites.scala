package tflaminis.common.lib.ritual

import java.util

import net.minecraft.entity.player.EntityPlayer

object Rites{
  private val instances: util.Map[EntityPlayer, PlayerRituals] = new util.HashMap[EntityPlayer, PlayerRituals]();

  def get(player: EntityPlayer): PlayerRituals={
    return this.instances.get(player);
  }

  def put(player: EntityPlayer, ritual: PlayerRituals): Unit ={
    this.instances.put(player, ritual);
  }
}