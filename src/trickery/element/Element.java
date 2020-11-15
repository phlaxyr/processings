package trickery.element;

import java.util.HashMap;

import main.Main;
import processing.event.MouseEvent;

public class Element {
	/**
	 * Should be run after all super() calls and all subclass super() calls;
	 * Should be ran exactly once.
	 * 
	 * If you're a subclass, do this by passing null to the superclass postconstr object
	 * ie. If FancyElement extends Element,
	 * the constructor would call
	 * super(x, y, lenx, leny, null); // passing null to the postconstr
	 * @param constr
	 */
	private void postconstr(PostConstructor constr) {
		if(constr != null) {
			constr.constr(this);
			// this.onsetup();
			if(register) Main.main.register(this);
			
		}
		 // auto-register
	}

	public Element(int x, int y, PostConstructor constr) {
		this.x = x;
		this.y = y;
		this.postconstr(constr);
	}
	public Element(int x, int y, int lenx, int leny, PostConstructor constr) {
		this(x, y, null);
		this.lenx = lenx;
		this.leny = leny;
		this.postconstr(constr);
	}
	
	private HashMap<Class<? extends Object>, Object> submap;
	@SuppressWarnings("unchecked")
	public <V> V sub(V key) {
		return (V) submap.get(key.getClass());
	}
	@SuppressWarnings("unchecked")
	public <V> V sub(Class<V> clazz) {
		return (V) submap.get(clazz.getClass());
	}
	public <V> void addSub(V sub) {
		submap.put(sub.getClass(), sub);
	}
	
	private HashMap<Class<? extends Object>, Object> funcmap;
	@SuppressWarnings("unchecked")
	public <F> F func(F key) {
		return (F) funcmap.get(key.getClass());
	}
	@SuppressWarnings("unchecked")
	public <F> F func(Class<F> clazz) {
		return (F) funcmap.get(clazz.getClass());
	}
	public <F> void addFunc(F sub) {
		funcmap.put(sub.getClass(), sub);
	}
	
	private HashMap<String, Class<?>> storetypes;
	private HashMap<String, Object> stores;
	public <T> void store(String key, T value) {
		storetypes.put(key, value.getClass());
		stores.put(key, value);
	}
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> type) {
		Class<?> c = storetypes.get(key);
		
		if(c == null) {
			// type is not found in storetypes
			assertt(stores.get(key) == null);
			return null;
		}
		
		if(c.equals(type)) {
			return (T) stores.get(key);
		} 
		throw new AssertionError("Stored class " + c + "for " + key + " doesn't match " + type);
	}
	
	// BUILT-INS
	public int x;
	public int y;
	public Element at(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	public int x() {
		return x;
	}
	public int y() {
	 	return y;
	}
	public int lenx = 10;
	public int leny = 10;
	public int lenx() {
		return lenx;
	}
	public int leny() {
		return leny;
	}
	public Element len(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	public Integer fill = null;
	public Integer stroke = null;
	
	
	
	public String text = null;
	public Float textsize = null;
	public void autoTextSize() {
		Main main = Main.main;
		main.pushStyle();
		main.textSize(100);
//		textsizex = sizex * 100 / main.textWidth(text);
//		textsizey = sizey * 100 / (main.textAscent() + main.textDescent());
		// approx area. the constant is just 2. it just seems to work, there is no rationale
		float textarea = 2 * main.textWidth(text) * (main.textAscent() + main.textDescent());
		float boxarea = this.lenx * this.leny;
		float scaleby = (float) Math.sqrt(boxarea / textarea); 
//		main.erase(x, y - sizey, sizex, sizey);

//		float textsize = Main.min(textsizex, textsizey);
		textsize = 100 * scaleby;
		main.popStyle();
	}
	
	/**
	 * inclusize exclusive
	 */
	public boolean isPointWithin(int x, int y) {
		return this.x <= x && x < this.x + lenx && this.y <= y && y < this.y + leny;	
	}
	/**
	 * inclusize exclusive
	 */
	public boolean isPointWithin(float x, float y) {
		return this.x <= x && x < this.x + lenx && this.y <= y && y < this.y + leny;
	}
	
	public boolean registerfixed = true;
	
	public SetupHandler onsetup = (self) -> {
		if(text != null && textsize == null) this.autoTextSize();
	};
	public void onsetup() {
		onsetup.onsetup(this);
	}
	
	// Imitate Python/JS's Properties
	public ClickHandler onclick = ClickHandler.NONE;
	public void onclick(MouseEvent e, boolean isClick, boolean isInside) {
		onclick.onclick(this, e, isClick, isInside);
	}
	
	public DrawHandler draw = (self) -> {

		// System.out.print("draw");
		Main.main.pushStyle();
		Main main = Main.main;
		if(fill != null) {
			main.fill(fill);
		}
		if(stroke != null) {
			main.stroke(stroke);
		}
		main.rect(x, y, lenx, leny);
		if(text != null) {
			main.text(text, x+5, y+5);
		}
		/*
		if(hasText) {
			if(textsize == 0.0) {
				throw new NullPointerException("textsize 0.0. onSetup() was not called");
			} else {
				main.textSize(tex0
				tsize);
			}
			main.fill(textcolor);
			main.text(text, x+5, y+5/*);//*//*, sizex, sizey);
		}*/

		
		main.popStyle();
		
	};
			//DrawHandler.NONE;
	public void draw() {
		draw.draw(this);
	}
	
	public void assertt(boolean value) { 
		if(!value) {
			throw new AssertionError(value);
		}
	}
	
	public boolean register = true;
	public void unregister() {
		register = false;
	}

	
	
}
