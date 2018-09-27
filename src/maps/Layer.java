package maps;

import bases.GameObject;
import game.Platform;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ",height" + height +
                ",width" + width +
                '}';
    }

    public void generate() {
        for(int titleY = 0;titleY < 0 ; titleY ++){
            for (int titleX = 0;titleX<=width;titleX ++){
                int mapData = data.get(titleY * width + titleX);
                if(mapData !=0){
                    Platform platform = new Platform();
                    platform.position.set(titleX *32, titleY *32);
                    GameObject.add(platform);
                }
            }
        }
    }
}
