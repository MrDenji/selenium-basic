import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MykTest extends TestBase {
    @BeforeMethod
    public void testSetup() {
        driver.get("file:///C:/Users/Kamil/Desktop/TESTER%20AUTOMATYZUJ%C4%84CY/Automation%20Pratice.html");

    }
    @Test
    public void  test1() throws InterruptedException {
        Thread.sleep(5000);
    }

}
