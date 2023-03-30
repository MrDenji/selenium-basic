import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends TestBase{
    @BeforeMethod
    public void testSetup() {
        driver.get("http://51.75.61.161:9102/alerts.php");

    }

    @Test
    public void shouldAcceptAlert() throws InterruptedException {
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("simple-alert-label")).getText(), "OK button pressed");
        Thread.sleep(1000);
    }
    @Test
    public void shouldFillPromptAlert() throws InterruptedException {
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Jan");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("prompt-label")).getText(), "Hello Jan! How are you today?");
        Thread.sleep(1000);

    }
    @Test
    public void shouldDismissAlert() throws InterruptedException {
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirm-label")).getText(), "You pressed Cancel!");
        Thread.sleep(1000);
    }

    @Test
    public void iframes() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(),"This is a sample page");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        Assert.assertEquals(driver.findElement(By.id("sampleHeading")).getText(),"This is a sample page");
        Thread.sleep(1000);
    }

    @Test
    public void delayedAlertTest() throws InterruptedException {
        driver.findElement(By.id("delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("delayed-alert-label")).getText(), "OK button pressed");
        Thread.sleep(1000);
    }


}
