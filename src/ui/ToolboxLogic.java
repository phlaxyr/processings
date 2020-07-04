package ui;

import capabilities.IRefactorable;
import main.Main;
import processing.event.MouseEvent;
import rect.IDrawnShape;
import trickery.ISetupable;

public class ToolboxLogic implements ISetupable{
	
	public static ToolboxState getToolboxState(Toolbox tb) {
		return tb.activeTool.getCorrespondingState();
	}
	public static boolean isState(Toolbox tb, ToolboxState s) {
		return getToolboxState(tb) == s;
	}
	
	Toolbox tb;
	{
		this.tb = Main.main.toolb;
	}
	public void onElementClicked(MouseEvent e, IDrawnShape s, boolean isCoordsMovable) {
		if(isState(tb, ToolboxState.MOVE)) {
			if(s instanceof IRefactorable) {
				IRefactorable ref = (IRefactorable) s;
				System.out.print(ref);
			}
		}
	}
	@Override
	public void onSetup() {
		
	}
	
	
}
