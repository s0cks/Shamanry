package shamanry.api;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class LoreCollector{
    private static final Map<String, String> map = new HashMap<String, String>();
    private static final Gson GSON = new Gson();

    static
    {
        InputStream stream = null;
        try{
            stream = LoreCollector.class.getResourceAsStream("/lore.json");
            if(stream == null){
                throw new NullPointerException("Stream == null");
            }

            Map<String, String> map1 = GSON.fromJson(new InputStreamReader(stream), new TypeToken<Map<String, String>>(){}.getType());
            map.putAll(map1);
        } catch(Exception e){
            e.printStackTrace(System.err);
        } finally{
            try{
                if(stream != null){
                    stream.close();
                }
            } catch(IOException e){
                e.printStackTrace(System.err);
            }
        }
    }

    public static String getLore(String key){
        return map.get(key);
    }
}