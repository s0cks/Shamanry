package tflaminis.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

public interface IRitual{
    public Aspect getAspect();
    public String getName();
    public boolean hasRequiredKarma(EntityPlayer player);
    public void perform(World world, int x, int y, int z, EntityPlayer player);
}