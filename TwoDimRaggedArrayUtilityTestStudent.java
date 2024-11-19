import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSet1 = {{10, 20, 30}, {40, 50}, {60, 70, 80, 90}};
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(90.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
    }

}