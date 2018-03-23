package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java");
        setBounds(800, 400, 763, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color backgr = new Color(0xFDF3AA);
        setLayout(new GridLayout(1, 2));
        JPanel jpLeft = new JPanel();
        add(jpLeft);
        jpLeft.setBackground(backgr);
        jpLeft.setBorder(new LineBorder(backgr, 10, false));
        jpLeft.setLayout(new BoxLayout(jpLeft, BoxLayout.Y_AXIS));

        JButton buttonPaint = new JButton("Paint");
        jpLeft.add(buttonPaint);
        JButton buttonPicture = new JButton("Picture");
        jpLeft.add(buttonPicture);
        JButton buttonChat = new JButton("Chat");
        jpLeft.add(buttonChat);


        JPanel jpRight = new JPanel();
        add(jpRight);
        jpRight.setBackground(backgr);
        jpRight.setBorder(new LineBorder(Color.PINK, 3, true));

        MiniPaintPanel jpPaint = new MiniPaintPanel();
        jpPaint.setBackground(new Color(0x737EFF));
        jpRight.setLayout(new CardLayout());

        ChatPanel jpChat = new ChatPanel();
        jpChat.setBackground(backgr);
        PicturePanel jpPicPnel = new PicturePanel();
        jpPicPnel.setBackground(backgr);

        jpRight.add(jpPaint, "PAINT");
        jpRight.add(jpPicPnel, "PICTURE");
        jpRight.add(jpChat, "CHAT");

        buttonPaint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "PAINT");
            }
        });

        buttonPicture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "PICTURE");
            }
        });

        buttonChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jpRight.getLayout()).show(jpRight, "CHAT");
            }
        });

        setVisible(true);
    }
}
