package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java");
        setBounds(800, 400, 770, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color backgr = new Color(0xFDF3AA);
        setLayout(new GridLayout(1, 2));
        JPanel jpLeft = new JPanel();
        add(jpLeft);
        jpLeft.setBackground(backgr);
        jpLeft.setBorder(new LineBorder(Color.CYAN, 3, true));
        jpLeft.setLayout(new BoxLayout(jpLeft, BoxLayout.Y_AXIS));

        JButton buttonPaint = new JButton("Paint");
        jpLeft.add(buttonPaint);
        JButton button2 = new JButton("button2");
        jpLeft.add(button2);
        JButton button3 = new JButton("button3");
        jpLeft.add(button3);


        JPanel jpRight = new JPanel();
        add(jpRight);
        jpRight.setBackground(backgr);
        jpRight.setBorder(new LineBorder(Color.CYAN, 3, true));

        MiniPaintPanel jpPaint = new MiniPaintPanel();
        jpPaint.setBackground(new Color(0x737EFF));
        jpRight.setLayout(new CardLayout());

        JPanel jpRed = new JPanel();
        jpRed.setBackground(Color.RED);
        PicturePanel jpYellow = new PicturePanel();
        jpYellow.setBackground(Color.YELLOW);
        jpRight.add(jpPaint, "PAINT");
        jpRight.add(jpYellow, "YELLOW");
        jpRight.add(jpRed, "RED");

        buttonPaint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "PAINT");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "BLUE");
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
