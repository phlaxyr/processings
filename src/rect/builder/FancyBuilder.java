package rect.builder;

import clickers.FancyButton;
import rect.IBuilder;

public class FancyBuilder extends Builder implements IBuilder<FancyButton, FancyRect> {

	public FancyBuilder() {
	}
	public FancyBuilder(int x, int y, int sizex, int sizey) {
		this.pos(x, y).size(sizex, sizey);
	}
	@Override
	public FancyBuilder pos(int x, int y) {
		return (FancyBuilder) super.pos(x, y);
	}
	@Override
	public FancyBuilder pos(float x, float y) {
		return (FancyBuilder) super.pos(x, y);
	}
	@Override
	public FancyBuilder size(int x, int y) {
		return (FancyBuilder) super.size(x, y);
	}
	@Override
	public FancyBuilder size(float x, float y) {
		return (FancyBuilder) super.size(x, y);
	}


	@Override
	public FancyRect buildRect() {
		return new FancyRect(this);
	}
	@Override
	public FancyButton buildButton() {
		return new FancyButton(this.buildRect());
	}
	
	@Override
	public FancyBuilder fill(int fill) {
		return (FancyBuilder) super.fill(fill);
	}
	@Override
	public FancyBuilder stroke(int fill) {
		return (FancyBuilder) super.stroke(fill);
	}	@Override
	public FancyBuilder selectedFill(int fill) {
		return (FancyBuilder) super.selectedFill(fill);
	}
	
}