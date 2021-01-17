package trickery.toolbox;

import processing.event.MouseEvent;
import trickery.element.Element;
import trickery.element.IElementSubimpl;

public class ToolboxSubimpl implements IElementSubimpl{
	String id;
	public ToolboxSubimpl(String id) {
		this.id = id;
	}
	public void onTBMouse(ToolboxSubimpl self, ToolboxCoordinator manager, MouseEvent e) { 
		manager.setActiveMode(self.id);
	}
	private Element e;
	@Override
	public void __finish_initialization__(Element e) {
		this.e = e;
	}
	@Override
	public void __do_overrides__(Element parent) {
		parent.text = id;
	}

}
