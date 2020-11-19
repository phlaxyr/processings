package ui;

import capabilities.IRefactorable;
import main.Ap;
import main.Main;
import mouse.MovableMouseEvent;
import processing.event.MouseEvent;
import shape.IShape;
import shape.ShapeSet;
import trickery.ISetupable;

public class ToolboxManager implements ISetupable {
	
	Main m;
	Toolbox tb;
	public ToolboxManager(Toolbox tb) {
		this.tb = tb;
		this.m = Main.main;
	}
	ShapeSet s;
	public ToolboxManager() {
		this(Main.main.toolb);
		this.s = Main.main.shapes;
	}
	
	public static ToolboxState getToolboxState(Toolbox tb) {
		return tb.activeTool.getCorrespondingState();
	}
	public static boolean isState(Toolbox tb, ToolboxState s) {
		return getToolboxState(tb) == s;
	}
	
	IRefactorable moveme;
	public void onToolboxMouse(MouseEvent e) {


		IShape nominal = s.getOneFixedUnder(e);
		boolean isMovable;
		if(nominal == null) {
			nominal = s.getOneMovableUnder(new MovableMouseEvent(e, Ap.p));
			if(nominal == null) {
				return;
			} else {
				isMovable = true;
			}
		} else {
			isMovable = false;
		}
		
		if(e.getAction() == MouseEvent.RELEASE) {
			if(s != null) {
				if(moveme instanceof IRefactorable) {
					this.moveme = (IRefactorable) s;
				}
			}
		} else if(e.getAction() == MouseEvent.DRAG) {
			float x = e.getX();
			float y = e.getY();
			x = isMovable ? Ap.p.screenXToCoordX(x) : x;
			y = isMovable ? Ap.p.screenYToCoordY(y) : y;
			if(isState(tb, ToolboxState.MOVE)) {
				moveme.moveTo((int)x, (int)y);
			}
		}
	}
	@Override
	public void onSetup() {
		
	}

	
	
}
