package trickery.element;

public interface PostConstructor extends PostConstructorT<Element>{
	static final PostConstructor NONE = new PostConstructor() {
		@Override
		public void constr(Element self) {
			
		}
	 };
}
