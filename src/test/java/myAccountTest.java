import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myAccountTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    // Tema pt laboratorul 18. Test 2
    @Test
    public void myAccountTestWishList() throws InterruptedException {
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(" div.skip-links > div > a"));
        accountButton.click();
        driver.findElement(By.cssSelector("#header-account div > ul > li.first > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement wishListContent = driver.findElement(By.cssSelector("li:nth-child(8) > a"));
        wishListContent.click();
        WebElement shareWishlistButton = driver.findElement(By.cssSelector("button.button.btn-share"));
        Assert.assertEquals(shareWishlistButton.getText(), "SHARE WISHLIST");
    }

    @Test
    public void myAccountAddressBook() throws InterruptedException {
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(" div.skip-links > div > a"));
        accountButton.click();
        driver.findElement(By.cssSelector("#header-account div > ul > li.first > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement addresBookContent = driver.findElement(By.cssSelector(" div.block-content > ul > li:nth-child(3) > a"));
        addresBookContent.click();
        WebElement addressMessage = driver.findElement(By.cssSelector("li:nth-child(1) > h3"));
        Assert.assertEquals(addressMessage.getText(), "DEFAULT BILLING ADDRESS");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

}
