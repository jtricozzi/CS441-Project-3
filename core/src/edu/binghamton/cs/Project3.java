package edu.binghamton.cs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

public class Project3 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img2, redC, yellowC, blueC;
	float x, y, x2, y2;
	float dx, dy, dx2, dy2;
	float w, h;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("yellowCircle.png");
		img2 = new Texture("yellowCircle.png");

		blueC = new Texture("blueCircle.png");
		redC = new Texture("redCircle.png");
		yellowC = new Texture("yellowCircle.png");

		x = 0;
		y = 0;
		x2 = 5;
		y2 = 5;
		dx = 17;
		dy = 29;
		dx2= 15;
		dy2 = 35;
	}

	@Override
	public void render () {
		ScreenUtils.clear(255, 255, 255, 1);
		x = x + dx;
		y = y + dy;

		x2 = x2 + dx2;
		y2 = y2 + dy2;

		if((x > w) || (x < 0)){
			dx = -dx;
			img = blueC;
		}
		if((y > h) || (y < 0)){
			dy = -dy;
			img = redC;
		}

		if((x2 > w) || (x2 < 0)){
			dx2 = -dx2;
			img2 = blueC;
		}
		if((y2 > h) || (y2 < 0)){
			dy2 = -dy2;
			img2 = redC;
		}

		if(Intersector.overlaps(img, img2)) {
			dy = -dy;
			dx = -dx;
			dy2 = -dy2;
			dx2 = -dx2;
			img = yellowC;
			img2 = yellowC;

		}

		batch.begin();
		batch.draw(img, x, y);
		batch.draw(img2, x2, y2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		img2.dispose();
	}

	@Override
	public void resize (int width, int height) {
		w = width;
		h = height;
	}

}
