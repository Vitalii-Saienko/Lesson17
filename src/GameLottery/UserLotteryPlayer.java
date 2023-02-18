package GameLottery;

import java.util.Arrays;
import java.util.Scanner;

public class UserLotteryPlayer extends Lottery{

    int [] userCombination;
    String userName;

    public int[] getUserCombination() {
        return userCombination;
    }

    @Override
    public String toString() {
        return "Player " + userName + " has next combination: " + Arrays.toString(userCombination);
    }

    public UserLotteryPlayer() {

        this.userName = inputUserName();
        this.userCombination = enterPlayerCombination();

    }
    public String inputUserName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who plays?:) What is your name?");
        String name = scanner.nextLine();
        return name;
    }
}
