package rect;

public interface IFancyRect extends IDrawnShape, IFancinessCustomizable<IFancyRect>{

	void defaultCustomizations();
	void customize();
}
