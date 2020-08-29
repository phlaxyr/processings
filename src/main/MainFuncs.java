package main;

import java.util.ArrayList;
import java.util.List;

import annotation.AnnotationProcessor;
import clickers.AbstractButton;
import clickers.IClickable;
import processing.core.PApplet;
import processing.core.PMatrix;
import processing.event.MouseEvent;
import rect.Rect;
import rect.ShapeSet;
import trickery.ISetupable;

public class MainFuncs extends PApplet{
	
	final static void initBlock(Main self) {
		Rect.main = self;
		Transform.main = self;
		AnnotationProcessor.main = self;
		Ap.p = self;
//		Main.pgraphics = new PGraphics();
	}
	

	final static void setupDependents(Main self) {
		self.transformer.onSetup();
		for(Rect r : self.shapes.rects) r.onSetup();
		for(IClickable<?> c : self.shapes.clickers) c.onSetup();
		for(Rect r : self.shapes.rectsmovable) r.onSetup();
		for(IClickable<?> c : self.shapes.clickersmovable) c.onSetup();
		for(ISetupable r : self.soleRegistrees) r.onSetup();
	}
	
	public Transform transformer = new Transform();
	public List<ISetupable> soleRegistrees = new ArrayList<>();
	public ShapeSet shapes = new ShapeSet();
	



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
		setMatrix(this.getTfmMatrix());
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
		return screenXToCoordX(this.mouseX);
	}
	public float getMouseCoordX(MouseEvent e) {
		return screenXToCoordX(e.getX());
	}
	public float getMouseCoordY() {
		return screenYToCoordY(this.mouseY);
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
		this.pushStyle();
		this.fill(255);
		this.stroke(255);
		this.rect(posx, posy, sizex, sizey);
	}

	public <N extends AbstractButton<?>> N registerMovableButton(N b) {
		shapes.rectsmovable.add(b.rect);
		shapes.clickersmovable.add(b);
		return b;
	}
	public <N extends AbstractButton<?>> N registerButton(N b) {
		shapes.rects.add(b.rect);
		shapes.clickers.add(b);
		return b;
	}
	public <N extends IClickable<?>> N registerMovableClickable(N b) {
		shapes.clickersmovable.add(b);
		return b;
	}
	public <N extends IClickable<?>> N registerClickable(N b) {
		shapes.clickers.add(b);
		return b;
	}
	
	public <N extends Rect> N registerMovableRect(N b) {
		shapes.rectsmovable.add(b);
		return b;
	}

	
	public <N extends Rect> N registerRect(N b) {
		shapes.rects.add(b);
		return b;
	}
	
	public <R extends ISetupable> R registerSetupable(R r) {
		soleRegistrees.add(r);
		return r;
	}
}
