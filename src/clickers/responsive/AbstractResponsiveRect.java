package clickers.responsive;

import shape.FancyRect;
import shape.New;

public abstract class AbstractResponsiveRect extends FancyRect implements IRequireSelectionable{
	public AbstractResponsiveRect(New b) {
		super(b);
	}
	public AbstractResponsiveRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public AbstractResponsiveRect(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}
	

	@Override
	public void defaultCustomizations() {

		super.defaultCustomizations();
//		if(getModel().isSelected() && f2flag) {
		if (getSelectable().isSelected()) {
			if (f2flag) {
				main.fill(select_fill);
			}
			if (s2flag) {
				main.stroke(selectstroke);
			}
		}

	}
}
