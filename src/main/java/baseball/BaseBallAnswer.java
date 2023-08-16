package baseball;

import baseball.result.BaseBallResult;
import baseball.result.BaseBallResultFactory;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseBallAnswer {
    private static final BaseBallResultFactory resultFactory = new BaseBallResultFactory();
    private final int[] answer = new int[3];

    public BaseBallAnswer() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < answer.length) {
            int random = Randoms.pickNumberInRange(1, 9);
            numberSet.add(random);
        }
        setAnswer(numberSet);
    }

    private void setAnswer(Set<Integer> numberSet) {
        int idx = 0;
        for (int num : numberSet) {
            answer[idx++] = num;
        }
    }

    public BaseBallResult judgeResult(int[] userInput) {
        return resultFactory.createResult(userInput, answer);
    }
}
