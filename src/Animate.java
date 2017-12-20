
public class Animate implements Runnable{
	
	BrickBreakerPanel bp;
	
	Animate(BrickBreakerPanel b) {
		bp = b;
	}
	
	@Override
	public void run() {
		while (true) {
			bp.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
