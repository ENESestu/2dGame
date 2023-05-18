package main;

import buildings.Weapon;
import enemy.Enemy;
import enemy.EnemySetter;
import enemy.Entity;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 17;
    public final int maxScreenRow = 9;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    //FPS
    int FPS= 60;

    public Enemy[] enemies = new Enemy[5];
    public Weapon weapon= new Weapon(this);
    public Weapon[] weapons = new Weapon[5];
    public TileManager tileManager = new TileManager(this);

    Thread gameThread;//                                       -----??????

    EnemySetter enemySetter = new EnemySetter(this);

    MyMouseListener mouseListener = new MyMouseListener(this);
    MouseCoordinates mouseCoordinates = new MouseCoordinates();
    MouseBorder mouseBorder = new MouseBorder(this);

    Timer timer = new Timer();

    public GamePanel (){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);

        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseCoordinates);
        this.setDoubleBuffered(true);//                         ----??????
        this.setFocusable(true);
    }

    public void setupGame(){
        timer.schedule(enemySetter,0,2000);
    }

    public void startGameThread(){
        gameThread =new Thread(this);
        gameThread.start();                     //Bu kod run metodunu çalıştırıyor.??????
    }

    @Override
    public void run() {                            // Oyun dögüsü
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread!=null) {// game loop
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000){
                drawCount=0;
                timer=0;
            }
        }
    }

    public void update(){
        for(int i =0;i<enemies.length;i++){

            if(enemies[i]!=null)
            enemies[i].update();
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // Bu kullanımı daha önce görmemiştim.
        tileManager.draw(g2);
        weapon.draw(g2);
        mouseBorder.draw(g2, this);
        for(int i =0;i<enemies.length;i++){
            if(enemies[i]!=null)
                enemies[i].draw(g2);
        }
        g2.dispose();
    }
}
