package ui;

import shape.IShape;
import shape.IShapeProvider;

public interface ISelectable extends IShapeProvider<IShape>{
	boolean isSelected();
	void onSelect();
	void onDeselect();
}
