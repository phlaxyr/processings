package rect.builder;

import clickers.responsive.InteResponsiveButton;
import clickers.responsive.ResponsiveButton;
import clickers.responsive.ResponsiveRect;

public class ResponsiveBuilder extends New implements IBuilder<ResponsiveButton, ResponsiveRect>{

	public ResponsiveBuilder() {
	}
	public ResponsiveBuilder(int x, int y, int sizex, int sizey) {
		this.pos(x, y).size(sizex, sizey);
	}
	@Override
	public ResponsiveBuilder pos(int x, int y) {
		return (ResponsiveBuilder) super.pos(x, y);
	}
	@Override
	public ResponsiveBuilder pos(float x, float y) {
		return (ResponsiveBuilder) super.pos(x, y);
	}
	@Override
	public ResponsiveBuilder size(int x, int y) {
		return (ResponsiveBuilder) super.size(x, y);
	}
	@Override
	public ResponsiveBuilder size(float x, float y) {
		return (ResponsiveBuilder) super.size(x, y);
	}
	
	@Override
	public ResponsiveButton buildButton() {
		return new ResponsiveButton(this.buildRect());
	}
	@Override
	public ResponsiveRect buildRect() {
		ResponsiveRect r = new ResponsiveRect(x, y, sizex, sizey);
		New.match(r, this);
		return r;
	}
	
	public InteResponsiveButton buildInteButton() {
		InteResponsiveButton r = new InteResponsiveButton(x, y, sizex, sizey);
		New.match(r, this);
		return r;
	}
	
	@Override
	public ResponsiveBuilder fill(int fill) {
		return (ResponsiveBuilder) super.fill(fill);
	}
	@Override
	public ResponsiveBuilder stroke(int fill) {
		return (ResponsiveBuilder) super.stroke(fill);
	}	@Override
	public ResponsiveBuilder selectedFill(int fill) {
		return (ResponsiveBuilder) super.selectedFill(fill);
	}


}
