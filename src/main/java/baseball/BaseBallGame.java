package baseball;

import baseball.input.NextstepConsoleInput;
import baseball.result.BaseBallResult;
import baseball.view.BaseBallView;
import baseball.view.input.BaseBallConsoleInput;
import baseball.view.output.BaseBallConsoleOutput;
import baseball.view.output.BaseBallOutputMessageFactory;

public class BaseBallGame {
    BaseBallView view;

    public BaseBallGame() {
        BaseBallConsoleInput input = new BaseBallConsoleInput(new NextstepConsoleInput());
        BaseBallConsoleOutput output = new BaseBallConsoleOutput(new BaseBallOutputMessageFactory());
        view = new BaseBallView(input, output);
    }

    public void initGame() {
        boolean isEndGame = false;
        while (!isEndGame) {
            BaseBallAnswer answer = new BaseBallAnswer();
            boolean isWin = false;
            view.startGame();
            while (!isWin) {
                int[] userInput = view.chooseNumbers();
                BaseBallResult result = answer.judgeResult(userInput);
                view.result(result);
                isWin = result.isWin();
            }
            isEndGame = view.endGame();
        }
    }
}
