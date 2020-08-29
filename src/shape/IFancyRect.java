package shape;

public interface IFancyRect extends IDrawn, IFancinessCustomizable<IFancyRect>{

	void defaultCustomizations();
	void customize();
}
