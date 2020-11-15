package trickery.element;

import main.Main;
import processing.event.MouseEvent;

public class SuperWrapper {
	Element el;
	public SuperWrapper(Element el) {
		this.el = el;
	}
	
	public ClickHandler onclick = ClickHandler.NONE;
	public void onclick(MouseEvent e, boolean isClick, boolean isInside) {
		onclick.onclick(el, e, isClick, isInside);
	}
	
	public final DrawHandler draw = (self) -> {

		// System.out.print("draw");
		Main.main.pushStyle();
		Main main = Main.main;
		if(self.fill != null) {
			main.fill(self.fill);
		}
		if(self.stroke != null) {
			main.stroke(self.stroke);
		}
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
		
	};
	public void draw() {
		draw.draw(el);
	}
}
