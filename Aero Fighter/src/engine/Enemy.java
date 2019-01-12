package engine;

import interfaces.Render;
import interfaces.Tick;

import java.awt.*;

public class Enemy implements Tick, Render {
    private int x ;
    private int y;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
    }
@Override
    public void tick(){
        y += 1;
    }
    @Override
    public void render(Graphics g){
        g.drawImage(LoadImage.enemy,x,y,50,50,null);
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }




}
