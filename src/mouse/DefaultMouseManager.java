package mouse;


import clickers.IClickable;
import main.Main;
import processing.event.MouseEvent;
import shape.ShapeSet;

public class DefaultMouseManager implements IMouseManager{
	Main m;
	{
		m = Main.main;
	}
	public ShapeSet shapes() {
		return m.shapes;
	}
	@Deprecated
	@Override
	public void mouseEvent(MouseEvent e) {
		if(e.getAction() == MouseEvent.RELEASE ) {
			for (IClickable rect : shapes().clickers) {
				float x = e.getX();
				float y = e.getY();
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onMouseEvent(e, true, true);
				} else {
					rect.onMouseEvent(e, true, false);
				}
			}
			for (IClickable rect : shapes().clickersmovable) {
				float x = m.getMouseCoordX(e);
				float y = m.getMouseCoordY(e);
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onMouseEvent(e, true, true);
				} else {
					rect.onMouseEvent(e, true, false);
				}
			}
		}
		m.transformer.mouseEvent(e);
	}

}