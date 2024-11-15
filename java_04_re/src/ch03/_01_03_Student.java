package ch03;

//AI서비스_웹과정반 @6일차
public class _01_03_Student {
	private final char MARK_FULL = '*';
	private final char MARK_EMPTY = '-';
	private final int MAX_METER = 10;

	private boolean attendance; // 출석여부
	private String eduStage; // 'E':Elementary(초등), 'M':Middle(중등), 'H':High(고등)
	private String dream;
	private char sincere; // 상, 중, 하
	private int moodsMeter; // ?/10:MAX_METER

	public void setAttendance(boolean isAttendance) {
		this.attendance = isAttendance;
	}

	public void setEduStage(String eduStage) {
		this.eduStage = eduStage;
	}

	public void setDream(String dream) {
		this.dream = dream;
	}

	public void setSincere(char sincere) {
		this.sincere = sincere;
	}
	
	public void setMoodsMeter(int moodsMeter) {
		this.moodsMeter = moodsMeter;
	}


	public void showInfo() {
		System.out.println("=== 학생정보 =========");

		System.out.println("교육단계:\t" + this.eduStage);
		System.out.println("꿈:\t" + this.dream);
		System.out.println("성실함:\t" + this.sincere);

		System.out.print("기분정도:\t");
		if (this.moodsMeter > 0 && this.moodsMeter <= 10) {
			for (int i = 1; i <= MAX_METER; i++) {
				if (i <= moodsMeter)
					System.out.print(MARK_FULL);
				else System.out.print(MARK_EMPTY);
			}
		}

		if (!this.attendance)
			System.out.println("\n" + "오늘은 출석하지 않았습니다...");
	}
}
