package shamanry.common.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public final class RotationHelper{
    private RotationHelper(){}

    public static final float NORTH = 180.0F;
    public static final float SOUTH = 0.0F;
    public static final float WEST = 90.0F;
    public static final float EAST = 270.0F;
    public static final float UNKNOWN = NORTH;

    public static float get3DRotation(EntityLivingBase living){
        return RotationHelper.getWeight(MathHelper.floor_double((double) ((living.rotationYaw * 4.0F) / 360.0F) + 0.5D) & 3);
    }

    public static float getWeight(int theta){
        switch(theta)
        {
            case 0:{
                return NORTH;
            }
            case 1:{
                return EAST;
            }
            case 2:{
                return SOUTH;
            }
            case 3:{
                return WEST;
            }
            case 4:{
                return SOUTH;
            }
            default:{
                return UNKNOWN;
            }
        }
    }
}