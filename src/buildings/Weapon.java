package buildings;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Weapon extends SuperBuilding{
    GamePanel gamePanel;

    public int location =16;
    int screenX;
    int screenY;
    Weapon[] weapons = new Weapon[5];

    public Weapon(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        screenX = (gamePanel.tileSize * location)-8;
        screenY = (gamePanel.tileSize) * 2 ;
    }


    public void draw(Graphics2D g2){
        try{
            weapons[0] = new Weapon(gamePanel);
            weapons[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/buildings/towerDefense_tile249.png")));
            weapons[1] = new Weapon(gamePanel);
            weapons[1].image =  ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/buildings/towerDefense_tile250.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
        for (int i =0; i<weapons.length;i++){
            if(weapons[i]!=null)
            g2.drawImage(weapons[i].image, screenX ,screenY * i ,null);
        }
    }
}
