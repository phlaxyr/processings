package trickery.element;

import java.util.HashMap;

import main.Main;
import processing.event.MouseEvent;
import trickery.element.subimpl.SuperimplPolicy;

/**
 * Creates an all-purpose element.
 * 
 * <br>
 * Primarily uses lambdas and function handlers 
 * in an imitation of python's and js's treatment of functions
 * instead of inheritance.
 * <br>
 * ie. instead of overriding draw(), set draw to a new handler/lambda
 * <br>
 * ie. draw = (self) -> System.out.println("hi");
 * <br>
 * self.super_ contains the default, unmodified implementations of methods
 * that might be of use when "overriding" functions
 * <br>
 * ie. draw = (self) -> {
 * System.out.println("hi");
 * self.super_.draw();
 * }
 * <br>
 * self.super_ also contains default implementations of possible
 * "subclasses"; ie. self.super_.button
 * <br>
 * <b>Do NOT extend Element, unless you know what you're doing. 
 * For instance, see the tricky postconstr() handling.</b>
 * @author phlaxyr
 *
 */
public class Element {//extends DeepDictionary{
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
	protected void postconstr(PostConstructorT<? super Element> constr) {
		if(constr != null) {
			constr.constr(this);
			// this.onsetup();
			if(register) Main.main.register(this);
			// this.onsetup();
		}
		 // auto-register
	}
	public Element(PostConstructor constr) {
		this.postconstr(constr);
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
	
	private HashMap<Class<? extends IElementSubimpl>, IElementSubimpl> submap = new HashMap<>();
	protected HashMap<Class<? extends IElementSubimpl>, IElementSubimpl> __get_submap_internal__() {
		return submap;
	}

	public <V extends IElementSubimpl> void installSubimpl(V sub) {
		sub.__finish_initialization__(this);
		submap.put(sub.getClass(), sub);
//		sub.__declare_superimpl__(parent);
		SuperimplPolicy sups = sub.__get_superimpl__(this);
		for(Class<? extends IElementSubimpl> c : sups.toBeInstalled()) {
			if (!submap.containsKey(c)) {
				submap.put(c, sub);
			} else {
				throw new IllegalArgumentException("SuperimplPolicy is mishandled; duplicate " + c);
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public <V extends IElementSubimpl> V sub(V instance) {
		return (V) getSubimpl(instance.getClass());
	}
	@SuppressWarnings("unchecked")
	public <V extends IElementSubimpl> V getSubimpl(Class<V> clazz) {
		return (V) submap.get(clazz);
	}
	
	public <V extends IElementSubimpl> V cast(Class<V> subclass) {
		return getSubimpl(subclass);
	}
	public <V extends IElementSubimpl> V cast(Class<V> subclass, V returnOnError) {
		if (submap.containsKey(subclass)) {
			return getSubimpl(subclass);
		} else {
			return returnOnError;
		}
	}
	
	/*
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
	
	private HashMap<String, Object> funcstrmap;
	@SuppressWarnings("unchecked")
	public <F> F func(String key) {
		return (F) funcstrmap.get(key);
	}
	public <F> void addFunc(String sub, F func) {
		funcstrmap.put(sub, func);
	}
	

	
	private HashMap<String, Class<?>> storetypes;
	private HashMap<String, Object> stores;
	/**
	 * Use this as one way to extend Element
	 * ie. put("isEnergetic", Boolean.TRUE);
	 *//*
	public <T> void put(String key, T value) {
		storetypes.put(key, value.getClass());
		stores.put(key, value);
	}
	/**
	 * Use this as one way to extend Element
	 * ie. see put() above
	 * ie. get("isEnergetic", Boolean.class);
	 *//*
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
	}*/
	
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
	public int fill = 0xFFFFFFFF;
	public int unselected_fill = fill;
	public int selected_fill = fill;
	public int pressed_fill = fill;
	public int stroke = 0xFF000000;
	
	public int textcolor = 0xFF000000;
	
	public float z_index = 0;
	
	
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
	
	public boolean isMovable = false;
	/**
	 * Convenience variable with no functionality whatsoever
	 * 
	 */
	public boolean isSelected = false;
	/**
	 * Convenience variable with no functionality whatsoever
	 * 
	 */
	public boolean isPressed = false;
	
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
	

	
	// public Super Super = new Super();

	// Imitate Python/JS's Properties
	// Imitate the super keyword

	
	/**
	 * Contains copies of original lambda functions, ie. draw, onclick, etc. that work and are callable
	 */
	public final SuperWrapper super_ = new SuperWrapper(this);
	
	public SetupHandler onsetup = super_.onsetup;
	/**
	 * To override, modify the clickhandler object
	 * ie. self.onsetup = (self) -> self.unregister();
	 */
	public final void onsetup() {
		onsetup.onsetup(this);
	}
	
	public ClickHandler onclick = super_.onclick;
	/**
	 * To override, modify the clickhandler object
	 * ie. self.onclick = (self, e, is, in) -> {System.out.println("mouse")};
	 */
	public final void onclick(MouseEvent e, boolean isClick, boolean isInside) {
		onclick.onclick(this, e, isClick, isInside);
	}
	

	public DrawHandler draw = super_.draw;
	/**
	 * To override, modify the drawhandler object
	 * ie. self.draw = (self) -> {System.out.println("draw")};
	 */
	public final void draw() {
		draw.draw(this);
	}
	
	public DrawHandler customize = super_.customize;
	public final void customize() {
		customize.draw(this);
	}
	
	public static void assertt(boolean value) { 
		if(!value) {
			throw new AssertionError(value);
		}
	}
	
	public boolean register = true;
	public void unregister() {
		register = false;
	}

	
	
}
