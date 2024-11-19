import static org.junit.Assert.*;

import org.junit.Test;

public class HolidayBonusTestStudent {
	@Test
	public void testCalculateHolidayBonus() {
	    double[][] dataSet1 = { { 12, 22, 32 }, { 42, 52 }, { 62, 72, 82 } };

	    try {
	        double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
	        assertEquals(10000.0, result[0], 0.001); 
	        assertEquals(8000.0, result[1], 0.001); 
	        assertEquals(18000.0, result[2], 0.001); 
	    } catch (Exception e) {
	        fail("This should not have caused an Exception");
	    }
	}

	@Test
	public void testCalculateTotalHolidayBonus() {
	    double[][] dataSet2 = { { 14, 24, 34 }, { 44, 54, 64 }, { 74, 84 } };

	    assertEquals(38000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), 0.001); 
	}
}