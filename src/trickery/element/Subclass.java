package trickery.element;

import processing.event.MouseEvent;

public class Subclass {
	public final ClickHandler onclick = (self, e, is, in) -> {
		self.super_.onclick(e, is, in);
		if(e.getAction() == MouseEvent.MOVE || e.getAction() == MouseEvent.EXIT || e.getAction() == MouseEvent.ENTER) return;
		switch (e.getAction()) {		
		case MouseEvent.PRESS:
			if(in) { // We press only if it's in bounds
				self.isPressed = true;
				self.fill = self.pressed_fill;// 0xFF008800;
			}
			break;
		case MouseEvent.RELEASE:
			if(self.isPressed) { // As long as we are pressed, we need to listen to releases
				// even if it's out of bounds, because you can drag the mouse out of bounds
				// TODO MouseEvent.EXIT allows you to alt tab out of without having a release event
				self.isPressed = false; // unpress
				self.isSelected = !self.isSelected; // toggle selection
				self.fill = self.isSelected ? self.unselected_fill : self.selected_fill; // 0xFF00FF00 : 0xFFFFFFFF; // update fill
			}
			break;
		default:
			
		}
		// System.out.println(e.toString());
	};
	
	
	
	public class SubclassButton {
		int selected_fill = 0xFF000000;
		int unselected_fill = selected_fill;
		int pressed_fill = selected_fill;
		
	}
}
