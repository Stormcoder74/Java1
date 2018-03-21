package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java");
        setBounds(1000, 400, 600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);

        setLayout(new GridLayout(1, 2));
        JPanel jpLeft = new JPanel();
        add(jpLeft);
        jpLeft.setBackground(Color.BLUE);
        jpLeft.setBorder(new LineBorder(Color.CYAN, 3, true));

        jpLeft.setLayout(new BoxLayout(jpLeft, BoxLayout.Y_AXIS));
        JButton button1 = new JButton("button1");
        jpLeft.add(button1);
        JButton button2 = new JButton("button2");
        jpLeft.add(button2);
        JButton button3 = new JButton("button3");
        jpLeft.add(button3);


        JPanel jpRight = new JPanel();
        add(jpRight);
        jpRight.setBackground(Color.MAGENTA);
        jpRight.setBorder(new LineBorder(Color.PINK, 3, true));

        jpRight.setLayout(new CardLayout());
        JPanel jpRed = new JPanel();
        jpRed.setBackground(Color.RED);
        PaintPanel1 jpGreen = new PaintPanel1();
        jpGreen.setBackground(Color.GREEN);
        PaintPanel2 jpYellow = new PaintPanel2();
        jpYellow.setBackground(Color.YELLOW);
        jpRight.add(jpRed, "RED");
        jpRight.add(jpGreen, "GREEN");
        jpRight.add(jpYellow, "YELLOW");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "RED");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "GREEN");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "YELLOW");
            }
        });

        setVisible(true);
    }
}
