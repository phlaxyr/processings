package trickery.element;

import java.awt.List;
import java.util.ArrayList;

public class ElementList<T extends IElementSubimpl> extends ArrayList<Element> {
	public ArrayList<Element> wrapper;
	public ElementList() {
		this(new ArrayList<>());
	}
	public ElementList(ArrayList<Element> elist) {
		this.wrapper = elist;
	}
	
}
