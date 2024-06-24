package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class gameScreen implements Screen {

    SpriteBatch batch;
    Texture img;

    BitmapFont font;

    boolean newLetter = true;
    int randomNumber;
    int score;
    int timer = 0;
    int miliS = 0;

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
        ScreenUtils.clear(0, 0, 0, 0);
        miliS++;
        if(miliS == 60){
            timer++;
            miliS = 0;
        }

        if(newLetter){
            randomNumber = getRandomNumber(29, 55);
            newLetter = false;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            timer = 0;
            score = 1;
        }

        if (Gdx.input.isKeyPressed(randomNumber)) {
            score++;
            newLetter = true;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            score--;
            newLetter = true;
        }

        batch.begin();

        GlyphLayout letterLayout = new GlyphLayout(font, "Letter:" + (char) (randomNumber + 36));
        GlyphLayout scoreLayouyt = new GlyphLayout(font,"Score:" + score);
        GlyphLayout timerLayout = new GlyphLayout(font,"Time:" + timer);
        GlyphLayout startButtonLayout = new GlyphLayout(font,"START");
        GlyphLayout restartButtonLayout = new GlyphLayout(font,"RESTART");

        font.draw(batch, timerLayout, Gdx.graphics.getWidth()/2 - timerLayout.width / 2, 410);
        font.draw(batch, letterLayout, Gdx.graphics.getWidth()/2 - letterLayout.width / 2, 310);
        font.draw(batch, scoreLayouyt, Gdx.graphics.getWidth()/2 - scoreLayouyt.width / 2, 210);
        font.draw(batch, restartButtonLayout, Gdx.graphics.getWidth()/2 - restartButtonLayout.width / 2, 100);


        batch.end();
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
        batch.dispose();
        img.dispose();
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
