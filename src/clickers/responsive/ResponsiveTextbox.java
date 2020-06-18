package clickers.responsive;

import rect.Textbox;

public class ResponsiveTextbox extends Textbox implements IRequireSelectionable{

	public ResponsiveTextbox(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}
	
	
	ISelectionable clickInfo;
	@Override
	public void linkSelectionable(ISelectionable info) {
		this.clickInfo = info;
	}
	
	
	@Override
	public void defaultCustomizations() {
//		System.out.print(this.fill);
		super.defaultCustomizations();
//		if(getModel().isSelected() && f2flag) {
		if(clickInfo.isSelected() && f2flag) {
			main.fill(select_fill);
		}
	}
	
}
