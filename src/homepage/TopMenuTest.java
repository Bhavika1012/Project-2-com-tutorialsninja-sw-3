package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        // Open browser and launch url
        openBrowser(baseUrl);
    }


    /**
     * This method is used to select menu
     * @param menu
     */
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        String menuName = "Show AllDesktops";
        // Mouse hover on Desktops Tab.and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // Click on “Show All Desktops”
        selectMenu(menuName);

        // before shorting value
        List<WebElement> beforeShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeShortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeShortValue) {
            beforeShortDesktopValue.add(value.getText());
        }
        // Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        Thread.sleep(1000);
        // After shorting value
        List<WebElement> afterShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterShortDesktopValue = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterShortValue) {
            afterShortDesktopValue.add(value1.getText());
        }

        Collections.sort(beforeShortDesktopValue, String.CASE_INSENSITIVE_ORDER);// Ascending order

        Collections.reverse(beforeShortDesktopValue); // descending order

        // Verify the Product will arrange in Descending order.
        Assert.assertEquals(beforeShortDesktopValue, afterShortDesktopValue);

    }
    @After
    public void tearDown() {
        // close all windows
        closeBrowser();
    }

}