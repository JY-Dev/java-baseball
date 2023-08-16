package baseball.result;

public class BaseBallResultFactory {
    public BaseBallResult createResult(int[] userInput, int[] answer) {
        int strikeCount = getStrikeCount(userInput, answer);
        int ballCount = getBallCount(userInput, answer, strikeCount);
        return new BaseBallResult(ballCount, strikeCount);
    }

    private int getStrikeCount(int[] userInput, int[] answer) {
        int strikeCount = 0;
        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i] == answer[i])
                strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount(int[] userInput, int[] answer, int strikeCount) {
        int ballCount = 0;
        for (int userNum : userInput) {
            if (hasNum(answer, userNum))
                ballCount++;
        }
        return Math.min(ballCount, Math.abs(ballCount - strikeCount));
    }

    private boolean hasNum(int[] answer, int num) {
        for (int answerNum : answer) {
            if (num == answerNum)
                return true;
        }
        return false;
    }


}
