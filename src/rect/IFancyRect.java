package rect;

public interface IFancyRect extends IDrawnShape{
	IFancyRect fill(int f);
	IFancyRect stroke(int s);
	IFancyRect selectedFill(int f);
	void defaultCustomizations();
	void customize();
}
