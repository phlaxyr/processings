package clickers;

import clickers.responsive.ISelectionable;
import rect.IDrawnShape;

public interface IIntegratedSelectionable extends IClickable<IIntegratedSelectionable>, IDrawnShape, ISelectionable{
//	@SuppressWarnings("unchecked")
//	@Override
//	default I getShape() {
//		return (I) this;
//	}
	default IIntegratedSelectionable getShape() {
		return this;
	}
}
