import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class MyStoreSimpleTest extends TestBase{
    @Test
    public void happyPath() throws InterruptedException {
        driver.get("http://146.59.32.4/index.php");

        //kliknij w Adventure poster
        driver.findElement(By.linkText("THE ADVENTURE POSTER")).click();
        String currentPriceModal = driver.findElement(By.cssSelector(".current-price")).getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //zmien rozmiar na inny
        List<WebElement> variants = driver.findElements(By.cssSelector(".product-variants>div"));
        for (WebElement variant : variants){
            if(variant.findElement(By.cssSelector("span")).getText().equals("Dimension")){
                WebElement dimensionWE = variant.findElement(By.cssSelector("select"));
                Select dimension = new Select(dimensionWE);
                dimension.selectByVisibleText("60x90cm");

                //poczekaj aż zniknie stara cena
            //  try {
            //      wait.until(ExpectedConditions.stalenessOf(currentPriceModal));
            //  }
            //  catch (TimeoutException e){}

                try {
                    wait.until(c -> !driver.findElement(By.cssSelector(".current-price")).getText().equals(currentPriceModal));
                }
                catch (TimeoutException ignored){}
                break;
            }
        }

        //zmien ilosc na 3
        WebElement qty = driver.findElement(By.id("quantity_wanted"));
        qty.clear();
        qty.sendKeys("3");
        //dodaj do koszyka
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".modal-content .product-quantity>strong"))));
       int qtyFromModel = Integer.parseInt(driver.findElement(By.cssSelector(".modal-content .product-quantity>strong")).getText());
       Assert.assertEquals(qtyFromModel, 3);
        // WebElement proceedButton = driver.findElement(By.cssSelector(".cart-content-btn a"));
        // wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
        driver.findElement(By.cssSelector(".cart-content-btn button")).click();

        //nacisnij na logo strony
        driver.findElement(By.cssSelector("#_desktop_logo a")).click();

        //kliknij quickview na hummingbird t-shirt
        List<WebElement> articles = driver.findElements(By.cssSelector(".featured-products article"));

        for(WebElement article : articles){
            WebElement prodTitle = article.findElement(By.cssSelector("h3.product-title a"));
            WebElement quickViewA = article.findElement(By.cssSelector("a.quick-view"));
            if (prodTitle.getText().equals("HUMMINGBIRD T-SHIRT")){
                Actions actions = new Actions(driver);
                actions.moveToElement(prodTitle).build().perform();
                wait.until(ExpectedConditions.visibilityOf(quickViewA));
                quickViewA.click();
                //czekaj na modal
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("add-to-cart"))));

                //zmien kolor na czarny
                List<WebElement> variantsModal = driver.findElements(By.cssSelector(".modal-content .product-variants-item"));
                for (WebElement var : variantsModal){
                   if (var.findElement(By.cssSelector("span.control-label")).getText().equals("Color")){
                       var.findElement(By.cssSelector("input[title=\"Black\"")).click();

                       try {
                           wait.until(c -> !driver.findElement(By.cssSelector(".current-price")).getText().equals(currentPriceModal));
                       }
                       catch (TimeoutException ignored){}
                       break;
                   }
                }

                //zmien ilosc na 2
                WebElement qtyModal = driver.findElement(By.id("quantity_wanted"));
                qtyModal.clear();
                qtyModal.sendKeys("2");

                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("add-to-cart")))).click();

                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".modal-content .product-quantity>strong"))));
                int qtyFromModal = Integer.parseInt(driver.findElement(By.cssSelector(".modal-content .product-quantity>strong")).getText());
                Assert.assertEquals(qtyFromModal, 2);

                //przejdź do koszyka
                driver.findElement(By.cssSelector(".cart-content-btn a")).click();


                break;
            }
        }

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item"));
        Assert.assertEquals(cartItems.size(), 2);

        WebElement cartItem = cartItems.get(1);
        String currItemPrice = cartItem.findElement(By.cssSelector(".product-price>strong")).getText();
        cartItem.findElement(By.cssSelector("button.js-increase-product-quantity")).click();

   //     wait.until(c-> !cartItem.findElement(By.cssSelector(".product-price>strong")).getText().equals(currItemPrice));
            wait.until(ExpectedConditions.stalenessOf(cartItem));

            cartItems = driver.findElements(By.cssSelector(".cart-item"));

        Thread.sleep(5000);

    }

}
