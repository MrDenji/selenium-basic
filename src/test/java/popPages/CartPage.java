package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    protected String cartItemsCSS = ".cart-item";
    List<CartItem> cartItems = new ArrayList<>();
    public CartPage(){
        readItems();
    }
    private void readItems(){
        List<WebElement> cartItemsWE = driver.findElements(By.cssSelector(cartItemsCSS));
        for (WebElement item: cartItemsWE) {
            cartItems.add(new CartItem(item));
        }
    }
    public void verifyItemsInCart(int amount) {
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart-item"));
        Assert.assertEquals(cartItems.size(), amount);
    }
    public int getItemsCount(){
        return driver.findElements(By.cssSelector(cartItemsCSS)).size();
    }

    public CartItem getItem(int i) {
        return cartItems.get(i);
    }
}
