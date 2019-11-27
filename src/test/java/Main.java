import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");



        }

        public static void loginTest() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");

            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();

//        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
//        loginLink.click();
//
            driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();


            driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");

            driver.findElement(By.cssSelector("#pass")).sendKeys("123456");

            driver.findElement(By.cssSelector("#send2")).click();

            driver.close();
        }

        public static void invalidLoginTest() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");

            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();

//        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
//        loginLink.click();
//
            driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();


            driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");

            driver.findElement(By.cssSelector("#pass")).sendKeys("kjashjgjghds");

            driver.findElement(By.cssSelector("#send2")).click();

            driver.close();
        }

    public static void validLoginTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();

//        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
//        loginLink.click();
//
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();


        driver.findElement(By.cssSelector("#email")).sendKeys("pentekmagda@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");

        driver.findElement(By.cssSelector("#send2")).click();

        driver.quit();
    }

    }


