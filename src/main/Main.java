package main;

import java.util.ArrayList;
import java.util.List;

import annotation.AddFixed;
import annotation.AnnotationProcessor;
import annotation.Peek;
import clickers.AbstractButton;
import clickers.FancyButton;
import clickers.IClickable;
import clickers.responsive.InteResponsiveButton;
import clickers.responsive.InteResponsiveTextButton;
import clickers.responsive.ResponsiveButton;
import clickers.responsive.ResponsiveTextButton;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PMatrix;
import processing.event.MouseEvent;
import rect.Rect;
import rect.Textbox;
import rect.builder.Builder;
import rect.builder.FancyRect;

public class Main extends PApplet{

	public static Main main;
	public static PGraphics pgraphics;
	
	{
		System.out.println("INIT BLOCK!");
		Main.main = this;
		Rect.main = this;
		Transform.main = this;
		AnnotationProcessor.main = this;
		Ap.p = this;
		pgraphics = new PGraphics();
	}

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	@Override
	public void settings() {
		this.size(1000, 1000);

		annotation = new AnnotationProcessor().addClass(this).addClass(tb);

	}

	
	@Peek(x=10,y=900)
	public boolean clickedin;
	@AddFixed
	public Textbox tb = new Textbox(50,50,200,200,"The quick brown fox jumps over the lazy dog");//.autoTextSize();
	@AddFixed
	public ResponsiveButton rb = Builder.Responsive().pos(35,300).size(50,50).selectedFill(0xFF303000).fill(0xFF666600).buildButton();
	@AddFixed
	public InteResponsiveButton rb2 = Builder.Responsive().pos(35,360).size(50,50).selectedFill(0xFF303000).fill(0xFF666600).buildInteButton();
	@AddFixed
	public ResponsiveTextButton t1 = Builder.ResponsiveText().pos(95,300).size(50,50).text("test1").selectedFill(0xFF303000).fill(0xFF666600).buildButton();
	@AddFixed
	public InteResponsiveTextButton t2 = Builder.ResponsiveText().pos(95,360).size(50,50).text("test2").selectedFill(0xFF303000).fill(0xFF666600).buildInteButton();
	
	public FancyButton buton1 = new FancyButton(new FancyRect(100,100,16,16).fill(0xFFFF0000)) {
		@Override
		public void onClick(MouseEvent e) {
			clickedin = true;
		}
		public void onClickOutside(MouseEvent e) {
			clickedin = false;
		};
	};
	PMatrix randMtx;
	@Override
	public void setup() {
		System.out.println("SETUP!");
		super.setup();
		this.surface.setResizable(true);
		background(0x00FFFFFF); 
		main.registerMethod("mouseEvent", this);
		rectsmovable.add(buton1.rect);
		clickersmovable.add(buton1);
		registerMovableButton(new FancyButton(100,200,16,16)).rect().fill(0xFF00FF00);
		registerMovableButton(new FancyButton(new FancyRect(200,100,16,16).fill(0xFF0000FF)));
		registerMovableButton(new FancyButton(new FancyRect(200,200,16,16).fill(0xFF00FFFF)));
//		matrix = main.getMatrix();
		transformer.setup();
		main.pushMatrix();
//		main.scale(1);
		main.translate(30, 14);
		randMtx = main.getMatrix();
		main.popMatrix();
//		tb.autoTextSize();
		main.textWidth("hi");
		for(Rect r : rects) r.onSetup();
		for(IClickable<?> c : clickers) c.onSetup();
		for(Rect r : rectsmovable) r.onSetup();
		for(IClickable<?> c : clickersmovable) c.onSetup();
	}

	public <N extends AbstractButton<?>> N registerMovableButton(N b) {
		rectsmovable.add(b.rect);
		clickersmovable.add(b);
		return b;
	}
	public <N extends AbstractButton<?>> N registerButton(N b) {
		rects.add(b.rect);
		clickers.add(b);
		return b;
	}
	public <N extends IClickable<?>> N registerMovableClickable(N b) {
		clickersmovable.add(b);
		return b;
	}
	public <N extends IClickable<?>> N registerClickable(N b) {
		clickers.add(b);
		return b;
	}
	
	public <N extends Rect> N registerMovableRect(N b) {
		rectsmovable.add(b);
		return b;
	}

	
	public <N extends Rect> N registerRect(N b) {
		rects.add(b);
		return b;
	}
	
	
	public List<Rect> rectsmovable = new ArrayList<>();
	public List<IClickable<?>> clickersmovable = new ArrayList<>();
	public List<Rect> rects = new ArrayList<>();
	public List<IClickable<?>> clickers = new ArrayList<>();
	@Override
	public void draw() {
		///*
		main.background(255);
		main.pushMatrix();
		this.loadTfmMatrix();
		for (Rect rect : rectsmovable) {
			rect.draw();
		}
		for(int i=-10000;i<10000;i+=100) {
			main.line(-100000, i, 100000, i);
			main.line(i, -100000, i, 100000);
		}

		main.popMatrix(); // Pop Matrix
		
		for (Rect rect : rects) {
			rect.draw();
		}
		
		main.pushStyle(); // debug points
		main.strokeWeight(10);
		main.stroke(200,200,200);
		for(int i=0;i<tempxs.size();i++) {
			float tx = coordXToScreenX(tempxs.get(i));
			float ty = coordYToScreenY(tempys.get(i));
			main.point(tx, ty);
		}
		main.popStyle();

		//*/
		main.pushStyle();
		main.erase(10, 900 - 32, 500000, 500000);
		main.fill(0);
		main.fill(100);
		main.textSize(32);
		main.text(Boolean.toString(clickedin), 100, 900); // text
		float[] f = main.coordXYToScreenXY(300, 300);
		float x = f[0]; float y = f[1];
		
		annotation.run();
		
		main.strokeWeight(20);
		main.stroke(220,220,220);
		main.point(x, y);
		
		main.strokeWeight(14);
		main.stroke(255,0,0); // red
		main.point(300, 300);
		main.stroke(255,0,255); //magenta
		main.point(300 * sf(), 300 * sf()); // matches the scale
		main.point(300 * sf() - p1x(), 300 * sf() - p1y()); // is correct, 
		
		main.stroke(0,255,0); //green
		main.point(300-p1x(), 300-p1y());
		main.point(sf()*(300-p1x()), sf()*(300-p1y()));
		
		main.strokeWeight(8);
		main.stroke(0,0,255); //blue
//		main.translate(-nox, -noy);
//		main.point(300, 300);
		main.scale(sf()); // translations
		main.point(300, 300);
		main.translate(-p1x() / sf(), -p1y() / sf());
		main.point(300, 300);
//		main.point((300 * scale_factor)-nox, (300 * scale_factor)-noy);
		main.popStyle();

//		noLoop();
		//*/
		

		
	}
	private AnnotationProcessor annotation;

	@Override
	public void keyPressed() {
		if(keyCode == 32) {
//			pause = !pause; // pause unpause
		}
	}
	public boolean doTransformations = true;
//	public PMatrix matrix;
//	public float tempx, tempy = 0;
	public Transform transformer = new Transform();
	public void mouseEvent(MouseEvent e) {
		

		if(e.getAction() == MouseEvent.PRESS ) {
			for (IClickable<?> rect : clickers) {
				float x = e.getX();
				float y = e.getY();
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onClick(e);
				} else {
					rect.onClickOutside(e);
				}
			}
			for (IClickable<?> rect : clickersmovable) {
				float x = this.getMouseCoordX(e);
				float y = this.getMouseCoordY(e);
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onClick(e);
				} else {
					rect.onClickOutside(e);
				}
			}
		}
		transformer.mouseEvent(e);

		
//		loop();
	}
	public void updateTfmMatrix() {
		transformer.updateTfmMtx();
	}
	public PMatrix getTfmMatrix() {
		return transformer.matrix;
	}
	public void setTfmMatrix(PMatrix to) {
		transformer.matrix = to;
	}
	public void loadTfmMatrix() {
		main.setMatrix(this.getTfmMatrix());
	}
	public void debug(float[] f) {
		this.debug(f[0], f[1]);
	}
	List<Float> tempxs = new ArrayList<>();
	List<Float> tempys = new ArrayList<>();
	public void debug(float x, float y) {
		tempxs.add(x);
		tempys.add(y);
	}

	public void debugClear() {
		tempxs.clear();
		tempys.clear();
	}
	
//	public void scaleFromPoint(float x, float y, float scaleby) {
//		scale_factor = scaleby;
//		p1x = x*(1 - scaleby);
//		p1y = y*(1 - scaleby);
//	}
//	public void scaleFromPoint(float x, float y, float sf) {
//		scale_factor = sf;
//		p1x = x * (sf - 1);
//		p1y = y * (sf - 1);
//	}
	public void scaleFromPoint(float m2x, float m2y, float f2) {
		transformer.scaleFromPoint(m2x, m2y, f2);
	}
	
	public float p1x() {
		return transformer.p1x;
	}
	public float p1y() {
		return transformer.p1y;
	}
	public float sf() {
		return transformer.scale_factor;
	}
	public void setsf(float to) {
		this.transformer.scale_factor = to;
	}
	public void setp1(float x, float y) {
		this.transformer.p1x = x;
		this.transformer.p1y = y;
	}
	
	public float getMouseCoordX() {
		return screenXToCoordX(main.mouseX);
	}
	public float getMouseCoordX(MouseEvent e) {
		return screenXToCoordX(e.getX());
	}
	public float getMouseCoordY() {
		return screenYToCoordY(main.mouseY);
	}
	public float getMouseCoordY(MouseEvent e) {
		return screenYToCoordY(e.getY());
	}
	
	public float[] screenXYToCoordXY(float x, float y) {
		return transformer.screenXYToCoordXY(x, y);
	}
	public float[] coordXYToScreenXY(float x, float y) {
		return transformer.coordXYToScreenXY(x, y);
	}
	public float screenXToCoordX(float x) {
		return transformer.screenXToCoordX(x);
	}
	public float screenYToCoordY(float y) {
		return transformer.screenYToCoordY(y);
	}
	public float coordXToScreenX(float x) {
		return transformer.coordXToScreenX(x);
	}
	public float coordYToScreenY(float y) {
		return transformer.coordYToScreenY(y);
	}
	public void erase(int posx, int posy, int sizex, int sizey) {
		main.pushStyle();
		main.fill(255);
		main.stroke(255);
		main.rect(posx, posy, sizex, sizey);
	}

}
