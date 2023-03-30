import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends TestBase{
    @Test
    public void completeProgressBar(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBar = driver.findElement(By.id("progressbar"));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar,"Complete!"));
    }
    @Test
    public void completeProgressBar2(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement progressBar = driver.findElement(By.cssSelector("#progressbar>div:last-of-type"));
        wait.until(ExpectedConditions.attributeContains(progressBar, "class", "ui-progressbar-complete"));
    }
}
