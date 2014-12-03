package tflaminis.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class LoreCollector{
    private static final Map<String, String> map = new HashMap<>();
    private static final Gson GSON = new Gson();

    static
    {
        try(InputStream stream = System.class.getResourceAsStream("/assets/tflaminis/lore.json")){
            Map<String, String> map1 = GSON.fromJson(new InputStreamReader(stream), new TypeToken<Map<String, String>>(){}.getType());
            map.putAll(map1);
        } catch(Exception e){
            // Fallthrough
        }
    }

    public static String getLore(String key){
        return map.get(key);
    }
}