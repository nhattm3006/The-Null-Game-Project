package maps;

import bases.GameObject;
import game.Platform;

import java.util.List;

public class Layer {
    List<Integer> data;
    int width;
    int height;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ",height" + height +
                ",width" + width +
                '}';
    }

    public void generate() {
        for(int titleY = 0;titleY < height ; titleY ++){
            for (int titleX = 0;titleX<width;titleX ++){
                int mapData = data.get(titleY * width + titleX);
                if(mapData !=0){
                    Platform platform = new Platform(titleX *32 , titleY *32, 32, 32);
                    platform.addImage(mapData);
                    GameObject.add(platform);
                }
            }
        }
    }
}