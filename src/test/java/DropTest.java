import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropTest extends TestBase{
    @Test
    public void verifyDropping1() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).perform();

        Thread.sleep(1000);
        actions.clickAndHold(drag).release().perform();

        Assert.assertEquals(drop.getText(),"Dropped!");
        Thread.sleep(1000);
    }
    @Test
    public void verifyDropping2() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();


        Assert.assertEquals(drop.getText(),"Dropped!");
        Thread.sleep(1000);
    }
    @Test
    public void verifyDropping3() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(drop.getLocation().getX()-drag.getLocation().getX(),0).release().perform();
        Thread.sleep(1000);
        Assert.assertEquals(drop.getText(),"Dropped!");
        Thread.sleep(1000);
    }
}
