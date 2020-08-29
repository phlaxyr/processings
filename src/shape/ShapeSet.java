package shape;

import java.util.ArrayList;
import java.util.List;

import clickers.IClickable;

public class ShapeSet {
	public List<Rect> rectsmovable = new ArrayList<>();
	public List<IClickable<?>> clickersmovable = new ArrayList<>();
	public List<Rect> rects = new ArrayList<>();
	public List<IClickable<?>> clickers = new ArrayList<>();
	
	public void drawMovable() {
		for (Rect rect : rectsmovable) {
			rect.draw();
		}
	}
	public void drawFixed() {
		for (Rect rect : rects) {
			rect.draw();
		}
	}
	public IClickable<?> getOneElementUnder(float x, float y) {
		for (IClickable<?> rect : clickers) {
			if(rect.getShape().isPointWithin(x, y)) {
				return rect;
			}
		}
		for (IClickable<?> rect : clickersmovable) {
			if(rect.getShape().isPointWithin(x, y)) {
				return rect;
			}
		}
		return null;
	}
}
