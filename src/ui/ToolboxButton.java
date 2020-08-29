package ui;

import clickers.responsive.CoupledButton;

public class ToolboxButton extends CoupledButton{
	public Toolbox tb;
	public ToolboxState state;
	public ToolboxButton(Toolbox tb, int x, int y, int sizex, int sizey, String txt, ToolboxState state) {
		super(x, y, sizex, sizey, txt);
		this.tb = tb;
		this.state = state;
	}
	
	@Override
	public ToolboxButton selectedFill(int fill) {
		return (ToolboxButton) super.selectedFill(fill);
	}
	

	public ToolboxState getCorrespondingState() {
		return state;
	}
	
	public static final ToolboxButton NONE = new ToolboxButton(null, 0, 0, 0, 0 ,"", ToolboxState.NONE);


}
