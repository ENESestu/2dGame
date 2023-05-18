package tile;

import enemy.Enemy;
import enemy.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {


    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        tile = new Tile[300];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage(){
        try {
            tile[78] = new Tile();
            tile[78].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile079.png")));
            tile[78].isBuildable=true;

            tile[79] = new Tile();
            tile[79].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile080.png")));
            tile[79].isBuildable=true;

            tile[80] = new Tile();
            tile[80].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile081.png")));
            tile[80].isBuildable=true;

            tile[101] = new Tile();
            tile[101].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile102.png")));
            tile[101].isBuildable=true;

            tile[102] = new Tile();
            tile[102].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile103.png")));
            tile[102].isBuildable=false;

            tile[103] = new Tile();
            tile[103].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile104.png")));
            tile[103].isBuildable=true;

            tile[118] = new Tile();
            tile[118].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile119.png")));
            tile[118].isBuildable=true;

            tile[124] = new Tile();
            tile[124].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile125.png")));
            tile[124].isBuildable=true;

            tile[125] = new Tile();
            tile[125].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile126.png")));
            tile[125].isBuildable=true;

            tile[126] = new Tile();
            tile[126].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile127.png")));
            tile[126].isBuildable=true;

            tile[128] = new Tile();
            tile[128].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile129.png")));
            tile[128].isBuildable=true;


            tile[262] = new Tile();
            tile[262].image =ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/towerDefense_tile262.png")));
            tile[262].isBuildable=true;


        } catch (IOException e) {


            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/TDmap01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row=0;
            int col=0;
            while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
                String line = br.readLine();
                while (col < gamePanel.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col==gamePanel.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        int col=0;
        int row=0;
        int x=0;
        int y=0;

        while (col <gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
            int tileNumber = mapTileNum[col][row];
            g2.drawImage(tile[tileNumber].image,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
            col++;
            x +=gamePanel.tileSize;

            if (col == gamePanel.maxScreenCol){
                col=0;
                x=0;
                row++;
                y +=gamePanel.tileSize;
            }
        }
    }

}
