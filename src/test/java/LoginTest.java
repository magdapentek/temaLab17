import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validLoginTest(){

        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        WebElement loginButton = driver.findElement((By.cssSelector("#send2")));
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        loginButton.click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("p.hello > strong"));

        Assert.assertEquals(welcomeMessageElement.getText(), "Hello, Magda Pentek!");

    }

    @Test
    public void invalidTest(){
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");
        WebElement loginButton = driver.findElement((By.cssSelector("#send2")));
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        loginButton.click();
        WebElement welcomeMessageElement = driver.findElement(By.cssSelector("p.hello > strong"));

        Assert.assertFalse(welcomeMessageElement.getText(), false);
    }


    @After
    public void closeDriver(){
        driver.quit();
    }


}
