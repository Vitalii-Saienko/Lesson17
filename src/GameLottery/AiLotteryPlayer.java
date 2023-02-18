package GameLottery;

import java.util.Arrays;

public class AiLotteryPlayer extends Lottery {

    public int[] getAiCombination() {
        return aiCombination;
    }

    int [] aiCombination;
    String aiName;

    public AiLotteryPlayer() {

        this.aiName = "AI";
        this.aiCombination = generateAiCombination();
    }
    @Override
    public String toString() {
        return "Player " + aiName + " has next combination: " +
                Arrays.toString(aiCombination);
    }

}
