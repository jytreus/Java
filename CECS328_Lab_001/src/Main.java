import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws InputMismatchException{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		int precision = 2;
		while(loop) {
			
			System.out.println("");
			System.out.println("//|| Super Program 1.0 ||\\");
			System.out.println("---------------------------");
			System.out.println("|    Try TO BREAK MY MENU! |");
			System.out.println("1) Set Decimal Precision. (Currently " +precision+" places.)");
			System.out.println("2) Display the most fequent number. ");
			System.out.println("3) Display the Average and Standard Deviation.");
			System.out.println("4) Exit.");
			System.out.println("-------------------------- ");
			int choice = 0;
			boolean validInput = false;
			
			while (!validInput) {
				try {
					choice = scanner.nextInt();
					validInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Please Enter a numeric Value(1 TO 4):  .......you delinquent");
					scanner.nextLine();
				}
			}
			//int precision = 2;
			switch (choice) {
			
			case 1:
				//set decimal place
				System.out.println("How many Decimal places do you need? ");
				System.out.println("Currently set to: " + precision + " decimal places");
				precision = scanner.nextInt();
				System.out.println(precision);
				break;
			
			case 2:
				//have user enter numbers then display most frequent
				FrequentAndDeviator x = new FrequentAndDeviator();
				x.getInput();
				int size = x.convertedList.size();
				//if(x.convertedList.size()=3)
				//set breakpoint here
				x.frequent();
				break;
				
			case 3:
				//have user enter numbers then display the avg and std. deviation
				FrequentAndDeviator y = new FrequentAndDeviator();
				y.getInput();
				y.AvgPlusDev(precision);
				y.findDeviation(precision);
				break;
				
			case 4:
				//Exit
				System.out.println("Goodbye.");
				break;
				
			default:
				//user unexpected choice. retry entry
				System.out.println("Invalid choice, try again. (at least it was a number this time?)");
			}
			if(choice==4){
				loop = false;
				
			}
		}
	}
}
		


