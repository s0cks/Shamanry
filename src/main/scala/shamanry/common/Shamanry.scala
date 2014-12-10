package shamanry.common

import cpw.mods.fml.common.event._
import cpw.mods.fml.common.{Mod, SidedProxy}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import org.apache.logging.log4j.{LogManager, Logger}
import shamanry.common.command.{CommandKarma, CommandSetKarma}
import shamanry.common.event.EntityEventHandler
import shamanry.common.network.PacketHandler
import shamanry.common.research.ShamanryResearch

@Mod(modid = "shamanry", name = "Shamanry", version = "0.0.3.0", modLanguage = "scala", dependencies = "required-after:Thaumcraft", useMetadata = true)
object Shamanry{
  @SidedProxy(
    clientSide = "shamanry.client.ClientProxy",
    serverSide = "shamanry.common.CommonProxy"
  )
  var proxy: CommonProxy = null;

  val LOGGER: Logger = LogManager.getLogger(Shamanry.getClass().getSimpleName());
  val TAB: CreativeTabs = new CreativeTabs("shamanry"){
    override def getTabIconItem: Item ={
      return ShamanryItems.itemStoneKnife;
    }
  };

  @Mod.EventHandler
  def onPreInit(e: FMLPreInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(EntityEventHandler);

    proxy.registerRenders();
  }

  @Mod.EventHandler
  def onInit(e: FMLInitializationEvent): Unit ={
    ShamanryItems.init();
    ShamanryBlocks.init();
    ShamanryTiles.init();
    ShamanryRituals.init();

    FMLInterModComms.sendMessage("Waila", "register", "shamanry.client.waila.WailaHandler.create");
  }

  @Mod.EventHandler
  def onPostInit(e: FMLPostInitializationEvent): Unit ={
    ShamanryRituals.generateTablets();
    ShamanryRecipes.init();
    ShamanryResearch.init();
    PacketHandler.init();
  }

  @Mod.EventHandler
  def onServerStart(e: FMLServerStartingEvent): Unit ={
    e.registerServerCommand(new CommandKarma());
    e.registerServerCommand(new CommandSetKarma());
  }
}