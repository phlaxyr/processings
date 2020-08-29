package ui;

import capabilities.IRefactorable;
import clickers.IClickable;
import main.Ap;
import main.Main;
import mouse.IMouseManager;
import processing.event.MouseEvent;
import rect.IDrawnShape;
import rect.ShapeSet;
import trickery.ISetupable;

public class ToolboxManager implements ISetupable, IMouseManager{
	
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
	
	@Override
	public void mouseEvent(MouseEvent e) {
		if(e.getAction() == MouseEvent.RELEASE ) {
			for (IClickable<?> rect : s.clickers) {
				float x = e.getX();
				float y = e.getY();
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onMouseEvent(e, true);
					onToolboxMouse(e, rect, false);
				} else {
					rect.onMouseEvent(e, false);
				}
			}
			for (IClickable<?> rect : s.clickersmovable) {
				float x = m.getMouseCoordX(e);
				float y = m.getMouseCoordY(e);
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onMouseEvent(e, true);
					onToolboxMouse(e, rect, true);
				} else {
					rect.onMouseEvent(e, false);
				}
			}
		}
		m.transformer.mouseEvent(e);
	}
	
	IRefactorable moveme;
	public void onToolboxMouse(MouseEvent e, IDrawnShape s, boolean isCoordsMovable) {

		
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
