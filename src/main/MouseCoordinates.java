package main;

import java.awt.*;
import java.awt.event.*;

public class MouseCoordinates extends Frame implements MouseMotionListener {
    static int cordinateX;
    static int cordinateY;

    public MouseCoordinates() {
        // Add the mouse motion listener to the frame
        addMouseMotionListener(this);
    }

    // Implement the MouseMotionListener interface
    public void mouseMoved(MouseEvent e) { // fare hareketlerini anlık olarak bulup tile etrafında ince bir çerçeve yapmak için işe yaracak.
        cordinateX= e.getX();
        cordinateY= e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        // Do nothing
    }
}
