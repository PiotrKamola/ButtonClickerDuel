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
	int randomNumber;
	int score;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
		ScreenUtils.clear(1, 0, 0, 1);

//		System.out.println((int) ((Math.random() * (54 - 29)) + 29));

		if(newLetter){
			randomNumber = getRandomNumber(29, 55);
			System.out.println("Score: " + score);
//			System.out.println(randomNumber);
			System.out.println((char) (randomNumber + 36));
			newLetter = false;
		}

		if (Gdx.input.isKeyPressed(randomNumber)) {
			score++;
			newLetter = true;
		}else if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
			score--;
			newLetter = true;
		}

		batch.begin();
		GlyphLayout scoreLayouyt = new GlyphLayout(font, "" + (char) (randomNumber + 36) + "\n \n" + score);
		font.draw(batch, scoreLayouyt, Gdx.graphics.getWidth() / 2 - scoreLayouyt.width / 2, Gdx.graphics.getHeight() / 2 - scoreLayouyt.height / 2);

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
