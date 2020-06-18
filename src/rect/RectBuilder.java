package rect;

import clickers.SimpleButton;

public class RectBuilder implements IBuilder<SimpleButton, Rect> {
	public RectBuilder() {
	}
	public RectBuilder(int x, int y, int sizex, int sizey) {
		this.pos(x, y).size(sizex, sizey);
	}
	int x, y;
	public RectBuilder pos(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	public RectBuilder pos(float x, float y) {
		this.pos((int)x, (int)y);
		return this;
	}
	int sizex, sizey;
	public RectBuilder size(int x, int y) {
		this.sizex = x;
		this.sizey = y;
		return this;
	}
	public RectBuilder size(float x, float y) {
		this.size((int)x, (int)y);
		return this;
	}
	@Override
	public Rect buildRect() {
		return new Rect(x, y, sizex, sizey);
	}

	@Override
	public SimpleButton buildButton() {
		return new SimpleButton(this.buildRect());
	}

}
