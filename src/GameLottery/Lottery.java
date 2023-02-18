package GameLottery;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Lottery {

    int [] winCombination;

    public boolean checkElementArray(int[]array, int number) {
        boolean isNumberUnique = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                isNumberUnique = false;
                break;
            }
        }
        return isNumberUnique;
    }

    public int [] enterPlayerCombination() {
        int [] playerCombination = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter in order 5 numbers in range 1 - 50:");
        for (int i = 0; i < playerCombination.length; i++) {
            int nextNumber;
            while (true) {
                try {
                    nextNumber = scanner.nextInt();
                    if (nextNumber>0 & nextNumber <=51){
                        if (checkElementArray(playerCombination, nextNumber)){
                            playerCombination[i] = nextNumber;
                            break;
                        }
                        else {
                            System.out.println("Number is not unique, please choose another number:");
                        }
                    }
                    else {
                        System.out.println("Please use number in range 1 - 50");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter valid data! Use only numbers in range 1 - 50.");
                    scanner.next();
                }
            }
        }
        return playerCombination;
    }

    public int [] generateAiCombination() {
        int [] lotteryCombination = new int[5];
        lotteryCombination[0] = (int) (Math.random()*(50)+1);
        for (int i = 1; i < lotteryCombination.length; i++) {
            int nextNumber = (int) (Math.random()*(50)+1);
            while (!checkElementArray(lotteryCombination, nextNumber)) {
                nextNumber = (int) (Math.random()*(50)+1);
            }
            lotteryCombination[i] = nextNumber;
        }
        return lotteryCombination;
    }
    public int [] generateWinCombination() {
        this.winCombination = generateAiCombination();
        return winCombination;
    }
    public void printWinCombination() {
        System.out.print("The win combination is following: ");
        System.out.println(Arrays.toString(winCombination));
    }
    public int checkWin(int playerCombo[], int winCombo[]){
        int result = 0;
        for (int i = 0; i < playerCombo.length; i++) {
            for (int j = 0; j < winCombo.length; j++) {
                if (playerCombo[i]==winCombo[j]){
                    result++;
                }
            }
        }
        return result;
    }
    public void showGuessedNumbers(String player, int playerCombo[], int winCombo[]){
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < playerCombo.length; i++) {
            for (int j = 0; j < winCombo.length; j++) {
                if (playerCombo[i]==winCombo[j]){
                    stringBuilder.append(playerCombo[i]);
                    stringBuilder.append(" ");
                    counter++;
                }
            }
        }
        if (counter>0){
            System.out.println("Player " + player + ", you've guessed number(s):" + stringBuilder);}
    }
    public void calculatePrize (String player, int guessedNumbers){
        switch (guessedNumbers) {
            case 1:
                System.out.println("Congratulations "+player+", for guessed 1 number you win $10 :)");
                break;
            case 2:
                System.out.println("Congratulations "+player+", for guessed 2 numbers you win $100 :)");
                break;
            case 3:
                System.out.println("Congratulations "+player+", for guessed 3 numbers you win $1.000 :)");
                break;
            case 4:
                System.out.println("Congratulations "+player+", for guessed 4 numbers you win $10.000 :)");
                break;
            case 5:
                System.out.println("Congratulations "+player+", for guessed 5 numbers you win $100.000 :)");
                break;
            case 0:
                System.out.println("Sorry "+player+", you didn't win. Try next time :)");
        }
    }
    public boolean continueGame(){
        boolean continueGame = false;
        System.out.println("Do you want to play again?  1 - yes / any other symbol - no");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (Objects.equals(answer, "1")){
            continueGame = true;
        } else {
            System.out.println("Good-bye!");
        }
        return continueGame;
    }
    public void game() throws InterruptedException {
        boolean continueGame = true;
        System.out.println("Hello. This is the lottery game. You play with AI.");
        Thread.sleep(1500);
        while (continueGame) {
            AiLotteryPlayer aiLotteryPlayer = new AiLotteryPlayer();
            UserLotteryPlayer userLotteryPlayer = new UserLotteryPlayer();
            generateWinCombination();
            Thread.sleep(1000);
            System.out.println("So, there are your cards, AI cards and win combination:");
            System.out.println();
            Thread.sleep(1200);
            System.out.println(aiLotteryPlayer);
            Thread.sleep(1200);
            System.out.println(userLotteryPlayer);
            Thread.sleep(1200);
            printWinCombination();
            Thread.sleep(1200);
            System.out.println();
            System.out.println(". . . generating the results of GameLottery.Lottery . . .");
            System.out.println();
            Thread.sleep(1200);
            showGuessedNumbers(aiLotteryPlayer.aiName, aiLotteryPlayer.getAiCombination(), winCombination);
            calculatePrize(aiLotteryPlayer.aiName, checkWin(aiLotteryPlayer.getAiCombination(), winCombination));
            showGuessedNumbers(userLotteryPlayer.userName, userLotteryPlayer.getUserCombination(), winCombination);
            calculatePrize(userLotteryPlayer.userName, checkWin(userLotteryPlayer.getUserCombination(), winCombination));
            System.out.println();
            continueGame = continueGame();
        }
    }
}
