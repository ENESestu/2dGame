package main;
import buildings.CheckBuilds;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
        CheckBuilds checkBuilds;
        GamePanel gamePanel;
        public MyMouseListener (GamePanel gamePanel) {
                this.gamePanel = gamePanel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                checkBuilds = new CheckBuilds(this.gamePanel);
                checkBuilds.check(e);

            // System.out.println("Mouse clicked at x: " + e.getX() + ", y: " + e.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // System.out.println("Mouse entered at x: " + e.getX() + ", y: " + e.getY());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //  System.out.println("Mouse exited at x: " + e.getX() + ", y: " + e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {

            // System.out.println("Mouse pressed at x: " + e.getX() + ", y: " + e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // System.out.println("Mouse released at x: " + e.getX() + ", y: " + e.getY());
        }
    }
