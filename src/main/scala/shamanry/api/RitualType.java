package shamanry.api;

import net.minecraft.util.ResourceLocation;

public enum RitualType{
    EVIL, GOOD, NEUTRAL;

    public String getTexture(){
        switch(this)
        {
            case EVIL:
            case NEUTRAL:{
                return "evil_tablet";
            }
            case GOOD:
            default:{
                return "good_tablet";
            }
        }
    }

    public ResourceLocation getModelTexture(){
        switch(this){
            case EVIL:
            case NEUTRAL:{
                return new ResourceLocation("shamanry", "textures/models/altar_evil.png");
            }
            case GOOD:
            default:{
                return new ResourceLocation("shamanry", "textures/models/altar_good.png");
            }
        }
    }
}