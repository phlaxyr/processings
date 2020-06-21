package rect.builder;

import rect.IFancyRect;
import rect.Rect;

public class FancyRect extends Rect implements IFancyRect{
	public FancyRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public FancyRect(FancyBuilder b) {
		this(b.x, b.y, b.sizex, b.sizey);
		New.match(this, b);
	}

	
	protected int fill;
	protected boolean fill_flag = false;
	public FancyRect fill(int fill) {
		this.fill_flag = true;
		this.fill = fill;
		return this;
	}
	protected int stroke;
	protected boolean stroke_flag = false;
	public FancyRect stroke(int stroke) {
		this.stroke_flag = true;
		this.stroke = stroke;
		return this;
	}
	
	protected boolean f2flag = false;
	protected int select_fill;
	public FancyRect selectedFill(int fill) { 
		f2flag = true;
		this.select_fill = fill;
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
	@Override
	public void defaultCustomizations() {
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
	public static FancyBuilder builder() {
		return new FancyBuilder();
	}
	
}
