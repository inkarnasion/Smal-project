package engine;

import interfaces.Init;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadImage implements Init {
    public static BufferedImage image;
    public static BufferedImage entities;
   // public static BufferedImage entities2;
    public static BufferedImage player, enemy;


    @Override
    public  void init()
    {
        image = imageLoader("/white.png");
        entities = imageLoader("/airplane.png");
        //entities2= imageLoader("/airplane.png");

        crop();

    }

    public static BufferedImage imageLoader(String path){
        try {
            return
                    ImageIO.read(LoadImage.class.
                            getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    public static void crop(){
        enemy = entities.getSubimage(0, 0, 115, 95);
        player = entities.getSubimage(115, 0, 115, 95);

    }



}
