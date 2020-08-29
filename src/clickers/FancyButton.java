package clickers;

import shape.FancyRect;

public class FancyButton extends AbstractButton {

	public FancyButton(FancyRect rect) {
		super(rect);
	}
	@Override
	public FancyRect rect() {
		return (FancyRect)super.rect();
	}
	public FancyButton(int x, int y, int sizex, int sizey) {
		this(new FancyRect(x, y, sizex, sizey));
	}

}
