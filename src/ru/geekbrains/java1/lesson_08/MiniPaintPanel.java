package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import java.awt.*;

public class MiniPaintPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(40, 380, 210, 180);
        g.fillOval(65, 250, 160, 145);
        g.fillOval(95, 150, 110, 110);

        g.setColor(new Color(0xAE592D));
        g.fillPolygon(new int[]{105, 115, 190, 200}, new int[]{170, 90, 90, 170}, 4);

        g.setColor(Color.BLACK);
        g.fillOval(120, 185, 10, 10);
        g.fillOval(160, 185, 10, 10);

        g.setColor(Color.ORANGE);
        g.fillPolygon(new int[]{105, 150, 150}, new int[]{210, 200, 220}, 3);
    }
}