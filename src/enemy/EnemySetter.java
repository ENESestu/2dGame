package enemy;

import main.GamePanel;

import java.util.TimerTask;

public class EnemySetter extends TimerTask {
    GamePanel gamePanel;
    public int enemyCounter=0;

    public EnemySetter (GamePanel gamePanel){
        this.gamePanel =gamePanel;
    }

    public void createEnemy(int i){ // integer değer üretilen düşmanların hangisi olacağıyla alakalı bilgiyi oluşturacak.
        if(i<gamePanel.enemies.length)
        gamePanel.enemies[i] = new Enemy(gamePanel);
    }

    @Override
    public void run() {
    createEnemy(enemyCounter);
    enemyCounter++;
    }
}
