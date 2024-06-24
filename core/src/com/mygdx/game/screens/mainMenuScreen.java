package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.ai.GdxAI;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.buttonClickerDuel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.awt.*;

public class mainMenuScreen implements Screen {
    private static final int LOGO_BUTTON_Y = 450;
    private static final int START_BUTTON_Y = 315;
    private static final int OPTIONS_BUTTON_Y = START_BUTTON_Y - 100;
    private static final int EXIT_BUTTON_Y = OPTIONS_BUTTON_Y - 100;

    private static final int TIME_BUTTON_Y = 315;
//    private static final int SCORE_BUTTON_Y = TIME_BUTTON_Y - 100;
    private static final int FREE_PLAY_BUTTON_Y = TIME_BUTTON_Y - 100;
    private static final int BACK_GAME_BUTTON_Y = FREE_PLAY_BUTTON_Y - 100;

    private static final int FULLSCREEN_BUTTON_Y = 315;
    private static final int BACK_BUTTON_Y = FULLSCREEN_BUTTON_Y - 100;

    private boolean isMenuOn = true;
    private boolean isOptionsOn = false;
    private boolean isGameOn = false;
    buttonClickerDuel game;
    SpriteBatch batch;
    BitmapFont font;

    public mainMenuScreen(buttonClickerDuel game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
        GlyphLayout logoLayout = new GlyphLayout(font, "BUTTON CLICKER DUEL");
        ScreenUtils.clear(0, 0, 0, 0);

        game.batch.begin();

        font.draw(game.batch, logoLayout, game.WIDTH / 2 - logoLayout.width / 2, LOGO_BUTTON_Y);

        if (isMenuOn) {
            showMainMenu();
        }else if (isOptionsOn) {
            showOptionsMenu();
        }else if (isGameOn) {
            showGameMenu();
        }

        game.batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    private boolean isCursorOnButton(GlyphLayout buttonLayout, int buttonX) {
        return !(Gdx.input.getX() < buttonClickerDuel.WIDTH / 2 - buttonLayout.width / 2 + buttonLayout.width) ||
                !(Gdx.input.getX() > buttonClickerDuel.WIDTH / 2 - buttonLayout.width / 2) ||
                buttonClickerDuel.HEIGHT - Gdx.input.getY() >= buttonX ||
                !(buttonClickerDuel.HEIGHT - Gdx.input.getY() > buttonX - buttonLayout.height);
    }

    private void showMainMenu() {
        GlyphLayout startButtonLayout = new GlyphLayout(font, "START");
        GlyphLayout optionsButtonLayout = new GlyphLayout(font, "OPTIONS");
        GlyphLayout exitButtonLayout = new GlyphLayout(font, "EXIT");

        font.draw(game.batch, startButtonLayout, game.WIDTH / 2 - startButtonLayout.width / 2, START_BUTTON_Y);
        font.draw(game.batch, optionsButtonLayout, game.WIDTH / 2 - optionsButtonLayout.width / 2, OPTIONS_BUTTON_Y);
        font.draw(game.batch, exitButtonLayout, game.WIDTH / 2 - exitButtonLayout.width / 2, EXIT_BUTTON_Y);
        if (isCursorOnButton(startButtonLayout, START_BUTTON_Y) &&
                isCursorOnButton(optionsButtonLayout, OPTIONS_BUTTON_Y) &&
                isCursorOnButton(exitButtonLayout, EXIT_BUTTON_Y)) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        } else {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

            if (!isCursorOnButton(startButtonLayout, START_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("START");
                    isMenuOn = false;
                    isGameOn = true;
                }
            }
            if (!isCursorOnButton(optionsButtonLayout, OPTIONS_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("OPTIONS");
                    isMenuOn = false;
                    isOptionsOn = true;
                }
            }
            if (!isCursorOnButton(exitButtonLayout, EXIT_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("EXIT");
                    Gdx.app.exit();
                }
            }
        }
    }

    private void showOptionsMenu() {
        GlyphLayout fullScreenButtonLayout = new GlyphLayout(font, "FULL SCREEN");
        GlyphLayout backButtonLayout = new GlyphLayout(font, "BACK");

        font.draw(game.batch, fullScreenButtonLayout, game.WIDTH / 2 - fullScreenButtonLayout.width / 2, START_BUTTON_Y);
        font.draw(game.batch, backButtonLayout, game.WIDTH / 2 - backButtonLayout.width / 2, BACK_BUTTON_Y);
        if (isCursorOnButton(fullScreenButtonLayout, FULLSCREEN_BUTTON_Y) &&
                isCursorOnButton(backButtonLayout, BACK_BUTTON_Y)){
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        } else {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

            if (!isCursorOnButton(fullScreenButtonLayout, FULLSCREEN_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("FULL SCREEN");
                    toggleFullscreen();
//                    Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
                }
            }
            if (!isCursorOnButton(backButtonLayout, BACK_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("BACK");
                    isMenuOn = true;
                    isOptionsOn = false;
                }
            }
        }
    }

    private void showGameMenu() {
        GlyphLayout timeButtonLayout = new GlyphLayout(font, "TIME GAME");
        GlyphLayout freeButtonLayout = new GlyphLayout(font, "FREEPLAY");
        GlyphLayout backButtonLayout = new GlyphLayout(font, "BACK");

        font.draw(game.batch, timeButtonLayout, game.WIDTH / 2 - timeButtonLayout.width / 2, TIME_BUTTON_Y);
        font.draw(game.batch, freeButtonLayout, game.WIDTH / 2 - freeButtonLayout.width / 2, FREE_PLAY_BUTTON_Y);
        font.draw(game.batch, backButtonLayout, game.WIDTH / 2 - backButtonLayout.width / 2, BACK_GAME_BUTTON_Y);
        if (isCursorOnButton(timeButtonLayout, TIME_BUTTON_Y) &&
                isCursorOnButton(freeButtonLayout, FREE_PLAY_BUTTON_Y) &&
                isCursorOnButton(backButtonLayout, BACK_GAME_BUTTON_Y)){
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        } else {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

            if (!isCursorOnButton(timeButtonLayout, TIME_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("TIME");
                }
            }
            if (!isCursorOnButton(freeButtonLayout, FREE_PLAY_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("FREE");
                }
            }
            if (!isCursorOnButton(backButtonLayout, BACK_GAME_BUTTON_Y)) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println("BACK");
                    isMenuOn = true;
                    isGameOn = false;
                }
            }
        }
    }

    private void toggleFullscreen() {
        if (Gdx.graphics.isFullscreen()) {
            Gdx.graphics.setWindowedMode(buttonClickerDuel.WIDTH, buttonClickerDuel.HEIGHT); // Set to desired window size
        } else {
            Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
            Gdx.graphics.setFullscreenMode(displayMode);
        }
    }
}