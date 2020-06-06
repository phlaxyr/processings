package rect;

public class FancyRect extends Rect{
	public FancyRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	int fill;
	boolean fill_flag = false;
	public FancyRect setFill(int fill) {
		this.fill_flag = true;
		this.fill = fill;
		return this;
	}
	int stroke;
	boolean stroke_flag = false;
	public FancyRect setStroke(int stroke) {
		this.stroke_flag = true;
		this.stroke = stroke;
		return this;
	}
	
	@Override
	public void draw() {
		main.pushStyle();
		defaultCustomizations();
		customize();
		super.draw();
		main.popStyle();
	}
	protected void defaultCustomizations() {
		if(fill_flag) {
			main.fill(fill);
		}
		if(stroke_flag) {
			main.stroke(stroke);
		}
	}
	public void customize() {
		
	}
	public static FancyRect build(int x, int y, int sizex, int sizey) {
		return new FancyRect(x, y, sizex, sizey);
	}
}
