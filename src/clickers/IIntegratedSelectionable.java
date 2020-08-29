package clickers;

import clickers.responsive.IRequireSelectionable;
import clickers.responsive.ISelectionable;
import shape.IDrawn;

public interface IIntegratedSelectionable
		extends IClickable<IIntegratedSelectionable>, IDrawn, ISelectionable, IRequireSelectionable {
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

	default void acknowledgeContainer(ISelectionable s) {
	}
}
