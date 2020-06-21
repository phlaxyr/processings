package ui;

import clickers.responsive.InteResponsiveTextButton;

public class ToolboxButton extends InteResponsiveTextButton{
	public ToolBox tb;
	public ToolboxButton(int x, int y, int sizex, int sizey, String txt, ToolBox tb) {
		super(x, y, sizex, sizey, txt);
		this.tb = tb;
	}
	
	



}
