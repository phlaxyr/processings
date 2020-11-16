package main;

import annotation.AddFixed;
import annotation.AnnotationProcessor;
import annotation.Peek;
import annotation.Setup;
import clickers.FancyButton;
import clickers.IClickable;
import clickers.responsive.CoupledButton;
import clickers.responsive.ResponsiveButton;
import processing.core.PApplet;
import processing.event.MouseEvent;
import shape.FancyRect;
import shape.New;
import shape.Textbox;
import trickery.element.Element;
import ui.Toolbox;
import ui.ToolboxManager;
import ui.ToolboxState;

public class Main extends MainFuncs{

	public static Main main;
//	public static PGraphics pgraphics;
	{
		Main.main = this;
		MainFuncs.initBlock(this);
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
	public CoupledButton rb2 = New.at(35,360,50,50).selectedFill(0xFF303000).fill(0xFF666600).CoupledButton();
	@AddFixed
	public ResponsiveButton t1 = New.at(95,300,50,50).text("test1").selectedFill(0xFF303000).fill(0xFF666600).ResponsiveTextButton();
	@AddFixed
	public CoupledButton t2 = New.at(95,360,50,50).text("test2").selectedFill(0xFF303000).fill(0xFF666600).CoupledTextButton();
	@AddFixed
	public Toolbox toolb = new Toolbox(0, 800, 1000, 70);
	
	
	Element e1 = new Element(350, 50, 200, 200, (self) -> {

		self.fill = 0xFF00BB00;
		self.stroke = 0xFFFF6600;
		self.z_index = -10;
		self.text = "The quick brown fox jumps over the lazy dog";
		self.registerfixed = false;
		self.onclick = (self2, e, isClick, in) -> {
			self.super_.onclick(e, isClick, in);
			if(in && isClick) {
				self.fill += 0x00001100;
			}
		};
		// self.unregister(); // this MUST be the last call
	});
	Element e2 = new Element(650, 50, 100, 100, (self) -> {
		self.fill = 0xFFFFFFFF;
		self.text = "Button";
		self.textsize = 30.0F;
		self.onclick = (self2, e, is, in) -> {
			self.super_.onclick(e, is, in);
			if(is && in) {
				self.isSelected = !self.isSelected;
				self.fill = self.isSelected ? 0xFF00FF00 : 0xFFFFFFFF;
			}
		};

	});
	
	public FancyButton buton1 = new FancyButton(new FancyRect(100,100,16,16).fill(0xFFFF0000)) {
		@Override
		public void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside) {
			if(isClick) {
				clickedin = isInside;
			}
		}
	};
	@Override
	public void setup() {
		System.out.println("SETUP!");
		this.surface.setResizable(true);
		main.registerMethod("mouseEvent", this);
		background(0x00FFFFFF); 
		shapes.rectsmovable.add(buton1.rect);
		shapes.clickersmovable.add(buton1);
		registerButton(new FancyButton(100,200,16,16), false).rect().fill(0xFF00FF00);
		registerButton(new FancyButton(new FancyRect(200,100,16,16).fill(0xFF0000FF)), false);
		registerButton(new FancyButton(new FancyRect(200,200,16,16).fill(0xFF00FFFF)), false);
//		matrix = main.getMatrix();

//		tb.autoTextSize();
		MainFuncs.setupDependents(this);
	}
	
	@Override
	public void draw() {
		
		main.background(255);
		main.pushMatrix(); 
		this.loadTfmMatrix();
		// start movable
		

		shapes.drawMovable();
		Demo.gridLines(); // grid lines

		// end movable
		main.popMatrix(); 

		
		// start fixed
		
		shapes.drawFixed();
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

	@Setup
	public ToolboxManager selector = new ToolboxManager();
	@SuppressWarnings("unused")
	public void mouseEvent(MouseEvent e) {

		if(false && ToolboxManager.isState(toolb, ToolboxState.MOVE)) {
			// MOVE
			float x = e.getX();
			float y = e.getY();
			if(!toolb.isPointWithin(x, y)) { // if we're clicking on a sandbox, nontoolbox thing
				selector.onToolboxMouse(e);
			}
			
		} else {
		
			// NORMAL
			if(e.getAction() == MouseEvent.RELEASE ) {
				for (IClickable rect : shapes.clickers) {
					float x = e.getX();
					float y = e.getY();
					rect.onMouseEvent(e, true, rect.getShape().isPointWithin(x, y));
	
				}
				for (IClickable rect : shapes.clickersmovable) {
					float x = getMouseCoordX(e);
					float y = getMouseCoordY(e);
					rect.onMouseEvent(e, true, rect.getShape().isPointWithin(x, y));
				}
			} else {
				for (IClickable rect : shapes.clickers) {
					rect.onMouseEvent(e, false, false);
	
				}
				for (IClickable rect : shapes.clickersmovable) {
					rect.onMouseEvent(e, false, false);
				}
			}
			transformer.mouseEvent(e);
		}
	}


}
