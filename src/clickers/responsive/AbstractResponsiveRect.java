package clickers.responsive;

import rect.FancyRect;
import rect.New;

public abstract class AbstractResponsiveRect extends FancyRect implements IRequireSelectionable{
	public AbstractResponsiveRect(New b) {
		super(b);
	}

	public AbstractResponsiveRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
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
