import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class SliderTests extends TestBase {
    @Test
    public void verifySliderWithArrows() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/slider.php");

        WebElement slider = driver.findElement(By.id("custom-handle"));

        slideTo(slider, 50);
        Thread.sleep(3000);
        slideTo(slider, 30);
        Thread.sleep(3000);
        slideTo(slider, 30);
        Thread.sleep(3000);
        slideTo(slider, 20);
        Thread.sleep(3000);
        Assert.assertEquals(slider.getText(),"20");
    }

    private void slideTo(WebElement slider, int posTo){
        int pos = Integer.parseInt(slider.getText());
        Keys key;
        if(pos==posTo){
            return;
        } else if (pos<posTo) {
            key = Keys.ARROW_RIGHT;
        }else{
            key = Keys.ARROW_LEFT;
        }

        while (Integer.parseInt(slider.getText())!=posTo){
            slider.sendKeys(key);
        }

    }
}
