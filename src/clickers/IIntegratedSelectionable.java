package clickers;

import clickers.responsive.IRequireSelectionable;
import clickers.responsive.ISelectionable;
import rect.IDrawnShape;

public interface IIntegratedSelectionable
		extends IClickable<IIntegratedSelectionable>, IDrawnShape, ISelectionable, IRequireSelectionable {
//	@SuppressWarnings("unchecked")
//	@Override
//	default I getShape() {
//		return (I) this;
//	}
	default IIntegratedSelectionable getShape() {
		return this;
	}

	@Override
	default ISelectionable getSelectable() {
		return this;
	}

	default void linkSelectionable(ISelectionable s) {
	}
}
