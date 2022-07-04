import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class AddRemoveElementsTests extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementsTests() {
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.isEmpty();
        addButton.click();
        addButton.click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        int actualResult = deleteButtons.size();
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult, "Checking for the number of elements");


    }

}
