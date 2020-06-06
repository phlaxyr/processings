package clickers;

import rect.IShape;

public interface IClickable<V extends IShape> extends IMouseHandler{
	public V getShape();
//	public void setElement(V v);
	
	
	
}
