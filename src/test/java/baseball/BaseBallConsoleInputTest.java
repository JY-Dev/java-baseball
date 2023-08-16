package baseball;

import baseball.input.ConsoleInput;
import baseball.view.input.BaseBallConsoleInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallConsoleInputTest {

    @DisplayName("사용자의 입력의 길이가 3보다 큰 경우 예외 발생")
    @Test
    void invalid_input_length_high_test(){
        ConsoleInput consoleInputHigh = new TestConsoleInput("1234");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(consoleInputHigh);

        Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getNumberInput);
    }

    @DisplayName("사용자의 입력의 길이가 3보다 작은 경우 예외 발생")
    @Test
    void invalid_input_length_low_test(){
        ConsoleInput consoleInputLow = new TestConsoleInput("1");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(consoleInputLow);

        Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getNumberInput);
    }

    @DisplayName("사용자의 입력이 숫자가 아닌 문자가 들어온 경우 예외 발생")
    @Test
    void invalid_wrong_input_test(){
        ConsoleInput consoleInputLow = new TestConsoleInput("a12");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(consoleInputLow);

        Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getNumberInput);
    }

    @DisplayName("사용자의 입력에 0이 포함된 경우 예외 발생")
    @Test
    void invalid_zero_input_test(){
        ConsoleInput consoleInputLow = new TestConsoleInput("012");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(consoleInputLow);

        Assertions.assertThrows(IllegalArgumentException.class, consoleInput::getNumberInput);
    }

    @DisplayName("사용자의 입력의 정상적인 경우 크기가 3인 int 배열을 반환해야함")
    @Test
    void valid_input_length_test(){
        ConsoleInput consoleInputLow = new TestConsoleInput("423");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(consoleInputLow);

        int[] userInput = consoleInput.getNumberInput();

        org.assertj.core.api.Assertions.assertThat(userInput.length).isEqualTo(3);
        org.assertj.core.api.Assertions.assertThat(userInput[0]).isEqualTo(4);
        org.assertj.core.api.Assertions.assertThat(userInput[1]).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(userInput[2]).isEqualTo(3);
    }

    @DisplayName("사용자의 입력이 1인 경우 true을 반환 해야함")
    @Test
    void valid_restart_game_test(){
        ConsoleInput restartInput = new TestConsoleInput("1");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(restartInput);

        boolean isRestart = consoleInput.restartGame();

        org.assertj.core.api.Assertions.assertThat(isRestart).isTrue();
    }

    @DisplayName("사용자의 입력이 0인 경우 true을 반환 해야함")
    @Test
    void invalid_restart_game_test(){
        ConsoleInput restartInput = new TestConsoleInput("0");
        BaseBallConsoleInput consoleInput = new BaseBallConsoleInput(restartInput);

        boolean isRestart = consoleInput.restartGame();

        org.assertj.core.api.Assertions.assertThat(isRestart).isFalse();
    }

    static class TestConsoleInput implements ConsoleInput{
        private final String input;
        public TestConsoleInput(String input){
            this.input = input;
        }
        @Override
        public String readLine() {
            return input;
        }
    }
}
