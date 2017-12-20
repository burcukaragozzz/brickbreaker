import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BrickBreakerPanel extends JPanel implements KeyListener{
	
	ArrayList<Brick> bricks = new ArrayList<Brick>();
	ArrayList<Brick> ball = new ArrayList<Brick>();
	int size = 25;
	Brick paddle;
	Thread thread;
	Animate animate;
	
	// Constructor method
	BrickBreakerPanel() {
		
		// raketi olustur.
		paddle = new Brick(175,300,150,25, "images/black.png");
		
		// Belirlenen koordinatlara, 60x25 boyutlarindaki 8x4 farkli renk tuglayi ekle
		for (int i = 0; i < 8; i++) {
			bricks.add(new Brick((i*60+2),0,60,25, "images/blue.png"));
		}
		for (int i = 0; i < 8; i++) {
			bricks.add(new Brick((i*60+2),25,60,25, "images/red.png"));
		}
		for (int i = 0; i < 8; i++) {
			bricks.add(new Brick((i*60+2),50,60,25, "images/green.png"));
		}
		for (int i = 0; i < 8; i++) {
			bricks.add(new Brick((i*60+2),75,60,25, "images/yellow.png"));
		}
		ball.add(new Brick(237,237,25,25,"images/ball.png"));
		setFocusable(true); 
		addKeyListener(this); // Keyleri oku
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Brick b: bricks)
			b.draw(g, this);
		for (Brick b: ball)
			b.draw(g, this);
		paddle.draw(g, this);
	}
	
	public void update() {
		for	(Brick ba:ball) {
			ba.x += ba.dx;
			if (ba.x > (getWidth()-size)&& ba.dx > 0 || ba.x < 0)
				ba.dx *= -1;
			if (ba.y < 0 || ba.intersects(paddle))
				ba.dy *= -1;
			ba.y += ba.dy;
			
			for (Brick b:bricks) {
				if (ba.intersects(b) && !b.destroyed) {
					b.destroyed = true;
					ba.dy *= -1;	
				}
			}
			
		}
		
		repaint();
	}

	// KeyListener interface'inden gelen method
	@Override
	public void keyPressed(KeyEvent e) {
		// Sol ok tusuna basilinca raket sola 15px kayar
		if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0) {
			paddle.x-=15;
		}
		// Sag ok tusuna basilinca raket saga 15px kayar
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth()-paddle.width)) {
			paddle.x+=15;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
