package shape;

import java.util.ArrayList;
import java.util.List;

import clickers.IClickable;
import mouse.MovableMouseEvent;
import processing.event.MouseEvent;
import trickery.IDrawHandler;
import trickery.element.Element;

public class ShapeSet {
	public List<IDrawn> rectsmovable = new ArrayList<>();
	public List<IClickable> clickersmovable = new ArrayList<>();
	public List<IDrawn> rects = new ArrayList<>();
	public List<IClickable> clickers = new ArrayList<>();
	public List<IDrawHandler> soledrawables = new ArrayList<>();
	public List<IDrawHandler> soledrawablesmovable = new ArrayList<>();
	
	public List<Element> elements = new ArrayList<>();
	public List<Element> elementsonclick = new ArrayList<>();
	
	public void drawMovable() {
		for (IDrawn rect : rectsmovable) {
			rect.draw();
		}
		for(IDrawHandler drawns : soledrawablesmovable) {
			drawns.draw();
		}
	}
	public void drawFixed() {
		for (IDrawn rect : rects) {
			rect.draw();
		}
		for(IDrawHandler drawns : soledrawables) {	
			drawns.draw();
		}
	}
	public IClickable getOneFixedUnder(MouseEvent e) {
		for (IClickable rect : clickers) {
			float x = e.getX();
			float y = e.getY();
			if(rect.getShape().isPointWithin(x, y)) {
				return rect;
			}

		}
		return null;
	}
	public IClickable getOneMovableUnder(MovableMouseEvent e) {
		for (IClickable rect : clickersmovable) {
			
			if(rect.getShape().isPointWithin(e.coordX, e.coordY)) {
				return rect;
			}
		}
		return null;
	}
}
