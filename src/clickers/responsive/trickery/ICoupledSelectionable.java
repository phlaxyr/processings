package clickers.responsive.trickery;

import clickers.IClickable;
import clickers.responsive.ISelectionable;
import shape.IDrawn;

public interface ICoupledSelectionable
		extends IClickable, IDrawn, ISelectionable, IRequireSelectionable {
//	@SuppressWarnings("unchecked")
//	@Override
//	default I getShape() {
//		return (I) this;
//	}
	@Override
	default ICoupledSelectionable getShape() {
		return this;
	}

	@Override
	default ISelectionable getSelectable() {
		return this;
	}
	@Override
	default void acknowledgeContainer(ISelectionable s) {
	}

}
