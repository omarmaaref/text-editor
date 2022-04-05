package com.example;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.example.enums.ActiveTextAreaEnum;

import java.util.function.Consumer;

public class ReadTextArea extends MyTextArea {
    ReadTextArea(boolean enabled, ActiveTextAreaEnum activeTextArea) {
        super(enabled, activeTextArea);
    }
    @Override
    protected void attachListener() {
		Consumer<String> messageConsumer = message -> {
			try {
				// remove content from document
				Document doc = getDocument();
				doc.remove(0, doc.getLength());
				// insert new content
				doc.insertString(0, message, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		};
		MessageSender.readMessage(queueNameManager.getQueueName(), messageConsumer);
    }
}