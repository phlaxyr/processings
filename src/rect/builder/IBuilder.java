package rect.builder;

import clickers.IClickable;
import rect.IDrawnShape;

public interface IBuilder<S extends IClickable<R>, R extends IDrawnShape> {
	R buildRect();
	S buildButton();
}
