import org.testng.Assert;
import org.testng.annotations.Test;

public class squareTest {
    @Test
    public void isValueEqual(){
        int a = 5;
        Assert.assertEquals( a * a, 24);
    }
}
