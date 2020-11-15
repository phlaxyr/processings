package mouse;

import main.Main;
import processing.event.MouseEvent;

public class MovableMouseEvent {
	public final MouseEvent e;
	public final float coordX, coordY;
	public MovableMouseEvent(MouseEvent e, Main m) {
		this.e = e;
		this.coordX = m.screenXToCoordX(e.getX());
		this.coordY = m.screenYToCoordY(e.getY());
		
	}
}
