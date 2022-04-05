package com.example;

import com.example.enums.*;

public class TextAreaFactory {
	public static MyTextArea createTextArea(boolean enabled, ActiveTextAreaEnum activeTextArea, TextAreaModeEnum mode) {
		if(mode == TextAreaModeEnum.READ) {
			return new ReadTextArea(enabled, activeTextArea);
		} else {
			return new WriteTextArea(enabled, activeTextArea);
		}
	}
}
