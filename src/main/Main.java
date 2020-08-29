package main;

import annotation.AddFixed;

import annotation.AnnotationProcessor;
import annotation.Peek;
import annotation.Setup;
import clickers.FancyButton;
import clickers.responsive.InteResponsiveButton;
import clickers.responsive.ResponsiveButton;
import mouse.DefaultMouseManager;
import mouse.IMouseManager;
import processing.core.PApplet;
import processing.event.MouseEvent;
import rect.FancyRect;
import rect.New;
import rect.Textbox;
import ui.Toolbox;
import ui.ToolboxManager;

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
	public InteResponsiveButton rb2 = New.at(35,360,50,50).selectedFill(0xFF303000).fill(0xFF666600).InteResponsiveButton();
	@AddFixed
	public ResponsiveButton t1 = New.at(95,300,50,50).text("test1").selectedFill(0xFF303000).fill(0xFF666600).ResponsiveTextButton();
	@AddFixed
	public InteResponsiveButton t2 = New.at(95,360,50,50).text("test2").selectedFill(0xFF303000).fill(0xFF666600).InteResponsiveTextButton();
	@AddFixed
	public Toolbox toolb = new Toolbox(0, 800, 1000, 70);
	
	public FancyButton buton1 = new FancyButton(new FancyRect(100,100,16,16).fill(0xFFFF0000)) {
		@Override
		public void onMouseEvent(MouseEvent e, boolean isInside) {
			clickedin = isInside;
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
		registerMovableButton(new FancyButton(100,200,16,16)).rect().fill(0xFF00FF00);
		registerMovableButton(new FancyButton(new FancyRect(200,100,16,16).fill(0xFF0000FF)));
		registerMovableButton(new FancyButton(new FancyRect(200,200,16,16).fill(0xFF00FFFF)));
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
	public IMouseManager mouseman = new DefaultMouseManager();
	public void mouseEvent(MouseEvent e) {
		
		mouseman.mouseEvent(e);

		
//		loop();
	}


}
