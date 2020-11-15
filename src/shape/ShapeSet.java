package shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import clickers.IClickable;
import mouse.MovableMouseEvent;
import processing.event.MouseEvent;
import trickery.IDrawHandler;
import trickery.element.Element;

public class ShapeSet {
	public List<IDrawn> rectsmovable = new ArrayList<>();
	public List<IClickable> clickersmovable = new ArrayList<>();
	public List<IDrawn> rects = new ArrayList<>();
	public List<IClickable> clickers = new ArrayList<>();
	public List<IDrawHandler> soledrawables = new ArrayList<>();
	public List<IDrawHandler> soledrawablesmovable = new ArrayList<>();
	
	public List<Element> elements = new ArrayList<>();
	public List<Element> elementsonclick = new ArrayList<>();
	
	public List<Element> z_index = new ArrayList<>();
	public int z_index_partition;
	public void setup() {
		// draw elements according to z_index
		List<Element> z_index = new ArrayList<>(elements);
		
		Collections.sort(z_index, (a, b) -> Float.compare(a.z_index, b.z_index));
		
        List<List<Element>> lists = new ArrayList<>(
        			z_index.stream() 
                    .collect(Collectors.partitioningBy(s -> s.z_index > 0)) 
                    .values()); 
        Element.assertt(lists.size() == 2);
        
        this.z_index = z_index;
        this.z_index_partition = lists.get(0).size();
		
	}
	
	public void drawMovable() {

		for(int i=0;i<z_index_partition;i++) {
			Element e = z_index.get(i);
			if(!e.registerfixed) e.draw();

		}
		
		for (IDrawn rect : rectsmovable) {
			rect.draw();
		}
		for(IDrawHandler drawns : soledrawablesmovable) {
			drawns.draw();
		}
		for(int i=z_index_partition;i<z_index.size();i++) {
			Element e = z_index.get(i);
			if(!e.registerfixed) e.draw();
		}

	}
	public void drawFixed() {
		for(int i=0;i<z_index_partition;i++) {
			Element e = z_index.get(i);
			if(e.registerfixed) e.draw();
		}
		
		for (IDrawn rect : rects) {
			rect.draw();
		}
		for(IDrawHandler drawns : soledrawables) {	
			drawns.draw();
		}
		
		for(int i=z_index_partition;i<z_index.size();i++) {
			Element e = z_index.get(i);
			if(e.registerfixed) e.draw();
		}
	}
	public IClickable getOneFixedUnder(MouseEvent e) {
		for (IClickable rect : clickers) {
			float x = e.getX();
			float y = e.getY();
			if(rect.getShape().isPointWithin(x, y)) {
				return rect;
			}

		}
		return null;
	}
	public IClickable getOneMovableUnder(MovableMouseEvent e) {
		for (IClickable rect : clickersmovable) {
			
			if(rect.getShape().isPointWithin(e.coordX, e.coordY)) {
				return rect;
			}
		}
		return null;
	}

}
