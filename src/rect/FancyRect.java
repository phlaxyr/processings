package rect;

public class FancyRect extends Rect implements IFancyRect{
	public FancyRect(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public FancyRect(New builder) {
		this(builder.x, builder.y, builder.sizex, builder.sizey);
		New.match(this, builder);
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
	protected boolean s2flag = false;
	protected int selectstroke;
	public FancyRect selectedStroke(int stroke) { 
		s2flag = true;
		this.selectstroke = stroke;
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
	
}
