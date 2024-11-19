
/*
 * Class: CMSC203 21475
 * Instructor: Prof G
 * Description: Utility classes which manipulates 2D ragged array and utility class which calculate holiday bonuses
 * Due: 11/18/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: David Pichardo
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility(){
		//constructor
	}

	//2D ragged array method
	public static double[][] readFile(File file) throws FileNotFoundException {
		int numRows = 0;
		Scanner inputFile = new Scanner(file);

		while(inputFile.hasNextLine()){
			inputFile.nextLine();
			numRows++;
		}
		
		inputFile.close();
		inputFile = new Scanner(file);
			

		
		double [][] data = new double [numRows][];
		
		for (int i = 0; i < numRows; i++){
			String[] numbers;
		
			numbers = inputFile.nextLine().split(" ");
			data[i] = new double[numbers.length];
			
			
			for (int h = 0; h < numbers.length; h++) {
				data[i][h] = Double.parseDouble(numbers[h]);
			}
			
		}
		
		inputFile.close();
		return data;
		
	}


	//writeToFile method
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		try (PrintWriter write = new PrintWriter(outputFile)){
			for (int i = 0; i < data.length; i++) {
				for (int h = 0; h < data[i].length; h++){
					write.print(data[i][h] + " ");
				}
				write.println();
			}
		}
	}

	
	//getTotal method
	public static double getTotal(double[][] data){
		double total = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int h = 0; h < data[i].length; h++){
				total += data[i][h];
			}
		}
		return total;
	}

	//getAverage method
	public static double getAverage(double[][] data){
		int count = 0;
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			for (int h = 0; h < data[i].length; h++){
				total += data[i][h];
				count++;
			}
		}

		if (count == 0) {
			return 0;
		}
	
		else {
			return total / count;
		}
		
		
	}

	
	//getRowTotal method
	public static double getRowTotal(double[][] data, int row){
		double total = 0;
		
		for(int i = 0; i < data[row].length; i++){
			total += data[row][i];
		}
		
		return total;
		
	}


	//getColumnTotal method
	public static double getColumnTotal(double[][] data, int col){
		double total = 0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length){
				total += data[row][col];
			}
		}

		return total;
	}

	
	//getHighestInRow method
	public static double getHighestInRow(double[][] data, int row){
		double highestValue = Double.MIN_VALUE;

		if (row >= 0 && row < data.length){
			for (int i = 0; i < data[row].length; i++) {
				if (data[row][i] > highestValue) {
					highestValue = data[row][i];
				}
			}
		}
		return highestValue;
	}

	
	public static int getHighestInRowIndex(double[][] data, int row){
		int highestIndex = -1;
		double highestValue;
		
		if (row >= 0 && row < data.length) {
			highestValue = Double.MIN_VALUE;
			for (int i = 0; i < data[row].length; i++){
				if(data[row][i] > highestValue) {
					highestValue = data[row][i];
					highestIndex = i;
				}
			}
		}
		return highestIndex;
	}

	//getLowestInRow method
	public static double getLowestInRow(double[][] data, int row){
		double lowestValue = Double.MAX_VALUE;
	
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowestValue) {
				lowestValue = data[row][i];
			}
		}
		
		return lowestValue;
	}
	

	//getLowestInRowIndex method
	public static int getLowestInRowIndex(double[][] data, int row){
		int lowestIndex = -1;
		double lowestValue;

		if (row >= 0 && row < data.length) {
			lowestValue = Double.MAX_VALUE;
		
			for (int i = 0; i < data[row].length; i++){
				if (data[row][i] < lowestValue) {
					lowestValue = data[row][i];
					lowestIndex = i;
				}
			}
		}
		return lowestIndex;
	}


	//getHighestInColumn method
	public static double getHighestInColumn(double[][] data, int col){
		double highestValue = Double.MIN_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			if (col >= 0 && col < data[row].length) {
				if(data[row][col] > highestValue) {
					highestValue = data[row][col];
				}
			}
		}
		return highestValue;
	}


	//getHighestInColumnIndex method
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highestIndex = -1;
		
		for (int i = 0; i < data.length; i++) {
			if (col >= 0 && col < data[i].length) {
				if (highestIndex == -1 || data[i][col] > data[highestIndex][col]) {
					highestIndex = i;
				}
			}
		}
		return highestIndex;
	}


	//getLowestInColumn method
	public static double getLowestInColumn(double[][] data, int col){
		double lowestValue = Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			if (col >= 0 && col < data[row].length) {
				if(data[row][col] < lowestValue) {
					lowestValue = data[row][col];
				}
			}
		}
		return lowestValue;
	}

	//getLowestInColumnIndex method
	public static int getLowestInColumnIndex(double[][] data, int col){
		int lowestIndex = -1;
	
		for (int i = 0; i < data.length; i++) {
			if(col >= 0 && col < data[i].length) {
				if (lowestIndex == -1 || data[i][col] < data[lowestIndex][col]) {
					lowestIndex = i;
				}
			}
		}
		return lowestIndex;
	}

	//getHighestInArray method
	public static double getHighestInArray(double[][] data){
		double highestValue = Double.MIN_VALUE;
		
		for (int row = 0; row < data.length; row++){
			for(int col = 0; col < data[row].length; col++){
				if (data[row][col] > highestValue) {
					highestValue = data[row][col];
				}
			}
		}
		return highestValue;
	}

	//getLowestInArray method
	public static double getLowestInArray(double[][] data){
		double lowestValue = Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++){
			for (int col = 0; col < data[row].length; col++){
				if (data[row][col] < lowestValue) {
					lowestValue = data[row][col];
				}
			}
		}
	return lowestValue;
	}
}