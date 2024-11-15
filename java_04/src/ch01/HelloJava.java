package ch01; /* package는 방 */

//AI서비스_웹과정반 @1일차
public/* 공개적 */ class HelloJava/* 대문자로 주인대접을 한다. */ {
	/*
	 * 소스코드를 작성
	 * 들여쓰기는 같은 라인에 맞춘다.
	 * File...Save : 'Ctrl' + 'S'
	 * 
	 * * Hotkey
	 * - 'Ctrl' + 'D' : 한줄삭제
	 * - 'Ctrl' + 'F11' : Run
	 * - 'Ctrl' + 'Shift' + 'Arrow UP', 'Down' : 블락(영역:{})이동
	 * 
	 * .java는 소스코드 --- compile -> .class는 기계어로 번역(Project...Build automatically 체크)
	 * 
	 * Compile은 컴퓨터가 이해할 수 있도록 현재 java코드를 해석해준다.
	 * 
	 * %JAVA_HOME%/bin/javac.exe(compiler)	%JAVA_HOME%/bin/java.exe(execute)
	 */
	public static void main(/* 문자열 */String[] args) { /* 주인 | 이 한줄이 없으면, 안된다. */
		/*
		 * System.in 콘솔에서 입력받을때
		 * System.out 콘솔에서 출력할때
		 */
//		System.out.println("무엇을 출력할래");
		System.out.println("Welcome~~");/* 문장의 마침표 */
		System.out.println("영대야, 아자아자화이팅!");
	}
}
