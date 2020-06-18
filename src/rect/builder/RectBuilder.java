package rect.builder;

import clickers.SimpleButton;
import rect.Rect;

public class RectBuilder extends Builder implements IBuilder<SimpleButton, Rect> {
	public RectBuilder() {
	}
	public RectBuilder(int x, int y, int sizex, int sizey) {
		this.pos(x, y).size(sizex, sizey);
	}
	@Override
	public RectBuilder pos(int x, int y) {
		return (RectBuilder) super.pos(x, y);
	}
	@Override
	public RectBuilder pos(float x, float y) {
		return (RectBuilder) super.pos(x, y);
	}
	@Override
	public RectBuilder size(int x, int y) {
		return (RectBuilder) super.size(x, y);
	}
	@Override
	public RectBuilder size(float x, float y) {
		return (RectBuilder) super.size(x, y);
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
