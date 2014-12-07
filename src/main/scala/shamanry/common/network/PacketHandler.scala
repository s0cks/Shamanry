package shamanry.common.network

import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.relauncher.Side

object PacketHandler {
  val instance = NetworkRegistry.INSTANCE.newSimpleChannel("shamanry");

  def init(): Unit ={
    instance.registerMessage(classOf[PacketSyncKarma], classOf[PacketSyncKarma], 0, Side.CLIENT);
  }
}