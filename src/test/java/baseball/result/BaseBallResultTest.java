package baseball.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallResultTest {

    @DisplayName("strike count가 3인 경우 isWin은 true를 반환해야한다.")
    @Test
    void valid_is_win_test() {
        BaseBallResult result = new BaseBallResult(0, 3);
        Assertions.assertThat(result.isWin()).isTrue();
    }

    @DisplayName("strike count가 3이 아닌 경우 isWin은 false를 반환해야한다.")
    @Test
    void invalid_is_win_test() {
        BaseBallResult result = new BaseBallResult(0, 0);
        Assertions.assertThat(result.isWin()).isFalse();
    }
}
