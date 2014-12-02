package tflaminis.common.command

import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText
import tflaminis.common.lib.karma.Karma

class CommandSetKarma
extends CommandBase{
  override def getCommandName: String ={
    return "set_karma";
  }

  override def getCommandUsage(p_71518_1_ : ICommandSender): String ={
    return "/set_karma [bad|good] (0 - 1)";
  }

  override def processCommand(p_71515_1_ : ICommandSender, p_71515_2_ : Array[String]): Unit ={
    val value: Float = java.lang.Float.valueOf(p_71515_2_(1)).floatValue();

    p_71515_2_(0) match
    {
      case "bad"=>{
        Karma.get(p_71515_1_.asInstanceOf[EntityPlayer]).setBadKarma(value);
        return;
      }
      case "good"=>{
        Karma.get(p_71515_1_.asInstanceOf[EntityPlayer]).setGoodKarma(value);
        return;
      }
      case _=>{
        p_71515_1_.addChatMessage(new ChatComponentText("Invalid Karma Type: " + p_71515_2_(0)));
        return;
      }
    }
  }
}