package baseball.result;

public class BaseBallResult {
    public final int ballCount;
    public final int strikeCount;

    public BaseBallResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isWin() {
        return strikeCount == 3;
    }
}
