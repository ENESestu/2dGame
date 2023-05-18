package buildings;


import main.GamePanel;

import java.awt.event.MouseEvent;

public class CheckBuilds {
    public boolean isBuilds = false;
    int cordinateX,cordinateY;
    GamePanel gamePanel;
    public CheckBuilds(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public boolean check(MouseEvent e){
        cordinateX = (e.getX() / gamePanel.tileSize);
        cordinateY = (e.getY() / gamePanel.tileSize);
        return isBuilds;
    }

}
