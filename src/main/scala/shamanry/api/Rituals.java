package shamanry.api;

import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Rituals{
    private Rituals(){}

    private static List<IRitual> rituals = new LinkedList<IRitual>();
    private static Map<String, ItemStack> tablets = new HashMap<String, ItemStack>();

    public static IRitual getRitualByName(String name){
        for(IRitual ritual : rituals){
            if(ritual.getName().equalsIgnoreCase(name)){
                return ritual;
            }
        }

        return null;
    }

    public static Collection<ItemStack> getTablets(){
        return tablets.values();
    }

    public static List<IRitual> getRituals(){
        return rituals;
    }

    public static ItemStack getTablet(String key){
        if(tablets.containsKey(key)){
            return tablets.get(key);
        } else{
            throw new RuntimeException("Cannot find tablet: " + key + " dumping tablets: " + dump());
        }
    }

    private static String dump(){
        StringBuilder builder = new StringBuilder();
        for(String str : tablets.keySet()){
            builder.append(str).append(",");
        }
        return builder.toString();
    }

    public static void registerTablet(String key, ItemStack stack){
        tablets.put(key, stack);
    }

    public static void registerRitual(IRitual r){
        rituals.add(r);
    }
}