package ru.geekbrains.java1.lesson_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel {

    private JTextField textField;
    private JTextArea textArea;

    public ChatPanel(){
        setLayout(new FlowLayout());
        Font font1 = new Font("sanserif", Font.BOLD, 18);

        textField = new JTextField(15);
        textField.setFont(font1);
        add(textField);

        JButton button = new JButton("Send");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
                    textField.grabFocus();
                }
            }
        });
        add(button);

        textArea = new JTextArea(21, 20);
        textArea.setFont(font1);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        add(textArea);
    }

}
