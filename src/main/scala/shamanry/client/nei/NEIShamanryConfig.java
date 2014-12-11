package shamanry.client.nei;

import codechicken.nei.api.IConfigureNEI;

public class NEIShamanryConfig
implements IConfigureNEI{
    @Override
    public void loadConfig(){
        System.out.println("Configuring NEI Plugin");
    }

    @Override
    public String getName(){
        return "Shamanry NEI Plugin";
    }

    @Override
    public String getVersion(){
        return "1.0.0.0";
    }
}