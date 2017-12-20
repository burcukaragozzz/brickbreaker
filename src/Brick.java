import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Brick extends Rectangle{
	
	// Tugla objesini olustururken kullanilacak img
	Image pic;
	// topun yer degistirmesi
	int dx = 3;
	int dy = -3;
	// tuglanin silinmesi
	boolean destroyed = false;
	
	// x,y koordinatlari, uzunluk, yukseklik ve img
	Brick(int a, int b, int w, int h, String s) {
		x = a;
		y = b;
		width = w;
		height = h;
		pic = Toolkit.getDefaultToolkit().getImage(s);
	}
	
	// Tugla nesnesini cizen metod
	public void draw(Graphics g, Component c) {
		if (!destroyed)
			g.drawImage(pic,x,y,width,height,c);
	}
	
}
