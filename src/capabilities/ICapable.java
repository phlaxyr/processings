package capabilities;

public interface ICapable {
	void accept(ICapability cap);
	<T extends ICapability> boolean hasCap(Class<T> cap);
	<T extends ICapability> T getCap(Class<T> cap);
}
