import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void shirtsProducts() {

        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement searchForShirts = driver.findElement(By.cssSelector(("#search")));
        searchForShirts.sendKeys("SHIRTS");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement resultMessage = driver.findElement((By.cssSelector("div.page-title > h1")));
        Assert.assertEquals(resultMessage.getText(), "SEARCH RESULTS FOR 'SHIRTS'");

}

      @Test
      public void bedAndBathProducts(){

          driver.get("https://fasttrackit.org/selenium-test/");

          WebElement searchForHome = driver.findElement(By.cssSelector(("#search")));
          searchForHome.sendKeys("home");
          driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
          Select sortByElement = new Select(driver.findElement(By.cssSelector(".category-products >.toolbar select[title='Sort By']")));
          sortByElement.selectByIndex(1);
          Assert.assertTrue(driver.findElement(By.cssSelector(".category-products > .toolbar option[value*='name']"))
                  .getAttribute("selected").contains("true"));

      }

      @Test
      public void womenProducts(){

          driver.get("https://fasttrackit.org/selenium-test/");

          WebElement searchForShirts = driver.findElement(By.cssSelector(("#search")));
          searchForShirts.sendKeys("tops");
          driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
          WebElement numberOfItems = driver.findElement((By.cssSelector(".pager p > strong")));
          Assert.assertEquals(numberOfItems.getText(), "4 Item(s)");
      }


      @After
       public void closeDriver(){
        driver.quit();
}


}
