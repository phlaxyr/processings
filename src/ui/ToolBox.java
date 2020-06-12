package ui;

import java.util.ArrayList;
import java.util.List;

import clickers.TextButton;
import main.Ap;
import processing.event.MouseEvent;


public class ToolBox {
	public TextButton a;
	public TextButton b;
	public TextButton activeTool;
	public List<TextButton> tools = new ArrayList<>();
	{
		a = new TextButton(0, 400, 100, 50, "Create Node");
		b = new TextButton(100, 400, 100, 50, "Select Tool");
//			@Override
//			public void onDepress() {
//				super.onDepress();
//				Ap.p.stm.select(null);
//			}
		
		tools.add(a);
		tools.add(b);
	}
	public void draw(){
		Ap.p.pushStyle();

		Ap.p.fill(255);
//		nodeCreate.draw(flatdc);
//		select.draw(flatdc);
		for(TextButton b : tools) {
			b.draw();
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
		for(TextButton b : tools) {
			boolean wasPressed = b.isPressed();
			if(b.isPointWithin(e.getX(), e.getY())) {
				b.onClick(e);
				activeTool = wasPressed ? null : b;
				
			} else b.onClickOutside(e);
//			if(b.buttonClicked(x, y)) { 
				

//				break;
			
 
		}

		
	}
	
	public boolean isActive(TextButton b) {
		return b.equals(activeTool);
	}
//	public void mouseReleased() {
////		nodeCreate.mouseReleased();
////		select.mouseReleased();
//
//	}
	
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
