package trickery.element;

import processing.event.MouseEvent;

public class LambdaWrapper {
	public final Element el;
	public final ClickHandler onclick;
	public final DrawHandler draw;
	public final SetupHandler onsetup;
	public final DrawHandler customize;



	public LambdaWrapper(Element el, ClickHandler onclick, DrawHandler draw, SetupHandler onsetup,
			DrawHandler customize) {
		this.el = el;
		this.onclick = onclick;
		this.draw = draw;
		this.onsetup = onsetup;
		this.customize = customize;
	}

	public final void onclick(MouseEvent e, boolean isClick, boolean isInside) {
		onclick.onclick(el, e, isClick, isInside);
	}
	
	public final void draw() {
		draw.draw(el);
	}
	
	public final void onsetup() {
		onsetup.onsetup(el);
	}
	public final void customize() {
		customize.draw(el);
	}
}
