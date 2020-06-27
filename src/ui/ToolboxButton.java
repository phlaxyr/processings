package ui;

import clickers.responsive.InteResponsiveButton;

public class ToolboxButton extends InteResponsiveButton{
	public Toolbox tb;
	public ToolboxButton(int x, int y, int sizex, int sizey, String txt, Toolbox tb) {
		super(x, y, sizex, sizey, txt);
		this.tb = tb;
	}
	
	@Override
	public ToolboxButton selectedFill(int fill) {
		return (ToolboxButton) super.selectedFill(fill);
	}
	



}
