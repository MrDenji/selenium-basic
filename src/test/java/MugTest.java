import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MugTest extends TestBase{
    @Test
    public void mugTest() throws InterruptedException {
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product&id_lang=2");
        driver.findElement(By.className("add-to-cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn a"))).click();

        driver.findElement(By.className("remove-from-cart")).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("remove-from-cart"))));
        Assert.assertEquals(driver.findElement(By.cssSelector(".no-items")).getText(),"There are no more items in your cart");
    }
}
