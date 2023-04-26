package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl = "";

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();

        // Launch url
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    public void closeBrowser() {
        // close all windows
        driver.quit();
    }
}
