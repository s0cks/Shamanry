package shamanry.common.event

import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.{PlayerEvent => PEvent}
import cpw.mods.fml.relauncher.Side
import net.minecraftforge.event.entity.player.PlayerEvent
import shamanry.common.lib.karma.{Karma, KarmaManager}
import shamanry.common.network.{PacketSyncKarma, PacketHandler}

object EntityEventHandler{
  @SubscribeEvent
  def onPlayerLoad(e: PlayerEvent.LoadFromFile): Unit ={
    KarmaManager.loadPlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerSave(e: PlayerEvent.SaveToFile): Unit ={
    KarmaManager.savePlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerLogIn(e: PEvent.PlayerLoggedInEvent): Unit ={
    val side: Side = FMLCommonHandler.instance().getEffectiveSide;
    if(side == Side.SERVER){
      PacketHandler.instance.sendToAll(new PacketSyncKarma(Karma.get(e.player).getGoodKarma(), Karma.get(e.player).getBadKarma()));
    }
  }
}