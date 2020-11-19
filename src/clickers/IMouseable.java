package clickers;

import processing.event.MouseEvent;

public interface IMouseable {
	void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside);
	static final IMouseable NONE = new IMouseable() {
		public void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside){}
	};
}
