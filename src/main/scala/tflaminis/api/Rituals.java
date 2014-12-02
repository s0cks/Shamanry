package tflaminis.api;

import java.util.LinkedList;
import java.util.List;

public final class Rituals{
    private Rituals(){}

    private static List<IRitual> rituals = new LinkedList<>();

    public static IRitual getRitualByName(String name){
        for(IRitual ritual : rituals){
            if(ritual.getName().equalsIgnoreCase(name)){
                return ritual;
            }
        }

        return null;
    }

    public static void registerRitual(IRitual r){
        rituals.add(r);
    }
}