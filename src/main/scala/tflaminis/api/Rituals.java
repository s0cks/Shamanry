package tflaminis.api;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Rituals{
    private Rituals(){}

    private static List<IRitual> rituals = new LinkedList<>();
    private static Map<String, ItemStack> tablets = new HashMap<>();

    public static IRitual getRitualByName(String name){
        for(IRitual ritual : rituals){
            if(ritual.getName().equalsIgnoreCase(name)){
                return ritual;
            }
        }

        return null;
    }

    public static List<IRitual> getRituals(){
        return rituals;
    }

    public static ItemStack getTablet(String key){
        return tablets.get(key);
    }

    public static void registerTablet(String key, ItemStack stack){
        tablets.put(key, stack);
    }

    public static void registerRitual(IRitual r){
        rituals.add(r);
    }
}