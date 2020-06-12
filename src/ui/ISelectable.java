package ui;

import rect.IDrawnShape;
import rect.IShapeProvider;

public interface ISelectable extends IShapeProvider<IDrawnShape>{
	boolean isSelected();
	void onSelect();
	void onDeselect();
}
