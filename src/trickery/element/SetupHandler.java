package trickery.element;

public interface SetupHandler {
	void onsetup(Element self);
	
	static SetupHandler NONE = new SetupHandler() {
		@Override
		public void onsetup(Element self) {
			
		}
	};
}
