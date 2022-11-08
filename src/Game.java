import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET_BACKGROUND = "\u001B[49m";


    private static Player playerOne;
    private static Player playerTwo;
    private static int numberOfMonsters;

    private static Fairy fairy = new Fairy();
    private static Witch witch = new Witch();

    public static void gameOn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player One name:");
        playerOne = new Player(ANSI_CYAN_BACKGROUND + scanner.next() + ANSI_RESET_BACKGROUND);
        System.out.print("Player Two name:");
        playerTwo = new Player(ANSI_PURPLE_BACKGROUND + scanner.next() + ANSI_RESET_BACKGROUND);

        System.out.println("Choose how many monsters you want for each team");
        numberOfMonsters = scanner.nextInt();

        System.out.println("1- Werewolf|🐺|");
        System.out.println("2- Vampire|🧛‍|");
        System.out.println("3- Mummy|👳‍|");

        System.out.println(playerOne.getPlayerName() + " choose your Monsters:");
        for (int i = 0; i < numberOfMonsters; i++) {
            System.out.print("Monster " + (i + 1) + ": ");
            playerOne.addMonster(scanner.nextInt());
        }
        System.out.println(playerTwo.getPlayerName() + " choose your Monsters:");
        for (int i = 0; i < numberOfMonsters; i++) {
            System.out.print("Monster " + (i + 1) + ": ");
            playerTwo.addMonster(scanner.nextInt());
        }

        playerOne.seeMonsters();
        playerTwo.seeMonsters();

        match();

        //Win
        if (playerOne.numberOfMonsters() > playerTwo.numberOfMonsters()) {
            playerOne.win();
        } else {
            playerTwo.win();
        }
    }


    public static void match() {
        Scanner scanner = new Scanner(System.in);
        int rounds = 1;
        while (playerOne.numberOfMonsters() > 0 && playerTwo.numberOfMonsters() > 0) {

            System.out.println("Press R to start a new round!");
            String go = scanner.next();
            int typeRoundProb = (int) Math.floor(Math.random() * 100);

            System.out.println("ROUND " + rounds + " :");
            System.out.println("FIGHT⚔️");

            if (typeRoundProb >= 20) {
                normalRound();
            } else {
                obstacleRound();
            }
            rounds++;
        }
    }

    public static boolean checkAliveWitch() {
        if (witch.getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public static void normalRound() {
        int playerOneRandom = (int) Math.floor(Math.random() * (playerOne.getMyMonsters().size()));
        int playerTwoRandom = (int) Math.floor(Math.random() * (playerTwo.getMyMonsters().size()));
        Monster playerOneMonster = playerOne.getMyMonsters().get(playerOneRandom);
        Monster playerTwoMonster = playerTwo.getMyMonsters().get(playerTwoRandom);

        System.out.println(playerOne.getPlayerName() + "'s " + playerOneMonster.getName() + " attacked " + playerTwo.getPlayerName() + "'s " + playerTwoMonster.getName());
        fight(playerOneMonster, playerTwoMonster);

        System.out.println(playerTwo.getPlayerName() + "'s " + playerTwoMonster.getName() + " attacked " + playerOne.getPlayerName() + "'s " + playerOneMonster.getName());
        fight(playerTwoMonster, playerOneMonster);


        playerOne.checkMonsters();
        playerTwo.checkMonsters();
        playerOne.seeMonsters();
        playerTwo.seeMonsters();
    }

    public static void obstacleRound() {
        int obstacleType = (int) Math.floor(Math.random() * 100);
        if (obstacleType > 35 && checkAliveWitch()) {
            witchFight();
        }
        if (obstacleType <= 35) {
            fairyFight();
        }
    }

    public static void fight(Monster monsterOne, Monster monsterTwo) {
        monsterTwo.sufferDamage(monsterOne.attack());
    }

    public static void fairyFight() {
        System.out.println(ANSI_RED_BACKGROUND + "The fairy appeared, and she doesn't look happy..." + ANSI_RESET_BACKGROUND);
        int playerOneRandom = (int) Math.floor(Math.random() * (numberOfMonsters - 1));
        int playerTwoRandom = (int) Math.floor(Math.random() * (numberOfMonsters - 1));
        Monster playerOneMonster = playerOne.getMyMonsters().get(playerOneRandom);
        Monster playerTwoMonster = playerTwo.getMyMonsters().get(playerTwoRandom);

        System.out.println(fairy.getName() + " attacked " + playerOne.getPlayerName() + "'s " + playerOneMonster.getName());
        playerOneMonster.sufferDamage(fairy.attack());

        System.out.println(fairy.getName() + " attacked " + playerTwo.getPlayerName() + "'s " + playerTwoMonster.getName());
        playerTwoMonster.sufferDamage(fairy.attack());
    }

    public static void witchFight() {
        System.out.println(ANSI_RED_BACKGROUND + "The witch appeared, and well... she is a witch, so..." + ANSI_RESET_BACKGROUND);
        int playerOneRandom = (int) Math.floor(Math.random() * (numberOfMonsters - 1));
        int playerTwoRandom = (int) Math.floor(Math.random() * (numberOfMonsters - 1));
        Monster playerOneMonster = playerOne.getMyMonsters().get(playerOneRandom);
        Monster playerTwoMonster = playerTwo.getMyMonsters().get(playerTwoRandom);

        System.out.println(witch.getName() + " attacked " + playerOne.getPlayerName() + "'s " + playerOneMonster.getName());
        playerOneMonster.sufferDamage(witch.attack());

        System.out.println(playerOne.getPlayerName() + " attacked " + witch.getName());
        witch.sufferDamage(witch.attack());

        System.out.println(witch.getName() + " attacked " + playerTwo.getPlayerName() + "'s " + playerTwoMonster.getName());
        playerTwoMonster.sufferDamage(witch.attack());

        System.out.println(playerTwo.getPlayerName() + " attacked " + witch.getName());
        witch.sufferDamage(witch.attack());

        System.out.println(ANSI_RED_BACKGROUND + "Witch Health: " + witch.getHealth() + "❤️"+ANSI_RESET_BACKGROUND);
    }

}
