package trickery.element;

import main.Main;
import processing.event.MouseEvent;

public class SuperWrapper {
	Element el;
	public SuperWrapper(Element el) {
		this.el = el;
	}
	
	public final ClickHandler onclick = ClickHandler.NONE;
	public final void onclick(MouseEvent e, boolean isClick, boolean isInside) {
		onclick.onclick(el, e, isClick, isInside);
	}
	
	public final DrawHandler customize = (self) -> {
		Main main = Main.main;
		main.fill(self.fill);
		main.stroke(self.stroke);
		
	};
	public final void customize() {
		customize.draw(el);
	}
	
	public final DrawHandler draw = (self) -> {

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
		
	};
	public final void draw() {
		draw.draw(el);
	}
	
	
	public final SetupHandler onsetup = (self) -> {
		if(self.text != null && self.textsize == null) self.autoTextSize();
	};
	public final void onsetup() {
		onsetup.onsetup(el);
	}

}
