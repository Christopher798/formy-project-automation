import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "/Users/christopher.wu/Development/Selenium/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        // Driver still focuses on 1st tab
        String originalHandle = driver.getWindowHandle();

        // Switch to the 2nd tab
        for (String handle2: driver.getWindowHandles()) {
            driver.switchTo().window(handle2);
        }

        driver.switchTo().window(originalHandle);

        driver.quit();
    }
}
