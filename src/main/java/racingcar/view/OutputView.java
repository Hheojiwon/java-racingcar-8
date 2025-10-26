package racingcar.view;

import java.util.List;

public class OutputView {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultHeader() {
        System.out.println("실행 결과:");
    }

    public void printCarStatus(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void printWinnerResult(List<String> winners) {
        String winnerText = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerText);
    }
}