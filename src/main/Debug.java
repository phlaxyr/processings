package main;

import java.util.ArrayList;
import java.util.List;

public class Debug {
	public static List<Float> tempxs = new ArrayList<>();
	public static List<Float> tempys = new ArrayList<>();
	public static void debug(float x, float y) {
		tempxs.add(x);
		tempys.add(y);
	}

	public static void debugClear() {
		tempxs.clear();
		tempys.clear();
	}
	
//	static int shiny = 0;
	public static void debugPoints() {
		Main main = Main.main;
		main.pushStyle(); // debug points
		main.strokeWeight(10);
		main.stroke(200,200,200);
		for(int i=0;i<tempxs.size();i++) {
			float tx = main.coordXToScreenX(tempxs.get(i));
			float ty = main.coordYToScreenY(tempys.get(i));
			main.point(tx, ty);
		}
		main.popStyle();
	}
	public static void debug(float[] f) {
		Debug.debug(f[0], f[1]);
	}
	
	public static void transformationDebugPoints() {
		Main main = Main.main;
		float sf = main.sf();
		float p1x = main.p1x();
		float p1y = main.p1y();
		main.strokeWeight(14);
		main.stroke(255,0,0); // red
		main.point(300, 300);
		main.stroke(255,0,255); //magenta
		main.point(300 * sf, 300 * sf); // matches the scale
		main.point(300 * sf - p1x, 300 * sf - p1y); // is correct, 
		
		main.stroke(0,255,0); //green
		main.point(300-p1x, 300-p1y);
		main.point(sf*(300-p1x), sf*(300-p1y));
		
		main.strokeWeight(8);
		main.stroke(0,0,255); //blue
//		main.translate(-nox, -noy);
//		main.point(300, 300);
		main.scale(sf); // translations

		main.point(300, 300);
		main.translate(-p1x / sf, -p1y / sf);
		main.point(300, 300);

	}

}
