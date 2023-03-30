package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{

    public static void open() {
        driver.get("http://146.59.32.4/index.php");
        homePage = new HomePage();

    }

    public void openProductByName(String title) {
        driver.findElement(By.linkText(title)).click();
        productPage = new ProductPage();
    }

    public void previewProductByName(String productName) {
        List<WebElement> articles = driver.findElements(By.cssSelector(".featured-products article"));

        for(WebElement article : articles) {
            WebElement prodTitle = article.findElement(By.cssSelector("h3.product-title a"));
            WebElement quickViewA = article.findElement(By.cssSelector("a.quick-view"));
            if (prodTitle.getText().equals(productName)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(prodTitle).build().perform();
                wait.until(ExpectedConditions.visibilityOf(quickViewA));
                quickViewA.click();
                productPreview = new ProductPreview();
            break;
            }
        }
    }
}
