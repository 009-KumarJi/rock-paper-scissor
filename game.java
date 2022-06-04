import java.util.*;

public class game {
    public static String choice(int ch){
        switch (ch){
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            default:
                return "Scissor";
        }
    }

    public static int Who_Won(int comp, int user){
        if (comp == user) return 2;
        else{
            switch(comp){
                case 0:
                    if (user==1) return 1;
                    else return 0;
                case 1:
                    if (user==2) return 1;
                    else return 0;
                default:
                    if (user==0) return 1;
                    else return 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        String userc="", cmpc="";
        int compch, userch, win = 0, lose = 0, result;
        System.out.println("Rules for Rock, Paper, Scissor: " +
                "\nType 0 for Rock\nType 1 for Paper\nType 2 for Scissor\n" +
                "There will be max 5 rounds. You'll win if you score more than 50%.");
        for (int i = 1; i < 6; i++) {
            System.out.println("\n\n\tRound "+i+":\n");
            compch = rand.nextInt(3);
            while (true) {
                System.out.print("\nEnter your choice [ wisely;) ]: ");
                userch = in.nextInt();
                if (userch < 3 && userch > -1) break;
                else System.out.println("Enter a valid option.");
            }
            userc = choice(userch);
            cmpc = choice(compch);
            result = Who_Won(compch, userch);
            switch (result) {
                case 0:
                    System.out.println("\n\tBad Luck! You Lost!\n\tComputer has chosen " + cmpc);
                    System.out.printf("Computer:%d  ;You:%d ", ++lose, win);
                    break;
                case 1:
                    System.out.println("\n\tCongo! You won!\n\tComputer has chosen " + cmpc);
                    System.out.printf("Computer:%d  ;You:%d ", lose, ++win);
                    break;
                default:
                    System.out.println("\n\tDraw!\nComputer also chosen " + cmpc);
            }
            if (win>2){
                System.out.println("Congo! You won the set! no need for more rounds");
            }
        }
        if (win==lose) System.out.println("\nTough competition! Here's your Last Golden round. " +
                "If draw, There will be one more Golden round coz draw doesn't exists in real life.");
        boolean c = true;
        while (c) {
            if (win == lose) {
                compch = rand.nextInt(3);
                while (true) {
                    System.out.print("\nEnter your choice [ wisely;) ]: ");
                    userch = in.nextInt();
                    if (userch < 3 && userch > -1) break;
                    else System.out.println("Enter a valid option.");
                }
                userc = choice(userch);
                cmpc = choice(compch);
                result = Who_Won(compch, userch);
                switch (result) {
                    case 0:
                        System.out.println("\n\tBad Luck! You Lost!\n\tComputer has chosen " + cmpc);
                        c = false;
                        break;
                    case 1:
                        System.out.println("\n\tCongo! You won!\n\tComputer has chosen " + cmpc);
                        c= false;
                        break;
                    default:
                        System.out.println("\n\tDraw!\nComputer also chosen " + cmpc);
                        System.out.println("\n\n");
                }
            }
            else if (win>lose) {
                System.out.println("\n\tCongo! You won!\n\tComputer has chosen " + cmpc);
                c= false;
            }
            else{
                System.out.println("\n\tBad Luck! You Lost!\n\tComputer has chosen " + cmpc);
                c = false;
            }
        }
    }
}
