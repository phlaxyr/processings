package trickery.element;

public interface PostConstructorT<T> {
	void constr(T self);
	static final PostConstructorT<Object> NONE = new PostConstructorT<Object>() {
		@Override
		public void constr(Object self) {
			
		}
	 };
}
