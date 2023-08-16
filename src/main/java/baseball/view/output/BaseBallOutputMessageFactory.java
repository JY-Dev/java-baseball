package baseball.view.output;

import baseball.result.BaseBallResult;

public class BaseBallOutputMessageFactory {

    public String createStartGame(){
        return "숫자 야구 게임을 시작합니다.";
    }

    public String createInputNumber(){
        return "숫자를 입력해주세요 : ";
    }
    public String createBaseBallResult(BaseBallResult result) {
        BaseBallResultOutputType type = BaseBallResultOutputType.findOutPutType(result);
        switch (type) {
            case BALL:
                return String.format("%d볼", result.ballCount);
            case STRIKE:
                return String.format("%d스트라이크", result.strikeCount);
            case STRIKE_AND_BALL:
                return String.format("%d볼 %d스트라이크", result.ballCount, result.strikeCount);
            default:
                return "낫싱";
        }
    }

    public String createEndGame(){
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    public String createRestartGame(){
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public enum BaseBallResultOutputType {
        STRIKE, BALL, STRIKE_AND_BALL, NOTHING;

        public static BaseBallResultOutputType findOutPutType(BaseBallResult result) {
            if (result.strikeCount > 0 && result.ballCount > 0)
                return STRIKE_AND_BALL;
            else if (result.strikeCount > 0)
                return STRIKE;
            else if (result.ballCount > 0)
                return BALL;
            else
                return NOTHING;
        }
    }
}
