import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkboxesTests() {
        WebElement firstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        WebElement secondCheckbox = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        Assert.assertFalse(firstCheckbox.isSelected(),
                "Checking if the first checkbox is unchecked");
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(),
                "Marked the first checkbox, checked that it is checked");
        Assert.assertTrue(secondCheckbox.isSelected(),
                "Checked that the second checkbox is checked");
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(),
                "Made uncheck in the second checkbox, checked that it was unchecked");


    }
}
