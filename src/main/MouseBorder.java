package main;

import java.awt.*;

import static main.MouseCoordinates.cordinateX;
import static main.MouseCoordinates.cordinateY;

public class MouseBorder  {
    public int borderStickness = 2;// pixel
    int x,y;
    GamePanel gamePanel;

    public MouseBorder(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    MouseCoordinates mouseCoordinates = new MouseCoordinates();
    MyMouseListener myMouseListener= new MyMouseListener(this.gamePanel);

    public void draw (Graphics g, GamePanel gamePanel){
        System.out.println(cordinateX);

        if(mouseCoordinates!=null) {
            x= cordinateX / gamePanel.tileSize;
            if(x>15)x=15;
            y =cordinateY / gamePanel.tileSize;
            g.setColor(Color.BLACK);
            g.drawRect(x * gamePanel.tileSize ,y * gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize);
        }else{
            x= 1;
            y= gamePanel.tileSize;
            g.drawRect(x * gamePanel.tileSize , gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize);
        }
    }
}

