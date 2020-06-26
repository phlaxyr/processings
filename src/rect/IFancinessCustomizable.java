package rect;

public interface IFancinessCustomizable<This> {
	This fill(int f);
	This stroke(int s);
	This selectedFill(int f);
	This selectedStroke(int s);
}
