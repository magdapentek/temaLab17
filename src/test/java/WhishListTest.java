import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//   3. În pachetul test (nu main), creați o clasă WishListTest în care veți adăuga teste referitoare la Wishlist.
public class WhishListTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

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
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();

        Thread.sleep(5000);

        driver.close();



    }

    public static void changeQuantityInWhishlist(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

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
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#item_485 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input")).clear();
        driver.findElement(By.cssSelector("#item_485 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input")).click();
        driver.findElement(By.cssSelector("#item_485 > td.wishlist-cell2.customer-wishlist-item-quantity > div > div > input")).sendKeys();
        driver.findElement(By.cssSelector("body")).click();

        driver.close();
    }
//    4. Adăugati un test prin care să deschideți homepage-ul site-ului, apoi să navigați la categoria "Sale",
//    apoi să deschideți pagina de detalii a primului produs și să încercați să îl adăugați în WishList, apăsând
//    butonul Add to Wishlist.

    public static void addToWhislistSale(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        driver.close();

    }
}

