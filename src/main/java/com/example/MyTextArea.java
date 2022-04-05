package com.example;
import java.awt.Font;

import javax.swing.*;

import com.example.enums.ActiveTextAreaEnum;

public abstract class MyTextArea extends JTextArea {
    protected QueueNameManager queueNameManager;
    public MyTextArea(boolean enabled, ActiveTextAreaEnum activeTextArea) {
        super("write something here...");
        setEnabled(enabled);
        this.queueNameManager = new QueueNameManager(activeTextArea);
		setFont(new Font("Monaco", Font.PLAIN, 20));
		attachListener();
    }
    protected abstract void attachListener();
}