package trickery.element;

import main.Main;
import processing.event.MouseEvent;

public class SuperWrapper extends LambdaWrapper{
	public SuperWrapper(Element el) {
		super(el,
			// onclick = 
			ClickHandler.NONE, 
			// draw = 
			(self) -> {

				// System.out.print("draw");
				Main main = Main.main;
				Main.main.pushStyle();
	
				self.customize();
				main.rect(self.x, self.y, self.lenx, self.leny);
	
				
				if(self.text != null) {
					if(self.textsize == 0.0) {
						throw new NullPointerException("textsize 0.0. onSetup() was not called");
					} else {
						main.textSize(self.textsize);
					}
					main.fill(self.textcolor);
					main.text(self.text, self.x+5, self.y+5, self.lenx, self.leny);
				}
				main.popStyle();
			},
			// onsetup = 
			(self) -> {
				if(self.text != null && self.textsize == null) self.autoTextSize();
			},
			// customize = 
			(self) -> {
				Main main = Main.main;
				main.fill(self.fill);
				main.stroke(self.stroke);
				
			});
	}
	

	
	
	
	
	public final LambdaWrapper button = new LambdaWrapper(el, 
			(self, e, is, in) -> {
				self.super_.onclick(e, is, in);
				if (e.getAction() == MouseEvent.MOVE || e.getAction() == MouseEvent.EXIT
						|| e.getAction() == MouseEvent.ENTER)
					return;
				switch (e.getAction()) {
				case MouseEvent.PRESS:
					if (in) { // We press only if it's in bounds
						self.isPressed = true;
						self.fill = self.pressed_fill;// 0xFF008800;
					}
					break;
				case MouseEvent.RELEASE:
					if (self.isPressed) { // As long as we are pressed, we need to listen to releases
						// even if it's out of bounds, because you can drag the mouse out of bounds
						// TODO MouseEvent.EXIT allows you to alt tab out of without having a release
						// event
						self.isPressed = false; // unpress
						self.isSelected = !self.isSelected; // toggle selection
						self.fill = self.isSelected ? self.unselected_fill : self.selected_fill; // 0xFF00FF00 :
																									// 0xFFFFFFFF; //
																									// update fill
					}
					break;
				default:

				}
				// System.out.println(e.toString());
			}, this.draw, this.onsetup, this.customize);

}
