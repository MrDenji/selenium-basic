package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductBase extends BasePage{
    protected final String currentPriceCSS = ".current-price";
    protected final String qtyCSS = "#quantity_wanted";
    protected final String addToCartCSS = ".add-to-cart";
    protected final String productVariantsCSS = ".product-variants>div";
    protected final String variantNameCSS = "span.control-label";
    protected String modalCSSPrefix = "";
    protected final String productPriceCSS = "span[itemprop=\"price\"]";
    protected String _getCSSForInputVariant(String value){
        return "input[title=\""+value+"\"]";
    }
    protected String _getModalCSS(String css){
        return modalCSSPrefix+css;
    }
    public void changeVariant(String variantName, String value) {
        String oldPrice = driver.findElement(By.cssSelector(_getModalCSS(currentPriceCSS))).getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        List<WebElement> variants = driver.findElements(By.cssSelector(_getModalCSS(productVariantsCSS)));
        for (WebElement variant : variants){
            if(variant.findElement(By.cssSelector(_getModalCSS(variantNameCSS))).getText().equals(variantName)){
                WebElement tmp = variant.findElement(By.cssSelector("select, input"));

                if (tmp.getTagName().equals("select")){
                    //obsluz jako select
                    _changeSelectVariant(variant,value);
                }
                else {
                    //osbsluz jako input
                    _changeInputVariant(variant,value);
                }
                try {
                    wait.until(c -> !driver.findElement(By.cssSelector(_getModalCSS(currentPriceCSS))).getText().equals((oldPrice)));
                }
                catch (TimeoutException ignored){}
                break;
            }
        }
    }

    private void _changeInputVariant(WebElement variant, String value) {
        variant.findElement(By.cssSelector(_getCSSForInputVariant(value))).click();
    }

    private void _changeSelectVariant(WebElement variant, String value) {
        Select dropDown = new Select(variant.findElement(By.cssSelector("select")));
        dropDown.selectByVisibleText(value);
    }

    public void changeQty(int quantity) {
        WebElement qty = driver.findElement(By.cssSelector(_getModalCSS(qtyCSS)));
        qty.clear();
        qty.sendKeys(""+quantity);
    }

    public void addToCart() {
        WebElement addToCartBtn = driver.findElement(By.cssSelector(_getModalCSS(addToCartCSS)));
        addToCartBtn.click();
        cartPreview = new CartPreview();
    }

    public Float getPrice() {
       return Float.valueOf(driver.findElement(By.cssSelector(_getModalCSS(productPriceCSS))).getAttribute("content"));
    }
}
