package clickers;

import rect.IDrawnShape;
import rect.IRegistered;
import rect.IShapeProvider;

public interface IClickable<V extends IDrawnShape> extends IMouseHandler, IShapeProvider<V>, IRegistered {

//	public void setElement(V v);
	
	
	
}
