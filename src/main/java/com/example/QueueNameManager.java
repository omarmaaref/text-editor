package com.example;

import java.util.*;

import com.example.enums.ActiveTextAreaEnum;

public class QueueNameManager {
	private ActiveTextAreaEnum activeTextArea;	
	private static HashMap<ActiveTextAreaEnum, String> queueNameMap = new HashMap<>();
	static {
		queueNameMap.put(ActiveTextAreaEnum.first, "first_queue");
		queueNameMap.put(ActiveTextAreaEnum.second, "second_queue");
	}
	public QueueNameManager(ActiveTextAreaEnum activeTextArea) {
		this.activeTextArea = activeTextArea;
	}
	public String getQueueName() {
		return queueNameMap.get(activeTextArea);
	}
}
