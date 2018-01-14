import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

@Test
public class TestCalculate {

    private Calculator calculator;

    @BeforeTest
    public void init(){
        calculator = new Calculator();
    }

    public void emptyStringReturnsZero() throws Exception {
        assertEquals(0,calculator.calculate(""));
    }

    public void singleValueIsReplied() throws Exception {
        assertEquals(1, calculator.calculate("1"));
    }

    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(3,calculator.calculate("1,2"));
    }

    public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(3,calculator.calculate("1\n2"));
    }

    public void threeNumbersDelimitedBothWaysReturnSum() throws Exception {
        assertEquals(6,calculator.calculate("1,2,3"));
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeInputReturnsException() throws Exception {
        calculator.calculate("-1");
    }

    public void ignoresNumbersGreaterThan1000() throws Exception {
        assertEquals(20,calculator.calculate("10,10,1001"));
    }

}