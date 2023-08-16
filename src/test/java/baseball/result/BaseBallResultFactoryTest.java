package baseball.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallResultFactoryTest {
    BaseBallResultFactory resultFactory = new BaseBallResultFactory();

    @DisplayName("유저의 입력이 432 정답이 324 일때 ball count는 3이고 strike count는 0이여야 한다.")
    @Test
    void ball_count_test() {
        int[] userInput = {4, 3, 2};
        int[] answer = {3, 2, 4};
        BaseBallResult result = resultFactory.createResult(userInput, answer);
        Assertions.assertThat(result.ballCount).isEqualTo(3);
        Assertions.assertThat(result.strikeCount).isEqualTo(0);
    }

    @DisplayName("유저의 입력이 432 정답이 432 일때 ball count는 0이고 strike count는 3이여야 한다.")
    @Test
    void strike_count_test() {
        int[] userInput = {4, 3, 2};
        int[] answer = {4, 3, 2};
        BaseBallResult result = resultFactory.createResult(userInput, answer);
        Assertions.assertThat(result.ballCount).isEqualTo(0);
        Assertions.assertThat(result.strikeCount).isEqualTo(3);
    }

    @DisplayName("유저의 입력이 432 정답이 312 일때 ball count는 1이고 strike count는 1이여야 한다.")
    @Test
    void strike_and_ball_count_test() {
        int[] userInput = {4, 3, 2};
        int[] answer = {3, 1, 2};
        BaseBallResult result = resultFactory.createResult(userInput, answer);
        Assertions.assertThat(result.ballCount).isEqualTo(1);
        Assertions.assertThat(result.strikeCount).isEqualTo(1);
    }
}
