package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	BitmapFont font;

	boolean newLetter = true;
	boolean playing = false;
	int randomNumber;
	int score;
	int timer = 0;
	int miliS = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
		ScreenUtils.clear(0, 0, 0, 0);
		miliS++;
		if(miliS == 60){
			timer++;
			miliS = 0;
		}

		if(newLetter){
			randomNumber = getRandomNumber(29, 55);
//			System.out.println("Score: " + score);
//			System.out.println(randomNumber);
//			System.out.println((char) (randomNumber + 36));
			newLetter = false;
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			playing = true;
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

//		GlyphLayout scoreLayouyt = new GlyphLayout(font, "" + (char) (randomNumber + 36) + "\n \n" + score);
// 		font.draw(batch, scoreLayouyt, Gdx.graphics.getWidth() / 2 - scoreLayouyt.width / 2, Gdx.graphics.getHeight() / 2 - scoreLayouyt.height / 2);


		GlyphLayout letterLayout = new GlyphLayout(font, "Letter:" + (char) (randomNumber + 36));
		GlyphLayout scoreLayouyt = new GlyphLayout(font,"Score:" + score);
		GlyphLayout timerLayout = new GlyphLayout(font,"Time:" + timer);
		GlyphLayout startButtonLayout = new GlyphLayout(font,"START");

//		font.draw(batch, timerLayout, 310, 410);
		if(playing){
			font.draw(batch, timerLayout, Gdx.graphics.getWidth()/2 - timerLayout.width / 2, 410);
			font.draw(batch, letterLayout, Gdx.graphics.getWidth()/2 - letterLayout.width / 2, 310);
			font.draw(batch, scoreLayouyt, Gdx.graphics.getWidth()/2 - scoreLayouyt.width / 2, 210);
		}
		font.draw(batch, startButtonLayout, Gdx.graphics.getWidth()/2 - startButtonLayout.width / 2, 100);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public int getRandomNumber(int min, int max){
		return (int) ((Math.random() * (max - min)) + min);
	}
}
