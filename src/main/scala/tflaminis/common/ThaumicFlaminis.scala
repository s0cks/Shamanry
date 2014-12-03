package tflaminis.common

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}
import cpw.mods.fml.common.{Mod, SidedProxy}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import org.apache.logging.log4j.{LogManager, Logger}
import tflaminis.common.command.{CommandKarma, CommandSetKarma}
import tflaminis.common.event.EntityEventHandler
import tflaminis.common.research.TFResearch

@Mod(modid = "tflaminis", name = "Thaumic Flaminis", version = "0.0.0.0", modLanguage = "scala", dependencies = "required-after:Thaumcraft")
object ThaumicFlaminis{
  @SidedProxy(
    clientSide = "tflaminis.client.ClientProxy",
    serverSide = "tflaminis.common.CommonProxy"
  )
  var proxy: CommonProxy = null;

  val LOGGER: Logger = LogManager.getLogger(ThaumicFlaminis.getClass().getSimpleName());
  val TAB: CreativeTabs = new CreativeTabs("tflaminis"){
    override def getTabIconItem: Item ={
      return TFItems.itemStoneKnife;
    }
  };

  @Mod.EventHandler
  def onPreInit(e: FMLPreInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(EntityEventHandler);
  }

  @Mod.EventHandler
  def onInit(e: FMLInitializationEvent): Unit ={
    TFItems.init();
    TFBlocks.init();
    TFTiles.init();
    TFRecipes.init();
    TFResearch.init();
    TFRituals.init();
  }

  @Mod.EventHandler
  def onPostInit(e: FMLPostInitializationEvent): Unit ={
    TFRituals.generateTablets();
  }

  @Mod.EventHandler
  def onServerStart(e: FMLServerStartingEvent): Unit ={
    e.registerServerCommand(new CommandKarma());
    e.registerServerCommand(new CommandSetKarma());
  }
}