import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//   3. În pachetul test (nu main), creați o clasă WishListTest în care veți adăuga teste referitoare la Wishlist.
public class WhishListTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void wishListValidTest() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        WebElement wishlistButton = driver.findElement(By.cssSelector("ul.add-to-links > li:nth-child(1) > a"));
        wishlistButton.click();
        Thread.sleep(5000);
        WebElement addToCartButton = driver.findElement(By.cssSelector(".customer-wishlist-item-cart > div > button > span > span"));
        Assert.assertTrue(addToCartButton.isDisplayed());

    }
      @Test
    public void changeQuantityInWhishlist() throws InterruptedException {
         driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();
         driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("ul.add-to-links > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector(".customer-wishlist-item-quantity > div > div > input")).clear();
        driver.findElement(By.cssSelector(".customer-wishlist-item-quantity > div > div > input")).click();
        driver.findElement(By.cssSelector(".customer-wishlist-item-quantity > div > div > input")).sendKeys("7");
        driver.findElement(By.cssSelector("body")).click();
        Thread.sleep(5000);
        WebElement updateWhislist = driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-update.button-secondary > span > span"));
        Assert.assertTrue(updateWhislist.isDisplayed());


    }
//    4. Adăugati un test prin care să deschideți homepage-ul site-ului, apoi să navigați la categoria "Sale",
//    apoi să deschideți pagina de detalii a primului produs și să încercați să îl adăugați în WishList, apăsând
//    butonul Add to Wishlist.

    @Test
    public void addToWhislistSale(){
        driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();

        WebElement sale = driver.findElement(By.cssSelector("li.level0.nav-5.parent > a"));
        sale.click();
        driver.findElement(By.cssSelector("li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        WebElement addToWishlist = driver.findElement(By.cssSelector("ul.add-to-links > li:nth-child(1) > a"));
        addToWishlist.click();
        WebElement loginPagen = driver.findElement(By.cssSelector("div.col-2.registered-users > div.content.fieldset > h2"));
        Assert.assertEquals(loginPagen.getText(), "ALREADY REGISTERED?");




    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}

