package ui;

import clickers.responsive.InteResponsiveTextButton;

public class ToolboxButton extends InteResponsiveTextButton{
	public Toolbox tb;
	public ToolboxButton(int x, int y, int sizex, int sizey, String txt, Toolbox tb) {
		super(x, y, sizex, sizey, txt);
		this.tb = tb;
	}
	
	@Override
	public ToolboxButton selectedFill(int fill) {
		// TODO Auto-generated method stub
		return (ToolboxButton) super.selectedFill(fill);
	}
	



}
