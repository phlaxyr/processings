package main;

import processing.event.MouseEvent;

public class DragEvent {
	public MouseEvent e;
	public int startingx, startingy;
	public DragEvent(MouseEvent e, int startingx) {
		this.e = e;
		this.startingx = startingx;
	}
}
