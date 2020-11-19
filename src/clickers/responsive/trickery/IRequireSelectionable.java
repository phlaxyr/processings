package clickers.responsive.trickery;

import clickers.responsive.ISelectionable;

public interface IRequireSelectionable {
	void acknowledgeContainer(ISelectionable s);
	ISelectionable getSelectable();
}
