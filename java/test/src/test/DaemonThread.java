package test;

public class DaemonThread implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("데몬 쓰레드가 실행중입니다.");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인 쓰레드가 종료됩니다.");
	}
}
