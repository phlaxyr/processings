package rect;

import clickers.IClickable;

public interface IBuilder<S extends IClickable<R>, R extends IDrawnShape> {
	R buildRect();
	S buildButton();
}
