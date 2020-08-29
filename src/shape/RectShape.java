package shape;

import main.Main;

public class RectShape implements IShape{
	public static Main main;
	public int x, y, sizex, sizey;

	public RectShape(int x, int y, int sizex, int sizey) {
		this.x = x;
		this.y = y;
		this.sizex = sizex;
		this.sizey = sizey;
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
	@Override
	public void onSetup() {
		
	}

	
}
