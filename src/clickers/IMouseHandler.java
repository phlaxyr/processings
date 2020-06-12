package clickers;

import processing.event.MouseEvent;

public interface IMouseHandler {
	void onClick(MouseEvent e);
	void onClickOutside(MouseEvent e);
	public static final IMouseHandler NONE = new IMouseHandlerImpl() {
		@Override
		public void onClick(MouseEvent e) {}
		@Override
		public void onClickOutside(MouseEvent e) {}
	};
}
