package rect.builder;

import rect.RectBuilder;

public class Builder {
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
	
	
	int x, y;
	public Builder pos(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Builder pos(float x, float y) {
		this.pos((int)x, (int)y);
		return this;
	}
	int sizex, sizey;
	
	public Builder size(int x, int y) {
		this.sizex = x;
		this.sizey = y;
		return this;
	}
	public Builder size(float x, float y) {
		this.size((int)x, (int)y);
		return this;
	}
	
	
	
	protected int fill;
	protected boolean fill_flag = false;
	protected Builder fill(int fill) {
		this.fill_flag = true;
		this.fill = fill;
		return this;
	}
	protected int stroke;
	protected boolean stroke_flag = false;
	protected Builder stroke(int stroke) {
		this.stroke_flag = true;
		this.stroke = stroke;
		return this;
	}
	
	protected boolean f2flag = false;
	protected int select_fill;
	protected Builder selectedFill(int fill) { 
		f2flag = true;
		this.select_fill = fill;
		return this;
	}

	public static void match(FancyRect r, Builder b) {
		r.fill = b.fill;
		r.fill_flag = b.fill_flag;
		r.stroke = b.stroke;
		r.stroke_flag = b.stroke_flag;
		r.select_fill = b.select_fill;
//		System.out.println(r.select_fill);System.out.println(this.select_fill);
		r.f2flag = b.f2flag;
	}
	
}
