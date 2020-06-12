package clickers;

import rect.IDrawnShape;
import rect.IShapeProvider;

public interface IClickable<V extends IDrawnShape> extends IMouseHandler, IShapeProvider<V>{

//	public void setElement(V v);
	
	
	
}
