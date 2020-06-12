package rect;

import main.Main;

public class Rect implements IDrawnShape{
	public static Main main;
	public int x, y, sizex, sizey;

	public Rect(int x, int y, int sizex, int sizey) {
		this.x = x;
		this.y = y;
		this.sizex = sizex;
		this.sizey = sizey;
	}

	
	
	
	@Override
	public void draw() {

		main.rect(x, y, sizex, sizey);

	}
	/**
	 * inclusize exclusive
	 * @param x
	 * @param y
	 * @return
	 */
	@Override
	public boolean isPointWithin(int x, int y) {
		return this.x <= x && x < this.x + sizex && this.y <= y && y < this.y + sizey;
		
	}
	
	/**
	 * inclusize exclusive
	 * @param x
	 * @param y
	 * @return
	 */
	@Override
	public boolean isPointWithin(float x, float y) {
		return this.x <= x && x < this.x + sizex && this.y <= y && y < this.y + sizey;
		
	}
	
}
