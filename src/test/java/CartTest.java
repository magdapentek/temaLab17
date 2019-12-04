import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;

    @Before
            public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
            public void validCartTest() throws InterruptedException {

        driver.get("https://fasttrackit.org/selenium-test/");

        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();
    WebElement addToCart = driver.findElement(By.cssSelector("div.add-to-cart-buttons"));
        addToCart.click();
    WebElement pageTitleCart = driver.findElement(By.cssSelector("div.page-title.title-buttons > h1"));
        Assert.assertEquals(pageTitleCart.getText(), "SHOPPING CART");

    }

    @Test
    public void emptyCart(){
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();
        WebElement addToCart = driver.findElement(By.cssSelector("div.add-to-cart-buttons"));
        addToCart.click();
        WebElement emptyCart = driver.findElement(By.cssSelector("#empty_cart_button > span > span"));
        emptyCart.click();
        WebElement pageTitleEmptyCart = driver.findElement(By.cssSelector("div.page-title > h1"));
        Assert.assertEquals(pageTitleEmptyCart.getText(), "SHOPPING CART IS EMPTY");
    }

    @Test
    public void deleteProduct () throws InterruptedException {

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector("td.a-center > a")).click();
        Thread.sleep(5000);
        WebElement cartPageTitle = driver.findElement(By.cssSelector(".page-title>h1"));
        Assert.assertEquals(cartPageTitle.getText(), "SHOPPING CART IS EMPTY");
    }

    @After
     public void closeDriver(){
        driver.quit();
    }



}
