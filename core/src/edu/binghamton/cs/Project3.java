package edu.binghamton.cs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

public class Project3 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img2, redC, yellowC, blueC;
	Sprite s1, s2;

	float x, y, x2, y2;
	float dx, dy, dx2, dy2;
	float w, h;

	Circle ball1;
	Circle ball2;

	boolean skip = false;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("yellowCircle.png");
		img2 = new Texture("yellowCircle.png");

		blueC = new Texture("blueCircle.png");
		redC = new Texture("redCircle.png");
		yellowC = new Texture("yellowCircle.png");

		s1 = new Sprite(img);
		s2 = new Sprite(img2);

		x = 0;
		y = 0;
		x2 = 300;
		y2 = 500;
		dx = 17;
		dy = 29;
		dx2= 15;
		dy2 = 35;

		ball1 = new Circle(x, y, s1.getWidth() / 2);
		ball2 = new Circle(x2, y2, s2.getWidth() / 2);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		x = x + dx;
		y = y + dy;

		x2 = x2 + dx2;
		y2 = y2 + dy2;

		ball1.x = x;
		ball1.y = y;
		ball2.x = x2;
		ball2.y = y2;


		if((x > w) || (x < 0)){
			dx = -dx;
			img = blueC;
			skip = true;
		}
		if((y > h) || (y < 0)){
			dy = -dy;
			img = redC;
			skip = true;
		}

		if((x2 > w) || (x2 < 0)){
			dx2 = -dx2;
			img2 = blueC;
			skip = true;
		}
		if((y2 > h) || (y2 < 0)){
			dy2 = -dy2;
			img2 = redC;
			skip = true;
		}

		if(Intersector.overlaps(ball1, ball2)) {

			if((img == redC && img2 == blueC) || (img2 == redC && img == blueC)) {
				img = yellowC;
				img2 = yellowC;
			}else if(skip) {
				skip = false;
			}else {
				float store1 = dy;
				float store2 = dx;
				dx = -dx2;
				dy = -dy2;
				dx2 = -store1;
				dy2 = -store2;
			}



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
