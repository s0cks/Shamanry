package shamanry.client.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import shamanry.common.tile.TileRitualAltar;

import java.util.List;

public final class WailaHandler
implements IWailaDataProvider{
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config){
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){
        TileEntity tile = accessor.getTileEntity();
        if(tile instanceof TileRitualAltar){
            TileRitualAltar ritualAltar = (TileRitualAltar) tile;

            if(ritualAltar.getRitual() != null){
                currenttip.add("Current Ritual: " + StatCollector.translateToLocal("ritual." + ritualAltar.getRitual().getName() + ".name"));
            }
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){
        return currenttip;
    }

    public static void create(IWailaRegistrar registrar){
        registrar.registerBodyProvider(new WailaHandler(), Block.class);
    }
}