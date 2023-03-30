import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormTest extends TestBase{
    @Test
    public void shouldFillFormWithSuccess() throws InterruptedException {
        driver.get("http://51.75.61.161:9102/form.php");
        WebElement firstName = driver.findElement(By.id("inputFirstName3"));

        firstName.sendKeys("Jan");
        WebElement lastName = driver.findElement(By.id("inputLastName3"));

        lastName.sendKeys("Kowalski");
        WebElement email = driver.findElement(By.id("inputEmail3"));

        email.sendKeys("jkowal@mail.pl");

        List<WebElement> gender = driver.findElements(By.name("gridRadiosSex"));
        for (WebElement element : gender){
            if(element.getAttribute("value").equals("other")){
                element.click();
                break;
            }
        }


        WebElement age = driver.findElement(By.id("inputAge3"));
        age.clear();
        age.sendKeys("28");

        List<WebElement> exp = driver.findElements(By.name("gridRadiosExperience"));
        for (WebElement element : exp){
            if(element.getAttribute("value").equals("4")){
                element.click();
                break;
            }
        }
        List<String> professions = Arrays.asList("other", "manual tester");
        List<WebElement> professionsLabels = driver.findElements(By.cssSelector("*[name=\"gridCheckboxProfession\"]+label"));
        for (WebElement label : professionsLabels){
            if (professions.contains(label.getText().trim().toLowerCase())) {
                label.click();
            }
        }

        //WebElement continent = driver.findElement(By.id("selectContinents"));
        Select continent = new Select(driver.findElement(By.id("selectContinents")));
        continent.selectByIndex(2);

        Select sCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        List<String> commands = Arrays.asList("navigation-commands", "wait-commands");
        for (String val : commands) {
            sCommands.selectByValue(val);
        }

        File file = new File("src//main//resources//file");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());



        driver.findElement(By.cssSelector("button[type = \"submit\"]")).click();
        Thread.sleep(5000);
    }


}
