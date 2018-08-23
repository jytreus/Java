import java.util.*;

public class PrintChars {

	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
		System.out.print("input a char followed by enter? ");
		char c = in.next().charAt(0);//will not get spaces
		System.out.println("Your Char '" + c + "' is numeric value: " + (int)c);
		
		System.out.println( (char)(c + 10) );
		}
		}
	}
