package baseball.output;

import baseball.result.BaseBallResult;
import baseball.view.output.BaseBallOutputMessageFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallResultOutputTypeTest {
    @DisplayName("BaseBallResult에서 strike count가 0이고 ball count가 0인 경우 NOTHING을 반환해야함")
    @Test
    void nothing_test(){
        BaseBallResult result = new BaseBallResult(0,0);
        BaseBallOutputMessageFactory.BaseBallResultOutputType type = BaseBallOutputMessageFactory.BaseBallResultOutputType
                .findOutPutType(result);

        Assertions.assertThat(type).isEqualTo(BaseBallOutputMessageFactory.BaseBallResultOutputType.NOTHING);
    }

    @DisplayName("BaseBallResult에서 strike count가 0이고 ball count가 0보다 큰 경우 NOTHING을 반환해야함")
    @Test
    void ball_test(){
        BaseBallResult result = new BaseBallResult(2,0);
        BaseBallOutputMessageFactory.BaseBallResultOutputType type = BaseBallOutputMessageFactory.BaseBallResultOutputType
                .findOutPutType(result);

        Assertions.assertThat(type).isEqualTo(BaseBallOutputMessageFactory.BaseBallResultOutputType.BALL);
    }

    @DisplayName("BaseBallResult에서 strike count가 0보다 크고 ball count가 0인 경우 NOTHING을 반환해야함")
    @Test
    void strike_test(){
        BaseBallResult result = new BaseBallResult(0,2);
        BaseBallOutputMessageFactory.BaseBallResultOutputType type = BaseBallOutputMessageFactory.BaseBallResultOutputType
                .findOutPutType(result);

        Assertions.assertThat(type).isEqualTo(BaseBallOutputMessageFactory.BaseBallResultOutputType.STRIKE);
    }

    @DisplayName("BaseBallResult에서 strike count가 0이상이고 ball count가 0이상인 경우 NOTHING을 반환해야함")
    @Test
    void strike_and_ball_test(){
        BaseBallResult result = new BaseBallResult(2,2);
        BaseBallOutputMessageFactory.BaseBallResultOutputType type = BaseBallOutputMessageFactory.BaseBallResultOutputType
                .findOutPutType(result);

        Assertions.assertThat(type).isEqualTo(BaseBallOutputMessageFactory.BaseBallResultOutputType.STRIKE_AND_BALL);
    }
}
