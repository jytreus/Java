import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FrequentAndDeviator {

	public String userInput;
	public static ArrayList<Double>  convertedList;

	public FrequentAndDeviator(){

	}
	public void getInput(){
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a list of numbers seperated with comma's.");
		System.out.println("ex: 2,2,4,7,3.4,...");
		userInput = scn.nextLine();
		String[] numbArray = userInput.trim().split(",");
		this.convertedList = new ArrayList<Double>();
		for(int i = 0; i < numbArray.length; i++){
			double temp = Double.parseDouble(numbArray[i]);
			this.convertedList.add(temp);
		}
	}
	// AKA THE MODE FUNCTION
	public void frequent(){
		Map<Double,Integer> map = new HashMap<Double, Integer>();
		for(int i=0;i<this.convertedList.size();i++){            
			Integer count = map.get(this.convertedList.get(i));       
			map.put(this.convertedList.get(i), count==null?1:count+1);   //auto boxing and count
		}
		//System.out.println(map.toString());
		Set mapSet = (Set) map.entrySet();
		Iterator mapIterator = mapSet.iterator();
		Double mostFrequentNumber = 0.0;
		Integer occur =0;
		while (mapIterator.hasNext()) 
		{
			Map.Entry mapEntry = (Map.Entry) mapIterator.next();
			Double keyValue =  (Double) mapEntry.getKey();
			Integer value =  (Integer) mapEntry.getValue();
			if(value > occur){
				occur = value;
				mostFrequentNumber = keyValue;
			}
		}
		System.out.println();
		System.out.println("The Most Frequent Number is: " +mostFrequentNumber+ " Occurrences: "+ occur);
	}
	public void AvgPlusDev(int precision){
		System.out.println("Your numbers: are");
		for(Double d : this.convertedList){
			System.out.print(d+ "  ");
		}
		System.out.println("");
		double addedNums = 0.0;
		int denominator = this.convertedList.size();
		System.out.print("The Averages of them is ");
		for(Double d : this.convertedList){
			addedNums = addedNums + d;
		}
		Double average = new Double(addedNums/denominator);
		BigDecimal bg1,bg2;
		bg1 = new BigDecimal(average);
		bg2 = bg1.setScale(precision, RoundingMode.HALF_UP);
		System.out.println(bg2);
	}
	public void findDeviation(int precision) {
		System.out.print("The Standard Deviation is: ");
		ArrayList<Double> temp = convertedList;
		double mean = 0;
		double sum = 0;
		//double stdDeviation = 0;
		for(Double d : convertedList){
			sum = sum + d;
		}
		mean = sum / convertedList.size();
		double squareSum = 0;
		for(Double d : temp){
			squareSum += Math.pow(d.doubleValue() - mean, 2);
		}
		Double stdDeviation = new Double(  Math.sqrt((squareSum) / (convertedList.size() - 1)));
		BigDecimal bg1,bg2;
		bg1 = new BigDecimal(stdDeviation);
		bg2 = bg1.setScale(precision, RoundingMode.HALF_UP);
		System.out.println(bg2);
		System.out.println();
	}
	public double findMean() {
		double sum = 0;
		for(Double d : this.convertedList){
			sum = sum + d;
		}
		return sum / convertedList.size();
	}

}
