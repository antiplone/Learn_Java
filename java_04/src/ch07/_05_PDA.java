package ch07;

public class _05_PDA implements _05_MP3 {

	@Override
	public void play() {
		System.out.println("음악을 재생중...");
	}

	@Override
	public void stop() {
		System.out.println("재생 중단...");
	}

	public int calculate(int x, int y) {
		return (x + y);
	}
}
