import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DynamicControlsTests extends BaseTest {




    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void dynamicControlsTests() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        Assert.assertEquals(numberOfCheckboxes, 0, "Check if the checkbox is not there");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertFalse(input.isEnabled(), "Check that the input is disabled");
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));
        Assert.assertTrue(input.isEnabled(), "Check that the input is enabled");













    }
}
