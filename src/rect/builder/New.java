package rect.builder;

public class New {
	public static ResponsiveBuilder Responsive() {
		return new ResponsiveBuilder();
	}
	public static ResponsiveTextBuilder ResponsiveText() {
		return new ResponsiveTextBuilder();
	}
	public static FancyBuilder FancyRect() {
		return new FancyBuilder();
	}
	public static RectBuilder Rect() {
		return new RectBuilder();
	}
	public static ResponsiveBuilder Responsive(int x, int y, int sizex, int sizey) {
		return new ResponsiveBuilder(x, y, sizex, sizey);
	}
	public static ResponsiveTextBuilder ResponsiveText(int x, int y, int sizex, int sizey, String str) {
		return new ResponsiveTextBuilder(x, y, sizex, sizey, str);
	}
	public static FancyBuilder FancyRect(int x, int y, int sizex, int sizey) {
		return new FancyBuilder(x, y, sizex, sizey);
	}
	public static RectBuilder Rect(int x, int y, int sizex, int sizey) {
		return new RectBuilder(x, y, sizex, sizey);
	}
	
	int x, y;
	public New pos(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public New pos(float x, float y) {
		this.pos((int)x, (int)y);
		return this;
	}
	int sizex, sizey;
	
	public New size(int x, int y) {
		this.sizex = x;
		this.sizey = y;
		return this;
	}
	public New size(float x, float y) {
		this.size((int)x, (int)y);
		return this;
	}
	
	
	
	protected int fill;
	protected boolean fill_flag = false;
	protected New fill(int fill) {
		this.fill_flag = true;
		this.fill = fill;
		return this;
	}
	protected int stroke;
	protected boolean stroke_flag = false;
	protected New stroke(int stroke) {
		this.stroke_flag = true;
		this.stroke = stroke;
		return this;
	}
	
	protected boolean f2flag = false;
	protected int select_fill;
	protected New selectedFill(int fill) { 
		f2flag = true;
		this.select_fill = fill;
		return this;
	}

	public static void match(FancyRect r, New b) {
		r.fill = b.fill;
		r.fill_flag = b.fill_flag;
		r.stroke = b.stroke;
		r.stroke_flag = b.stroke_flag;
		r.select_fill = b.select_fill;
//		System.out.println(r.select_fill);System.out.println(this.select_fill);
		r.f2flag = b.f2flag;
	}
	
}
