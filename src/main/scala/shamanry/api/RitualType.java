package shamanry.api;

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
}