package rect;

import clickers.AbstractButton;
import clickers.FancyButton;
import clickers.SimpleButton;
import clickers.TextButton;
import clickers.responsive.InteResponsiveButton;
import clickers.responsive.InteResponsiveTextButton;
import clickers.responsive.ResponsiveButton;
import clickers.responsive.ResponsiveRect;
import clickers.responsive.ResponsiveTextButton;
import clickers.responsive.ResponsiveTextbox;

public class New implements IFancinessCustomizable<New>{
	
	public New() {}
	public New(int x, int y, int sizex, int sizey) {
		this.of(x, y, sizex, sizey);
	}
	public static New Builder() {
		return new New();
	}
	public static BuildNewFancy Fancy() {
		return new BuildNewFancy();
	}
	public static BuildNewText Text() {
		return new BuildNewText();
	}
	public static BuildNewResponsive Responsive() {
		return new BuildNewResponsive();
	}
	public static BuildNewResponsiveText ResponsiveText() {
		return new BuildNewResponsiveText();
	}

	// the overloaded methods
	public Rect Rect() {
		return new Rect(x, y, sizex, sizey);
	}
	public AbstractButton<?> Button() {
		return new SimpleButton(this.Rect());
	}
	
	
	public FancyRect FancyRect() {
		return new FancyRect(this);
	}
	public FancyButton FancyButton() {
		return new FancyButton(this.FancyRect());
	}
	public Textbox Textbox() {
		Textbox t = new Textbox(x, y, sizex, sizey, str);
		New.match(t, this);
		return t; 
	}
	public TextButton TextButton() {
		return new TextButton(this.Textbox());
	}
	public ResponsiveButton ResponsiveButton() {
		return new ResponsiveButton(this.ResponsiveRect());
	}
	public ResponsiveRect ResponsiveRect() {
		ResponsiveRect r = new ResponsiveRect(x, y, sizex, sizey);
		New.match(r, this);
		return r;
	}
	public InteResponsiveButton InteResponsiveButton() {
		InteResponsiveButton r = new InteResponsiveButton(x, y, sizex, sizey);
		New.match(r, this);
		return r;
	}
	
	public ResponsiveTextButton ResponsiveTextButton() {
		return new ResponsiveTextButton(this.ResponsiveTextbox());
	}
	public ResponsiveTextbox ResponsiveTextbox() {
		if(str == null) str = "";
		ResponsiveTextbox r = new ResponsiveTextbox(x, y, sizex, sizey, str);
		match(r, this);
//		System.out.print("HI!");
		return r;
	}
	
	public InteResponsiveTextButton InteResponsiveTextButton() {
		InteResponsiveTextButton r = new InteResponsiveTextButton(x, y, sizex, sizey, str);
		match(r, this);
		return r;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param sizex
	 * @param sizey
	 * @return
	 */
	public New of(int x, int y, int sizex, int sizey) {
		return this.pos(x, y).size(sizex, sizey);
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
	public New fill(int fill) {
		this.fill_flag = true;
		this.fill = fill;
		return this;
	}
	protected int stroke;
	protected boolean stroke_flag = false;
	public New stroke(int stroke) {
		this.stroke_flag = true;
		this.stroke = stroke;
		return this;
	}
	
	protected boolean f2flag = false;
	protected int select_fill;
	public New selectedFill(int fill) { 
		f2flag = true;
		this.select_fill = fill;
		return this;
	}
	protected boolean s2flag = false;
	protected int selectstroke;
	public New selectedStroke(int stroke) { 
		s2flag = true;
		this.selectstroke = stroke;
		return this;
	}

	
	String str;
	/**
	 * For Textbox
	 * @param str
	 * @return
	 */
	public New text(String str) {
		this.str = str;
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
		r.selectstroke = b.selectstroke;
		r.s2flag = b.s2flag;
	}
	public static class BuildNewResponsive extends New {
		@Override
		public ResponsiveRect Rect() {
			return super.ResponsiveRect();
		}
		@Override
		public ResponsiveButton Button() {
			return super.ResponsiveButton();
		}
		
	}
	public static class BuildNewResponsiveText extends New {
		@Override
		public ResponsiveTextbox Rect() {
			return super.ResponsiveTextbox();
		}
		@Override
		public ResponsiveTextButton Button() {
			return super.ResponsiveTextButton();
		}
		
	}
	public static class BuildNewFancy extends New {
		@Override
		public FancyRect Rect() {
			return super.FancyRect();
		}
		@Override
		public FancyButton Button() {
			return super.FancyButton();
		}
	}
	public static class BuildNewText extends New {
		@Override
		public FancyRect Rect() {
			return super.Textbox();
		}
		@Override
		public AbstractButton<?> Button() {
			return super.TextButton();
		}
	}
}
