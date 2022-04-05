package com.example;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.example.enums.ActiveTextAreaEnum;

public class WriteTextArea extends MyTextArea {
    WriteTextArea(boolean enabled, ActiveTextAreaEnum activeTextArea) {
        super(enabled, activeTextArea);
    }
    @Override
    protected void attachListener() {
        getDocument().addDocumentListener(
            new SendingDocumentListener(queueNameManager));
    }
}

class SendingDocumentListener implements DocumentListener {
    private QueueNameManager queueNameManager;
    public SendingDocumentListener(QueueNameManager queueNameManager) {
        this.queueNameManager = queueNameManager;
    }
    private void sendMessage(Document doc) {
        String text;
        try {
            text = doc.getText(0, doc.getLength());
            MessageSender.sendMessage(text, queueNameManager.getQueueName());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void insertUpdate(DocumentEvent e) {
        sendMessage((Document)e.getDocument());
    }

    public void removeUpdate(DocumentEvent e) {
        sendMessage((Document)e.getDocument());
    }

    public void changedUpdate(DocumentEvent e) {
        System.out.println("removeUpdate");
    }
}
