package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    // 게임 시작
    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printEnd() {
        System.out.println("게임을 종료합니다.");
    }

    // 숫자 입력
    public String inputNumber() {
        System.out.println("숫자를 입력해주세요: ");
        String input = Console.readLine();
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백 없이 입력해 주세요.");
        return input;
    }

    // 결과 출력
    public void printResult(Store store) {
        if (store.result.isEmpty()) System.out.println("낫싱");
        else {
            for (String key : store.result.keySet()) System.out.print(store.result.get(key) + key + " ");
        }
    }

    // 정답 메시지 출력
    public void ifWin(Store store, int NUMBER_OF_DIGITS) {
        if (store.result.getOrDefault("스트라이크", 0) == NUMBER_OF_DIGITS)
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 게임 진행 여부
    public String printProcess() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (! (input.equals("1") || input.equals("2"))) throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        return input;
    }
}


