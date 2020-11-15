package trickery.element;

import processing.event.MouseEvent;

public interface ClickHandler {
	void onclick(Element self, MouseEvent e, boolean isClick, boolean isInside);
	
	static ClickHandler NONE = new ClickHandler() {
		@Override
		public void onclick(Element self, MouseEvent e, boolean isClick, boolean isInside) {
			
		}
		@SuppressWarnings("unused")
		public final boolean IS_NONE = true;
	};
}
