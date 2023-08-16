package baseball.output;

import baseball.result.BaseBallResult;
import baseball.view.output.BaseBallOutputMessageFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallOutputMessageFactoryTest {
    private final BaseBallOutputMessageFactory messageFactory = new BaseBallOutputMessageFactory();

    @DisplayName("BaseBallResult에서 strike count가 0이고 ball count가 0인 경우 낫싱 문자열 반환해야함")
    @Test
    void create_base_ball_result_nothing_output_test(){
        BaseBallResult result = new BaseBallResult(0,0);
        String output = messageFactory.createBaseBallResult(result);

        Assertions.assertThat(output).isEqualTo("낫싱");
    }

    @DisplayName("BaseBallResult에서 strike count가 0이고 ball count가 2인 경우 2볼 문자열 반환해야함")
    @Test
    void create_base_ball_result_ball_output_test(){
        BaseBallResult result = new BaseBallResult(2,0);
        String output = messageFactory.createBaseBallResult(result);

        Assertions.assertThat(output).isEqualTo("2볼");
    }

    @DisplayName("BaseBallResult에서 strike count가 2이고 ball count가 0인 경우 2스트라이크 문자열 반환해야함")
    @Test
    void create_base_ball_result_strike_output_test(){
        BaseBallResult result = new BaseBallResult(0,2);
        String output = messageFactory.createBaseBallResult(result);

        Assertions.assertThat(output).isEqualTo("2스트라이크");
    }
    @DisplayName("BaseBallResult에서 strike count가 2이고 ball count가 1인 경우 1볼 2스트라이크 문자열 반환해야함")
    @Test
    void create_base_ball_result_ball_and_strike_output_test(){
        BaseBallResult result = new BaseBallResult(1,2);
        String output = messageFactory.createBaseBallResult(result);

        Assertions.assertThat(output).isEqualTo("1볼 2스트라이크");
    }

}
