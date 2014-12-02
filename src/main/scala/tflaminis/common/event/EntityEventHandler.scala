package tflaminis.common.event

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import tflaminis.common.lib.karma.KarmaManager

object EntityEventHandler{
  @SubscribeEvent
  def onPlayerLoad(e: PlayerEvent.LoadFromFile): Unit ={
    KarmaManager.loadPlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerSave(e: PlayerEvent.SaveToFile): Unit ={
    KarmaManager.savePlayerData(e.entityPlayer);
  }
}