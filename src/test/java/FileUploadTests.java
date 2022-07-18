import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTests extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void fileUploadTests() {
        File file = new File("src\\test\\java\\Resources\\Test.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBe(By.tagName("h3"), "File Uploaded!"));
        String expectedResult = "Test.jpg";
        String actualResult = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Checking the title of the uploaded image");


    }
}
