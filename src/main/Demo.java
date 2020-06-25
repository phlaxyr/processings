package main;

public class Demo {
	public static void gridLines() {
		Main main = Main.main;
		for(int i=-10000;i<10000;i+=100) {
			main.line(-100000, i, 100000, i);
			main.line(i, -100000, i, 100000);
		}
	}

	public static void movablePointAt300300() {
		Main main = Main.main;
		float[] f = main.coordXYToScreenXY(300, 300);
		float x = f[0]; float y = f[1];
		main.strokeWeight(20);
		main.stroke(220,220,220);
		main.point(x, y);
	}
}
