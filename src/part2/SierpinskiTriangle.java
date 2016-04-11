package part2;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import draw.UltraDraw;


public class SierpinskiTriangle implements MouseListener, MouseMotionListener{ 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = UltraDraw.YELLOW;
	static int recursionFactor = 1;
	
	public SierpinskiTriangle() {
		UltraDraw.addMouseListener(this);
		UltraDraw.setXscale(0, 150);
		UltraDraw.setYscale(75, 150);
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		UltraDraw.clear(UltraDraw.GRAY); 
	}
   
	public void sierpinski(Point2D.Double a, Point2D.Double b, Point2D.Double c, int n) {
		if(n <= 0) {
			return;
		}
		Double left = new Point2D.Double(c.x + Math.abs(c.x - a.x) / 2, c.y + Math.abs(c.y - a.y) / 2);
		Double bottom = new Point2D.Double(a.x, b.y);
		Double right = new Point2D.Double(a.x + Math.abs(b.x - a.x) / 2, c.y + Math.abs(b.y - a.y) / 2);
		drawTriangle(a, b, c, UltraDraw.WHITE);
		drawTriangle(left, right, bottom, UltraDraw.BLACK);
		sierpinski(right, b, bottom, n-1);
		sierpinski(left, bottom, c, n-1);
		sierpinski(a, right, left, n-1);
		
    }
   
	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
	   double[] x = {a.x, b.x, c.x};
	   double[] y = {a.y, b.y, c.y};
	   UltraDraw.setPenColor(color);
	   UltraDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		sierpinski(top, right, left, n);
	}
	
	
	
	public static void main(String[] args) { 
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(recursionFactor);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(recursionFactor <= 10) {
			SierpinskiTriangle triangle = new SierpinskiTriangle();
			triangle.draw(recursionFactor);
			recursionFactor += 1;
		} else {
			recursionFactor = 0;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
