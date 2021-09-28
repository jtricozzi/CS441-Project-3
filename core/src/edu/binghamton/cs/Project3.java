package edu.binghamton.cs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Project3 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x, y;
	float dx, dy;
	float w, h;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		x = 0;
		y = 0;
		dx = 17;
		dy = 29;
	}

	@Override
	public void render () {
		ScreenUtils.clear((float).2, (float).3, 0, 1);
		x = x + dx;
		y = y + dy;

		if((x > w) || (x < 0)){
			dx = -dx;
		}
		if((y > h) || (y < 0)){
			dy = -dy;
		}
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resize (int width, int height) {
		w = width;
		h = height;
	}

}
