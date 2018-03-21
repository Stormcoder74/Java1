package ru.geekbrains.java1.lesson_08;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaintPanel2 extends JPanel {
    private BufferedImage image;

    public PaintPanel2() {
        try {
            image = ImageIO.read(new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = image.getGraphics();
                g.setColor(Color.ORANGE);
                g.fillOval(e.getX(), e.getY(), 3, 10);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 3, 3, this);
    }

}
