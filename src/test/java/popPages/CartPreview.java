package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPreview extends BasePage{

    public CartPreview() {
        _waitForModal();
    }

    private void _waitForModal() {
        //czekaj na modal
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".cart-content-btn button"))));
    }

    public void clickContinueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".cart-content-btn button"))));
        driver.findElement(By.cssSelector(".cart-content-btn button")).click();
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".cart-content-btn button"))));
        driver.findElement(By.cssSelector(".cart-content-btn a")).click();
        cartPage = new CartPage();
    }
}
