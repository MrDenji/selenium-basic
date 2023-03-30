package popPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    public static HomePage homePage;
    public static ProductPage productPage;
    public static CartPage cartPage;
    public static CartPreview cartPreview;
    public static ProductPreview productPreview;
    public static NavigationHeader nav;

//    public BasePage() {
//        if (nav == null ) nav = new NavigationHeader();
//    }
}
