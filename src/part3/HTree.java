package part3;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import draw.UltraDraw;


public class HTree implements KeyListener {
	public static void main(String[] args) {
		HTree htree = new HTree();
		htree.draw(1);
	}

	public HTree() {
		UltraDraw.addKeyListener(this);
		UltraDraw.setXscale(0, 150);
		UltraDraw.setYscale(0, 150);
		UltraDraw.clear(UltraDraw.GRAY);
		UltraDraw.setPenColor(UltraDraw.WHITE);
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

	@Override
	public void keyPressed(KeyEvent e) {
		char keychar = e.getKeyChar();
		if(Character.getNumericValue(keychar) <= 6) {
			UltraDraw.clear(UltraDraw.GRAY);
			draw(Character.getNumericValue(keychar));
		} else {
			return;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e);
		
	}
	
}
