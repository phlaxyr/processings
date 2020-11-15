package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import clickers.AbstractButton;
import clickers.IClickable;
import main.Main;
import shape.Rect;
import trickery.ISetupable;

public class AnnotationProcessor {
	public static Main main;
	List<ClassHandler> parts = new ArrayList<ClassHandler>();
	public AnnotationProcessor addClass(Object o) {
		parts.add(new ClassHandler(o));
		return this;
	}
	public void run() {
		for (ClassHandler part : parts) {
			part.run();
		}
	}
	
	
	public static class ClassHandler {

		
		public List<Field> peeks = new ArrayList<>();
		public List<Field> ats = new ArrayList<>();
		public float[] xs, ys;
		public int[] textsize;
		Object o;
		Class<?> c;
		public ClassHandler(Object o) {
			this.o = o;
			this.c = o.getClass();
			Field[] fs = c.getDeclaredFields();
			try {
				for(Field f : fs) {
					
					if(f.isAnnotationPresent(Peek.class)) {
						this.peeks.add(f);
					}
					if(f.isAnnotationPresent(Setup.class)) {
						this.loadSetupable(f, o);
					}
					if(f.isAnnotationPresent(AddMovable.class)) {
						loadFlexible(f, o);
					} else if(f.isAnnotationPresent(AddFixed.class)) {
						loadFixed(f, o);
					} else if(f.isAnnotationPresent(Add.class)) {
						if(f.getAnnotation(Add.class).isFixed()) {
							loadFixed(f, o);
						} else {
							loadFlexible(f, o);
						}
					}
					if(f.isAnnotationPresent(At.class)) {
						this.ats.add(f);
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			xs = new float[peeks.size()];
			ys = new float[peeks.size()];
			textsize = new int[peeks.size()];
			int i=0;
			for(Field f : peeks) {
				Peek an = f.getAnnotation(Peek.class);
				xs[i] = an.x();
				ys[i] = an.y();
				textsize[i] = an.textsize();
				i++;
				
			}
		}
		private void loadFlexible(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
//			if(ITangible.class.isAssignableFrom(f.getType())) {
//				ITangible tang = (ITangible)f.get(o);
//				
//				return;
//			}

			load(f, o, false);
		}
		private void loadFixed(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
			load(f, o, true);
	
		}
		private void load(Field f, Object o, boolean isFixed) throws IllegalArgumentException, IllegalAccessException {

			if(AbstractButton.class.isAssignableFrom(f.getType())) {
				main.registerButton((AbstractButton)f.get(o), isFixed);
			} else {
				if(Rect.class.isAssignableFrom(f.getType())) {
					main.registerRect((Rect)f.get(o), isFixed);
				}
				if(IClickable.class.isAssignableFrom(f.getType())) {
					main.registerClickable((IClickable)f.get(o), isFixed);
				}
			}

		}

		private void loadSetupable(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
			if(ISetupable.class.isAssignableFrom(f.getType())) {
				main.registerSetupable((ISetupable) f.get(o));
			}
		}
		
		public void run() { 
			int i=0;
			try {
				main.pushStyle();
				main.fill(100);
				for(Field f : peeks) {
	
					main.textSize(textsize[i]);
					String txt = f.get(o).toString();
					main.text(txt, xs[i], ys[i]);
					i++;
	
				}
				main.popStyle();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				
			}
		}
	}
}
