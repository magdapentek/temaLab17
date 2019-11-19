import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Exercitiul1 {
//    1. Creați un nou proiect în care să repetați pașii de la curs automatizând diferite
//    interacțiuni cu elemente din magazinul online http://testfasttrackit.info/selenium-test/
    public static void main(String[] args) throws InterruptedException {
//        Add a product in cart
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();

        sleep(5000);
        driver.close();

    }
    public static void cartDeleteProduct () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-425")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr.last.even > td.a-center.product-cart-remove.last > a")).click();
        driver.close();
    }
}
