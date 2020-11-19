package trickery.element;

public interface DrawHandler {
	void draw(Element self);
	static DrawHandler NONE = new DrawHandler() {
		@Override
		public void draw(Element self) {
			
		}
	 };
}
