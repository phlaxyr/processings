package rect;

public interface IShape {
	void draw();
	boolean isPointWithin(int x, int y);
	boolean isPointWithin(float x, float y);
}
