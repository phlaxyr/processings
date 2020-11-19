package trickery.element;

public interface PostConstructor {
	void constr(Element self);
	static PostConstructor NONE = new PostConstructor() {
		@Override
		public void constr(Element self) {
			
		}
	 };
}
