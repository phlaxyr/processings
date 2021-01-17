package mouse;

import main.Main;
import processing.core.PMatrix;
import processing.event.MouseEvent;
import trickery.ISetupable;

public class ClickCenter implements ISetupable{
	public static Main main;
	
	public boolean doTransformations = true;
	public PMatrix matrix;
//	public float tempx, tempy = 0;
	private boolean drag_flag = false;
	private float screentrackx, screentracky;
	public final float scale_factor = 1; 
	public float totdx, totdy; 
	{
		totdx = totdy = 0;
	}
	
	public void onSetup() {
		this.matrix = main.getMatrix();
	}

	public void mouseEvent(MouseEvent e) {
		

		if(doTransformations) {
			if (e.getAction() == MouseEvent.PRESS) {
				this.screentrackx = this.getMouseCoordX(e);
				this.screentracky = this.getMouseCoordY(e);

				drag_flag = true;
			} else if (e.getAction() == MouseEvent.DRAG) {
				if(drag_flag) {
					float dx = this.getMouseCoordX(e) - this.screentrackx;
					float dy = this.getMouseCoordY(e) - this.screentracky;
					this.totdx -= dx * scale_factor; 
					this.totdy -= dy * scale_factor;
					this.screentrackx = this.getMouseCoordX(e);
					this.screentracky = this.getMouseCoordY(e);
					// updateTfmMtx();
				}
			} else if (e.getAction() == MouseEvent.RELEASE) {
				drag_flag = false;
			} else if (e.getAction() == MouseEvent.WHEEL) {
				return;
				/*
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
				return; */
			}

		}
//		loop();
	}
	public void updateTfmMtx() {
		main.pushMatrix();
		main.resetMatrix();

		main.translate(-totdx, -totdy); // make (nox, noy) the new screen origin
		// main.scale(scale_factor);
		this.matrix = main.getMatrix();
		main.popMatrix();
	}
//	public void scaleFromPoint(float m2x, float m2y, float f2) {
//		float f1 = scale_factor;
//		float totdx = this.totdx;
//		float totdy = this.totdy;
//		scale_factor = f1 * f2;
//		this.totdx = f2*totdx + m2x*(f2-1);
//		this.totdy = f2*totdy + m2y*(f2-1);
//	}
	

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
		float tempx = x + totdx;
		return tempx / scale_factor;
	}
	public float screenYToCoordY(float y) {
		float tempy = y + totdy;
		return tempy / scale_factor;
	}
	public float coordXToScreenX(float x) {
		float tempx = x * scale_factor;
		return tempx - totdx;
	}
	public float coordYToScreenY(float y) {
		float tempy = y * scale_factor;
		return tempy - totdy;
	}
}
