package clickers.responsive;

import rect.Textbox;

public abstract class AbstractResponsiveTextbox extends Textbox implements IRequireSelectionable{
 

	public AbstractResponsiveTextbox(int x, int y, int sizex, int sizey, String str) {
		super(x, y, sizex, sizey, str);
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
