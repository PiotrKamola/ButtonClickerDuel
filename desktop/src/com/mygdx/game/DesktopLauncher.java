package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Cursor;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("ButtonClickerDuel");
		config.setWindowedMode(buttonClickerDuel.WIDTH, buttonClickerDuel.HEIGHT);
		config.setResizable(false);
//		new Lwjgl3Application(new mainMenuScreen(), config);
		new Lwjgl3Application(new buttonClickerDuel(), config);
	}
}
