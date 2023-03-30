package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPreview extends ProductBase{

    public ProductPreview(){
        modalCSSPrefix = ".modal-content ";
        _waitForModal();
    }

    private void _waitForModal() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".modal-content .add-to-cart"))));
    }

}
