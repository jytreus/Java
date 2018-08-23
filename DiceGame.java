import java.util.*;

public class DiceGame {
  public static void main(String[] args) {
    
	 Scanner console = new Scanner(System.in);
    
	 Random random = new Random();
    int wallet = 0;

    int x = getNumber(console);
    
	 
	 while (x != 0) {
      int y = random.nextInt(6) + 1;
      
		boolean checker = checkWin(x, y);
      System.out.println("The computer rolled a " + y);
     
	   if (checker) {
        wallet += 51;
        System.out.println("You won $51, and your new balance is $" + wallet);
      } else {
        wallet -= 10;
        System.out.println("You lost $10, and your new balance is $" + wallet);
      }
      x = getNumber(console);
    }
    System.out.println("Your final balance is: $ " + wallet);
  }

 
  public static int getNumber(Scanner console) {
    System.out.print("Pick a number from 1 to 6, enter 0 to quit: ");
    return console.nextInt();
  }

  public static boolean checkWin(int aNumber1, int aNumber2) {
    return aNumber1 == aNumber2;
  }
}