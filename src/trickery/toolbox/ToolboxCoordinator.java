package trickery.toolbox;

import java.util.List;

import annotation.Peek;
import main.Main;
import trickery.element.Element;
import trickery.element.PostConstructorT;

public class ToolboxCoordinator extends Element{
	public List<Element> tbbuttons;
	public ToolboxCoordinator(List<Element> tbbuttons, PostConstructorT<ToolboxCoordinator> postconstr) {
		super(0, 900, 1000, 70, null);
		this.tbbuttons = tbbuttons;
		// use outer class as variable dump
		this.onclick = (self2, e, isClick, in) -> {
			if(in && isClick) {
				for(Element ele : this.tbbuttons) {
					if(ele.isPointWithin(e.getX(), e.getY())) {
						// since we're fixed we can do this directly
						// ele.func(key)
						ToolboxSubimpl i = ele.cast(ToolboxSubimpl.class);
						i.onTBMouse(i, this, e);
					}
				}
			}
		};

		this.postconstrTB(postconstr);
	}
	
	
	
	public void tbAddButton(Element ele) {
		// registration, although it happens before setting coords, is irrelevant
		// Registration is only relevant for the onclick method TODO: address this
		int tbidx = this.tbbuttons.size();
		ele.x = this.x + 5 + tbidx * 70;
		ele.y = this.y + 5;
		ele.lenx = 70;
		ele.leny = 30;
		ele.installSubimpl(new ToolboxSubimpl(ele.text));
		this.tbbuttons.add(ele);
	}
	
	
	// postconstr boilerplate
	@Override
	protected void postconstr(PostConstructorT<? super Element> constr) {
		this.postconstrTB(constr); // weird generics thing with postconstructors
	}
	protected void postconstrTB(PostConstructorT<? super ToolboxCoordinator> constr) {
		if(constr != null) {
			constr.constr(this);
			// this.onsetup();
			if(register) Main.main.register(this);
			// this.onsetup();
		}
	}
	
	public String activemode = "n";
	protected void setActiveMode(String id) {
		this.activemode = id;
		System.out.print(id);
	}
	

	
}
