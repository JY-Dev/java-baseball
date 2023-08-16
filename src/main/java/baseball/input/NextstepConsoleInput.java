package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class NextstepConsoleInput implements ConsoleInput {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
