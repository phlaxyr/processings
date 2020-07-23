package ui;

import capabilities.IRefactorable;
import main.Ap;
import main.Main;
import processing.event.MouseEvent;
import rect.IDrawnShape;
import trickery.ISetupable;

public class ToolboxManager implements ISetupable{
	
	Toolbox tb;
	public ToolboxManager(Toolbox tb) {
		this.tb = tb;
	}
	public ToolboxManager() {
		this(Main.main.toolb);
	}
	
	public static ToolboxState getToolboxState(Toolbox tb) {
		return tb.activeTool.getCorrespondingState();
	}
	public static boolean isState(Toolbox tb, ToolboxState s) {
		return getToolboxState(tb) == s;
	}
	
	IRefactorable moveme;
	public void onMouse(MouseEvent e, IDrawnShape s, boolean isCoordsMovable) {

		
		if(e.getAction() == MouseEvent.RELEASE) {
			if(s != null) {
				if(moveme instanceof IRefactorable) {
					this.moveme = (IRefactorable) s;
				}
			}
		} else if(e.getAction() == MouseEvent.DRAG) {
			float x = e.getX();
			float y = e.getY();
			x = isCoordsMovable ? Ap.p.screenXToCoordX(x) : x;
			y = isCoordsMovable ? Ap.p.screenYToCoordY(y) : y;
			if(isState(tb, ToolboxState.MOVE)) {
				moveme.moveTo((int)x, (int)y);
			}
		}
	}
	@Override
	public void onSetup() {
		
	}
	
	
}
