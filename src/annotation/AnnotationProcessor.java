package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import clickers.Button;
import main.Main;
import rect.Rect;

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
					} else if(f.isAnnotationPresent(AddMovable.class)) {
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
		@SuppressWarnings("rawtypes")
		private void loadFlexible(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
			if(Button.class.isAssignableFrom(f.getType())) main.registerFlexibleClicker((Button)f.get(o));
			else if(Rect.class.isAssignableFrom(f.getType())) main.registerFlexibleRect((Rect)f.get(o));
		}
		@SuppressWarnings("rawtypes")
		private void loadFixed(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
			if(Button.class.isAssignableFrom(f.getType())) main.registerFixedClicker((Button)f.get(o));
			else if(Rect.class.isAssignableFrom(f.getType())) main.registerFixedRect((Rect)f.get(o));
	
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
