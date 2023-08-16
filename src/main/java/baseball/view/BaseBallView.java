package baseball.view;

import baseball.result.BaseBallResult;
import baseball.view.input.BaseBallConsoleInput;
import baseball.view.output.BaseBallConsoleOutput;

public class BaseBallView {
    private final BaseBallConsoleInput input;
    private final BaseBallConsoleOutput output;

    public BaseBallView(BaseBallConsoleInput input, BaseBallConsoleOutput output) {
        this.input = input;
        this.output = output;
    }

    public void startGame() {
        output.printStartGame();
    }

    public int[] chooseNumbers() {
        output.printInputNumber();
        return input.getNumberInput();
    }

    public void result(BaseBallResult result) {
        output.printResult(result);
    }

    public boolean endGame() {
        output.printEndGame();
        output.printRestartGame();
        return !input.restartGame();
    }
}
