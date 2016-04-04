package part3;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import draw.StdDraw;


public class HTree {
	public static void main(String[] args) {
		HTree htree = new HTree();
		htree.draw(4);
	}

	public HTree() {
		StdDraw.setXscale(0, 150);
		StdDraw.setYscale(0, 150);
		StdDraw.clear(StdDraw.GRAY);
		StdDraw.setPenColor(StdDraw.WHITE);
	}
	
	public void draw(int n) {
		tree(new Point2D.Double(150 / 2, 150 / 2), 75, n);
	}
	
	public void tree(Point2D.Double center, double radius, int n) {
		if(n <= 0) return;	
		H h = new H(center, radius);
		h.draw();
		H h2 = new H(h.getTopRight(), radius / 2);
		h2.draw();
		H h3 = new H(h.getTopLeft(), radius / 2);
		h3.draw();
		H h4 = new H(h.getBottomLeft(), radius / 2);
		h4.draw();
		H h5 = new H(h.getBottomRight(), radius / 2);
		h5.draw();
		tree(h.getTopRight(), radius / 2, n - 1);
		tree(h.getTopLeft(), radius / 2, n - 1);
		tree(h.getBottomRight(), radius / 2, n - 1);
		tree(h.getBottomLeft(), radius / 2, n - 1);
	}
	
}
