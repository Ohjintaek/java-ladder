package laddergame.view;

import java.util.Scanner;

public class InputView {
	public static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {

	}

	public static String inputPlayers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return SCANNER.nextLine();
	}

	public static Integer inputLadderHeight() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력하세요");
		}
	}

	public static String inputRewards() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
		return SCANNER.nextLine();
	}

	public static String inputCommand() {
		System.out.println("결과를 보고 싶은 사람은?");
		return SCANNER.nextLine();
	}
}