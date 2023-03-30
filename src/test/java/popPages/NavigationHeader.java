package popPages;

import org.openqa.selenium.By;

public class NavigationHeader extends BasePage{
    protected String logoCSS = "#_desktop_logo a";
    public void clickStoreLogo() {

        driver.findElement(By.cssSelector(logoCSS)).click();
        homePage = new HomePage();
    }
}
