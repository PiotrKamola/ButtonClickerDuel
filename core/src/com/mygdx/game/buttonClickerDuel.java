package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.mainMenuScreen;

public class buttonClickerDuel extends Game {
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public SpriteBatch batch;
	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new mainMenuScreen(this));
	}

	@Override
	public void render(){
		super.render();
	}
}
//	SpriteBatch batch;
//	Texture img;
//
//	BitmapFont font;
//
//	boolean newLetter = true;
//	boolean playing = false;
//	int randomNumber;
//	int score;
//	int timer = 0;
//	int miliS = 0;

//	@Override
//	public void create () {
//		batch = new SpriteBatch();
//	}
//
//	@Override
//	public void render () {
//		font = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
//		ScreenUtils.clear(0, 0, 0, 0);
//		miliS++;
//		if(miliS == 60){
//			timer++;
//			miliS = 0;
//		}
//
//		if(newLetter){
//			randomNumber = getRandomNumber(29, 55);
//			newLetter = false;
//		}
//
//		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
//			playing = true;
//			timer = 0;
//			score = 1;
//		}
//
//		if (Gdx.input.isKeyPressed(randomNumber)) {
//			score++;
//			newLetter = true;
//		}else if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
//			score--;
//			newLetter = true;
//		}
//
//		batch.begin();
//
//		GlyphLayout letterLayout = new GlyphLayout(font, "Letter:" + (char) (randomNumber + 36));
//		GlyphLayout scoreLayouyt = new GlyphLayout(font,"Score:" + score);
//		GlyphLayout timerLayout = new GlyphLayout(font,"Time:" + timer);
//		GlyphLayout startButtonLayout = new GlyphLayout(font,"START");
//		GlyphLayout restartButtonLayout = new GlyphLayout(font,"RESTART");
//
//		if(playing){
//			font.draw(batch, timerLayout, Gdx.graphics.getWidth()/2 - timerLayout.width / 2, 410);
//			font.draw(batch, letterLayout, Gdx.graphics.getWidth()/2 - letterLayout.width / 2, 310);
//			font.draw(batch, scoreLayouyt, Gdx.graphics.getWidth()/2 - scoreLayouyt.width / 2, 210);
//			font.draw(batch, restartButtonLayout, Gdx.graphics.getWidth()/2 - restartButtonLayout.width / 2, 100);
//		}
//		if(!playing){
//			font.draw(batch, startButtonLayout, Gdx.graphics.getWidth()/2 - startButtonLayout.width / 2, 100);
//		}
//
//		if(Gdx.input.isTouched()){
//			playing = true;
//		}
//
//		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
//
//	public int getRandomNumber(int min, int max){
//		return (int) ((Math.random() * (max - min)) + min);
//	}
//}
