package day06;

interface USBMouseInterface {
	void mouseMove();

	void mouseClick();
}

interface RollMouseInterface {
	void roll();
}

public class MouseDriver implements RollMouseInterface, USBMouseInterface {
	public void mouseMove() {}

	public void mouseClick() {}

	public void roll() {}

	// 추가적으로 다른 메소드를 작성할 수 있다.
	int getStatus() {return 1;}

	int getButton() {return 2;}
}
