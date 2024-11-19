
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

public class HolidayBonus {
	//three constants for bonus amounts
	private static final double HIGH_BONUS = 5000.0;
	private static final double LOW_BONUS = 1000.0;
	private static final double OTHER_BONUS = 2000.0;
		

	//constructor
	public HolidayBonus() {
		
	}

	//calculateHolidayBonus method
	public static double[] calculateHolidayBonus(double[][] data){
		int storesNumber = data.length;
		double[] bonuses = new double[storesNumber];
		int maxColumns = 0; 


	
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > maxColumns) {
				maxColumns = data[i].length;
			}
		}

		for (int col = 0; col < maxColumns; col++){
			double highestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
			double lowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

			for (int row = 0; row < storesNumber; row++) {
				if (col < data[row].length){
					double value = data[row][col];
					if (value == highestInColumn){
						bonuses[row] += HIGH_BONUS;
					}
					else if (value == lowestInColumn){
						bonuses[row] += LOW_BONUS;
					}
					else {
						bonuses[row] += OTHER_BONUS;
					}
				}
			}
		}
		return bonuses;

	}

	//calculateTotalHolidayBonus method
	public static double calculateTotalHolidayBonus(double[][] data){
		double totalBonus = 0;
		
		double[] bonuses = calculateHolidayBonus(data);
		
		for(double bonus : bonuses) {
			totalBonus += bonus;
		}
		
		return totalBonus;
	}
	
}