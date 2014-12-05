package shamanry.common.command

import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import shamanry.common.lib.karma.Karma

class CommandKarma
extends CommandBase{
  override def getCommandName: String ={
    return "karma";
  }

  override def getCommandUsage(p_71518_1_ : ICommandSender): String ={
    return "/karma";
  }

  override def processCommand(p_71515_1_ : ICommandSender, p_71515_2_ : Array[String]): Unit ={
    p_71515_1_.addChatMessage(new ChatComponentText("Good Karma: " + Karma.get(p_71515_1_.asInstanceOf[EntityPlayer]).getGoodKarma()));
    p_71515_1_.addChatMessage(new ChatComponentText("Bad Karma: " + Karma.get(p_71515_1_.asInstanceOf[EntityPlayer]).getBadKarma()));
  }
}