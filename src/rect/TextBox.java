package rect;

import processing.core.PGraphics;

public class TextBox extends FancyRect{

	public String text;
	public TextBox(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey);
		this.text = text;
		this.setTextColor(0).setFill(255).setStroke(0); 
		// these can be overriden just by building with the factory pattern, as normal
	}
	
	boolean flag = false;
	int textcolor;
	public TextBox setTextColor(int color) {
		this.flag = true;
		this.textcolor = color;
		return this;
	}
//	float textsizex, textsizey;
	float textsize;
	public TextBox autoTextSize() {
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
	

	
	
	public void draw() {
		
		main.pushStyle();
		defaultCustomizations();
		customize();
		main.rect(x, y, sizex, sizey);
		main.textSize(textsize);
		main.fill(textcolor);
		main.text(text, x+5, y+5/*);//*/, sizex, sizey);

		main.popStyle();
		
	}
	

}
