package rect;

import main.Main;

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
	
	public void draw() {
		main.pushStyle();
		defaultCustomizations();
		customize();
		main.textSize(100);
		float textsizex = sizex * 100 / main.textWidth(text);
		float textsizey = sizey * 100 / (main.textAscent() + main.textDescent());
		System.out.println(textsizex + ", "+textsizey);
//		main.erase(x, y - sizey, sizex, sizey);
		main.rect(x, y, sizex, sizey);
		float textsize = Main.min(textsizex, textsizey);

		main.textSize(textsize);
		main.fill(textcolor);
		main.text(text, x, y/*);//*/, sizex, sizey);
		main.popStyle();
	}

}
