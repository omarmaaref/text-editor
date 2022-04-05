package com.example;
import com.example.enums.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TextEditorFrame extends JFrame {
    private MyTextArea textArea1;
    private MyTextArea textArea2;
    TextEditorFrame(ActiveTextAreaEnum activeTextArea, TextAreaModeEnum mode) {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        if (mode == TextAreaModeEnum.WRITE) {
            textArea1 = TextAreaFactory.createTextArea(
                activeTextArea == ActiveTextAreaEnum.first,
                ActiveTextAreaEnum.first, TextAreaModeEnum.WRITE);
            textArea2 = TextAreaFactory.createTextArea(
                activeTextArea == ActiveTextAreaEnum.second,
                ActiveTextAreaEnum.second, TextAreaModeEnum.WRITE);
        } else {
            textArea1 = TextAreaFactory.createTextArea(
                false, ActiveTextAreaEnum.first, TextAreaModeEnum.READ);
            textArea2 = TextAreaFactory.createTextArea(
                false, ActiveTextAreaEnum.second, TextAreaModeEnum.READ);
        }

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(50, 30, 50, 30));

        GridLayout layout = new GridLayout(2, 1);
        layout.setVgap(50);
        panel.setLayout(layout);

        panel.add(textArea1);
        panel.add(textArea2);

        add(panel);

        setVisible(true);
    }
}
