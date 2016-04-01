package part2;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import draw.StdDraw;


public class SierpinskiTriangle { 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = StdDraw.YELLOW;
	
	public SierpinskiTriangle() {
		StdDraw.setXscale(0, 150);
		StdDraw.setYscale(75, 150);
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		StdDraw.clear(StdDraw.GRAY); 
	}
   
	public void sierpinski(Point2D.Double a, Point2D.Double b, Point2D.Double c, int n) {
		if(n <= 0) {
			return;
		}
		Double left = new Point2D.Double(c.x + Math.abs(c.x - a.x) / 2, c.y + Math.abs(c.y - a.y) / 2);
		Double bottom = new Point2D.Double(a.x, b.y);
		Double right = new Point2D.Double(a.x + Math.abs(b.x - a.x) / 2, c.y + Math.abs(b.y - a.y) / 2);
		drawTriangle(a, b, c, StdDraw.WHITE);
		drawTriangle(left, right, bottom, StdDraw.BLACK);
		sierpinski(right, b, bottom, n-1);
		sierpinski(left, bottom, c, n-1);
		sierpinski(a, right, left, n-1);
		
    }
   
	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
	   double[] x = {a.x, b.x, c.x};
	   double[] y = {a.y, b.y, c.y};
	   StdDraw.setPenColor(color);
	   StdDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		sierpinski(top, right, left, n);
	}
	
	
	
	public static void main(String[] args) { 
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(16);
	}
}
