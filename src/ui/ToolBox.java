package ui;

import java.util.ArrayList;
import java.util.List;

import clickers.IClickable;
import main.Ap;
import processing.event.MouseEvent;
import rect.builder.FancyRect;


/**
 * @author phlaxyr
 *
 */
public class Toolbox extends FancyRect implements IClickable<Toolbox>{
	public Toolbox(int x, int y, int sizex, int sizey) {
 		super(x, y, sizex, sizey);
	}

	public ToolboxButton a, b, c;
	public ToolboxButton activeTool;
	public List<ToolboxButton> tools = new ArrayList<>();
	protected int buttonXSize = 100;
	protected int buttonYSize = 50;
	protected int buttonXMargin = 10;
	protected int buttonYMargin = 10;
	protected int defaultSelectedFill = 0xFF00C8C8;
	protected int defaultTextSize = 15;
	protected int counter =0 ;
	{
//		a = new ToolboxButton(x + 10, y + 10, 100, 50, "Create Node", this);
//		a.selectedFill(0xFF00C8C8);
		a = this.autoAddButton("Create Node");
		b = this.autoAddButton("Select Tool");
		c = this.autoAddButton("Move Tool");
//			@Override
//			public void onDepress() {
//				super.onDepress();
//				Ap.p.stm.select(null);
//			}
		System.out.print("");
		
	}
	

	public ToolboxButton autoAddButton(String str) {
		ToolboxButton b = new ToolboxButton(
				x+buttonXMargin + counter * (buttonXSize + buttonXMargin), 
				y+buttonYMargin, 
				buttonXSize,
				buttonYSize, 
				str, 
				this);
//		b.setTextSize(10);
		b.selectedFill(defaultSelectedFill).setTextSize(defaultTextSize).selectedStroke(0xFFFF0000);
		counter++;
		tools.add(b);
		return b;
	}
	
	@Override
	public void onSetup() {
//		a.onSetup();
//		a.rect.onSetup();
//		b.onSetup();
//		b.rect.onSetup();
		for(ToolboxButton b : tools) {
			b.onSetup();
			b.getShape().onSetup();
		}
	}
	public void draw(){
		super.draw();
		Ap.p.pushStyle();

		Ap.p.fill(255);
//		nodeCreate.draw(flatdc);
//		select.draw(flatdc);
		for(ToolboxButton b : tools) {
			b.draw();
//			System.out.print(b.text);
		}
		Ap.p.popStyle();
	}
	
	


	/**
	 * draw standard
	 * @param x
	 * @param y
	 */
	public void onClick(MouseEvent e) {

//		Util.println(x, y);
//		System.out.println(nodeCreate.isWithinBounds(x, y, flatdc));
//		isPressed = true;
//		if(nodeCreate.onMousePress(x, y, flatdc)) {
//			
//			activeTool = nodeCreate;
//			
//			select.setUnpressed();
//		} else if(select.onMousePress(x, y, flatdc)) {
//			
//			activeTool = select;
//			
//			nodeCreate.setUnpressed();
//		}
		System.out.print("CLICK!");
		for(ToolboxButton b : tools) {
			boolean wasPressed = b.isSelected();
			if(b.isPointWithin(e.getX(), e.getY())) {
				b.onClick(e);
				activeTool = wasPressed ? null : b;
				
			} else b.onClickOutside(e);
//			if(b.buttonClicked(x, y)) { 
				

//				break;
			
 
		}

		
	}
	
	public boolean isActive(ToolboxButton b) {
		return b.equals(activeTool);
	}
//	public void mouseReleased() {
////		nodeCreate.mouseReleased();
////		select.mouseReleased();
//
//	}




	@Override
	public void onClickOutside(MouseEvent e) {		
	}




	@Override
	public Toolbox getShape() {
		return this;
	}
	
//	/**
//	 * Depends on rectmode
//	 * @param x
//	 * @param y
//	 * @param a
//	 * @param b
//	 */
//	public void button1(float x, float y, float a, float b, String text) {
//		Main p = Ap.p();
//		p.rect(x, y, a, b);
//		int rmode = p.g.rectMode;
//		float cx = x; // center
//		float cy = y;
//		if(rmode == PConstants.CORNER) {
//			cx = x + a/2;
//			cy = y + b/2;
//		} else if(rmode == PConstants.CORNERS) {
//			cx = (x + a) / 2;
//			cy = (y + b) / 2; // average (midpoint) of 2 points
//		} // else if(rmode == PConstants.CENTER || rmode == PConstants.RADIUS) {
//		
//		p.pushStyle();
//		
//			p.fill(0);
//			p.textSize(10);
//			p.textAlign(PConstants.CENTER, PConstants.CENTER);
//			p.text(text, cx, cy);
//
//		p.popStyle();
//	}

}
