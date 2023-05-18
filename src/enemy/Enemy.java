package enemy;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends Entity {

    GamePanel gamePanel;
    public  int heal;
    String road ="7 3 5 3 3 3 4 3 8";                           // bu ve altındaki değerin daha flex bir hale gelmesi gerekiyor. Bu haliyle çok bağımlı bir hali var.
    String turns ="right up right down right up right down";
    public int counter=0,turnCounter=0;


    public Enemy(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemy/towerDefense_tile245.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        this.heal = 100;
        setDefaultValues();
    }

    public void setDefaultValues() {
        speed = 2;
        direction = "down";
        solidAreaX = gamePanel.tileSize -4;
        solidAreaY = 0;
    }

    public void update() {
        if(gamePanel.screenWidth > solidAreaX &&gamePanel.screenHeight >solidAreaY){
            if (counter < convertRoad(turnCounter) * gamePanel.tileSize) {// --------> Buradaki seçeneğin değişmesi gerek. Bir sonraki ve sağ soldaki değerlerin yol olup olmasına bağlı olarak.
                switch (direction){
                    case "down":
                        solidAreaY += speed;
                        counter += speed;
                        break;
                    case "up":
                        solidAreaY -= speed;
                        counter += speed;
                        break;
                    case "left":
                        solidAreaX -= speed;
                        counter += speed;

                        break;
                    case "right":
                        solidAreaX += speed;
                        counter += speed;
                        break;
                }
            }else {
                changeDirection(spliceTurn(turnCounter));
                turnCounter++;
                System.out.println(turnCounter);
                counter=0;
            }
        }else {
        }
    }
    public void  draw (Graphics2D g2){
        g2.drawImage(this.image, solidAreaX, solidAreaY,null);
    }
    public void changeDirection(String direction){
        System.out.println("direction was changed");//
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(45));
        BufferedImage rotatedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g2 = rotatedImage.createGraphics();
        g2.drawImage(image, tx, null);
        this.direction= direction;
    }
    public int convertRoad(int i){

        String str = road;
        String[] strArray = str.split(" ");
        int roadNum = Integer.parseInt(strArray[i]);
        return roadNum;

    }

    public String spliceTurn(int i){
        String str = turns;
        String[] strArray = str.split(" ");
        return strArray[i];
    }

}
