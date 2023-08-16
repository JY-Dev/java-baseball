package baseball.view.output;

import baseball.result.BaseBallResult;

public class BaseBallConsoleOutput {
    private final BaseBallOutputMessageFactory messageFactory;

    public BaseBallConsoleOutput(BaseBallOutputMessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    public void printStartGame() {
        String output = messageFactory.createStartGame();
        System.out.println(output);
    }

    public void printInputNumber() {
        String output = messageFactory.createInputNumber();
        System.out.println(output);
    }

    public void printResult(BaseBallResult baseBallResult) {
        String output = messageFactory.createBaseBallResult(baseBallResult);
        System.out.println(output);
    }

    public void printEndGame() {
        String output = messageFactory.createEndGame();
        System.out.println(output);
    }

    public void printRestartGame(){
        String output = messageFactory.createRestartGame();
        System.out.println(output);
    }
}
