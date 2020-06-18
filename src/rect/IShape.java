package rect;

public interface IShape extends IRegistered{
	boolean isPointWithin(int x, int y);
	boolean isPointWithin(float x, float y);
}
