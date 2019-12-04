import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void searchValidTest(){
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        Select sortByElement = new Select(driver.findElement(By.cssSelector(".category-products >.toolbar select[title='Sort By']")));
        sortByElement.selectByIndex(2);
        driver.findElement(By.cssSelector(".category-products> .toolbar a[title='Set Descending Direction']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".category-products > .toolbar option[value*='price']"))
                .getAttribute("selected").contains("true"));

    }

    @Test
    public void sortByCategory(){
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement searchForShirts = driver.findElement(By.cssSelector(("#search")));
        searchForShirts.sendKeys("tops");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement womenProducts = driver.findElement(By.cssSelector("#narrow-by-list ol > li:nth-child(1) > a"));
        womenProducts.click();
        WebElement onlyWomenTop = driver.findElement(By.cssSelector("div.category-products > ul > li > div > h2 > a"));
        Assert.assertEquals(onlyWomenTop.getText(), "NOLITA CAMI");
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
}
