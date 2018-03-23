package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MiniPaintPanel extends JPanel {
    private Graphics graphics;
    public MiniPaintPanel() {
        // эта рисовалка не работает, не пойму почему, объясните пожалуйста
        // https://github.com/Stormcoder74/Java1.git
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphics.setColor(Color.ORANGE);
                graphics.fillOval(e.getX(), e.getY(), 20, 20);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(graphics == null)graphics = g;
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