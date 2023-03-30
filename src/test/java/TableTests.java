import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTests extends TestBase{
    @BeforeMethod
    public void testSetup() {
        driver.get("http://51.75.61.161:9102/table.php");

    }

    @Test
    public void mountainPeaksPrint(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            if(Integer.parseInt(cells.get(3).getText()) > 4000){
                System.out.println("Nazwa: "+cells.get(0).getText()
                        +"; Pasmo: "+cells.get(1).getText()
                        +"; Państwo: "+cells.get(2).getText()
                        +"; Wysokość: "+cells.get(3).getText());
            }
        }
    }
}
