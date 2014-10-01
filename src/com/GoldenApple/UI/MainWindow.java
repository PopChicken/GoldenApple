package com.GoldenApple.UI;

import com.GoldenApple.GoldenApple.util.Logger;

public class MainWindow implements UI {
	
	private Logger logger;
	
	public MainWindow(Logger logger){
		this.logger = logger;
		this.consoleListen();
	}

	private void consoleListen() {
		//TODO
		//logger.addHook(this);
	}
	
	public void LoggerLog(String ms){
		UIConsoleLog(ms);
	}

	private void UIConsoleLog(String ms) {
		// TODO
	}
}
