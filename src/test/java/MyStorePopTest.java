import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.annotations.Test;
import popPages.BasePage;
import popPages.HomePage;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyStorePopTest extends TestPopBase{
    @Test
    public void myStoreHappyPath() throws InterruptedException {
        List<Float> itemPrice = new ArrayList<>();
        List<Integer> itemQty = new ArrayList<>();

        HomePage.open();
        BasePage.homePage.openProductByName("THE ADVENTURE POSTER");

        BasePage.productPage.changeVariant("Dimension", "60x90cm");
        BasePage.productPage.changeQty(3);
        itemQty.add(3);
        itemPrice.add(BasePage.productPage.getPrice());
        BasePage.productPage.addToCart();
        BasePage.cartPreview.clickContinueShopping();
        BasePage.productPage.nav.clickStoreLogo();

        BasePage.homePage.previewProductByName("HUMMINGBIRD T-SHIRT");
        BasePage.productPreview.changeVariant("Size", "L");
        BasePage.productPreview.changeVariant("Color", "Black");
        BasePage.productPreview.changeQty(2);
        itemQty.add(2);
        itemPrice.add(BasePage.productPage.getPrice());
        BasePage.productPreview.addToCart();

        BasePage.cartPreview.clickProceedToCheckout();

        BasePage.cartPage.verifyItemsInCart(2);




        for (int i = 0; i < itemQty.size(); i++) {
            Assert.assertEquals(BasePage.cartPage.getItem(i).getQty(), itemQty.get(i));
            Assert.assertEquals(BasePage.cartPage.getItem(i).getTotalPrice(), formatPrice(itemQty.get(i)*itemPrice.get(i)));
        }

        Thread.sleep(2000);
    }

    private String formatPrice(Float price){
        Locale currentLocale = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("0.00", otherSymbols);


        return "$"+formatter.format(price);
    }
}
