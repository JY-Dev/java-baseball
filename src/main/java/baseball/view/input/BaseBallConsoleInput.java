package baseball.view.input;

import baseball.input.ConsoleInput;

import java.util.stream.Collectors;

public class BaseBallConsoleInput {
    ConsoleInput consoleInput;

    public BaseBallConsoleInput(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public int[] getNumberInput() {
        String input = consoleInput.readLine();
        validateBaseBallNumberInput(input);
        return input.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public boolean restartGame() {
        String input = consoleInput.readLine();
        return input.equals("1");
    }

    private void validateBaseBallNumberInput(String input) {
        int numSize = input.chars()
                .filter(this::isBaseBallValidNumber)
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toSet())
                .size();

        if (numSize != 3)
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private boolean isBaseBallValidNumber(int asciiData) {
        return asciiData >= '1' && asciiData <= '9';
    }
}
