import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.Random;

import static org.openqa.selenium.By.className;

public class RegisterTest {
//    Adăugați în clasa RegisterTest un test în care să automatizați pașii necesari
//    pentru înregistrarea cu succes a unui utilizator nou (deschideți homepage-ul,
//    apăsați pe Account, apăsați pe Register, completați toate câmpurile de pe pagina Register -
//    atenție ca email-ul să fie unic, bifați opțiunea pentru primirea newsleterr-ului).
//    Folosiți identificatori diferiți pentru câmpurile de pe pagina Register (id, name, className).
     private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void registerValidTest() throws InterruptedException{
        String userEmail = RandomStringUtils.randomAlphanumeric(5)+ "@testFastTrackIt.com";

        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement registerButton = driver.findElement(By.cssSelector("div.skip-links > div > a > span.label"));
        registerButton.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Pentek");
        driver.findElement(By.name("lastname")).sendKeys("Magda");
        driver.findElement(By.id("email_address")).sendKeys(userEmail);
        driver.findElement(By.name("password")).sendKeys("0246810");
        driver.findElement(By.id("confirmation")).sendKeys("0246810");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set button > span > span")).click();
        WebElement myDashbord = driver.findElement(By.cssSelector("div.page-title > h1"));
        Assert.assertEquals(myDashbord.getText(), "MY DASHBOARD");

        Thread.sleep(3000);

    }

    @Test
    public void InvalidRegisterTest() throws InterruptedException {
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement registerButton = driver.findElement(By.cssSelector("div.skip-links > div > a > span.label"));
        registerButton.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Pentek");
        driver.findElement(By.name("lastname")).sendKeys("Magda");
        driver.findElement(By.id("email_address")).sendKeys("magdiakadelpentek30@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("0246810");
        driver.findElement(By.id("confirmation")).sendKeys("024681023");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
        Thread.sleep(5000);
        WebElement registerButtonDisplay = driver.findElement(By.cssSelector("div.buttons-set > button > span > span"));
        Assert.assertTrue(registerButtonDisplay.isDisplayed());
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
