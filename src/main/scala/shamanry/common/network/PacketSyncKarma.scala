package shamanry.common.network

import cpw.mods.fml.common.network.simpleimpl.{MessageContext, IMessageHandler, IMessage}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.netty.buffer.ByteBuf
import net.minecraft.client.Minecraft
import shamanry.common.lib.karma.Karma

class PacketSyncKarma(var good: Double, var bad: Double)
extends IMessage
with IMessageHandler[PacketSyncKarma, IMessage]{
  def this() = this(-1D, -1D);

  override def fromBytes(buf: ByteBuf): Unit ={
    this.good = buf.readDouble();
    this.bad = buf.readDouble();
  }

  override def toBytes(buf: ByteBuf): Unit ={
    buf.writeDouble(this.good);
    buf.writeDouble(this.bad);
  }

  @SideOnly(Side.CLIENT)
  override def onMessage(message: PacketSyncKarma, ctx: MessageContext): IMessage ={
    Karma.get(Minecraft.getMinecraft.thePlayer).setBadKarma(message.bad);
    Karma.get(Minecraft.getMinecraft.thePlayer).setGoodKarma(message.good);
    return null;
  }
}