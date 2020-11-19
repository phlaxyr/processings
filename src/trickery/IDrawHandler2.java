package trickery;

import clickers.IMouseable;

public interface IDrawHandler2 extends IDrawHandler{
	default IMouseable getMouseHandler() {
		return IMouseable.NONE;
	}
	
}
