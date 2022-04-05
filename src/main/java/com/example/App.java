package com.example;

import com.example.enums.ActiveTextAreaEnum;
import com.example.enums.TextAreaModeEnum;

public class App {
    public static void main(String[] args) {
        ActiveTextAreaEnum activeTextArea;
		TextAreaModeEnum mode;
		String usage = "Usage: java App <first|second> <read|write>";
		if(args.length != 2) {
			System.out.println(usage);
			return;
		}
        if (args[0].equals("first")) {
            activeTextArea = ActiveTextAreaEnum.first;
        } else if (args[0].equals("second")) {
            activeTextArea = ActiveTextAreaEnum.second;
        } else {
            System.out.println(usage);
			throw new RuntimeException("Invalid argument");
        }
		if(args[1].equals("read")) {
			mode = TextAreaModeEnum.READ;
		} else if(args[1].equals("write")) {
			mode = TextAreaModeEnum.WRITE;
		} else {
			System.out.println(usage);
			throw new RuntimeException("Invalid argument");
		}
        new TextEditorFrame(activeTextArea, mode);
    }
}
