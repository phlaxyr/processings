package main;

import java.util.ArrayList;
import java.util.List;

import annotation.AddFixed;
import annotation.AnnotationProcessor;
import annotation.Peek;
import annotation.Setup;
import clickers.AbstractButton;
import clickers.FancyButton;
import clickers.IClickable;
import clickers.responsive.InteResponsiveButton;
import clickers.responsive.ResponsiveButton;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PMatrix;
import processing.event.MouseEvent;
import rect.FancyRect;
import rect.New;
import rect.Rect;
import rect.Textbox;
import trickery.ISetupable;
import ui.Toolbox;
import ui.ToolboxLogic;

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
	public ResponsiveButton rb = New.at(35,300,50,50).selectedFill(0xFF303000).fill(0xFF666600).ResponsiveButton();
	@AddFixed
	public InteResponsiveButton rb2 = New.at(35,360,50,50).selectedFill(0xFF303000).fill(0xFF666600).InteResponsiveButton();
	@AddFixed
	public ResponsiveButton t1 = New.at(95,300,50,50).text("test1").selectedFill(0xFF303000).fill(0xFF666600).ResponsiveTextButton();
	@AddFixed
	public InteResponsiveButton t2 = New.at(95,360,50,50).text("test2").selectedFill(0xFF303000).fill(0xFF666600).InteResponsiveTextButton();
	@AddFixed
	public Toolbox toolb = new Toolbox(0, 800, 1000, 70);
	
	public FancyButton buton1 = new FancyButton(new FancyRect(100,100,16,16).fill(0xFFFF0000)) {
		@Override
		public void onClick(MouseEvent e) {
			clickedin = true;
		}
		public void onClickOutside(MouseEvent e) {
			clickedin = false;
		};
	};
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

//		tb.autoTextSize();
		setupDependents();
	}

	public void setupDependents() {
		transformer.onSetup();
		for(Rect r : rects) r.onSetup();
		for(IClickable<?> c : clickers) c.onSetup();
		for(Rect r : rectsmovable) r.onSetup();
		for(IClickable<?> c : clickersmovable) c.onSetup();
		for(ISetupable r : soleRegistrees) r.onSetup();
	}

	
	public List<ISetupable> soleRegistrees = new ArrayList<>();
	public List<Rect> rectsmovable = new ArrayList<>();
	public List<IClickable<?>> clickersmovable = new ArrayList<>();
	public List<Rect> rects = new ArrayList<>();
	public List<IClickable<?>> clickers = new ArrayList<>();
	@Override
	public void draw() {
		
		main.background(255);
		main.pushMatrix(); 
		this.loadTfmMatrix();
		// start movable
		

		for (Rect rect : rectsmovable) {
			rect.draw();
		}
		Demo.gridLines(); // grid lines

		// end movable
		main.popMatrix(); 

		
		// start fixed
		
		for (Rect rect : rects) {
			rect.draw();
		}
		Debug.debugPoints(); // debug points

		main.pushStyle();
//		main.erase(10, 900 - 32, 500000, 500000);
		main.fill(0);
		main.fill(100);
		main.textSize(32);
		main.text(Boolean.toString(clickedin), 100, 900); // text

		
		annotation.run();
		
		Demo.movablePointAt300300();
		
		Debug.transformationDebugPoints();
		//		main.point((300 * scale_factor)-nox, (300 * scale_factor)-noy);
		main.popStyle();

//		noLoop();
		
		// end fixed

		
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
	@Setup
	public ToolboxLogic selector = new ToolboxLogic();
	public void mouseEvent(MouseEvent e) {
		

		if(e.getAction() == MouseEvent.RELEASE ) {
			for (IClickable<?> rect : clickers) {
				float x = e.getX();
				float y = e.getY();
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onClick(e);
					selector.onElementClicked(e, rect, false);
				} else {
					rect.onClickOutside(e);
				}
			}
			for (IClickable<?> rect : clickersmovable) {
				float x = this.getMouseCoordX(e);
				float y = this.getMouseCoordY(e);
				if(rect.getShape().isPointWithin(x, y)) {
					rect.onClick(e);
					selector.onElementClicked(e, rect, true);
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
	
	public <R extends ISetupable> R registerSetupable(R r) {
		soleRegistrees.add(r);
		return r;
	}
}
