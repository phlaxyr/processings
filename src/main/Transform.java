package main;

import processing.core.PMatrix;
import processing.event.MouseEvent;

public class Transform {
	public static Main main;
//	public static Transform transform = new Transform();
	
	public boolean doTransformations = true;
	public PMatrix matrix;
//	public float tempx, tempy = 0;
	private boolean drag_flag = false;
	private float mousepressinitx, mousepressinity;
	public void setup() {
		this.matrix = main.getMatrix();
	}

	public void mouseEvent(MouseEvent e) {
		

		if(doTransformations) {
			if (e.getAction() == MouseEvent.PRESS) {
//				System.out.println("PRESS");
				this.mousepressinitx = this.getMouseCoordX(e);
				this.mousepressinity = this.getMouseCoordY(e);
				Debug.debugClear();
				Debug.debug(mousepressinitx, mousepressinity);
				drag_flag = true;
			} else if (e.getAction() == MouseEvent.DRAG) {
//				System.out.println("DRAG");
				if(drag_flag) {
					float dx = this.getMouseCoordX(e) - this.mousepressinitx;
					float dy = this.getMouseCoordY(e) - this.mousepressinity;
					this.p1x -= dx * scale_factor;
					this.p1y -= dy * scale_factor;
					this.mousepressinitx = this.getMouseCoordX(e);
					this.mousepressinity = this.getMouseCoordY(e);
					updateTfmMtx();
				}
			} else if (e.getAction() == MouseEvent.RELEASE) {
//				System.out.println("RELEASE");
				drag_flag = false;
			} else if (e.getAction() == MouseEvent.WHEEL) {
				float x, y;
				float[] f;
//				f = screenXYToCoordXY(e.getX(), e.getY());
//				x = f[0];
//				y = f[1];
				x = e.getX(); y = e.getY();
				scaleFromPoint(x, y, e.getCount() == -1 ? 1.1f: 0.9f);
				f = screenXYToCoordXY(e.getX(), e.getY());
				Debug.debugClear();
				Debug.debug(f);
				updateTfmMtx();
				return; 
			}

		}
//		loop();
	}
	public void updateTfmMtx() {
		main.pushMatrix();
		main.resetMatrix();

		main.translate(-p1x, -p1y); // make (nox, noy) the new screen origin
		main.scale(scale_factor);
		this.matrix = main.getMatrix();
		main.popMatrix();
	}
	public void scaleFromPoint(float m2x, float m2y, float f2) {
		float f1 = scale_factor;
		float p1x = this.p1x;
		float p1y = this.p1y;
		scale_factor = f1 * f2;
		this.p1x = f2*p1x + m2x*(f2-1);
		this.p1y = f2*p1y + m2y*(f2-1);
	}
	
	public float scale_factor; 
	public float p1x, p1y; 
	{
		scale_factor = 1;
		p1x = p1y = 0;
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
		return new float[] {screenXToCoordX(x), screenYToCoordY(y)};
	}
	public float[] coordXYToScreenXY(float x, float y) {
		return new float[] {coordXToScreenX(x), coordYToScreenY(y)};
	}
	public float screenXToCoordX(float x) {
		float tempx = x + p1x;
		return tempx / scale_factor;
	}
	public float screenYToCoordY(float y) {
		float tempy = y + p1y;
		return tempy / scale_factor;
	}
	public float coordXToScreenX(float x) {
		float tempx = x * scale_factor;
		return tempx - p1x;
	}
	public float coordYToScreenY(float y) {
		float tempy = y * scale_factor;
		return tempy - p1y;
	}
}
