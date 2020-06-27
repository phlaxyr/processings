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
		
		if(hasText) {
			if(textsize == 0.0) {
				throw new NullPointerException("textsize 0.0. onSetup() was not called");
			} else {
				main.textSize(textsize);
			}
			main.fill(textcolor);
			main.text(text, x+5, y+5/*);//*/, sizex, sizey);
		}


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
	
	// imported from TextBox
	boolean hasText = false;
	String text;
	public FancyRect(int x, int y, int sizex, int sizey, String text) {
		this(x, y, sizex, sizey);
		this.setText(text);
		this.setTextColor(0).fill(255).stroke(0); 
		// these can be overriden just by building with the factory pattern, as normal
	}
	public FancyRect setText(String text) {
		this.text = text;
		hasText = true;
		return this;
	}
	
	boolean t1 = false;
	int textcolor;
	public FancyRect setTextColor(int color) {
		this.t1 = true;
		this.textcolor = color;
		return this;
	}
//	float textsizex, textsizey;
	
	
	float textsize = 0;
	public FancyRect setTextSize(int size) {
		this.textsize = size;
		return this;
	}
	public FancyRect autoTextSize() {
		main.pushStyle();
		main.textSize(100);
//		textsizex = sizex * 100 / main.textWidth(text);
//		textsizey = sizey * 100 / (main.textAscent() + main.textDescent());
		// approx area. the constant is just 2. it just seems to work, there is no rationale
		float textarea = 2 * main.textWidth(text) * (main.textAscent() + main.textDescent());
		float boxarea = this.sizex * this.sizey;
		float scaleby = (float) Math.sqrt(boxarea / textarea); 
//		main.erase(x, y - sizey, sizex, sizey);

//		float textsize = Main.min(textsizex, textsizey);
		textsize = 100 * scaleby;
		main.popStyle();
		return this;
	}
	@Override
	public void onSetup() {
		super.onSetup();
		if(hasText && textsize == 0) this.autoTextSize();
	}
	

	

	
	
	
}
