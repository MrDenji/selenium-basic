package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;

public class CartItem {
    WebElement itemElement;
    public String qtyCSS = ".js-cart-line-product-quantity";
    public String totalPriceCSS = ".product-line-actions .product-price";

    public CartItem(WebElement itemElement) {
        this.itemElement = itemElement;
    }

    public int getQty(){
        return Integer.parseInt(itemElement.findElement(By.cssSelector(qtyCSS)).getAttribute("value"));
    }
    public String getTotalPrice(){
       return itemElement.findElement(By.cssSelector(totalPriceCSS)).getText();
    }
}
