package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import java.awt.*;

public class PaintPanel1 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(20, 30, 125, 245);
    }
}
