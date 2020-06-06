package clickers;

import processing.event.MouseEvent;

public interface IMouseHandler {
	void onMouse(MouseEvent e);
	void onMouseOutside(MouseEvent e);
}
