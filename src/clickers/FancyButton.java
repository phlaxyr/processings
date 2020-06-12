package clickers;

import rect.FancyRect;

public class FancyButton extends AbstractButton<FancyRect>{

	public FancyButton(FancyRect rect) {
		super(rect);
	}
	public FancyButton(int x, int y, int sizex, int sizey) {
		this(new FancyRect(x, y, sizex, sizey));
	}

}
