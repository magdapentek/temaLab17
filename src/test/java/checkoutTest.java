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

public class checkoutTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validCheckOutTest() throws InterruptedException {
        String userEmail = RandomStringUtils.randomAlphanumeric(5)+ "@testFastTrackIt.com";

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement sale = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        sale.click();
        driver.findElement(By.cssSelector("li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons > button")).click();
        driver.findElement(By.cssSelector("div.page-title.title-buttons > ul > li > button")).click();
        driver.findElement(By.cssSelector("#login\\:register")).click();
        driver.findElement(By.cssSelector(".buttons-set #onepage-guest-register-button")).click();
        driver.findElement(By.cssSelector(".input-box>input[name='billing[firstname]']")).sendKeys("Pentek");
        driver.findElement(By.cssSelector(".input-box>input[name='billing[lastname]']")).sendKeys("Magda");
        driver.findElement(By.cssSelector(".input-box>input[name='billing[email]']")).sendKeys(userEmail);
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("Str. Traian Mosoiu, nr. 124");
        driver.findElement(By.cssSelector(".input-box>input[name='billing[city]']")).sendKeys("Cluj-Napoca");
        Select selectCountry = new Select(driver.findElement(By.cssSelector(".input-box >select[name='billing[country_id]']")));
        selectCountry.selectByVisibleText("România");
        Select selectRegion = new Select(driver.findElement(By.cssSelector(".input-box>select[name='billing[region_id]']")));
        selectRegion.selectByVisibleText("Cluj");
        driver.findElement(By.cssSelector(".input-box>input[name='billing[telephone]']")).sendKeys("0744958251");
        driver.findElement(By.cssSelector(".input-box>input[name='billing[postcode]']")).sendKeys("958251");

        driver.findElement(By.cssSelector(".input-box>input[title='Password']")).sendKeys("123456");
        driver.findElement(By.cssSelector(".input-box>input[title='Confirm Password']")).sendKeys("123456");
        driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
        Thread.sleep(4000);
        WebElement radioButton = driver.findElement(By.cssSelector("dd:nth-child(2) > ul > li > label"));
        radioButton.click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#payment-buttons-container > button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#review-buttons-container > button")).click();
        Thread.sleep(3000);

        WebElement orderRecived = driver.findElement(By.cssSelector("div.page-title > h1"));

        Assert.assertEquals(orderRecived.getText(), "YOUR ORDER HAS BEEN RECEIVED.");

    }

    @After
    public void closeDriver(){
        driver.quit();
    }


}
