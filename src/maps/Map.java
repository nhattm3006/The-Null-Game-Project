package maps;

import com.google.gson.Gson;
import utils.Utils;

import java.util.List;

public class Map {
    private List<Layer> layers;

    @Override
    public String toString() {
        return "Map{" +
                "Layer = "+layers +'}';
    }
    public void generate() {
        if(layers.size() > 0) {
            Layer layer = layers.get(0);
            layer.generate();
        }
    }
    public static Map load(String url){
        String mapContent = Utils.readTextFile(url);
        Gson gson = new Gson();
        System.out.println(gson.fromJson(mapContent, Map.class));
        return gson.fromJson(mapContent,Map.class);
    }
}
