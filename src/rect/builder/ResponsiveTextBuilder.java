package rect.builder;

import clickers.responsive.InteResponsiveTextButton;
import clickers.responsive.ResponsiveTextButton;
import clickers.responsive.ResponsiveTextbox;
import rect.IBuilder;

public class ResponsiveTextBuilder extends Builder implements IBuilder<ResponsiveTextButton<ResponsiveTextbox>, ResponsiveTextbox>{


	@Override
	public ResponsiveTextBuilder pos(int x, int y) {
		return (ResponsiveTextBuilder) super.pos(x, y);
	}
	@Override
	public ResponsiveTextBuilder pos(float x, float y) {
		return (ResponsiveTextBuilder) super.pos(x, y);
	}
	@Override
	public ResponsiveTextBuilder size(int x, int y) {
		return (ResponsiveTextBuilder) super.size(x, y);
	}
	@Override
	public ResponsiveTextBuilder size(float x, float y) {
		return (ResponsiveTextBuilder) super.size(x, y);
	}
	String str;
	public ResponsiveTextBuilder text(String str) {
		this.str = str;
		return this;
	}
	
	@Override
	public ResponsiveTextButton<ResponsiveTextbox> buildButton() {
		return new ResponsiveTextButton<ResponsiveTextbox>(this.buildRect());
	}
	@Override
	public ResponsiveTextbox buildRect() {
		if(str == null) str = "";
		ResponsiveTextbox r = new ResponsiveTextbox(x, y, sizex, sizey, str);
		match(r, this);
		System.out.print("HI!");
		return r;
	}
	
	public InteResponsiveTextButton buildInteButton() {
		InteResponsiveTextButton r = new InteResponsiveTextButton(x, y, sizex, sizey, str);
		match(r, this);
		return r;
	}

	@Override
	public ResponsiveTextBuilder fill(int fill) {
		return (ResponsiveTextBuilder) super.fill(fill);
	}
	@Override
	public ResponsiveTextBuilder stroke(int fill) {
		return (ResponsiveTextBuilder) super.stroke(fill);
	}
	@Override
	public ResponsiveTextBuilder selectedFill(int fill) {
		return (ResponsiveTextBuilder) super.selectedFill(fill);
	}

}
