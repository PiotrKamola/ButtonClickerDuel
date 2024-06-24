package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.buttonClickerDuel;

public class gameScreen implements Screen {
    final buttonClickerDuel game;
    SpriteBatch batch;
    BitmapFont font;

    boolean newLetter = true;
    int randomNumber;
    int score;
    int timer = 0;
    int miliS = 0;

    int timeLimit = 0;
    boolean playing = true;

    public gameScreen(buttonClickerDuel game, int timeLimit){
        this.game = game;
        this.timeLimit = timeLimit;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
        GlyphLayout logoLayout = new GlyphLayout(font, "BUTTON CLICKER DUEL");
        ScreenUtils.clear(0, 0, 0, 0);

        game.batch.begin();
        miliS++;
        if(miliS == 60 && playing){
            timer++;
            miliS = 0;
        }
        if(timeLimit < timer){
            playing = false;
//            System.out.println("GAME OVER");
//            this.dispose();
//            game.setScreen(new mainMenuScreen(game));
        }

            if (newLetter) {
                randomNumber = getRandomNumber(29, 55);
                newLetter = false;
            }

            if(playing) {
                if (Gdx.input.isKeyPressed(randomNumber)) {
                    score++;
                    newLetter = true;
                } else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
                    score--;
                    newLetter = true;
                }
            }
            GlyphLayout letterLayout = new GlyphLayout(font, "Letter:" + (char) (randomNumber + 36));
            GlyphLayout scoreLayouyt = new GlyphLayout(font, "Score:" + score);
            GlyphLayout gameOverLayout = new GlyphLayout(font, "GAME OVER");
            GlyphLayout timerLayout = new GlyphLayout(font, "Time:" + timer);
            GlyphLayout backButtonLayout = new GlyphLayout(font, "Back to main menu");

            if(playing){
                font.draw(game.batch, timerLayout, game.WIDTH / 2 - timerLayout.width / 2, 410);
                font.draw(game.batch, letterLayout, game.WIDTH / 2 - letterLayout.width / 2, 310);
                font.draw(game.batch, scoreLayouyt, game.WIDTH / 2 - scoreLayouyt.width / 2, 210);
            }else{
                font.draw(game.batch, gameOverLayout, game.WIDTH / 2 - gameOverLayout.width / 2, 450);
                font.draw(game.batch, scoreLayouyt, game.WIDTH / 2 - scoreLayouyt.width / 2, 310);
                font.draw(game.batch, backButtonLayout, game.WIDTH / 2 - backButtonLayout.width / 2, 210);
                if (isCursorOnButton(backButtonLayout, 210)){
                    Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
                } else {
                    Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);

                    if (!isCursorOnButton(backButtonLayout, 210)) {
                        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                            System.out.println("BACK");
                            this.dispose();
                            game.setScreen(new mainMenuScreen(game));
                        }
                    }
                }
            }
            game.batch.end();
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

    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    private boolean isCursorOnButton(GlyphLayout buttonLayout, int buttonX) {
        return !(Gdx.input.getX() < buttonClickerDuel.WIDTH / 2 - buttonLayout.width / 2 + buttonLayout.width) ||
                !(Gdx.input.getX() > buttonClickerDuel.WIDTH / 2 - buttonLayout.width / 2) ||
                buttonClickerDuel.HEIGHT - Gdx.input.getY() >= buttonX ||
                !(buttonClickerDuel.HEIGHT - Gdx.input.getY() > buttonX - buttonLayout.height);
    }
}
