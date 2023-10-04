import java.util.Random;
import java.util.Scanner;
public class TextBasedGame {
    static int playerGold = 0;

    static double playerluck = 1;
    static int playertime = 10;

    static int playerbuff = 1;
    static int playerhunger = 100;
    static int playerHealth = 100 * playerbuff;
    static String playerName = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getname();

        getluck();

        buff();
        //playerHealth  = playerHealth * playerbuff;
        //System.out.println(playerluck);
        //System.out.println(playerbuff);

        returnstats();


        boolean gameover = false;

        //System.out.println("1111111");
        while (!gameover){
            //System.out.println("*******");
            mainthing();
            //System.out.println("*******");

            if (playerHealth <= 0){
                gameover = true;
                System.out.println("\n game over, you bled to death since you don't have any health left");
            }
            if (playertime <= 0){
                gameover = true;
                System.out.println("\n game over, you ran out of time");
            }
            if (playerhunger <= 0){
                gameover = true;
                System.out.println("\n you died of hunger");
            }
            if (playerGold >= 200){
                gameover = true;
                System.out.println("\n you got enough gold!");
            }
        }
        System.out.println("\n thank you for playing, this is your end result");
        returnstats();
    }


    public static void getgold(){
        Random ran = new Random();
        int gold = ran.nextInt(30) + 1;
        //System.out.println(gold + "initial gold");
        gold = (int) (gold * playerluck);// Random amount of gold (0 to 101)
        int healthlost = ran.nextInt(30) + 5;
        healthlost = (int) (healthlost * (2/playerluck));
        int chance = ran.nextInt(2) + 0;
        if (chance == 0){
            System.out.println("\nyou safely got " + gold + " gold nuggets!");
            playerGold += gold;
            playerhunger -= 15;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }
        if (chance == 1){
            System.out.println("\nyou got " + gold + " gold, but you lost " + healthlost + " health");
            playerGold += gold;
            playerHealth -= healthlost;
            playerhunger -= 15;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }
        if (chance == 2){
            System.out.println("unfortunately, you didn't find any gold, but you still lost" + healthlost + "health");
            playerHealth -= healthlost;
            playerhunger -= 15;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }

    }
    public static void findfood(){
        Random ran = new Random();
        int chance = ran.nextInt(2) + 0;
        int food = ran.nextInt(50)+10;
        food = (int) (food * playerluck);
        int healthlost = ran.nextInt(30) + 5;
        healthlost = (int) (healthlost * (2/playerluck));

        if (chance == 0){
            System.out.println("you safely got " + food + " food points!");
            playerhunger += food;
            playerhunger -= 15;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }
        if (chance == 1){
            System.out.println("you got " + food + " food, but you got injued in the process by a unicorn");
            System.out.println("you lost" + healthlost +"health points");
            playerhunger += food;
            playerhunger -= 15;
            playerhunger -= healthlost;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }
        if (chance == 2){
            System.out.println("you didn't get any food");
            playerhunger -= 15;
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);

        }
    }
    public static void rest(){
        Random ran = new Random();
        int healthgained = ran.nextInt(50)+10;
        int chance = ran.nextInt(1)+0;
        if (chance == 0){
            playerHealth += healthgained;
            System.out.println("you slept, and you got " + healthgained + " health");
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }
        else{
            System.out.println("you didn't manage to sleep last night :<");
            returninventory();
            playertime -= 1;
            System.out.println("your time left: " + playertime);
        }

    }
    public static void getluck(){
        System.out.println("the gods have decided to give you a choice! choose wisely. They might condemn you or they might reward you...");
        System.out.println("Choose either:");
        System.out.println("1. Bowl of mysterious soup");
        System.out.println("2. Bowl of mysterious fish");
        System.out.println("3. A mysterious sausage");

        int soup = wronganswer();

        if (soup == 1){
             playerluck = 2;
            System.out.println("you got double luck!");
        }
        if (soup == 2){
            playerluck = 1;
            System.out.println("you got normal luck");
        }
        if (soup == 3){
            playerluck = 0.5;
            System.out.println("you got cursed with half luck");
        }
    }
    public static void returnstats(){
        System.out.println("\nplayer you currently have the following stats:");
        System.out.println("player gold: " + playerGold);
        System.out.println("player health: " + playerHealth);
        System.out.println("player hunger: " + playerhunger);
        System.out.println("player's time left: " + playertime + " days");
    }

    public static void returninventory(){
        System.out.println("you have this much gold currently: " + playerGold + "\n you have this much health left " + playerHealth + "\n you have this much hunger left " + playerhunger);

    }

    public static void buff(){
        System.out.println("choose a random number between 1-100 to determine whether you're buff or not");

        int number = wronganswer2();
        if (number % 10 == 0){
            playerbuff = 2;
            playerHealth = playerHealth*playerbuff;
        }
        else{
            playerbuff = 1;
        }
        System.out.println("you got a buff of " + playerbuff);
    }

    public static void getname(){
        System.out.println("Hello my good people, You're in a world of dinosaurs where currently, you need to find 200 gold within 10 days in order to go back home.");
        System.out.println("Enter tribute's name");
        playerName = scanner.next();
    }

    public static void mainthing(){
        //scanner.nextLine();
        System.out.println("\n" + playerName +", you currently have a few options:");
        System.out.println("1. Go get Gold");
        System.out.println("2. Go find Food");
        System.out.println("3. rest");
        System.out.println("NOTE: each option will take a day to complete and will cost you 15 hunger points!");

        int choice = wronganswer();

        switch (choice){
            case 1: getgold();//goes and finds gold
                break;
            case 2: findfood();// goes and finds food
                break;
            case 3: rest();// goes and rests
                break;
            default: System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    public static int wronganswer(){
        // scanner = [ \n ]
        //if (scanner.hasNextLine()) scanner.nextLine();
        scanner.reset();
        int range = -1;
        while (range < 1 || range > 3) {
            try {
                range = Integer.parseInt(scanner.nextLine());
                if (range < 1) System.out.println("Range cannot be below 0!");
                if (range > 3) System.out.println("Range cannot be greater than 3!");
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
            //System.out.println("Please enter a valid number!");
        }
        return range;
    }
    public static int wronganswer2(){
        int range = -1;
        while (range < 1 || range > 100) {
            try {
                range = Integer.parseInt(scanner.nextLine());
                if (range < 1) System.out.println("Range cannot be 0 or below!");
                if (range > 100) System.out.println("Range cannot be greater than 100!");
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
            //System.out.println("Please enter a valid number!");
        }
        return range;
    }



}
